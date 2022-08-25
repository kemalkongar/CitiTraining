export class Order {
    constructor(
        public orderType: string,
        public securityName: string,
        public quantity: number,
        public executePrice: number,
        public orderStatus: string) {
      }
}
