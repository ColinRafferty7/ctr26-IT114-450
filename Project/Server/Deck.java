package Project.Server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import Project.Common.CardType;

public class Deck {
    private List<CardType> cards = new ArrayList<>();

    public Deck()
    {
        loadCards();
    }
    
    public void loadCards()
    {
        for (CardType card : CardType.values())
        {
            for (int i = 0; i < 4; i++)
            {
                cards.add(card);
            }
        }
        shuffle();
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public CardType draw()
    {
        CardType drawnCard = cards.get(0);
        cards.remove(0);
        return drawnCard;
    }

    public String toString()
    {
        return cards.toString();
    }
}
