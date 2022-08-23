import json

def importJson():
    resultDict = {}
    companyIndex = 1
    with open("./nyseprices.json", "r") as inputfile:
        data = json.load(inputfile)
        for value in data:
            priceData = json.loads(value["Price Data"])
            if "error" not in priceData and 'ticker' in priceData and 'price_data' in priceData:
                companyInstance = {}
                companyInstance["id"] = companyIndex
                companyInstance["ticker"] = value["ACT Symbol"]
                companyInstance["name"] = value["Company Name"]
                companyInstance["exchange"] = "nyse"
                
                date = 0
                for value in priceData["price_data"]:
                    if date == 0:
                        companyInstance["t0"] = round(value["value"], 2)
                        date +=1
                    else:
                        name = f"tminus{date}"
                        companyInstance[name] = round(value["value"], 2)
                        date +=1
                resultDict[str(companyIndex)] = companyInstance
                companyIndex +=1
    
    with open("./nasdaqprices.json", "r") as inputfile:
        data = json.load(inputfile)
        for value in data:
            priceData = json.loads(value["Price Data"])
            if "error" not in priceData and 'ticker' in priceData and 'price_data' in priceData:
                companyInstance = {}
                companyInstance["id"] = companyIndex
                companyInstance["ticker"] = value["Symbol"]
                companyInstance["name"] = value["Company Name"]
                companyInstance["exchange"] = "nasdaq"
                
                date = 0
                for value in priceData["price_data"]:
                    if date == 0:
                        companyInstance["t0"] = round(value["value"], 2)
                        date +=1
                    else:
                        name = f"tminus{date}"
                        companyInstance[name] = round(value["value"], 2)
                        date +=1
                resultDict[str(companyIndex)] = companyInstance
                companyIndex +=1
    print(resultDict)
    return resultDict
                
        



def main():
    with open("securities.json", "w") as outfile:
        json.dump(importJson(), outfile)

if __name__ == "__main__":
    main()