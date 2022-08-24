export class Order {
    constructor(
        public order_type: string,
        public security_name: string,
        public quantity: number,
        public execute_price: number,
        public order_status: string) {
      }
}
