import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EventsComponent} from "./events/events.component";
import {SigninComponent} from "./signin/signin.component";
import {SignupComponent} from "./signup/signup.component";
import {CardComponent} from "./card/card.component";
import {OffresComponent} from "./offres/offres.component";

const routes: Routes = [
  {path : "events" , component : EventsComponent},
  {path: "signin" , component : SigninComponent},
  {path : "signUp" , component : SignupComponent},
  {path: "card" , component : CardComponent},
  {path : "offers" , component : OffresComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})

export class AppRoutingModule { }

