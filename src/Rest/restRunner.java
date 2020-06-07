package Rest;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class restRunner {

	@Test
	public void testRun1() throws XmlException, IOException, SoapUIException
	{
		WsdlProject project =new WsdlProject("C:\\Tools\\REST-Project-5-soapui-project.xml");
		
		WsdlTestSuite testsuite = project.getTestSuiteByName("TestSuite");
		for(int i=0;i<testsuite.getTestCaseCount();i++)
		{
			WsdlTestCase testcase = testsuite.getTestCaseAt(i);
			TestRunner runner =testcase.run(new PropertiesMap(), false);
			Assert.assertEquals(Status.FINISHED, runner.getStatus());
		}
		
	}
}
