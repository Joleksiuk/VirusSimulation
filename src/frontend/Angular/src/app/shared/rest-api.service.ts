import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Simulation } from '../shared/simulation';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class RestApiService {

  apiURL = 'http://localhost:8080';
  constructor(private http: HttpClient) {}


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  getSimulations(): Observable<Simulation> {
    return this.http
      .get<Simulation>(this.apiURL + '/simulation')
      .pipe(retry(1), catchError(this.handleError));
  }

  getSimulation(id: any): Observable<Simulation> {
    return this.http
      .get<Simulation>(this.apiURL + '/simulation/' + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createSimulation(simulation: Simulation): Observable<Simulation> {
    //console.log(simulation)
    console.log(JSON.stringify(simulation))
    return this.http
      .post<Simulation>(
        this.apiURL + '/simulation',
        JSON.stringify(simulation),
        this.httpOptions
      )
      .pipe(retry(0), catchError(this.handleError));
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