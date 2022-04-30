package game;

public class Card {

    private String face;
    private String suit;

    public Card(String face, String suit) {
        setFace(face);
        setSuit(suit);
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return face + "of" + suit;
    }


}
