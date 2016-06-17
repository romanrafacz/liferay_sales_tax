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
import liferay.Util.SubmitOrder;

public class SalesTaxApp {
	  
	public static void main(String args[]){
		
		final String input1 = "input1";
		final String input2 = "input2";
		final String input3 = "input3";
		final String all = "all";
		
		//Add one of the input variables to submit an order(input 1-3)
		ArrayList<Item> items = SubmitOrder.submitOrder(input1);
		
	    ArrayList<Product> products = ProductImpl.loadItemsToProduct(items);

        ArrayList<Order> order = OrderImpl.loadProductsToOrder(products);        
		double SalesTax = 0.00;
		double Total = 0.00;
	
		//Print sale details based on input/order items
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