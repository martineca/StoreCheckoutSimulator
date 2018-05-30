import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// *************
// Manage products Screen
// **************

public class ProductManageView extends JPanel{

    public ProductManageView(mainFrame mainWindow){
        setLayout(null);

        JScrollPane scrollPane_4 = new JScrollPane();
        scrollPane_4.setBounds(33, 24, 382, 150);
        add(scrollPane_4);

        final JList panelProductsList = new JList(mainWindow.productsModel);
        scrollPane_4.setViewportView(panelProductsList);

        JButton btnCreateProduct = new JButton("Create Product");
        btnCreateProduct.setBounds(25, 226, 117, 29);
        add(btnCreateProduct);

        JButton btnDeleteProdct = new JButton("Delete Product");
        btnDeleteProdct.setBounds(160, 226, 117, 29);
        add(btnDeleteProdct);

        mainWindow.txtBarcode = new JTextField();
        mainWindow.txtBarcode.setText("BarCode");
        mainWindow.txtBarcode.setBounds(33, 198, 109, 28);
        add(mainWindow.txtBarcode);
        mainWindow.txtBarcode.setColumns(10);

        mainWindow.txtProductname = new JTextField();
        mainWindow.txtProductname.setText("ProductName");
        mainWindow.txtProductname.setBounds(160, 198, 134, 28);
        add( mainWindow.txtProductname);
        mainWindow.txtProductname.setColumns(10);

        mainWindow.txtProductprice = new JTextField();
        mainWindow.txtProductprice.setText("ProductPrice");
        mainWindow.txtProductprice.setBounds(322, 198, 93, 28);
        add( mainWindow.txtProductprice);
        mainWindow.txtProductprice.setColumns(10);

        JButton btnBack_1 = new JButton("Back");
        btnBack_1.setBounds(307, 226, 117, 29);
        add(btnBack_1);

        JLabel lblAddOrView = new JLabel("Add or view products");
        lblAddOrView.setBounds(33, 6, 150, 16);
        add(lblAddOrView);

        JLabel lblBarcode = new JLabel("Barcode");
        lblBarcode.setBounds(37, 182, 61, 16);
        add(lblBarcode);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(163, 182, 61, 16);
        add(lblName);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(325, 182, 61, 16);
        add(lblPrice);

        btnCreateProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = mainWindow.txtBarcode.getText();
                    String name = mainWindow.txtProductname.getText();
                    if (id.equals("") || name.equals("")) {
                        JOptionPane.showMessageDialog(null, "id or name is empty!", "Id or name is empty!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        double price = Double.parseDouble(mainWindow.txtProductprice.getText());
                        ((DefaultListModel) mainWindow.productsModel).addElement(new Products(id, name, price));
                    }
                } catch (NumberFormatException e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "Please type in correct price!", "Alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnDeleteProdct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = panelProductsList.getSelectedIndex();
                mainWindow.productsModel.remove(selectedIndex);
            }
        });

        btnBack_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (mainWindow.cards.getLayout());
                cl.show(mainWindow.cards, "name_19139854043156");
            }
        });

    }
}
