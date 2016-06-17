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
		
		//Load shopping items to Product object - Product(item, price, imported, taxExemption, salesTax(default to 0.00);
		
		ArrayList<Product> products = new ArrayList<Product>();
		//products.add(new Product("Book", 12.49, false, true, 0.00));
		//products.add(new Product("CD", 14.99, false, false, 0.00));
		//products.add(new Product("Chocolate Bar", .85, false, true, 0.00));
		
		//products.add(new Product("Box of Chocolates", 10.00, true, true, 0.00));
		//products.add(new Product("Bottle of Perfume", 47.50, true, false, 0.00));
		
		products.add(new Product("Imported Bottle of Perfume", 27.99, true, false, 0.00));
		products.add(new Product("Bottle of Perfume", 18.99, false, false, 0.00));
		products.add(new Product("Packet of Headache Pills", 9.75, false, true, 0.00));
		products.add(new Product("Importe Box of Chocolates", 11.25, true, true, 0.00));
		
        ArrayList<Order> order = ProductImpl.loadProductsToOrder(products);        
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
