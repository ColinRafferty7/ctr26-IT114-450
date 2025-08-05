package Project.Common;

import java.util.ArrayList;
import java.util.List;

public class CardsPayload extends Payload 
{
    private List<CardType> cards = new ArrayList<>();
    public CardsPayload(List<CardType> cards)
    {
        setPayloadType(PayloadType.CARDS);
        this.cards = cards;
    }

    public List<CardType> getCards()
    {
        return cards;
    }

    public String toString()
    {
        String out = super.toString() + " {Cards =";
        for (CardType card : cards)
        {
            out = out + " " + card.getCardType();
        }
        return super.toString() + out + "}";
    }
}
