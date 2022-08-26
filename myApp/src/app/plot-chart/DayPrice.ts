export class DayPriceItem {
    public constructor(init: Partial<DayPriceItem>) {
        Object.assign(this, init);
    }
    public day: string;
    public price: number;

}

export class DayPrice extends Array<DayPriceItem> {
    public constructor() {
        super();


        this.push(new DayPriceItem(
        {
            day: `t0`,
            price: 34,
           
        }));
        this.push(new DayPriceItem(
        {
            day: `t1`,
            price: 43,
           
        }));
        this.push(new DayPriceItem(
        {
            day: `t2`,
            price: 66,
           
        }));
        this.push(new DayPriceItem(
        {
            day: `t3`,
            price: 69,
        }));
    }
}