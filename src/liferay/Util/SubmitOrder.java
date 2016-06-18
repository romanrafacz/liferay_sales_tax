package liferay.Util;

import java.util.ArrayList;

import liferay.domain.Item;

public class SubmitOrder {
	
	public static ArrayList<Item> submitOrder(int input){
		
		ArrayList<Item> items = new ArrayList<Item>();
		
		if (input == 4){
			items.add(new Item("book", 12.49));
			items.add(new Item("music cd", 14.99));
			items.add(new Item("chocolate bar", .85));
		}else if (input == 3){
			items.add(new Item("imported box of chocolates", 10.00));
			items.add(new Item("imported bottle of perfume", 47.50));
		}else if (input == 2){
			items.add(new Item("imported bottle of perfume", 27.99));
			items.add(new Item("bottle of perfume", 18.99));
			items.add(new Item("packet of headache pills", 9.75));
			items.add(new Item("imported box of chocolates", 11.25));
		}else if (input == 1){
			items.add(new Item("book", 12.49));
			items.add(new Item("music cd", 14.99));
			items.add(new Item("chocolate bar", .85));
			items.add(new Item("imported box of chocolates", 10.00));
			items.add(new Item("imported bottle of perfume", 47.50));
			items.add(new Item("imported bottle of perfume", 27.99));
			items.add(new Item("bottle of perfume", 18.99));
			items.add(new Item("packet of headache pills", 9.75));
			items.add(new Item("imported box of chocolates", 11.25));
		}else{
			return items;
		}
			
		
		return items;
	}

}
