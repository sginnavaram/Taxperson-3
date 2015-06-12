import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Taxperson {

	/**
	 * @assumption cost of an item is provided in pennies
	 * an item would be either basic necessity or luxury item other than that no other kind of item exists.
	 * Input: Cost of item
	 * 		: Item type -> Luxury(L)/Basic Necessity(N)
	 */
	public static void main(String[] args)throws Exception{
		BufferedReader  in=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Cost of item:");
		double cost=Double.parseDouble(in.readLine());
		System.out.println("Item Type:(L/N)");
		char type=(char)in.read();
		
		try{
			double totalCost=getCostInclusiveTax(cost,type);
			System.out.println("Total cost of item :: "+totalCost);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private static double computeTax(double cost, double taxRate){
		return cost*taxRate/100;
	}
	private static double getCostInclusiveTax(double cost, char itemType)throws Exception{
		double taxRate;
		switch(itemType){
			case 'L':
			case 'l':
				taxRate=9;
				break;
			case 'N':
			case 'n':
				taxRate=1;
				break;
			default:
				throw new Exception("Invalid Item Type");	
		}
		return cost+computeTax(cost,taxRate);
	}
}
