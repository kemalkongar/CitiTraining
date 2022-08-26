import { Security } from '../security';
import { SecurityService } from '../security.service';
import { HttpClient, HttpHeaders, HttpHandler } from '@angular/common/http';

export class DayPriceItem {
    public constructor(init: Partial<DayPriceItem>) {
        Object.assign(this, init);
    }
    public day: string;
    public price: number;

}

export class DayPrice extends Array<DayPriceItem> {
    securityService:SecurityService;
    myDayPrice:DayPrice;
    mySecurity:Security;

    private _Http: HttpClient;
    private _httpHandler: HttpHandler;


    constructor() {
        super();
        this.push(new DayPriceItem(
            {
                day: `T0`,
                price: 164.92,
                
            }));
        this.push(new DayPriceItem(
            {
                day: `T-1`,
                price: 169.24,
                
            }));
            this.push(new DayPriceItem(
                {
                    day: `T-2`,
                    price: 168.49,
            }));
            this.push(new DayPriceItem(
                {
                    day: `T-3`,
                    price: 172.1,
                }));
            this.push(new DayPriceItem(
                    {
                    day: `T-4`,
                    price:  173.19,
            }));
        this.push(new DayPriceItem(
            {
                day: `T-5`,
                price: 173.03,
            }));
        this.push(new DayPriceItem(
                {
                day: `T-6`,
                price:  173.19,
        }));
        this.push(new DayPriceItem(
            {
            day: `T-7`,
            price:  174.15,
    }));
        this.push(new DayPriceItem(
        {
        day: `T-8`,
        price:  171.52,
        }));
        this.push(new DayPriceItem(
            {
            day: `T-9`,
            price:  167.57,
     }));
}
    
    // onInit():void{
        // this._Http = new HttpClient(this._httpHandler);
        // this.securityService = new SecurityService(this._Http);

        //hardcode for id=1 

        // this.securityService?.findByID(1).subscribe((data) => {
        //     console.log(data);
    //}
}