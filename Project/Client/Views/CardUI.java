package Project.Client.Views;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import Project.Common.CardType;

public class CardUI extends JButton {
    public static final int CARD_WIDTH = 120;
    public static final int CARD_HEIGHT = 168;

    public CardUI(CardType card, Consumer<CardType> onSelect) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(8, 8, 8, 8));

        setToolTipText(card.getCardType());
        setText(String.format(
                "<html><div style='width:100%%; white-space:normal;'><ul style='margin:0;padding:0;list-style:none;'>"
                        + "<li><b>Type:</b> %s</li>"
                        + "</ul></div></html>",

                card.getCardType()));
        addActionListener(_ -> {
            if (onSelect != null) {
                onSelect.accept(card);
            }
        });
        setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
        setMinimumSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
        setMaximumSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
        setAlignmentY(TOP_ALIGNMENT);
    }

    public void removeListeners() {
        // remove all action listeners
        for (ActionListener al : getActionListeners()) {
            removeActionListener(al);
        }
    }
}