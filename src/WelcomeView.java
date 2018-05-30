import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// *************
// Welcome screen
// **************

public class WelcomeView extends JPanel {

    public WelcomeView(mainFrame mainWindow) {
        setLayout(null);
        JButton enterSystem = new JButton("Continue");
        enterSystem.setBounds(157, 148, 117, 29);
        add(enterSystem);

        JLabel lblNewLabel = new JLabel("Welcome to checkout system");
        lblNewLabel.setBounds(121, 33, 243, 16);
        add(lblNewLabel);

        enterSystem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (mainWindow.cards.getLayout());
                cl.show(mainWindow.cards, "name_19139854043156");
            }
        });
    }
}
