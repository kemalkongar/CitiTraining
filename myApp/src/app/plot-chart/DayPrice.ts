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

        this._Http.get<any>('http://miss2trainingproject-miss2trainingproject.openshift82.conygre.com/api/securities/1').subscribe(data => {
        this.mySecurity = data;

        this.push(new DayPriceItem(
                {
                    day: `t0`,
                    price: data.t0,
                }));
            this.push(new DayPriceItem(
                    {
                    day: `t-1`,
                    price: data.tminus1,
                    }));
            this.push(new DayPriceItem(
                    {
                    day: `t-2`,
                    price: data.tminus2,
                    }));
            this.push(new DayPriceItem(
                {
                    day: `t-3`,
                    price: data.tminus3,
                }));
            this.push(new DayPriceItem(
                    {
                    day: `t-4`,
                    price: data.tminus4,
                    }));
            this.push(new DayPriceItem(
                    {
                    day: `t-5`,
                    price: data.tminus5,
                    }));
        }, error => {
            console.log('error');
          });

        // //WORKING EXAMPLE 
        // this.push(new DayPriceItem(
        //     {
        //         day: `t1`,
        //         price: 43,
                
        //     }));
        //     this.push(new DayPriceItem(
        //         {
        //             day: `t2`,
        //             price: 50,
        //     }));
        //     this.push(new DayPriceItem(
        //         {
        //             day: `t3`,
        //             price: 43,
        //         }));
        //         this.push(new DayPriceItem(
        //             {
        //                 day: `t4`,
        //                 price: 50,
        //     }));
    }
    // onInit():void{
        // this._Http = new HttpClient(this._httpHandler);
        // this.securityService = new SecurityService(this._Http);

        //hardcode for id=1 

        // this.securityService?.findByID(1).subscribe((data) => {
        //     console.log(data);
    //}
}