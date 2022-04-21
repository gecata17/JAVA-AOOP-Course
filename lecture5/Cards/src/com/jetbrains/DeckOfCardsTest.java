package com.jetbrains;

public class DeckOfCardsTest {

    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();

        //print all 52 cards in the order in whicj they are dealt
        for (int i = 0; i < 13; i++) {
            System.out.printf("%-20s%-20s%-20s%-20s\n",myDeckOfCards.dealCard(),
                    myDeckOfCards.dealCard(),
                    myDeckOfCards.dealCard(),
                    myDeckOfCards.dealCard());

        }
    }
}
