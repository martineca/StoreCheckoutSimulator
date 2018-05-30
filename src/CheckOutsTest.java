import static org.junit.Assert.*;
import org.junit.Test;
// *************
// JUnit test
// **************

public class CheckOutsTest {
	private Products product;
	private CheckOuts[] checkouts;
	@Test
    public void CheckoutAmountTest()
    {
        CheckOuts checkOut1 = new CheckOuts(1);
        CheckOuts CheckoutSelected =(CheckOuts) checkOut1;
        Products product1 = new Products("S001", "RedBull", 3.00);
        checkOut1.addProducts(product1.getID(), product1.getName(), product1.getPrice());
        checkOut1.addAmount(product1.getPrice());
        assertEquals(3, checkOut1.getTotal(), 0.1);
        checkOut1.removeAmount(2);
        assertEquals(1, checkOut1.getTotal(), 0.1);
        
    }
	@Test
	  public void CheckoutNameTest()
	    {
	        CheckOuts checkOut1 = new CheckOuts(1);
	        CheckOuts CheckoutSelected =(CheckOuts) checkOut1;
	        Products product1 = new Products("S001", "RedBull", 3.00);
	        checkOut1.addProducts(product1.getID(), product1.getName(), product1.getPrice());
	        assertEquals("S001", product1.getID());
	    }
}
