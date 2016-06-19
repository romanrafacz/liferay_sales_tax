package liferay.App;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import liferay.domain.Item;
import liferay.domain.Order;
import liferay.domain.Product;
import liferay.ShoppingCart.ShoppingCart;
import liferay.Util.ProcessInput;

public class SalesTaxApp {
	  
	public static void main(String args[]){
	    
	    // create a scanner so we can read the command-line input
	    Scanner scanner = new Scanner(System.in);

	    // prompt for the user for input based on package.
	    System.out.print("Enter your order. 1 for Input 1, 2 for Input 2, 3 for Input 3, 4 for all items: ");
	    
	    // get their input as a String
	    int response = scanner.nextInt();
	    
	    scanner.close();
		
	    //Add one of the input variables to submit an order(4-2, 1-all, or 0-null)
	    ArrayList<Item> items = ProcessInput.submitOrder(response);
		
		//Loads items to a product object which returns an array used to create an order object
	    ArrayList<Product> products = ShoppingCart.loadItemsToProduct(items);
	    
	    //products array is used to create an order array for processing.
	    ArrayList<Order> order = ShoppingCart.loadProductsToOrder(products);        
	    double SalesTax = 0.00;
	    double Total = 0.00;
	    
	    //Print sale details
	    System.out.println();
	    System.out.println("Input" + response);
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