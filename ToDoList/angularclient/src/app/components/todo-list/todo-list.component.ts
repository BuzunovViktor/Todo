import { Component, OnInit } from '@angular/core';
import { ToDo } from '../../model/todo';
import { TodoService } from '../../service/todo-service.service';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  todos: ToDo[];


  constructor(private todoService: TodoService) { }

  ngOnInit() {
  this.todoService.findAll().subscribe(data => {
        this.todos = data;
      });
  }

  onClick() {
    console.log("Click");
  }

}
