import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;

// *************
// main JFrame
// **************

public class mainFrame extends JFrame {
    private JPanel contentPane;
    private JLabel total;
    private Products[] product;
    public CheckOuts[] checkouts = {new CheckOuts(0)};
    public int selectedCheckout;
    public double GlobalTotalAmount;
    public JTextField txtBarcode;
    public JTextField txtProductname;
    public JTextField txtProductprice;
    final DefaultListModel checkoutsModel = new DefaultListModel();
    final DefaultListModel productsModel = new DefaultListModel();
    ManageCheckoutsView panelAllCheckouts;
    final JPanel cards = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainFrame frame = new mainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public mainFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        for (int i = 0, n = checkouts.length; i < n; i++) {
            checkoutsModel.addElement(checkouts[i]);
        }

        // add sample products data
        productsModel.addElement(new Products("S001", "RedBull", 3.00));
        productsModel.addElement(new Products("S002", "Chicken Steak", 4.50));
        productsModel.addElement(new Products("S003", "Jack Daniels", 29.93));
        productsModel.addElement(new Products("S004", "Beef Steak", 3.52));
        productsModel.addElement(new Products("S005", "Pasta", 0.60));
        productsModel.addElement(new Products("S006", "Coffee Gold", 4.99));

        //Add all jPanel classes to the card layout
        cards.setBounds(5, 5, 440, 267);
        contentPane.add(cards);
        cards.setLayout(new CardLayout(0, 0));
        //Add welcome screen + button
        WelcomeView panelWelcome = new WelcomeView(this);
        cards.add(panelWelcome, "name_19139841872446");
        //configure allCheckouts screen
        panelAllCheckouts = new ManageCheckoutsView(this);
        cards.add(panelAllCheckouts, "name_19139854043156");
        //configure Checkout panel screen
        CheckoutView panelCheckout = new CheckoutView(this);
        cards.add(panelCheckout, "name_20377923595946");
        // Configure allProducts screen
        ProductManageView panelProducts = new ProductManageView(this);
        cards.add(panelProducts, "name_215454235363453");

    }
}
