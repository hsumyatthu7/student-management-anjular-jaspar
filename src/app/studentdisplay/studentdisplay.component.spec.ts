import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentdisplayComponent } from './studentdisplay.component';

describe('StudentdisplayComponent', () => {
  let component: StudentdisplayComponent;
  let fixture: ComponentFixture<StudentdisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentdisplayComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentdisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
