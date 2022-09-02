import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { PatientService } from './patient.service';
import { HttpClient } from '@angular/common/http';

describe('PatientService', () => {
  let service: PatientService;
  let http: HttpClient;
  let httpcontroller: HttpTestingController;


  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[PatientService]
    });
    service = TestBed.inject(PatientService);
    http = TestBed.inject(HttpClient);
    httpcontroller = TestBed.inject(HttpTestingController);

  });

  it('should be created', () => {
    expect(service).toBeDefined();
  });
});

