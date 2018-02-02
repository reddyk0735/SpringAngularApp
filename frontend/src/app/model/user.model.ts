export interface person{
firstName: string;
lastName : string;
middleName : string;
occupation : string;
age: number;
dob: Date;
id: string;
}

export interface Address{
    id: number;
    personId: number;
    address1: string;
    address2 : string;
    city : string;
    state :string;
    zipCode : string

}

export interface PersonAddress{
 personId: string;
 address1: string;
 address2: string;
 city: string;
 state : string;
 zipCode: string;
addresses: Address[];

} 