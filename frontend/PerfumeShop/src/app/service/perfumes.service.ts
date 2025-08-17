import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PerfumesService {
  apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  getAllCarousels(){
    return this.http.get<any[]>(this.apiUrl + "/listAllCarousel");
  } 

  getDetailPerfume(idPerfume : number) {
    return this.http.get<any[]>(this.apiUrl + "/perfumeDetail/"+`${idPerfume}`);
  }

  getPerfumes(page : number, size: number, keyWord: string) {
    const options = { params: new HttpParams().set('page', page).set('size', size).set('keyWord', keyWord) };
    return this.http.get<any[]>(this.apiUrl + "/listPerfumes", options);
  }
}
