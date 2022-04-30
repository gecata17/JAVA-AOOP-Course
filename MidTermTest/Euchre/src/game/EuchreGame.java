package game;

import java.util.Random;

public class EuchreGame {
    private Card[] cards; // масив от всички карти в тестето от карти
    private Card[] hand; // текущо изтеглена ръка от най- много 5 карти
    private String TRUMP; // константа на всяка отделна игра
    private Random random; // генератор на случайни числа
    private int dealCard; // брой карти изтеглени текущо от cards

    private FaceOfCard[] faces = {FaceOfCard.ACE, FaceOfCard.KING, FaceOfCard.QUEEN, FaceOfCard.JACK, FaceOfCard.TEN, FaceOfCard.NINE};
    private SuitOfCard[] suits = {SuitOfCard.CLUBS, SuitOfCard.DIAMONDS, SuitOfCard.HEARTS, SuitOfCard.SPADES};


    public void setDealCard(int dealCard) {
        this.dealCard = (dealCard >= 0) ? dealCard : 0;
    }

    public EuchreGame() {
        cards = new Card[24];
        random = new Random();
        hand = new Card[5];
        setDealCard(0);

        int count = 0;

        for (int face = 0; face < faces.length; face++) {
            for (int suit = 0; suit < suits.length; suit++) {
                cards[count++] = new Card(faces[face].toString(), suits[suit].toString());

            }
        }

        SuitOfCard[] suit = SuitOfCard.values();
        TRUMP = suit[random.nextInt(4)].toString();
    }

    public String getTRUMP() {
        return TRUMP;
    }

    public void shuffleCards() {
        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int second = random.nextInt(24);

            Card temp = cards[i];
            cards[i] = cards[second];
            cards[second] = temp;
        }
        setDealCard(0);

    }

    public String printCards() {
        String output = "";
        int counter = 0;

        for (int i = 0; i < hand.length; i++) {
            if (counter == 3) {
                output += '\n';
                counter = 0;
                i--;
            } else {
                output = output + hand[i].toString() + ", ";
                counter++;
            }
        }
        return output;
    }

    public boolean dealHand(){
        for (int i = 0; i < 5; i++) {
            if (dealCard < cards.length)
                hand[i] = cards[dealCard++];
            else
                hand[i] = null;
        }

        return (dealCard < cards.length) ? true : false;
    }

    public int countHandStrength(){
        int result = 0;
        for(Card card : hand){
            result += FaceOfCard.valueOf(card.getFace()).ordinal();
        }
        return result;
    }

    public boolean hasJackQueenKingTrump(){
        boolean hasKing = false;
        boolean hasQueen = false;
        boolean hasJack = false;

        for(Card card : hand) {
            if (card.getSuit() == TRUMP)
            {
                if (card.getFace() == FaceOfCard.KING.toString())
                    hasKing = true;
                else if(card.getFace() == FaceOfCard.QUEEN.toString())
                    hasQueen = true;
                else if (card.getFace() == FaceOfCard.JACK.toString())
                    hasJack = true;
            }
        }
        return (hasJack && hasKing && hasQueen);
    }
    public boolean hasJackANDAceTrump (){
        boolean hasAce = false;
        boolean hasJack = false;

        for(Card card : hand) {
            if (card.getSuit() == TRUMP)
            {
                if (card.getFace() == FaceOfCard.ACE.toString())
                    hasAce = true;
                else if (card.getFace() == FaceOfCard.JACK.toString())
                    hasJack = true;
            }
        }
        return (hasJack && hasAce);
    }

    public static void main(String[] args) {
        EuchreGame game = new EuchreGame();
        game.shuffleCards();

        System.out.println(game.printCards());
    }
}
