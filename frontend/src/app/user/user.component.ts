import { Component, OnInit } from '@angular/core';
import { CustomNgHttpService } from 'app/services/common.service';
import { Router } from '@angular/router';

@Component({
  selector: 'user',
  templateUrl: './user.html',
  providers : [CustomNgHttpService]
})
export class UserComponent  {
  userList: any;
  title = 'app works!';
  status="No content to display";

  constructor(private service: CustomNgHttpService, private router : Router){
       this.refresh();
  }
  
   
  bindData(data : any){
    this.userList = data.content;
  }

  navigateToView(user: any){
    debugger
    this.router.navigateByUrl("userDetails/"+user.id);
  }
  changeAddress(user: any){
    debugger
    this.router.navigateByUrl("changeAddress/"+user.id);
  }

  editUser(user: any){
    this.router.navigateByUrl("updateUser/"+user.id);
  }

  deleteUser(user: any){
    this.service.deleteUser(user.id).then(i=>{
      alert("User Deleted Successfully");
      this.refresh();
    })
  }

  refresh(){
    this.service.getUserList().then(i=>{
      debugger
      this.bindData(i);
    
    });  
  }
}
