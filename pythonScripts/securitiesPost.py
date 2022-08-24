import requests
import json

def sendPost(filename):
    url = "http://localhost:8080/api/securities/addSecurity"
    with open(filename, "r") as inputfile:
        companies = json.load(inputfile)
        for value in companies.values():
            result = requests.post(url, json = value)
            print(result.text)


def main():
    sendPost("./securities.json")



if __name__ == "__main__":
    main()