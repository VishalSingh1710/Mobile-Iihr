package ListenersDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{

	public void onFinish(ITestContext result) {
		
	}

	public void onStart(ITestContext result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase failed and details are "+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase skipped and details are "+result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Testcase start and details are "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Testcase succeed and details are "+result.getName());
	}

}
