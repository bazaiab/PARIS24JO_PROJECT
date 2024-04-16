export interface Event {
  id : string;
  name : string;
  price : number;
}

export interface PageEvent {
  events : Event [];
  page : number;
  size : number;
  totalpages : number;

}
