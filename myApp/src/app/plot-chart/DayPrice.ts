import { Security } from '../security';
import { SecurityService } from '../security.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

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

    constructor(private http: HttpClient) {
        super();
      
        this.securityService = new SecurityService(http);

        this.securityService?.findByID(1).subscribe((data) => {
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
        }, error => {
          console.log('error');
        });


        // this.push(new DayPriceItem(
        // {
        //     day: `t1`,
        //     price: 43,
           
        // }));
    }
}