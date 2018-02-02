import { Component, OnInit } from '@angular/core';
import { CustomNgHttpService } from 'app/services/common.service';
import { PersonAddress } from 'app/model/user.model';
import { ActivatedRoute, Params } from "@angular/router";

@Component({
  selector: 'user-details',
  templateUrl: './change.address.html',
  providers : [CustomNgHttpService]
})
export class ChangeAddressComponent implements OnInit {

  id: any;
  isAddEdit: boolean = false;
  addressList:any = {
    addressList : []
  };
  postrequest :any = this.resetPostRequest();
  constructor(private service: CustomNgHttpService,private route : ActivatedRoute){
    this.addressList.addressList = [];
     this.refresh();

    //this.addressList =  this.service.getAdressList();
  }

  resetPostRequest(){
    return {
      id:"",
			personId: this.id,
			address1: "",
			address2: "",
			city: "",
			state: "",
			zipCode: ""
  }
  }
 
  ngOnInit(){
  
  }
  
  Add(model: any)
  {
    debugger
    this.postrequest = this.resetPostRequest();
    this.isAddEdit=true;
    //this.postrequest = model;
    // this.service.SaveAdress(this.postrequest).then(i=>{
    //   this.isAddEdit=true;
    //   alert("adress created succesfully");
    // });
  }

  Edit(model : any)
  {
    debugger
    this.postrequest = model
    this.isAddEdit=true;
  }

  saveEditAddress()
  {
    if(this.postrequest.id != undefined && this.postrequest.id != ""){
      this.postrequest.personId = this.id;

      this.service.updateAddress(this.postrequest.id, this.postrequest).then(i=>{
        this.refresh();
        this.isAddEdit=false;
        alert("Address Update Successful");
      })
    }else{
    this.service.SaveAdress(this.postrequest).then(i=>{
        this.refresh();
        this.isAddEdit=false;
        alert("Address Created Succesfully");
      });
  }
}

DeleteAddress(address: any){
this.service.deleteAddress(address.id).then(i=>{
  alert("Address Deleted Successfully");
  this.refresh();
})
}

  refresh(){
    this.route.params.forEach((params: Params) => {
      this.id = params['id'];
      if(this.id != 0 && this.id != undefined && this.id != "" ){
         this.service.getAddressById(this.id).then(i=>{
           debugger
           this.addressList=i;
          
         })
      }
  });
  }
}
