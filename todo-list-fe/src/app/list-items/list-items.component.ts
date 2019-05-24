import { Component, OnInit } from '@angular/core';
import { TodoListItemService } from '../todo-list-item.service';

@Component({
  selector: 'app-list-items',
  templateUrl: './list-items.component.html',
  styleUrls: ['./list-items.component.css']
})
export class ListItemsComponent implements OnInit {

  public listItems: Array<any> = new Array<any>();

  constructor(private todoListItemService: TodoListItemService) { }

  ngOnInit() {
    this.todoListItemService.getAllItems().subscribe(res => {
      this.listItems = res;
    })
  }

}
