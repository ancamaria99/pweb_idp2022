import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Shelter} from "../domain/Shelter";

@Injectable({
  providedIn: 'root'
})
export class SheltersService {
  private apiBaseUrl = 'http://localhost:80/api/refugees-shelter/';

  constructor(private http: HttpClient) {
  }

  getAllShelters(): Observable<Array<Shelter>> {
    const url = this.apiBaseUrl + 'shelters';

    return this.http.get<Array<Shelter>>(url);
  }

  getSheltersFiltered(filtersMap: Map<string, string>): Observable<Array<Shelter>> {
    const url = this.apiBaseUrl + 'shelters/filtered' + this.generateQueryParams(filtersMap);

    return this.http.get<Array<Shelter>>(url);
  }

  generateQueryParams(filtersMap: Map<string, string>): string {
    let queryParams = '';
    const iterator = filtersMap[Symbol.iterator]();

    if (filtersMap.size != 0) {
      queryParams += '?';

      for (const item of iterator) {
        queryParams += item[0] + '=' + item[1];
      }
    }

    return queryParams;
  }
}
