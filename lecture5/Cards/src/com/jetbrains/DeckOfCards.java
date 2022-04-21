package com.jetbrains;

import java.util.Random;

public class DeckOfCards {
    private Cards deck[];
    private int currentCard;
    private final int NUMBER_OF_CARDS = 52;
    private Random randomNumbers;

    public DeckOfCards() {
        String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

        deck = new Cards[NUMBER_OF_CARDS];//create array of Cards objects
        currentCard = 0;//set the currentCard so first Card dealt is deck[0]
        randomNumbers = new Random();

        //fill the deck array
        for (int counter = 0; counter < deck.length; counter++) {
            deck[counter] = new Cards(faces[counter % 13], suits[counter / 13]);
        }

    }

    public void shuffle() {
        currentCard = 0;//reinitialize currentCard
        for (int first = 0; first < deck.length; first++) {

            //select a random number between 0 and 1
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            Cards temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public Cards dealCard(){
        if(currentCard<deck.length){
            return deck[currentCard++];

        }
        else{
            return null;
        }
    }

}
