import { Injectable } from '@angular/core';
import {Observable, of, throwError} from "rxjs";
import {Event, PageEvent} from "../model/event.model";
import {UUID} from "angular2-uuid";



@Injectable({
  providedIn: 'root'
})
export class EventsService {
  private events! : Array<Event>;
  constructor() {
    this.events =[
      {id:UUID.UUID() , name:"Natation", price: 35},
      {id:UUID.UUID() , name:"Football", price: 40},
      {id:UUID.UUID() , name:"Athletisme", price: 45},
      {id:UUID.UUID() , name:"Canoe Slalom", price: 50},
      {id:UUID.UUID() , name:"Aviron", price: 55},
    ];
    for (let i = 0; i < 10; i++) {
      this.events.push({id:UUID.UUID(),name: "Natation",price: 35});
      this.events.push({id:UUID.UUID() , name:"Football", price: 40});
      this.events.push({id:UUID.UUID() , name:"Athletisme", price: 45});
      this.events.push({id:UUID.UUID() , name:"Canoe Slalom", price: 50});
      this.events.push({id:UUID.UUID() , name:"Aviron", price: 55});
    }
  }

  public getAllEvents () : Observable <Event[]> {
    let rnd=Math.random();
    if(rnd<0.1) return throwError(()=>new Error("Internet connexion"))
    return of(this.events);
  }

  public getPageEvents (page : number , size :number) : Observable <PageEvent> {
    let index = page*size;
    let totalPages = ~~(this.events.length/size);
    if(this.events.length % size!= 0)
      totalPages ++;
    let pageEvents = this.events.slice(index,index+size);
    return of({page:page, size:size, totalpages:totalPages , events: pageEvents});
  }

  public deleteEvent (id : string) : Observable<boolean> {
    this.events = this.events.filter(p=>p.id!=id);
    return of(true);
  }
  public searchEvents (keyword : string) : Observable <Array<Event>> {
    let events = this.events.filter(p=>p.name.includes(keyword));
    return of(events);
  }
}
