package Project.Client.Views;

import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Project.Client.Client;
import Project.Common.LoggerUtil;
import Project.Client.Interfaces.IConnectionEvents;

public class ReadyView extends JPanel implements IConnectionEvents {

    private final JTextField numDecks = new JTextField("1");
    private final JLabel decktext = new JLabel("Number of Decks: ");
    private final JLabel toggletext = new JLabel("Include Joker?");
    private final JCheckBox jokerToggle = new JCheckBox();
    private String deckCount;
    private JPanel content = new JPanel();
    private boolean isHost = false;
    

    public ReadyView() {
        // TODO some projects may need to add other UI here for pre-session setup
        JButton readyButton = new JButton("Ready");
        Client.INSTANCE.registerCallback(this);


        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(new EmptyBorder(10, 10, 10, 10));

        readyButton.addActionListener(_ -> {
            try {
                Client.INSTANCE.sendReady(isHost ? numDecks.getText().trim() : "", jokerToggle.isSelected());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        content.add(readyButton);

        add(content);
    }

    @Override
    public void roomCreator()
    {
        content.add(decktext);
        content.add(numDecks);
        content.add(toggletext);
        content.add(jokerToggle);
        isHost = true;
    }

    public String getDeckCount()
    {
        return numDecks.getText().trim();
    }

    public void onReceiveClientId(long id)
    {

    }

    public void onClientDisconnect(long id)
    {

    }
}
