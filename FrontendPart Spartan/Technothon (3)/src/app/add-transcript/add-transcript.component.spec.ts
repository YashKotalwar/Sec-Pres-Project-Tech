import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTranscriptComponent } from './add-transcript.component';

describe('AddTranscriptComponent', () => {
  let component: AddTranscriptComponent;
  let fixture: ComponentFixture<AddTranscriptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTranscriptComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddTranscriptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
