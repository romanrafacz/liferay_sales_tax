package liferay.App;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import liferay.domain.Order;
import liferay.domain.Product;
import liferay.Util.SalesTaxUtil;

public class SalesTaxApp {
	  
	public static void main(String args[]){
		
		/*Load shopping items to Product object - Product(item, price, imported, taxExemption, salesTax(default to 0.00);
		 *Load Input 1 Book, Cd, Chocloate Bar 
		 */
		Product book = new Product("Book", 12.49, false, true, 0.00);
		Product cd = new Product("CD", 14.99, false, false, 0.00);
		Product chocolateBar = new Product("Chocloate Bar", .85, false, true, 0.00);
		
		//Load objects for Input 2
		Product boxOfChocolates = new Product("Box of Chocloates", 10.00, true, true, 0.00);
		Product importedBottleOfPerfume = new Product("Bottle of Perfume", 47.50, true, false, 0.00);
		
		//Load Objects for Input 3
		Product importedBottleOfPerfume2 = new Product("Bottle of Perfume", 27.99, true, false, 0.00);
		Product bottleOfPerfume2 = new Product("Bottle of Perfume", 18.99, false, false, 0.00);
		Product headachePills = new Product("Packet of Headache Pills", 9.75, false, true, 0.00);
		Product boxOfChocolates2 = new Product("Bottle of Perfume", 11.25, true, true, 0.00);

		/*Input1 -  Product to an Array list with the Order object = Product, OrderQuantity
		 *
		 */
        ArrayList<Order> input1 = new ArrayList<Order>();
		input1.add(new Order(SalesTaxUtil.CalculateSalesTax(book), 1));
		input1.add(new Order(SalesTaxUtil.CalculateSalesTax(cd), 1));
		input1.add(new Order(SalesTaxUtil.CalculateSalesTax(chocolateBar), 1));
		double input1SalesTax = 0.00;
		double input1Total = 0.00;
		
		//Input 2 Variables
		ArrayList<Order> input2 = new ArrayList<Order>();
		input2.add(new Order(SalesTaxUtil.CalculateSalesTax(boxOfChocolates), 1));
		input2.add(new Order(SalesTaxUtil.CalculateSalesTax(importedBottleOfPerfume), 1));
		double input2SalesTax = 0.00;
		double input2Total = 0.00;
		
		//Input 3 Variables
		ArrayList<Order> input3 = new ArrayList<Order>();
		input3.add(new Order(SalesTaxUtil.CalculateSalesTax(importedBottleOfPerfume2), 1));
		input3.add(new Order(SalesTaxUtil.CalculateSalesTax(bottleOfPerfume2), 1));
		input3.add(new Order(SalesTaxUtil.CalculateSalesTax(headachePills), 1));
		input3.add(new Order(SalesTaxUtil.CalculateSalesTax(boxOfChocolates2), 1));
		double input3SalesTax = 0.00;
		double input3Total = 0.00;
	
		//Sales Details for Input 1
		for (Order x:input1){
			System.out.println(x.getQuantity() + " " + x.getProduct().getItem() + " at " + x.getProduct().getPrice());
		}	
		System.out.println();
		System.out.println("Sale Receipt for Input 1");
		System.out.println();
		for (Order x:input1){
			System.out.println(x.getQuantity() + " " + x.getProduct().getItem() + " at " + String.format("%.2f", (x.getProduct().getPrice() + x.getProduct().getSalesTax())));
			input1SalesTax = input1SalesTax + x.getProduct().getSalesTax();
			input1Total = (input1Total + (x.getProduct().getPrice() + x.getProduct().getSalesTax()));
		}
		System.out.println("Sales tax: " + String.format("%.2f", input1SalesTax));
		System.out.println("Total: " + String.format("%.2f", input1Total)  );
		System.out.println();
		
		//Sales Details for Input 2
		System.out.println();
		System.out.println("Order Details Input 2");
		System.out.println();
		for (Order x:input2){
			System.out.println(x.getQuantity() + " " + x.getProduct().getItem() + " at " + x.getProduct().getPrice());
		}	
		System.out.println();
		System.out.println("Sale Receipt for Input 2");
		System.out.println();
		for (Order x:input2){
			System.out.println(x.getQuantity() + " " + x.getProduct().getItem() + " at " + String.format("%.2f", (x.getProduct().getPrice() + x.getProduct().getSalesTax())));
			input2SalesTax = input2SalesTax + x.getProduct().getSalesTax();
			input2Total = (input2Total + (x.getProduct().getPrice() + x.getProduct().getSalesTax()));
		}
		System.out.println("Sales tax: " + String.format("%.2f", input2SalesTax));
		System.out.println("Total: " + String.format("%.2f", input2Total)  );
		System.out.println();
		
		//Sales Details for Input 3
		System.out.println();
		System.out.println("Order Details Input 3");
		System.out.println();
		for (Order x:input3){
			System.out.println(x.getQuantity() + " " + x.getProduct().getItem() + " at " + x.getProduct().getPrice());
		}	
		System.out.println();
		System.out.println("Sale Receipt for Input 3");
		System.out.println();
		for (Order x:input3){
			System.out.println(x.getQuantity() + " " + x.getProduct().getItem() + " at " + String.format("%.2f", (x.getProduct().getPrice() + x.getProduct().getSalesTax())));
			input3SalesTax = input3SalesTax + x.getProduct().getSalesTax();
			input3Total = (input3Total + (x.getProduct().getPrice() + x.getProduct().getSalesTax()));
		}
		System.out.println("Sales tax: " + String.format("%.2f", input3SalesTax));
		System.out.println("Total: " + String.format("%.2f", input3Total)  );
		System.out.println();
			
	}
}
