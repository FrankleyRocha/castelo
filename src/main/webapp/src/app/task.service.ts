import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tarefa } from './tarefa';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(
    private http: HttpClient
  ) { }

  all():Observable<Tarefa[]>{
    return this.http.get<Tarefa[]>(
      `http://localhost:8081/api/tarefas`
    );
  }

  save(task:Tarefa):Observable<Tarefa>{

    if(task.id != undefined)
      return this.http.patch<Tarefa>(
        `http://localhost:8081/api/tarefas`,
        task
      );
    else
      return this.http.post<Tarefa>(
        `http://localhost:8081/api/tarefas`,
        task
      );
  }

}
