import { Component } from '@angular/core';
import { CustomNgHttpService } from 'app/services/common.service';
import { Router } from '@angular/router';

@Component({
  selector: 'address',
  templateUrl: './address.html',
  providers : [CustomNgHttpService]
})
export class AddressComponent {
  addressList: any;
  title = 'app works!';

  constructor(private service: CustomNgHttpService, private router : Router){
    service.getAddressList().then(i=>{
    this.addressList = i;
    });      
  }

deleteAddress(address :any)
{
    this.service.deleteAddress(address.id).then(i=>{
        alert("Address Deleted Successfully");
    })

}

}
