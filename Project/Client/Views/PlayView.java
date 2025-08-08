package Project.Client.Views;

import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Project.Client.Client;
import Project.Common.CardType;
import Project.Common.Phase;

public class PlayView extends JPanel {
    private final JPanel buttonPanel = new JPanel();
    private final HandUI HandUI;
    private CardType selectedCard;

    public PlayView(String name) {
        this.setName(name);
        this.setLayout(new BorderLayout());
        // example user interaction
        buttonPanel.setLayout(new BorderLayout());
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setResizeWeight(0.6);
        splitPane.setDividerLocation(0.6);
        splitPane.setOneTouchExpandable(false);
        splitPane.setEnabled(false); // Prevent user from moving the divider

        HandUI = new HandUI(this::handleCardSelection);
        splitPane.setBottomComponent(HandUI);
        buttonPanel.add(splitPane, BorderLayout.CENTER);

        this.add(buttonPanel, BorderLayout.CENTER);
    }

    private void handleCardSelection(CardType card) {
        selectedCard = card;
        processSelections();
    }

    private void processSelections() {
        
    }

    public void changePhase(Phase phase){
        if (phase == Phase.READY) {
            buttonPanel.setVisible(false);
        } else if (phase == Phase.IN_PROGRESS) {
            buttonPanel.setVisible(true);
        }
    }
    
}
