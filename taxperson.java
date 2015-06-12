

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class taxperson {

	/**
	 * @assumption cost of an item is provided in pennies
	 * an item would be either basic necessity or luxury item other than that no other kind of item exists.
	 * Input: Cost of item
	 * 		: Item type -> Luxury(L)/Basic Necessity(N)
	 */
	public double CalculateCost(int cost, char type){
		double totalcost=0;
		try {
			totalcost=getCostInclusiveTax(cost,type);
		} catch (Exception e) {
			totalcost = 0;
		}
		System.out.println("Total cost of item :: "+totalcost);
		return totalcost;
	}
	private static double computeTax(int cost, float taxRate){
		return cost*taxRate/100;
	}
	private static double getCostInclusiveTax(int cost, char itemType)throws Exception{
		float taxRate;
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
