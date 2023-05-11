import { Component, ElementRef, QueryList, Renderer2, ViewChild, ViewChildren } from '@angular/core';

@Component({
  selector: 'app-select-employees',
  templateUrl: './select-employees.component.html',
  styleUrls: ['./select-employees.component.scss']
})
export class SelectEmployeesComponent {

  constructor(private render:Renderer2){}

  @ViewChildren('select')
  select!:QueryList<ElementRef>;
  options:any[] = [
    { id: 1, email: 'john.doe@example.com', name: 'John Doe' },
    { id: 2, email: 'jane.doe@example.com', name: 'Jane Doe' },
    { id: 3, email: 'alice.smith@example.com', name: 'Alice Smith' },
    { id: 4, email: 'bob.johnson@example.com', name: 'Bob Johnson' },
    { id: 5, email: 'susan.baker@example.com', name: 'Susan Baker' },
    { id: 6, email: 'jimmy.nguyen@example.com', name: 'Jimmy Nguyen' },
    { id: 7, email: 'amanda.lee@example.com', name: 'Amanda Lee' },
    { id: 8, email: 'jason.chen@example.com', name: 'Jason Chen' },
    { id: 9, email: 'emily.wu@example.com', name: 'Emily Wu' },
    { id: 10, email: 'alex.jones@example.com', name: 'Alex Jones' }
  ];
  selectedEmployees:any[] = [];
  filteredList!:any[]

  ngOnInit(){
    this.filteredList = this.options;
   
  }

  filter(value:string){
    value= value.toLowerCase().trim()
    this.filteredList = this.options.filter((input)=>input.name.toLowerCase().includes(value))
    console.log('filteredList',this.filteredList); 
  }

  selectEmployee(employee:any,i:any){
    this.selectedEmployees.push(employee);
    console.log(this.selectedEmployees,i);
    
    this.select.toArray()[i].nativeElement.style.background = 'gray'
  }
}
