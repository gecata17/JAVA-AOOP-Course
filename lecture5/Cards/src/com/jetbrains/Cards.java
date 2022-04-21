package com.jetbrains;

public class Cards {

    private String face;//face of card ("Ace, "Deuce" , ...)
    private String suit; // suit of card ("Hearts", "Diamonds")

    public Cards(String cardFace,String cardSuit){
       face = cardFace;//initialize face of card
       suit = cardSuit;//initialize suit of card

    }

    public String toString(){
        return face + "of" + suit;
    }
}
