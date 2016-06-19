package liferay.domain;

public class Product implements ProductIntf{
	
	private String item;
	
	private double price;
	
	//Boolean for imported items
	private Boolean imported;
	
	//Tax Exempt
	private Boolean taxExemption;
	
	//private double salesTax;
	private double salesTax;
	
	public Product(String item, double price, Boolean imported, Boolean taxExemption, double salesTax){
		this.item = item;
		this.price = price;
		this.imported = imported;
		this.taxExemption = taxExemption;
		this.salesTax = salesTax;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Boolean getImported() {
		return imported;
	}

	public void setImported(Boolean imported) {
		this.imported = imported;
	}

	public Boolean getTaxExemption() {
		return taxExemption;
	}

	public void setTaxExemption(Boolean taxExemption) {
		this.taxExemption = taxExemption;
	}
	
	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public String toString(){
		return "Product(Item:" + this.item + ", price: " + this.price + ", type: " + this.imported + 
				", tax exemption: " + this.taxExemption + ", sales tax: " + this.salesTax + ")"; 
	}

}
