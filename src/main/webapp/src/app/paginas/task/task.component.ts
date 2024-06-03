import { Component, OnInit } from '@angular/core';
import { Status } from 'src/app/status';
import { Tarefa } from 'src/app/tarefa';
import { TaskService } from 'src/app/task.service';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  ngOnInit(): void {
  }


  constructor(
    private taskService : TaskService
  ){
    this.loadTasks();
    this.newTask();
  }

  loadTasks(){
    this.taskService.all().subscribe( tasks => {

      console.log(tasks);

      this.todo = tasks.filter( task => task.status.nome === 'A_FAZER').sort( (a,b) => a.indice - b.indice);
      this.doing = tasks.filter( task => task.status.nome === 'FAZENDO').sort( (a,b) => a.indice - b.indice);
      this.done = tasks.filter( task => task.status.nome === 'FEITO').sort( (a,b) => a.indice - b.indice);
      
    });
  }

  task!:Tarefa;
  
  todo:Tarefa[] = [];

  doing:Tarefa[] = [];

  done:Tarefa[] = [];

  newTask(){
    this.task = {

      indice : this.todo.length,
      nome : '',
      titulo : '',
      
      status : new Status()      
    };
  }

  addTask(){
    if(this.task.titulo.length===0)
      return;

    console.log(this.task);

    this.taskService.save(this.task).subscribe( task => {
      this.todo.push(task);
      this.newTask();
    });
    
  }

  updateIndex(tasks:Tarefa[]){

    let tasksToUpdate:Tarefa[] = [];

    for(let task of tasks){
      let index = tasks.indexOf(task);
      if(task.indice !== tasks.indexOf(task)){
        task.indice = index;
        tasksToUpdate.push(task);
      }
    }

    for(let task of tasksToUpdate)
      this.taskService.save(task).subscribe( t => {
        console.log(t);
      });

  }

  drop(event: CdkDragDrop<Tarefa[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex,
      );
    }

    let task = event.container.data[event.currentIndex];
    task.indice = event.currentIndex;
    task.status.nome = event.container.id;
        
    this.taskService.save(task).subscribe( t => {
      console.log(t);
    });

    this.updateIndex(this.todo);
    this.updateIndex(this.doing);
    this.updateIndex(this.done);

  }

}
