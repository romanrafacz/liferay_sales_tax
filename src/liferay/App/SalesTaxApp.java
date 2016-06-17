package liferay.App;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import liferay.domain.Order;
import liferay.domain.Product;
import liferay.Util.ProductImpl;
import liferay.Util.SalesTaxUtil;

public class SalesTaxApp {
	  
	public static void main(String args[]){
		
		/*Load shopping items to Product object - Product(item, price, imported, taxExemption, salesTax(default to 0.00);
		 *Load Input 1 Book, Cd, Chocloate Bar 
		 */
		Product book = new Product("Book", 12.49, false, true, 0.00);
		Product cd = new Product("CD", 14.99, false, false, 0.00);
		Product chocolateBar = new Product("Chocloate Bar", .85, false, true, 0.00);
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(book);
		products.add(cd);
		products.add(chocolateBar);
		
		
        ArrayList<Order> order = ProductImpl.loadProdcutsToOrder(products);        
		double SalesTax = 0.00;
		double Total = 0.00;
		
	
		//Sales Details for Input
		for (Order x:order){
			System.out.println(x.getQuantity() + " " + x.getProduct().getItem() + " at " + x.getProduct().getPrice());
		}	
		System.out.println();
		System.out.println("Sale Receipt");
		System.out.println();
		for (Order x:order){
			System.out.println(x.getQuantity() + " " + x.getProduct().getItem() + " at " + String.format("%.2f", (x.getProduct().getPrice() + x.getProduct().getSalesTax())));
			SalesTax = SalesTax + x.getProduct().getSalesTax();
			Total = (Total + (x.getProduct().getPrice() + x.getProduct().getSalesTax()));
		}
		System.out.println("Sales tax: " + String.format("%.2f", SalesTax));
		System.out.println("Total: " + String.format("%.2f", Total)  );
		System.out.println();
		
		
			
	}
}
