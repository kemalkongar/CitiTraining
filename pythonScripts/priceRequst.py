from asyncore import read
from http.client import ImproperConnectionState
import requests
import json


def request(ticker):
    url = "https://3p7zu95yg3.execute-api.us-east-1.amazonaws.com/default/priceFeed2"
    result = requests.get(url, params={"ticker": ticker, "num_days": "10"})
    return result.text


def getResultNYSE():
    with open("./data/nyse-listed.json", "r") as readfile:
        data = json.load(readfile)
        for value in data:
            value["Price Data"] = request(value["ACT Symbol"])
            with open("./data/nyseprices.json", "w") as outfile:
                json.dump(data, outfile)
            print(value)


def getResultNASDAQ():
    with open("./data/nasdaq-listed-symbols.json", "r") as readfile:
        data = json.load(readfile)
        for value in data:
            value["Price Data"] = request(value["Symbol"])
            with open("./data/nasdaqprices.json", "w") as outfile:
                json.dump(data, outfile)
            print(value)


def main():
    getResultNASDAQ()


if __name__ == "__main__":
    main()
