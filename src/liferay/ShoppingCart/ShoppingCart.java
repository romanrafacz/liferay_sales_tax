package liferay.ShoppingCart;

import java.util.ArrayList;

import liferay.Util.SalesTaxUtil;
import liferay.domain.Item;
import liferay.domain.Order;
import liferay.domain.Product;

public class ShoppingCart {
	
	//Loads an Array of inputed items to an array of Product objects
	public static ArrayList<Product> loadItemsToProduct(ArrayList<Item> items){
		ArrayList<Product> shoppingCartItems = new ArrayList<Product>();
		for(Item x:items){
			if (x.getItemName() == "book" || x.getItemName() == "music" || x.getItemName() == "packet of headache pills" || x.getItemName() == "chocolate bar" ){
				shoppingCartItems.add(new Product(x.getItemName(), x.getPrice(), false, true, 0.00));
			}else if (x.getItemName() == "imported box of chocolates"){
				shoppingCartItems.add(new Product(x.getItemName(), x.getPrice(), true, true, 0.00));
			}else if (x.getItemName() == "imported bottle of perfume"){
				shoppingCartItems.add(new Product(x.getItemName(), x.getPrice(), true, false, 0.00));
			}else {
				shoppingCartItems.add(new Product(x.getItemName(), x.getPrice(), false, false, 0.00));
			}	
		}
		return shoppingCartItems;
	}
	
	//Loads an Array of Product objects into an array of Order items.
	public static ArrayList<Order> loadProductsToOrder(ArrayList<Product> products){	
		ArrayList<Order> order = new ArrayList<Order>();
		for (Product x:products){
			order.add(new Order(SalesTaxUtil.CalculateSalesTax(x), 1));
		}
		return order;
	}
	
	

}

