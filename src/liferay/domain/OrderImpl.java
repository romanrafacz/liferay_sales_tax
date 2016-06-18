package liferay.domain;

//Loads Products into an Order object, returns an array.

import java.util.ArrayList;

import liferay.Util.SalesTaxUtil;

public class OrderImpl {
	
	public static ArrayList<Order> loadProductsToOrder(ArrayList<Product> products){	
		ArrayList<Order> order = new ArrayList<Order>();
		for (Product x:products){
			order.add(new Order(SalesTaxUtil.CalculateSalesTax(x), 1));
		}
		return order;
	}
}

