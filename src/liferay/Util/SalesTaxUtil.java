package liferay.Util;

import java.math.BigDecimal;

import liferay.domain.Product;

//Calculate Sales tax and update the sales tax property in the product object

public class SalesTaxUtil {
	
	//Tax Exempt
	final static double EXEMPT =  0.00;
	//Import duty item tax 5%
	final static double IMPORT_DUTY = 0.05;
	//Basic sales tax %
	final static double BASIC_SALES_TAX = 0.10;
	//Basic sales tax with Import duty %
	final static double SALES_TAX_AND_IMPORTDUTY = 0.15;
	final static BigDecimal ROUND_FACTOR = new BigDecimal("0.05");
	
	public static Product CalculateSalesTax(Product product){
		if (product.getTaxExemption() == true && product.getImported() == false){
			//Do nothing, no sales tax.  Product is tax exempt and not imported(no import tax)
			product.setSalesTax(0.00);
		} else if (product.getTaxExemption() == true && product.getImported() == true ){
			//Product is exempt but imported Sales tax is 5%
			BigDecimal salesTaxPrimer = new BigDecimal(product.getPrice() * IMPORT_DUTY);
			BigDecimal salesTaxRound = getRound(salesTaxPrimer);
			double salesTaxFinal = salesTaxRound.doubleValue();
			product.setSalesTax(salesTaxFinal);
		}else if (product.getImported() == false){
			//Product is not imported, sales tax is 10%.
			BigDecimal salesTaxPrimer = new BigDecimal(product.getPrice() * BASIC_SALES_TAX);
			BigDecimal salesTaxRound = getRound(salesTaxPrimer);
			double salesTaxFinal = salesTaxRound.doubleValue();
			product.setSalesTax(salesTaxFinal);
		} else{
			//Product is not tax exempt but imported, Sales Tax is 15%
			BigDecimal salesTaxPrimer = new BigDecimal(product.getPrice() * SALES_TAX_AND_IMPORTDUTY);
			BigDecimal salesTaxRound = getRound(salesTaxPrimer);
			double salesTaxFinal = salesTaxRound.doubleValue();
			product.setSalesTax(salesTaxFinal);
		}
		return product;
	}
	
	public static BigDecimal getRound(BigDecimal salesTax){
			salesTax = salesTax.divide(ROUND_FACTOR);
			salesTax = new BigDecimal(Math.ceil(salesTax.doubleValue()));
			salesTax = salesTax.multiply(ROUND_FACTOR);
			return salesTax;
	}
}
