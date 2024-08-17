
public class Item {

	private String itemName;
	private double  weigth;
	private double  quantity;
	private double utility;
	
	public Item(String name, double weigth, double quantity) {
		
		this.itemName = name;
		this.weigth = weigth;
		this.quantity = quantity;
		utility = this.quantity/this.weigth;
	}
	
	public String getName() {
		return itemName;
	}
	
	public double getWeigth() {
		return weigth;
	}
	public double getQuantity() {
		return quantity;
	}
	public double getUtility() {
		return utility;
	}
}
