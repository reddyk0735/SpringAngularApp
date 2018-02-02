import { Component } from '@angular/core';
import { CustomNgHttpService } from 'app/services/common.service';
import { Router } from '@angular/router';

@Component({
  selector: 'createaddress',
  templateUrl: './createaddress.html',
  providers : [CustomNgHttpService]
})
export class CreateAddressComponent {
  addressList: any;
  title = 'app works!';

  constructor(private service: CustomNgHttpService, private router : Router){}
  
}