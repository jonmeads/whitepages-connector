package com.jpm.whitepages;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationMainIT {

	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void testServerComesUpAndReturnsValidResponse() throws Exception {
    	
    	String testName = "NAME";
    	String fooResourceUrl = "http://localhost:" + port + "/getNumbersFromName";
 
    	ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/" + testName, String.class);
    	
    	Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    	Assert.assertTrue(response.getBody().contains(testName));
    
    }
	
    // TODO Additional integration tests
	
	

}
