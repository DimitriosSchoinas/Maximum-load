import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		double maxWeigth = in.nextDouble();
		in.nextLine();
		int numOfProducts = in.nextInt();
		in.nextLine();

		Inventary inv = new Inventary(maxWeigth, numOfProducts);

		for (int i = 0; i < numOfProducts; i++) {

			String productName = in.next();
			double productWrigth = in.nextDouble();
			double productQuantity = in.nextDouble();
			in.nextLine();

			inv.addProduct(productName, productWrigth, productQuantity);
		}
		
		inv.calculateFinalItems();
		
		System.out.printf("%.2f\n" , inv.getTotalQuantity());
		
		InvIterator it = inv.iterator();
		while(it.hasNext()) {
			String itemName = it.next();
			System.out.println(itemName);
		}

	}

}
