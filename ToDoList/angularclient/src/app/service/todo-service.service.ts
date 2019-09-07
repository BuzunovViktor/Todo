import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ToDo } from '../model/todo';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TodoService {

  private todosUrl: string;

  constructor(private http: HttpClient) {
    this.todosUrl = 'http://localhost:8080/todos';
  }

  public findAll(): Observable<ToDo[]> {
    return this.http.get<ToDo[]>(this.todosUrl);
  }

  public save(todo: ToDo) {
    return this.http.post<ToDo>(this.todosUrl, todo);
  }
}
