package liferay.Util;

import liferay.domain.Product;

//Calculate Sales tax for each item.

public class SalesTaxUtil {
	
	public static Product CalculateSalesTax(Product product){
		if (product.getTaxExemption() == true && product.getImported() == false){
			//Do nothing, no sales tax.  Product is tax exempt and not imported(no import tax)
			product.setSalesTax(0.00);
		} else if (product.getTaxExemption() == true && product.getImported() == true ){
			//Product is tax exempt but imported, Sales Tax is 5%.
			product.setSalesTax(product.getPrice() * .05);
		}else if (product.getImported() == false){
			//Product is not imported, Sales Tax is 10%.
			product.setSalesTax(product.getPrice() * .10);
		} else
			//Product is not tax exempt but imported, Sales Tax is 15%
			product.setSalesTax(product.getPrice() * .15);
		return product;
	}
}
