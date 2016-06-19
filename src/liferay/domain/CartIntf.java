package liferay.domain;

public interface CartIntf {
	
	public void addToCartProduct(Product product);
	public double getSalesTax();
	public double getTotal();
	
	
}
