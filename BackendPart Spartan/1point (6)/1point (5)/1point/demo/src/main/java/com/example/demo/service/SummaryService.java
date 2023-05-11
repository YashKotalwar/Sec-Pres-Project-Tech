package com.example.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectDominantLanguageRequest;
import com.amazonaws.services.comprehend.model.DetectDominantLanguageResult;
import com.amazonaws.services.comprehend.model.DetectEntitiesRequest;
import com.amazonaws.services.comprehend.model.DetectEntitiesResult;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import com.amazonaws.services.comprehend.model.Entity;
import com.amazonaws.services.comprehend.model.SentimentScore;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.transcribe.AmazonTranscribeAsync;
import com.amazonaws.services.transcribe.AmazonTranscribeClient;


public class SummaryService {

    @Autowired
    private AmazonTranscribeClient transcribeClient;
    
    @Autowired
    private AmazonComprehend comprehendClient;
    
    
	Logger logger = LoggerFactory.getLogger(SummaryService.class);

    @Autowired
    private AmazonS3 amazonS3;
    

    @Autowired
    private AmazonTranscribeAsync amazonTranscribeAsync;
    
    
    public SummaryService(AmazonComprehend comprehendClient) {
        this.comprehendClient = comprehendClient;
    }
    
    private static final String PATTERN = "\\d+:\\d+:\\d+\\.\\d+ --> \\d+:\\d+:\\d+\\.\\d+\\s*[\\w\\s\\.]+";

	public String getSummary(String docxText) {
	    // remove timestamp and speaker name
	    String cleanText = docxText.replaceAll(PATTERN, "");
	    
	    // use AWS Comprehend to get the dominant language and entities in the text
	    AmazonComprehend comprehendClient = AmazonComprehendClientBuilder.defaultClient();
	    
	    DetectDominantLanguageRequest languageRequest = new DetectDominantLanguageRequest().withText(cleanText);
	    DetectDominantLanguageResult languageResult = comprehendClient.detectDominantLanguage(languageRequest);
	    String dominantLanguage = languageResult.getLanguages().get(0).getLanguageCode();
	    
	    DetectEntitiesRequest entitiesRequest = new DetectEntitiesRequest().withText(cleanText).withLanguageCode(dominantLanguage);
	    DetectEntitiesResult entitiesResult = comprehendClient.detectEntities(entitiesRequest);
	    List<Entity> entities = entitiesResult.getEntities();
	    
	    // use AWS Comprehend to get the sentiment score of the text
	    DetectSentimentRequest sentimentRequest = new DetectSentimentRequest().withText(cleanText).withLanguageCode(dominantLanguage);
	    DetectSentimentResult sentimentResult = comprehendClient.detectSentiment(sentimentRequest);
	    SentimentScore sentimentScore = sentimentResult.getSentimentScore();
	    
	    // create a summary string with the dominant language, entities, and sentiment score
	    StringBuilder summaryBuilder = new StringBuilder();
	    summaryBuilder.append("Dominant language: ").append(dominantLanguage).append("\n");
	    summaryBuilder.append("Entities: ");
	    for (Entity entity : entities) {
	        summaryBuilder.append(entity.getText()).append("(").append(entity.getType()).append(")").append(", ");
	    }
	    summaryBuilder.delete(summaryBuilder.length() - 2, summaryBuilder.length());
	    summaryBuilder.append("\nSentiment score: Positive=").append(sentimentScore.getPositive())
	                 .append(", Negative=").append(sentimentScore.getNegative())
	                 .append(", Neutral=").append(sentimentScore.getNeutral())
	                 .append(", Mixed=").append(sentimentScore.getMixed());
	    
	    return summaryBuilder.toString();
	}
	    
    
    
}
