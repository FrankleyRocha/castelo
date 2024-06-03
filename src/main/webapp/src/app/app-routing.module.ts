import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './paginas/login/login.component';
import { TaskComponent } from './paginas/task/task.component';
import { AuthGuard } from './auth/auth.guard';
import { HomeComponent } from './paginas/home/home.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'task', component: TaskComponent, canActivate: [AuthGuard] },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
  { path: '',   redirectTo: '/task', pathMatch: 'full' },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules, useHash: true })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
