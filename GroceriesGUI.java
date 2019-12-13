import javax.swing.*;
import java.awt.event.*;

class GroceriesGUI extends JPanel{
   private Groceries groceries = new Groceries();
   private JFrame window = new JFrame("Shopping List");
   private JLabel lblToBuy = new JLabel("Shopping List Items");
   private JTextArea txtGroceries = new JTextArea();
   private JScrollPane paneItem = new JScrollPane(txtGroceries);
   private JLabel lblItem = new JLabel("Item: ");
   private JTextField txtItem = new JTextField();
   
   private JButton btnAddItem = new JButton ("Add Item");
   private JButton btnRemoveItem = new JButton ("Remove Item");
      
     
   
   public GroceriesGUI(){
      setLayout(null);
      lblToBuy.setBounds(10, 5, 200, 30);
      paneItem.setBounds(10, 35, 350, 100);
      lblItem.setBounds(10, 145, 50, 30);
      txtItem.setBounds(60, 145, 300, 30);
      btnAddItem.setBounds(60, 180, 110, 30);
      btnRemoveItem.setBounds(250, 180, 110, 30);
      paneItem.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      
      add(lblToBuy);
      add(paneItem);
      add(lblItem);
      add(paneItem);
      add(txtItem);
      add(btnAddItem);
      add(btnRemoveItem);
      
      window.add(this);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(400, 400);
      window.setVisible(true);
      
      txtGroceries.setText(groceries.toString());
      
      btnAddItem.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            String item = txtItem.getText();
            groceries.addItem(item);
            groceries.saveShoppingList();
            txtGroceries.setText(groceries.toString());
            txtItem.setText("");
         }
      });//End btnAddListener

      
      btnRemoveItem.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            String item = txtItem.getText();
            groceries.removeItem(item);
            groceries.saveShoppingList();
            txtGroceries.setText(groceries.toString());
            txtItem.setText("");
         }
      });//End btnRemoveListener

   }
  

   public static void main(String[] args){
      new GroceriesGUI();
   }//End main
}//End class