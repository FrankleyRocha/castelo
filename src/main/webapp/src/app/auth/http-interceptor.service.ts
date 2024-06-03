import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {

  constructor(
    private auth: AuthService
  ) { }

  private addToken(request: HttpRequest<any>, token: any) {
    
    if (token) {
        let clone: HttpRequest<any>;
        clone = request.clone({
            setHeaders: {                
                Authorization: `Bearer ${token.access_token}`
            }
        });
        return clone;
    }

    return request;

  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
    let clonedReq = this.addToken(req, this.auth.token);

    return next.handle(clonedReq);

  }

}
