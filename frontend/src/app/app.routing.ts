import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AppComponent} from './app.component';
import { UserComponent } from './user/user.component';
import { UserDetailsComponent } from './user-details/userdetails.component';
import { ChangeAddressComponent } from './changeAddress/change.address';
import { CreateUserComponent } from './create-user/create.user';

const routes: Routes = [
  { path: '', redirectTo: "userList", pathMatch: 'full' },
  { path: 'userList', component: UserComponent },
  { path: 'userDetails/:id', component : UserDetailsComponent },
  { path: 'changeAddress/:id', component : ChangeAddressComponent },
  { path: 'createUser', component : CreateUserComponent },
  { path: 'updateUser/:id', component : CreateUserComponent },
  { path: '**', redirectTo : "userList" }
];
 
export const routing: ModuleWithProviders = RouterModule.forRoot(routes);