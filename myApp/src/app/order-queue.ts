export class OrderQueue {
    constructor(
        public order_type: string,
        public ticker: string,
        public quantity: number,
        public price: number,
        public status: string) {
      }

}
