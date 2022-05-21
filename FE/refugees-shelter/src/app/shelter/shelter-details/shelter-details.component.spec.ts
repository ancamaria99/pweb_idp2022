import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShelterDetailsComponent } from './shelter-details.component';

describe('ShelterDetailsComponent', () => {
  let component: ShelterDetailsComponent;
  let fixture: ComponentFixture<ShelterDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShelterDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShelterDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
