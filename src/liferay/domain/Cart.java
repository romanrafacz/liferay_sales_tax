package liferay.domain;

import java.util.ArrayList;

public class Cart implements CartIntf {
	
	private ArrayList<Product> order;
	
	public Cart( ){
		order = new ArrayList<Product>();
	}

	@Override
	public void addToCartProduct(Product product) {
		order.add(product);
		
	}

	@Override
	public double getSalesTax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
