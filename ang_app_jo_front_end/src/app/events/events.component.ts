import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {EventsService} from "../services/events.service";
import {Event} from "../model/event.model";
import {FormBuilder, FormGroup} from "@angular/forms";





@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrl: './events.component.css'
})
export class EventsComponent implements OnInit{
  events! : Array<Event>;
  currentPage : number =0;
  pageSize : number =5;
  totalPages : number=0;
  errorMessage! : string;
  searchFormGroup! : FormGroup;

  constructor(private eventsService : EventsService, private fb : FormBuilder) {}
  ngOnInit() : void{
    this.searchFormGroup = this.fb.group({
      keyword : this.fb.control(null)
    })
    this.handleGetPageEvents();
  }

  handleGetPageEvents (){
    this.eventsService.getPageEvents(this.currentPage , this.pageSize).subscribe({
      next : (data)=>{
        this.events = data.events;
        this.totalPages = data.totalpages;

      },
      error : (err)=>{
        this.errorMessage = err;
      }
    });
  }


  handleGetAllEvents (){
    this.eventsService.getAllEvents().subscribe({
      next : (data)=>{
        this.events = data;
      },
      error : (err)=>{
        this.errorMessage = err;
      }
    });
  }



  handleDeleteEvents(p: Event) {
    let conf = confirm("Are you sure?");
    if (conf==false) return;
    this.eventsService.deleteEvent(p.id).subscribe({
      next : (data)=>{
        //this.handleGetAllEvents();
        let index = this.events.indexOf(p);
        this.events.splice(index,1);
      }
    })
  }

  handleSearchEvents() {
    let keyword = this.searchFormGroup.value.keyword;
    this.eventsService.searchEvents(keyword).subscribe({
      next : (data) =>  {
        this.events = data;
      }
    })
  }
}
