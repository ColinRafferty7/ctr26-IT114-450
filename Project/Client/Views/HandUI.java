package Project.Client.Views;

import Project.Client.Client;
import Project.Client.Interfaces.ICardsEvent;
import Project.Common.CardType;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class HandUI extends JPanel implements ICardsEvent {
    private final HashMap<String, CardUI> cards;
    private final Consumer<CardType> onCardSelect;
    private final JPanel cardPanel;

    public HandUI(Consumer<CardType> onCardSelect) {
        super(new BorderLayout());
        this.onCardSelect = onCardSelect;

        // 1. Change to GridBagLayout for horizontal packing
        cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        cards = new HashMap<>();
        JScrollPane scrollPane = new JScrollPane(cardPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
        Client.INSTANCE.registerCallback(this);
    }

    public void addCard(CardType card) {
        CardUI cardView = new CardUI(card, this::handleCardSelection);
        cards.put(card.getCardType(), cardView);

        // Add with GridBagConstraints (for spacing)
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = cardPanel.getComponentCount();
        gbc.insets = new Insets(0, gbc.gridx == 0 ? 0 : 8, 0, 0); // 8px left gap after first card
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;
        cardPanel.add(cardView, gbc);

        cardPanel.revalidate();
        cardPanel.repaint();
    }

    public void updateCards(List<CardType> cardList) {
        // Remove CardObjectViews not in the new list
        cards.keySet().removeIf(id -> {
            boolean willRemove = cardList.stream().noneMatch(c -> c.getCardType().equals(id));
            if (willRemove) {
                CardUI cardView = cards.get(id);
                if (cardView != null) {
                    cardView.removeListeners();
                }
            }
            return willRemove;
        });
        cardPanel.removeAll();

        // 2. Add or update CardObjectViews for each card with spacing
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;

        for (int i = 0; i < cardList.size(); i++) {
            CardType card = cardList.get(i);
            CardUI cardView = cards.get(card.getCardType());
            if (cardView == null) {
                cardView = new CardUI(card, this::handleCardSelection);
                cards.put(card.getCardType(), cardView);
            }
            gbc.gridx = i;
            gbc.insets = new Insets(0, i == 0 ? 0 : 8, 0, 0); // 8px gap after first card
            cardPanel.add(cardView, gbc);
        }
        cardPanel.revalidate();
        cardPanel.repaint();
    }

    private void handleCardSelection(CardType card) {
        System.out.println("Selected card: " + card.getCardType());
        if (onCardSelect != null) {
            onCardSelect.accept(card);
        }
    }

    public void onCardAdded(CardType card) {
    }

    public void onCardRemoved(CardType card) {
        CardUI cardView = cards.remove(card.getCardType());
        if (cardView != null) {
            cardView.removeListeners();
            cardPanel.remove(cardView);
            cardPanel.revalidate();
            cardPanel.repaint();
        }
    }

    public void onCardsSync(List<CardType> cards) {
        updateCards(cards);
    }

    public void onCardsUpdate(long clientId, int cards)
    {

    }
}
