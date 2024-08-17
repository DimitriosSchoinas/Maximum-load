
public class Inventary {

	private static final int INIT_VALUE = 0;

	private double maxWeigth;
	private double totalWeigth;
	private double totalQuantity;
	private Item[] products;
	private String[] finalProducts;
	private int position;
	private int finalProductsSize;

	public Inventary(double maxWeigth, int numOfProducts) {

		this.maxWeigth = maxWeigth;
		totalWeigth = INIT_VALUE;
		totalQuantity = INIT_VALUE;
		products = new Item[numOfProducts];
		position = INIT_VALUE;
		finalProducts = new String[INIT_VALUE];
		finalProductsSize = INIT_VALUE;
	}

	public double getTotalQuantity() {
		return totalQuantity;
	}

	public void addProduct(String productName, double productWrigth, double productQuantity) {

		double utility = productQuantity / productWrigth;

		if (position == 0)
			products[position++] = new Item(productName, productWrigth, productQuantity);
		else {
			int i = position - 1;

			while (i >= 0 && utility > products[i].getUtility()) {
				products[i + 1] = products[i];
				i--;
			}
			products[i + 1] = new Item(productName, productWrigth, productQuantity);
			position++;
		}

	}

	public void addFinalProdcuts(String name) {

		if (isFull())
			grow();
		finalProducts[finalProductsSize++] = name;

	}

	private boolean isFull() {
		return finalProductsSize == finalProducts.length;
	}

	private void grow() {
		
		String[] tmp = new String [finalProductsSize + 1];
		
		for(int i = 0; i < finalProductsSize; i++) {
			tmp[i] = finalProducts[i];
		}
		
		finalProducts = tmp;
	}
	
	public InvIterator iterator() {
		return new InvIterator(finalProducts, finalProductsSize);
	}

	public void calculateFinalItems() {
		
		int i = 0;
		
		while(i < products.length &&  totalWeigth < maxWeigth) {
			if(totalWeigth + products[i].getWeigth() < maxWeigth) {
				addFinalProdcuts(products[i].getName());
				totalQuantity += products[i].getQuantity();
				totalWeigth += products[i].getWeigth();
			}else {
				addFinalProdcuts(products[i].getName());
				totalQuantity += products[i].getUtility() * (maxWeigth - totalWeigth);
				totalWeigth = maxWeigth;				
			}
			i++;
		}
		sort();
	}
	private void sort() {
		
		for (int i=0; i < finalProductsSize-1; i++) {
			int minIdx = i;
			for (int j=i+1; j < finalProductsSize; j++)
			if (finalProducts[j].compareTo(finalProducts[minIdx]) < 0)
			minIdx = j;
			String tmp = finalProducts[i];
			finalProducts[i] = finalProducts[minIdx];
			finalProducts[minIdx] = tmp;
	}
	}
}
