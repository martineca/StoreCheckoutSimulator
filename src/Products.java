// *************
// Product class
// **************
public class Products{
  private String id;
  private String name;
  private double price;
  
  public Products (String id, String name, double price){
	  this.id = id;
	  this.name = name;
	  this.price = price;
  }
  public String getID(){
      return (this.id);
  }
  public String getName(){
      return (this.name);
  }
  public double getPrice(){
      return (this.price);
  }
	
  public String toString(){
      return id + ": " + name + ", "+ price + "$";
  }

}
