	import { Injectable }from '@angular/core';
	import { Http, Response } from '@angular/http';
	import { Headers, RequestOptions } from '@angular/http';
	import { BaseHttpService } from 'app/services/BaseHttpService';

	@Injectable()

	export class CustomNgHttpService extends BaseHttpService  {

	getUserList(){
	var url = "/person";
	return this.GetCall(url);
	}

	getUserbyId(id: any){
	var url = "/person/"+id;
	return this.GetCall<any>(url);
	}

	createUser(data: any){
	var url = "/person"
	return this.PostCall<any>(url,data,"");

	}

	updateUser(id: any, data: any){
	var url = "/person/"+id;
	return this.PutCall<any>(url,data,"")
	}

	deleteUser(id: any){
	var url = "/person/"+id;
	return this.DeleteCall<any>(url,"","");
	}

	SaveAddress(data : any){
	var url = "adress/post";
	return this.PostCall<any>(url,data, "");

	}

	getAddressList(){
	var url = "/address/"
	return this.GetCall<any>(url);

	}

	getAddressById(id: any){
	var url = "/person/"+id;
	return this.GetCall<any>(url);
	}

	SaveAdress(data: any){
	var url = "/address/";
	return this.PostCall<any>(url, data,"");
	}

	updateAddress(id: any, data: any){
	var url = "/address/"+id;
	return this.PostCall<any>(url,data,"")
	}

	deleteAddress(id: any){
	var url = "/address/"+id;
	return this.DeleteCall<any>(url,"","")
	}

	}
