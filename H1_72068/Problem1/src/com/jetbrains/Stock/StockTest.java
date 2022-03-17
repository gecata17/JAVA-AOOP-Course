package com.jetbrains.Stock;

import com.jetbrains.Stock.Stock;

public class StockTest {
    public static void main(String[] args) {

        //create Stock object myStock

        Stock myStock = new Stock("EA","Emporio Armani");

        //set the previous closing price of the stock
        myStock.setPreviousClosingPrice(400.00);
        //set the current price of the stock
        myStock.setCurrentPrice(300.00);

        System.out.printf("Name of stock : %s\n" ,myStock.getName());

        System.out.printf("Symbol : %s\n",myStock.getSymbol());

        System.out.printf("Previous closing price: %.2f\n",myStock.getPreviousClosingPrice());

        System.out.printf("Current price: %.2f\n",myStock.getCurrentPrice());

        System.out.printf("Change of percent of price : %.2f",myStock.changePercent());
        System.out.println("%");


    }//end main



}//end class StockTest