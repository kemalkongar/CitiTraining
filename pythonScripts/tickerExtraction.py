import json

def jsonImport(filename):
    with open(filename, "r") as read_file:
        data = json.load(read_file)
        return data

def nyseTickerExtraction(nyse):
    companies = {}
    for value in nyse:
        name = value["Company Name"]
        ticker = value["ACT Symbol"]
        companies[ticker] = name
    return companies

def nasdaqTickerExtraction(nasdaq):
    companies = {}
    for value in nasdaq:
        name = value["Company Name"]
        ticker = value["Symbol"]
        companies[ticker] = name
    return companies

def writeToFile(filename, data):
    with open(filename, "w") as outfile:
        json.dump(data, outfile)

def main():
    nyseData = jsonImport("./data/nyse-listed.json")
    nasdaqData = jsonImport("./data/nasdaq-listed-symbols.json")
    nyse = nyseTickerExtraction(nyseData)
    nasdaq = nasdaqTickerExtraction(nasdaqData)
    writeToFile("./data/nyse.json", nyse)
    writeToFile("./data/nasdaq.json", nasdaq)

    print(nyse, nasdaq)
    


if __name__ == "__main__":
    main()