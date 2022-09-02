import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorService } from '../doctor.service';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent implements OnInit {

  patient : Patient = new Patient();

  doctors:any;
  doctorinfo:any;

  constructor(private patientService: PatientService,
    private doctorService:DoctorService,
    private router:Router) { }

  ngOnInit(): void {
    let response = this.doctorService.getAllDoctors();
    response.subscribe((data)=>this.doctors=data);
  }

  selectName(pid:number){
    let response = this.doctorService.getDoctorById(pid);
    response.subscribe((data)=>this.doctorinfo=data);

    console.log("id--->",pid);
    console.log("doctors--->",this.doctorinfo.docName);
  }

  savePatient(){
    this.patientService.createPatient(this.patient).subscribe(data =>{
      console.log(data);
    },
    error => console.log(error));
    this.router.navigate(['']);
  }

  onSubmit(){
    console.log(this.patient);
    this.savePatient();
  }
}
