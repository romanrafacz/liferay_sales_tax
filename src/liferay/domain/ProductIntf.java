package liferay.domain;

public interface ProductIntf {
	
	public String getItem();
	public void setItem(String item);
	public double getPrice();
	public void setPrice(double price);
	public Boolean getImported();
	public void setImported(Boolean imported);
	public Boolean getTaxExemption();
	public void setTaxExemption(Boolean taxExemption);

}
