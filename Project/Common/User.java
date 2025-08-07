package Project.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.smartcardio.Card;

public class User {
    private long clientId = Constants.DEFAULT_CLIENT_ID;
    private String clientName;
    private boolean isReady = false;
    private boolean tookTurn = false;
    private List<CardType> cards = new ArrayList<>();
    private int points = 0;

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the clientId
     */
    public long getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the username
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param username the username to set
     */
    public void setClientName(String username) {
        this.clientName = username;
    }

    public String getDisplayName() {
        return String.format("%s#%s", this.clientName, this.clientId);
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    public void reset() {
        this.clientId = Constants.DEFAULT_CLIENT_ID;
        this.clientName = null;
        this.isReady = false;
        this.tookTurn = false;
        this.points = 0;
    }

    /**
     * @return the tookTurn
     */
    public boolean didTakeTurn() {
        return tookTurn;
    }

    /**
     * @param tookTurn the tookTurn to set
     */
    public void setTookTurn(boolean tookTurn) {
        this.tookTurn = tookTurn;
    }

    public void addCard(CardType card)
    {
        cards.add(card);
    }

    public void removeCard(CardType card)
    {
        cards.remove(card);
    }

    public void clearHand()
    {
        cards.clear();
    }

    public List<CardType> getHand()
    {
        return new ArrayList<>(cards);
    }

    public void syncCards(List<CardType> newCards) {
        cards.clear();
        if (newCards == null) {
            throw new IllegalArgumentException("Card list cannot be null");
        }
        for (CardType card : newCards) {
            if (card == null) {
                throw new IllegalArgumentException("Card cannot be null");
            }
            cards.add(card);
        }
    }

    public int checkForPair()
    {
        int pairs = 0;
        for (int cardOne = 0; cardOne < cards.size(); cardOne++)
        {
            for (int cardTwo = cardOne + 1; cardTwo < cards.size(); cardTwo++)
            {
                if (cards.get(cardOne) == cards.get(cardTwo))
                {
                    pairs++;
                    cards.remove(cardOne);
                    cards.remove(cardTwo - 1);
                    cardOne -= 2;
                    cardOne = Math.max(0, cardOne);
                }
            }
        }
        return pairs;
    }
}