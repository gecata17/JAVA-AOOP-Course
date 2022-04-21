package cards;

public class Card {
    private FaceOfCard face;
    private SuitOfCard suit;

    //set method for the face of the card
    public void setFace(FaceOfCard face) {
        this.face = face == null ? FaceOfCard.ACE : face;
    }

    //set method for suit of the card
    public void setSuit(SuitOfCard suit) {
        this.suit = suit == null ? SuitOfCard.CLUBS : suit;
    }

    //get method for face of the card
    public FaceOfCard getFace() {
        return face;
    }

    //get method for suit of the card
    public SuitOfCard getSuit() {
        return suit;
    }

    //default constructor
    public Card() {
        setFace(FaceOfCard.ACE);
        setSuit(SuitOfCard.CLUBS);
    }

    //general purpose constructor
    public Card(FaceOfCard face, SuitOfCard suit) {
        setFace(face);
        setSuit(suit);
    }

    @Override
    public String toString() {
        //return the following formatted String : <сила на карта> of <цвят на карта>
        return String.format("%s ", face + " of " + suit);
    }
}
