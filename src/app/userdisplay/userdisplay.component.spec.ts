import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserdisplayComponent } from './userdisplay.component';

describe('UserdisplayComponent', () => {
  let component: UserdisplayComponent;
  let fixture: ComponentFixture<UserdisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserdisplayComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserdisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
