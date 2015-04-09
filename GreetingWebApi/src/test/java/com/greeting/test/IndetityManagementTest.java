package com.greeting.test;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestCaseRunContext;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.support.SoapUIException;

import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class IndetityManagementTest {


	private WsdlProject project;
	private TestSuite testSuite;
	private TestCase testCase;
	
	@Before("@soapui")
	public void initialize() {
		try {
			project = new WsdlProject(
					"src/test/resources/Greeting-soapui-project.xml");
			testSuite = project
					.getTestSuiteByName("TestSuite-Greeting");
			testCase = testSuite.getTestCaseByName("TestCase-Greeting");

		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SoapUIException e) {
			e.printStackTrace();
		}
	}
	
	@Given("^I have a (.+) and (.+)$")
	public void I_have_a_username_and_password(String userName, String password) {
		testCase.setPropertyValue("userName", userName);
		testCase.setPropertyValue("password", password);
	}

	@When("^I call authetication service$")
	public void I_call_authetication_service() {
	    // Express the Regexp above with the code you wish you had
		TestStep testStep =	runTestStep("give your  test step name");
		
		testCase.getPropertyValue("name of property set by required for next step");
	}
	
	private TestStep runTestStep(String stepName) {
		TestStep testStep = testCase.getTestStepByName(stepName);
		TestCaseRunner testRunnerStep = new com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner((WsdlTestCase) testCase, null);
		TestCaseRunContext testStepContext = new com.eviware.soapui.impl.wsdl.testcase.WsdlTestRunContext(testStep);
		testStep.run(testRunnerStep, testStepContext);
		return testStep;
	}

	@Then("^I should get Access Token$")
	public void I_should_get_Access_Token() {
	    // Express the Regexp above with the code you wish you had
	  //  throw new PendingException();
	}

	@Then("^I call user service to fetch the user profile$")
	public void I_call_user_service_to_fetch_the_user_profile() {
	    // Express the Regexp above with the code you wish you had
	   // throw new PendingException();
	}

	@Given("^I have a john and secret$")
	public void I_have_a_john_and_secret() {
	    // Express the Regexp above with the code you wish you had
	   // throw new PendingException();
	}

}
