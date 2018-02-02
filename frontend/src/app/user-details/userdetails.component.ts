import { Component } from '@angular/core';
import { Params, ActivatedRoute } from "@angular/router";
import { CustomNgHttpService } from "app/services/common.service";
import { person } from "app/model/user.model";

@Component({
  selector: 'user-details',
  templateUrl: './userDetails.html',
    providers : [CustomNgHttpService]
})
export class UserDetailsComponent {
  id: any;
  user : any = {
        firstName: "",
        lastName : "",
        middleName : "",
        occupation : "",
        age: 0,
        dob: null,
        id : null,
        addresses: []
  }
  constructor(private service: CustomNgHttpService,private route : ActivatedRoute){

     this.route.params.forEach((params: Params) => {
      this.id = params['id'];
      if(this.id != 0 && this.id != undefined && this.id != "" ){
         this.service.getUserbyId(this.id).then(i=>{
         debugger
           this.user = i;
         })
      }
  });
  }
}
