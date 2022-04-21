package cards;

public enum SuitOfCard {
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");

    private final String suit;

    SuitOfCard(String newSuit) {
        this.suit = newSuit == null ? "Clubs" : newSuit;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("%s",suit);
    }
}
