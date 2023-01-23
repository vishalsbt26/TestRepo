package analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer  {
	
	int counter = 0;
	int limit = 3;
	
	public boolean retry(ITestResult result) {
		if(counter<limit) {
			counter++;
			return true;
		}
		return false;
	}
	
	
}
