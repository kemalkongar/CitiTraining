Private training repo for Mississauga Team 2

Kemal K., Weiyu L., Xinchen H.

# Steps for test sending order:
send post request to http://localhost:8080/api/orders/addOrder, and input JSON text:
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
# angular
First, start the spring boot application in localhost port 8080, this requires you to revert application.properties to the previous version.(I will modify this instruction once angular works with docker backend).  
Then cd into CitiTraining/myApp. If you haven't done already, do ```npm install```. Then run ```ng serve``` to start the application. If there's dependency issues, run ```rm -r node_module```, then 
```rm package-lock.json```,then ```npm install```.

You might further need to run `export NODE_OPTIONS=--openssl-legacy-provider` for the app to work for now. 
