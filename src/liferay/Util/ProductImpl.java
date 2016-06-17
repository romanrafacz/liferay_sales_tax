package liferay.Util;

import java.util.ArrayList;

import liferay.domain.Item;
import liferay.domain.Product;

//Loads Input from the user to the Product Object.

public class ProductImpl {
	
	public static ArrayList<Product> loadItemsToProduct(ArrayList<Item> items){
		ArrayList<Product> shoppingCart = new ArrayList<Product>();
		for(Item x:items){
			if (x.getItemName() == "book" || x.getItemName() == "music" || x.getItemName() == "packet of headache pills" || x.getItemName() == "chocolate bar" ){
				shoppingCart.add(new Product(x.getItemName(), x.getPrice(), false, true, 0.00));
			}else if (x.getItemName() == "imported box of chocolates"){
				shoppingCart.add(new Product(x.getItemName(), x.getPrice(), true, true, 0.00));
			}else if (x.getItemName() == "imported bottle of perfume"){
				shoppingCart.add(new Product(x.getItemName(), x.getPrice(), true, false, 0.00));
			}else {
				shoppingCart.add(new Product(x.getItemName(), x.getPrice(), false, false, 0.00));
			}	
		}
		return shoppingCart;
	}

}
