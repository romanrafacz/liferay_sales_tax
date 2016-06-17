package liferay.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import liferay.domain.Product;

//Calculate Sales tax for each item.

public class SalesTaxUtil {
	
	public static Product CalculateSalesTax(Product product){
		if (product.getTaxExemption() == true && product.getImported() == false){
			//Do nothing, no sales tax.  Product is tax exempt and not imported(no import tax)
			product.setSalesTax(0.00);
		} else if (product.getTaxExemption() == true && product.getImported() == true ){
			//Product is tax exempt but imported, Sales Tax is 5%.
			//BigDecimal salesTax = new BigDecimal(product.getPrice() * .05).setScale(2, RoundingMode.HALF_UP);
			//double salesTaxDouble = salesTax.doubleValue();
			//product.setSalesTax(salesTaxDouble);
			
			//Testing Alternative
			double salesTaxPrimer = product.getPrice() * .05;
			double salesTax = (int)(salesTaxPrimer * 20.0 + 0.5) / 20.0;
			product.setSalesTax(salesTax);
		}else if (product.getImported() == false){
			//Product is not imported, Sales Tax is 10%.
			//BigDecimal salesTax = new BigDecimal(product.getPrice() * .10).setScale(2, RoundingMode.HALF_UP);
			//double salesTaxDouble = salesTax.doubleValue();
			//product.setSalesTax(salesTaxDouble);
			
			//Testing Alternative
			double salesTaxPrimer = product.getPrice() * .10;
			double salesTax = (int)(salesTaxPrimer * 20.0 + 0.5) / 20.0;
			product.setSalesTax(salesTax);
		} else{
			//Product is not tax exempt but imported, Sales Tax is 15%
			//BigDecimal salesTax = new BigDecimal(product.getPrice() * .15).setScale(2, RoundingMode.HALF_UP);
			//double salesTaxDouble = salesTax.doubleValue();
			//product.setSalesTax(salesTaxDouble);
			
			//Testing an alternative
			double salesTaxPrimer = product.getPrice() * .15;
			double salesTax = (int)(salesTaxPrimer * 20.0 + 0.5) / 20.0;
			product.setSalesTax(salesTax);
		}
		return product;
	}
}
