package com.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener implements ITestListener{

	private Logger log = Logger.getLogger(Listener.class);
	
	public void onTestStart(ITestResult result) {
		log.info("Testcase started with name: " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		log.info("Testcase passed with name: " + result.getName());

	}

	public void onTestFailure(ITestResult result) {

		log.info("Testcase failed with name: " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		log.info("Testcase skipped with name: " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		log.info("Testcase suite is ready to start the execution");

	}

	public void onFinish(ITestContext context) {

		log.info("Testcase suite is finished with the execution");
	}

}
