package liferay.domain;

import java.util.ArrayList;

//Loads Sales items from the user to the Product Object, returns an array.

public class ProductImpl {
	
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

}
