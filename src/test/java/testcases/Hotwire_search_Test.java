package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Hotwire_Search;
import util.ExcelUtil;
import util.TestUtil;

public class Hotwire_search_Test extends TestBase {
	private static final String sheetName = "HOTWIRE_SEARCH";
String inputdate="11/12/2019";
String actualmsg="Start by choosing your hotel";
String expected;
	Hotwire_Search search;
	static TestUtil testutil;
	static ExcelUtil excelutil;
public Hotwire_search_Test() {
	super();
	}
//launch brower or website
@ BeforeMethod
public void setup() {
	initialization();
	search= new Hotwire_Search();	
    testutil=new TestUtil();
    excelutil= new ExcelUtil();
}

//Test methos to sdearch result
@Test(dataProvider="getData")
public void Search(String FlyFrom, String FlyTo, String picktime, String Droptime){
	
		search.SearchVacation(FlyFrom, FlyTo, inputdate, picktime, Droptime);
		expected= search.Assrtmsg().trim();
		
		//Assert conditon if result is retuen then only "Start by choosing your hotel" message displayed on screen.
		Assert.assertEquals(actualmsg, expected);
	}

//Dataprovider to read data from excel

@DataProvider()
public Object[][] getData(){
	return ExcelUtil.getTestData(sheetName);
	
}

//Method to close browser after execute test method
@AfterMethod
public void quit() {
	driver.quit();
}




}
