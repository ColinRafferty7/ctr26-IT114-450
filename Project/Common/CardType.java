package Project.Common;

public enum CardType {
    _A("A"),
    _2("2"),
    _3("3"),
    _4("4"),
    _5("5"),
    _6("6"),
    _7("7"),
    _8("8"),
    _9("9"),
    _10("10"),
    _J("J"),
    _Q("Q"),
    _K("K"),
    _X("X"),
    ;

    private final String cardName;

    CardType(String cardName) {
        this.cardName = cardName;
    }

    public String getCardType() {
        return cardName;
    }

    public static CardType fromString(String value) {
        for (CardType ct : CardType.values()) {
            if (ct.cardName.equals(value)) {
                return ct;
            }
        }
        throw new IllegalArgumentException("Invalid card type: " + value);
    }

    public String toString()
    {
        return cardName;
    }
}
