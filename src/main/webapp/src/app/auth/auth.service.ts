import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
//import { BASE_URL } from 'src/environments/environment';

const BASE_URL = '';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public get isAdmin(){

    const user = this.account;

    if(!user || !user.authorities) return false;

    return user.authorities.filter( (a:any) => a === 'ROLE_ADMIN' ).length > 0;
  }

  public set account(account:any){
    localStorage.setItem(
      'account',
      JSON.stringify(account)
    );
  }

  public get account():any{

    let account = localStorage.getItem('account');

    if(account)
      return JSON.parse(
        account
      );

    null;
  }

  public set token(token:any){
    localStorage.setItem(
      'token',
      JSON.stringify(token)
    );
  }

  public get token():any{    
    let token = localStorage.getItem('token');

    if(token)
      return JSON.parse(
        token
      );

    null;
  }

  public get isAuthenticated():boolean{    
    return (this.token !== null);
  }

  constructor(
    private http:HttpClient
  ) { }

  getAuthenticatedUser(){
    return this.http.get(`${BASE_URL}/authenticate`);
  }

  getAccount(){
    return this.http.get(`${BASE_URL}/account`);
  }

  authenticate(username:string,password:string){

    let payload = new HttpParams()
      .set('grant_type', 'password')
      .set('client_id', 'myclient')
      .set('username', username)
      .set('password', password);

    return this.http.post(`http://localhost:8080/realms/myrealm/protocol/openid-connect/token`,
      payload
    );
  }

  logout(){
    localStorage.removeItem('token');
  }

}
