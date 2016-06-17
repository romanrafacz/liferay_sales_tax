package liferay.Util;

import java.util.ArrayList;
import java.util.List;

import liferay.domain.Product;
import liferay.domain.Order;

public class ProductImpl {
	
	public static ArrayList<Order> loadProdcutsToOrder(ArrayList<Product> products){	
		ArrayList<Order> input = new ArrayList<Order>();
		for (Product x:products){
			input.add(new Order(SalesTaxUtil.CalculateSalesTax(x), 1));
		}
		return input;
	}
}

