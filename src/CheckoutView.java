import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// *************
// Checkout Screen
// **************

public class CheckoutView extends JPanel {
    private JTextField scanField;
    static JList checkouts_list;
    public CheckoutView(mainFrame mainWindow){
        setLayout(null);


        final JCheckBox chckbxClubCardDiscount = new JCheckBox("Club Card Discount");
        chckbxClubCardDiscount.setBounds(265, 89, 155, 23);
        add(chckbxClubCardDiscount);

        final JLabel total = new JLabel("0$");
        total.setBounds(373, 215, 61, 16);
        add(total);

        scanField = new JTextField();
        scanField.setBounds(18, 147, 134, 28);
        add(scanField);

        scanField.setColumns(10);
        JButton btnCheckout = new JButton("Checkout Cash");
        btnCheckout.setBounds(265, 6, 139, 29);
        add(btnCheckout);

        JButton btnScann = new JButton("Scan");
        btnScann.setBounds(164, 148, 117, 29);
        add(btnScann);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(311, 215, 61, 16);
        add(lblTotal);

        JScrollPane productsAddedScrollPane = new JScrollPane();
        productsAddedScrollPane.setBounds(20, 25, 215, 110);
        add(productsAddedScrollPane);
         checkouts_list = new JList(mainWindow.checkouts[mainWindow.selectedCheckout]);
        productsAddedScrollPane.setViewportView(checkouts_list);

        JButton btnRemoveProduct = new JButton("Remove product");
        btnRemoveProduct.setBounds(265, 117, 139, 29);
        add(btnRemoveProduct);

        JButton btnBack = new JButton("back");
        btnBack.setBounds(20, 0, 117, 29);
        add(btnBack);

        JButton CheckoutCard = new JButton("Checkout Card");

        CheckoutCard.setBounds(265, 34, 139, 29);
        add(CheckoutCard);

        JButton btnAddProduct = new JButton("Add product");
        btnAddProduct.setBounds(265, 63, 139, 29);
        add(btnAddProduct);

        //available products to add
        JScrollPane availableProducts = new JScrollPane();
        availableProducts.setBounds(21, 205, 260, 55);
        add(availableProducts);

        final JList list_products = new JList();
        availableProducts.setViewportView(list_products);
        list_products.setModel(mainWindow.productsModel);

        JLabel lblAvailableProducts = new JLabel("Available products");
        lblAvailableProducts.setBounds(18, 187, 134, 16);
        add(lblAvailableProducts);

        btnAddProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedIndex = list_products.getSelectedIndex();
                    CheckOuts CheckoutSelected = (CheckOuts) mainWindow.checkoutsModel.getElementAt(mainWindow.selectedCheckout);
                    Products ProductSelected = (Products) mainWindow.productsModel.getElementAt(selectedIndex);
                    ProductSelected.getID();
                    CheckoutSelected.addProducts(ProductSelected.getID(), ProductSelected.getName(), ProductSelected.getPrice());
                    CheckoutSelected.addAmount(ProductSelected.getPrice());
                    double totalAmount = CheckoutSelected.getTotal();
                    totalAmount = Math.floor(totalAmount * 100) / 100;
                    total.setText(totalAmount + "$");
                    mainWindow.GlobalTotalAmount = mainWindow.GlobalTotalAmount + ProductSelected.getPrice();
                    mainWindow.GlobalTotalAmount = Math.floor(mainWindow.GlobalTotalAmount * 100) / 100;
                    ManageCheckoutsView.GlobalTotal.setText(mainWindow.GlobalTotalAmount + "$");

                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "Select Product First!", "Alert", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        btnRemoveProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = checkouts_list.getSelectedIndex();
                CheckOuts CheckoutSelected = (CheckOuts) mainWindow.checkoutsModel.getElementAt(mainWindow.selectedCheckout);
                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(null, "Select Product", "Select Product First", JOptionPane.ERROR_MESSAGE);
                } else {
                    Products toGo = (Products) CheckoutSelected.getElementAt(selectedIndex);
                    if (JOptionPane.showConfirmDialog(null,
                            "Remove Product", "Do you really wannt to remove?", JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION) {
                        CheckoutSelected.removeProduct(toGo.getID());
                        CheckoutSelected.removeAmount(toGo.getPrice());
                        double totalAmount = CheckoutSelected.getTotal();
                        totalAmount = Math.floor(totalAmount * 100) / 100;
                        total.setText(totalAmount + "$");
                        mainWindow.GlobalTotalAmount = mainWindow.GlobalTotalAmount - toGo.getPrice();
                        mainWindow.GlobalTotalAmount = Math.floor(mainWindow.GlobalTotalAmount * 100) / 100;
                        ManageCheckoutsView.GlobalTotal.setText(mainWindow.GlobalTotalAmount + "$");
                    }
                }
            }
        });


        CheckoutCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double clubCardDiscount = 2.4f;
                CheckOuts CheckoutSelected = (CheckOuts) mainWindow.checkoutsModel.getElementAt(mainWindow.selectedCheckout);
                if (CheckoutSelected.getSize() > 0) {
                    for (int i = 0; i < CheckoutSelected.getSize(); i++) {
                        System.out.println(CheckoutSelected.elementAt(i));
                    }
                    double totalAmount = CheckoutSelected.getTotal();
                    if (chckbxClubCardDiscount.isSelected()) {
                        totalAmount = totalAmount - ((totalAmount * clubCardDiscount) / 100.00f);
                    }
                    totalAmount = Math.floor(totalAmount * 100) / 100;
                    System.out.println(" ");
                    System.out.println("Payed by card");
                    System.out.println("======== ");
                    if (chckbxClubCardDiscount.isSelected()) {
                        System.out.println("Discount: " + Math.floor(((totalAmount * clubCardDiscount) / 100.00f) * 100) / 100 + " $");
                    }
                    System.out.println("Total: " + totalAmount + " $");
                    System.out.println("Debit: " + totalAmount + " $");
                    System.out.println("======== ");
                } else {
                    JOptionPane.showMessageDialog(null, "Add products", "Add products.", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double clubCardDiscount = 2.4f;
                CheckOuts CheckoutSelected = (CheckOuts) mainWindow.checkoutsModel.getElementAt(mainWindow.selectedCheckout);
                double totalAmount = CheckoutSelected.getTotal();
                if (chckbxClubCardDiscount.isSelected()) {

                    totalAmount = totalAmount - ((totalAmount * clubCardDiscount) / 100.00f);

                }
                totalAmount = Math.floor(totalAmount * 100) / 100;

                if (CheckoutSelected.getSize() > 0) {
                    String cashGivenStr = JOptionPane.showInputDialog("Please input given cash: ");
                    if (cashGivenStr != null) {
                        double cashGivenDouble = 0;
                        try {
                            cashGivenDouble = Double.parseDouble(cashGivenStr);
                            if (totalAmount <= cashGivenDouble) {

                                for (int i = 0; i < CheckoutSelected.getSize(); i++) {
                                    System.out.println(CheckoutSelected.elementAt(i));
                                }
                                double remainderAmount = cashGivenDouble - totalAmount;
                                remainderAmount = Math.floor(remainderAmount * 100) / 100;
                                System.out.println(" ");
                                System.out.println("Payed in cash");
                                System.out.println("======== ");
                                System.out.println("Cash given: " + cashGivenDouble + "$");
                                if (chckbxClubCardDiscount.isSelected()) {
                                    System.out.println("Discount: " + Math.floor(((totalAmount * clubCardDiscount) / 100.00f) * 100) / 100 + " $");
                                }
                                System.out.println("Total: " + totalAmount + " $");
                                System.out.println("Change: " + remainderAmount + " $");
                                System.out.println("======== ");
                            } else {
                                JOptionPane.showMessageDialog(null, "Money not enough!", "Money not enough!", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException e1) {
                            // TODO Auto-generated catch block
                            JOptionPane.showMessageDialog(null, "Please type in correct amount.", "Please type in correct amount.", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Add products", "Add products.", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (mainWindow.cards.getLayout());
                cl.show(mainWindow.cards, "name_19139854043156");
            }
        });
    }
}
