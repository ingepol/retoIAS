import { Zone } from './zone'
export class Country {
    constructor(
        public code:number,
        public name:string,
        public zone:Zone
    ){
        
    }
}