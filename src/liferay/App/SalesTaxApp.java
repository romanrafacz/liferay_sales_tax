package liferay.App;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import liferay.domain.Item;
import liferay.domain.Order;
import liferay.domain.Product;
import liferay.ShoppingCart.ShoppingCart;
import liferay.Util.SalesTaxUtil;
import liferay.Util.ProcessInput;

public class SalesTaxApp {
	  
	public static void main(String args[]){
		
		//Start GUI for Input selection
		String[] options = new String[] {"cancel", "all", "input3", "input2", "input1"};
	    int response = JOptionPane.showOptionDialog(null, "Select a input", "Sales Tax App",
	          JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	          null, options, options[0]);
		
		
		//Add one of the input variables to submit an order(4-2, 1-all, or 0-null)
		ArrayList<Item> items = ProcessInput.submitOrder(response);
		
		//Loads items to a product object which returns an array used to create an order object
	    ArrayList<Product> products = ShoppingCart.loadItemsToProduct(items);
	    
	    //products array is used to create an order array for processing.
        ArrayList<Order> order = ShoppingCart.loadProductsToOrder(products);        
		double SalesTax = 0.00;
		double Total = 0.00;
	
		//Print sale details
		System.out.println("Input");
		System.out.println();
		for (Order x:order){
			System.out.println(x.getQuantity() + " " + x.getProduct().getItem() + " at " + String.format("%.2f", x.getProduct().getPrice()));
		}
		System.out.println();
		System.out.println("Receipt");
		System.out.println();
		for (Order x:order){
			System.out.println(x.getQuantity() + " " + x.getProduct().getItem() + " at " + String.format("%.2f", (x.getProduct().getPrice() + x.getProduct().getSalesTax())));
			SalesTax = SalesTax + x.getProduct().getSalesTax();
			Total = (Total + (x.getProduct().getPrice() + x.getProduct().getSalesTax()));
		}
		System.out.println("Sales tax: " + String.format("%.2f", SalesTax));
		System.out.println("Total: " + String.format("%.2f", Total)  );
	
	}
}