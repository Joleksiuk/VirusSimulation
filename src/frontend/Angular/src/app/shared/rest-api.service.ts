import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Simulation } from '../shared/simulation';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class RestApiService {
  // Define API
  apiURL = 'http://localhost:8080';
  constructor(private http: HttpClient) {}
  /*========================================
    CRUD Methods for consuming RESTful API
  =========================================*/
  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  // HttpClient API get() method => Fetch simulation list
  getSimulations(): Observable<Simulation> {
    return this.http
      .get<Simulation>(this.apiURL + '/simulation')
      .pipe(retry(1), catchError(this.handleError));
  }
  // HttpClient API get() method => Fetch simulation
  getSimulation(id: any): Observable<Simulation> {
    return this.http
      .get<Simulation>(this.apiURL + '/simulation/' + id)
      .pipe(retry(1), catchError(this.handleError));
  }
  // HttpClient API post() method => Create simulation
  createSimulation(simulation: any): Observable<Simulation> {
    console.log(simulation)
    return this.http
      .post<Simulation>(
        this.apiURL + '/simulation',
        JSON.stringify(simulation),
        this.httpOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }
  // HttpClient API put() method => Update employee
  updateSimulation(id: any, simulation: any): Observable<Simulation> {
    return this.http
      .put<Simulation>(
        this.apiURL + '/simulation/' + id,
        JSON.stringify(simulation),
        this.httpOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }
  // HttpClient API delete() method => Delete employee
  deleteSimulation(id: any) {
    return this.http
      .delete<Simulation>(this.apiURL + '/simulation/' + id, this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }
  // Error handling
  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}