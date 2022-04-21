package cards;

public enum FaceOfCard {

    ACE("Ace"),
    DEUCE("Deuce"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King");

    private final String face;

    FaceOfCard(String newFace) {
        this.face = newFace == null ? "Ace" : newFace;
    }

    public String getFace() {
        return face;
    }

    @Override
    public String toString() {
        return String.format("%s",face);
    }
}


