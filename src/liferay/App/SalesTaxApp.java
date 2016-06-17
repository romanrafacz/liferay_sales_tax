package liferay.App;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import liferay.domain.Item;
import liferay.domain.Order;
import liferay.domain.Product;
import liferay.Util.OrderImpl;
import liferay.Util.ProductImpl;
import liferay.Util.SalesTaxUtil;

public class SalesTaxApp {
	  
	public static void main(String args[]){
		
		ArrayList<Item> items = new ArrayList<Item>();
		/*Input 1 - Works
		items.add(new Item("book", 12.49));
		items.add(new Item("music cd", 14.99));
		items.add(new Item("chocolate bar", .85));
		*/
		
		//Input 2 - Works
		//items.add(new Item("imported box of chocolates", 10.00));
		//items.add(new Item("imported bottle of perfume", 47.50));
		
		//Input 3
		items.add(new Item("imported bottle of perfume", 27.99));
		items.add(new Item("bottle of perfume", 18.99));
		items.add(new Item("packet of headache pills", 9.75));
		items.add(new Item("imported box of chocolates", 11.25));
		
	    ArrayList<Product> products = ProductImpl.loadItemsToProduct(items);

        ArrayList<Order> order = OrderImpl.loadProductsToOrder(products);        
		double SalesTax = 0.00;
		double Total = 0.00;
	
		//Sales Details for Input
		System.out.println("Order");
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
		System.out.println();
			
	}
}
