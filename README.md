Private training repo for Mississauga Team 2

Kemal K., Weiyu L., Xinchen H.

Step for test sending order:
http://localhost:8080/api/orders/addOrder, and input JSON text:
```
{
    "quantity": 1,
    "executeBy": "2023-12-31",
    "executePrice": 120,
    "orderPlacedTime": "2022-08-11",
    "orderType": "SELL",
    "securityId": 1
}

```
You will see SUCCESS status in the database because the sell price 127 is lower than current price 171.68, and the order is immediately executed after placed.  
Changing executePrice to 200 results in a PENDING status, and the order will be added to sellPendingOrders queue.
