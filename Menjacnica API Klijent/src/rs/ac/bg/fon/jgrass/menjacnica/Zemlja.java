package rs.ac.bg.fon.jgrass.menjacnica;

public class Zemlja {
	private String alpha3;
	private String currencyID;
	private String currencyName;
	private String currencySymbol;
	private String id;
	private String name;
	public String getAlpha3() {
		return alpha3;
	}
	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}
	public String getCurrencyID() {
		return currencyID;
	}
	public void setCurrencyID(String currencyID) {
		this.currencyID = currencyID;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Zemlja [alpha3=" + alpha3 + ", currencyID=" + currencyID + ", currencyName=" + currencyName
				+ ", currencySymbol=" + currencySymbol + ", id=" + id + ", name=" + name + "]";
	}
}
