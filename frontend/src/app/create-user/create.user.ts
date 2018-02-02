import { Component, OnInit } from '@angular/core';
import { CustomNgHttpService } from 'app/services/common.service';
import { PersonAddress, person } from 'app/model/user.model';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'user-create',
  templateUrl: './createUser.html',
  providers : [CustomNgHttpService],
  styleUrls: ['./create.user.css']
})
export class CreateUserComponent implements OnInit {



  constructor(private service: CustomNgHttpService, private route: ActivatedRoute, private router: Router){
  }

  user : person = {
        firstName: "",
        lastName : "",
        middleName : "",
        occupation : "",
        age: 0,
        dob: null,
        id : null
  }
  id: any;
  ngOnInit(){
     

    this.route.params.forEach((params: Params) => {
      this.id = params['id'];
      if(this.id != 0 && this.id != undefined && this.id != "" ){
         this.service.getUserbyId(this.id).then(i=>{
           this.user = i;
         })
      }
  });
  
  }


  saveUser(){
      this.service.createUser(this.user).then(i=>{
        alert("User Created");
        this.router.navigateByUrl("userList");
      })
      
  } 

  updateUser(){
    this.service.updateUser(this.user.id, this.user).then(i=>{
      alert("Update Successful");
      this.router.navigateByUrl("userList");
    })
  }
}
