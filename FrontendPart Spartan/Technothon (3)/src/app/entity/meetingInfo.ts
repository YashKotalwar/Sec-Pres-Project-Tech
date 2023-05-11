export interface MeetingInfo{
    meetingId: number;
    meetingTitle: string;
    meetingNoteStatus: boolean;
    meetingNotes: File;
    mailSendStatus: boolean;
    attendiesEmails: string[];
}
