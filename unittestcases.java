import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class unittestcases {
   private taxperson taxpersonChecker;
   @BeforeMethod
   public void initialize() {
      taxpersonChecker = new taxperson();
   }

   @DataProvider(name = "test1")
   public static Object[][] TaxpersonDataProvider() {
      return new Object[][] {{100,'l', 109},{101,'n',102.00999999046326 },{1000, 'm', 0} };
   }

   @Test(dataProvider = "test1")
   public void TestTaxPerson(int cost, char type, double expectedResult) {
    
	   System.out.println(cost + " " + type + " " + expectedResult);
    
	   Assert.assertEquals(expectedResult,taxpersonChecker.CalculateCost(cost,type));
	   
	   
   } 
}

