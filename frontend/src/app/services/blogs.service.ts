import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BlogsService {

  constructor(private _http: HttpClient) { }
  limit: BehaviorSubject<number> = new BehaviorSubject(9);
  searchValue: BehaviorSubject<string>= new BehaviorSubject('');

  getBlogs(limit: number): Observable<any> {
    return this._http.get(`https://dev.to/api/articles?per_page=${limit}`);
  }

  updateLimit(limitNo: number){
    return this.limit.next(limitNo);
  }

  UpdateSearchValue(value: string){    
return this.searchValue.next(value);
  }

}
