import javax.swing.DefaultListModel;
// *************
// Checkout class
// **************

public class CheckOuts extends DefaultListModel {
	private int checkoutNumber;
	private double total;
	private Products products;

	  public CheckOuts(int checkoutNumber) {
	    super();
	    this.checkoutNumber = checkoutNumber;
	  }
	  
	  public void addProducts(String id, String name, double price)
	  throws ArrayIndexOutOfBoundsException{
		  super.addElement(new Products(id, name, price));
	  }
	  public void addAmount (double amount){
		  
		 total = total+amount;
	  }
	  public void removeAmount (double amount){
		  
			 total = total-amount;
		  }
	  
	  
	  public double getTotal(){
	      return total;
	  }
	  public Products findProductByID(String id){
	        Products temp;
	        int indexLocation = -1;
	        for (int i = 0; i < super.size(); i++) {
	            temp = (Products)super.elementAt(i);
	            if (temp.getID().equals(id)){
	                indexLocation = i;
	                break;
	            }
	        }
	        
	        if (indexLocation == -1) {
	            return null;
	        } else {
	            return (Products)super.elementAt(indexLocation);
	        }        
	    }
	  
	  public void removeProduct(String id){
	        Products empToGo = this.findProductByID(id);
	        super.removeElement(empToGo);
	    }
	  
	  public String toString(){
	      return  "Checkout: " + (checkoutNumber+1) ;
	  }

}
