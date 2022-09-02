import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-show-patient',
  templateUrl: './show-patient.component.html',
  styleUrls: ['./show-patient.component.css']
})
export class ShowPatientComponent implements OnInit {

  patients:any;
  patientId:any;
  tablehide:boolean=false;

  constructor(private patientService: PatientService,
    private router: Router) { }


  getPatientDetails(patientId:number){
    let response = this.patientService.getPatient(patientId);
    response.subscribe((data)=>this.patients=data);

    console.log("data--->",this.patients)
  }

  ngOnInit(): void {
  }

  back():void{
    this.router.navigate(['']);
  }

}
