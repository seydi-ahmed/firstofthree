import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from '../models/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private apiUrl = 'http://localhost:8080/tasks'; //backend

  constructor(private http: HttpClient) { }

  // toutes les taches
  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.apiUrl);
  }

  // une tache
  getTask(id: number): Observable<Task> {
    return this.http.get<Task>(`{this.apiUrl}/${id}`);
  }

  // créer une tache
  addTask(task: Task): Observable<Task> {
    return this.http.post<Task>(this.apiUrl, task);
  }

  // modifier une tache
  updateTask(id: number, task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.apiUrl}/${id}`, task);
  }

  // supprimer une tache
  deleteTask(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  // supprimer toutes les taches
  deleteTasks(): Observable<void>{
    return this.http.delete<void>(this.apiUrl);
  }
}