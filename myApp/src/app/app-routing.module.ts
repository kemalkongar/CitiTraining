import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecurityListComponent } from './security-list/security-list.component';

const routes: Routes = [
  { path: '/api/securities/', component: SecurityListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }