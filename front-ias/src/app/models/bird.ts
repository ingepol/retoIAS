import { Country } from './country'
export class Bird {
    constructor(
        public code:number,
        public commonName:string,
        public scientificName:string,
        public countries:Country[]
    ){
        
    }

    inSelectedCountries(countrySelect:Country){
        console.log('hola ');
        var flag = false;
        this.countries.forEach(function(country) {
            if (this.code == country.code) {
                flag = true;
                return;
            }
                flag = false;
                return;
         });
        return flag;
    }
}