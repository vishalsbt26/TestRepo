package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.SearchTrain;

public class SearchTrainTest extends TestBase {
	SearchTrain searchTrain;
	
	public SearchTrainTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		searchTrain = new SearchTrain();
	}
	
	@Test
	public void search() throws InterruptedException {
		searchTrain.searchLoc();
		searchTrain.selDate();
		searchTrain.selClass();
		searchTrain.clickBtn();
		searchTrain.countTrains();
	}
}