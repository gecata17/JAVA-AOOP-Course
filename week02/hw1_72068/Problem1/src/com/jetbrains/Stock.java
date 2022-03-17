package com.jetbrains;

public class Stock {
    private String symbol;// symbol  this Stock represents
    private String name;//name this Stock represents
    private double previousClosingPrice;//previous closing price this Stock represents
    private double currentPrice;//the current price this Stock represents



    public Stock(String symbol, String name) {
        setSymbol(symbol);
        setName(name);

    }

    //method to set the symbol
    public void setSymbol(String symbol) {
        if (symbol != null) {
            this.symbol = symbol;
        } else {
            this.symbol = "#####";
        }
    }//end method setSymbol

    //method to set the name
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }//end method setName

    //method to set  the previous closing price
    public void setPreviousClosingPrice(double previousClosingPrice) {
        if (previousClosingPrice > 0) {
            this.previousClosingPrice = previousClosingPrice;
        } else {
            this.previousClosingPrice = 1;
        }
    }//end method setPreviousClosingPrice

    //method  to set the current price
    public void setCurrentPrice(double currentPrice) {
        if (currentPrice > 0) {
            this.currentPrice = currentPrice;
        } else {
            this.currentPrice = 1;
        }
    }//end method setCurrentPrice

    //method to retrieve the symbol
    public String getSymbol() {
        return symbol;
    } //end method getSymbol

    //method to retrieve the name
    public String getName() {
        return name;
    }//end method getName

    //method to retrieve the previous closing price
    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }//end method previousClosingPrice

    //method to retrieve the current price
    public double getCurrentPrice() {
        return currentPrice;
    }//end method getCurrentPrice

    //method to return the percentage  of change of this stock
    public double changePercent() {
        double changeOfPercent;
        double changeOfStock;
        double divisionOfNumbers;
        double minNumber = Math.min(getCurrentPrice(), getPreviousClosingPrice());
        if (getPreviousClosingPrice() < getCurrentPrice()) {
            changeOfStock = getCurrentPrice() - getPreviousClosingPrice();
            divisionOfNumbers = changeOfStock / minNumber;
            changeOfPercent = divisionOfNumbers * 100;

        } else {
            changeOfStock = getPreviousClosingPrice() - getCurrentPrice();
            divisionOfNumbers = changeOfStock / minNumber;
            changeOfPercent = divisionOfNumbers * 100;
        }
        return changeOfPercent;
    }//end method changePercent

}//end class Stock
