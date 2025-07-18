import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { __param } from 'tslib';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  getListMenus(role : number){
    const options = role ? { params: new HttpParams().set('role', role) } : {};
    return this.http.get<any[]>(this.apiUrl + "/listMenu", options);
  }
}
