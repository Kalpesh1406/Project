import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateDoctorComponent } from './create-doctor/create-doctor.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { ShowDoctorComponent } from './show-doctor/show-doctor.component';
import { ShowPatientComponent } from './show-patient/show-patient.component';

const routes: Routes = [
  {path: 'create-doctor', component: CreateDoctorComponent},
  {path: 'create-patient', component: CreatePatientComponent},
  {path: '',redirectTo: 'AppComponent', pathMatch:'full'},
  {path: 'show-doctor', component:ShowDoctorComponent},
  {path: 'show-patient', component: ShowPatientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
