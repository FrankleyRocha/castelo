import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario!:string;
  senha!:string;

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  login(){
    console.log('logando',this.usuario,this.senha);
    this.auth.authenticate(
      this.usuario,
      this.senha
    ).subscribe( d => {
      console.log('d',d);

      this.auth.token = d;

      this.router.navigate(['/']);
    })
  }

}
