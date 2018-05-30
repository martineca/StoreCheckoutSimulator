import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// *************
// Manage checkouts Screen
// **************

public class ManageCheckoutsView extends JPanel {
    static JList AllCheckoutslist = new JList();
    static JLabel GlobalTotal = new JLabel("0$");

   public ManageCheckoutsView(mainFrame mainWindow){
       setLayout(null);

       final JLabel total = new JLabel("0$");
       total.setBounds(373, 215, 61, 16);
       add(total);

       JButton toCheckout = new JButton("Next");
       toCheckout.setBounds(147, 186, 117, 29);
       add(toCheckout);

       JButton btnAddviewProducts = new JButton("Add/view products");
       btnAddviewProducts.setBounds(72, 218, 151, 29);
       add(btnAddviewProducts);

       JButton btnAddCheckout = new JButton("Add Checkout");
       btnAddCheckout.setBounds(244, 218, 117, 29);
       add(btnAddCheckout);

       JLabel ChooseCheckoutLabel = new JLabel("Choose checkout");
       ChooseCheckoutLabel.setBounds(147, 26, 138, 16);
       add(ChooseCheckoutLabel);

       JScrollPane scrollPane_3 = new JScrollPane();
       scrollPane_3.setBounds(96, 81, 222, 93);
       add(scrollPane_3);

       AllCheckoutslist = new JList(mainWindow.checkoutsModel);
       scrollPane_3.setViewportView(AllCheckoutslist);
       JLabel lblTotalAmountFrom = new JLabel("Total amount from checkouts");
       lblTotalAmountFrom.setBounds(86, 53, 199, 16);
       add(lblTotalAmountFrom);

       GlobalTotal.setBounds(289, 53, 61, 16);
       add(GlobalTotal);

       btnAddCheckout.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               int add = mainWindow.checkoutsModel.size();
               mainWindow.checkoutsModel.addElement(new CheckOuts(add));

           }
       });

       toCheckout.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               try {
                   mainWindow.selectedCheckout = ManageCheckoutsView.AllCheckoutslist.getSelectedIndex();
                   total.setText(String.valueOf(((CheckOuts) mainWindow.checkoutsModel.getElementAt(mainWindow.selectedCheckout)).getTotal()) + "$");
                   CheckoutView.checkouts_list.setModel(((CheckOuts) mainWindow.checkoutsModel.getElementAt(mainWindow.selectedCheckout)));
                   CardLayout cl = (CardLayout) (mainWindow.cards.getLayout());
                   cl.show(mainWindow.cards, "name_20377923595946");
               } catch (Exception e1) {
                   JOptionPane.showMessageDialog(null, "Please select a checkout first!", "Alert", JOptionPane.ERROR_MESSAGE);
               }
           }
       });

       btnAddviewProducts.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               CardLayout cl = (CardLayout) (mainWindow.cards.getLayout());
               cl.show(mainWindow.cards, "name_215454235363453");
           }
       });
   }
}
