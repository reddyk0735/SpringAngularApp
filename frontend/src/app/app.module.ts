import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { UserDetailsComponent } from './user-details/userdetails.component';
import { ChangeAddressComponent } from './changeAddress/change.address';
import { CreateUserComponent } from './create-user/create.user';
import { CreateAddressComponent } from './create-address/createaddress.component';
import { routing } from './app.routing';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    HomeComponent,
    AppComponent,
    UserComponent,
    UserDetailsComponent,
    ChangeAddressComponent,
    CreateUserComponent ,
    CreateAddressComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


