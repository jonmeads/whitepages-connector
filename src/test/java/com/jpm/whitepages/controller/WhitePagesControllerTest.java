package com.jpm.whitepages.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpm.whitepages.exceptions.WhitePagesFailureException;
import com.jpm.whitepages.exceptions.WhitePagesTimeoutException;
import com.jpm.whitepages.model.WhitePagesRequest;
import com.jpm.whitepages.model.WhitePagesResponse;
import com.jpm.whitepages.service.WhitePagesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhitePagesControllerTest {

	@Autowired
	@InjectMocks
    private WhitePagesController underTest;
	
	@Mock
	private WhitePagesService service;
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
    
    @Test
    public void testGetNameFromNumber() {
    	String testNumber = "1234";
    	String testName = "NAME";
    	
    	WhitePagesRequest request = new WhitePagesRequest(testNumber, null);
    	List<WhitePagesResponse>  response = Arrays.asList(new WhitePagesResponse(testNumber, testName));
    	
    	Mockito.when(service.requestWhitePages(Mockito.eq(request))).thenReturn(response);
    	List<WhitePagesResponse> actual = underTest.getNameFromNumber(testNumber);
    	
    	Assert.assertEquals(response, actual);
    }
    
    
    @Test
    public void testGetNumbersFromName() {
    	String testNumber = "1234";
    	String testName = "NAME";
    	
    	WhitePagesRequest request = new WhitePagesRequest(null, testName);
    	List<WhitePagesResponse>  response = Arrays.asList(new WhitePagesResponse(testNumber, testName));
    	
    	Mockito.when(service.requestWhitePages(Mockito.eq(request))).thenReturn(response);
    	List<WhitePagesResponse> actual = underTest.getNumbersFromName(testName);
    	
    	Assert.assertEquals(response, actual);
    }
    
    @Test
    public void testTimeoutException() {
    	
    	String testName = "NAME";
    	WhitePagesRequest request = new WhitePagesRequest(null, testName);
    	
    	Mockito.when(service.requestWhitePages(Mockito.eq(request))).thenThrow(new WhitePagesTimeoutException(request));
    	
    	thrown.expect(WhitePagesTimeoutException.class);
    	thrown.expectMessage("Timeout while requesting: " + request);
    	
    	// call
    	underTest.getNumbersFromName(testName);     
    }
    
    @Test
    public void testFailureException() {
    	
    	String testName = "NAME";
    	WhitePagesRequest request = new WhitePagesRequest(null, testName);
    	
    	Mockito.when(service.requestWhitePages(Mockito.eq(request))).thenThrow(new WhitePagesFailureException(request));
    	
    	thrown.expect(WhitePagesFailureException.class);
    	thrown.expectMessage("Failure while requesting: " + request);
    	
    	// call
    	underTest.getNumbersFromName(testName);     
    }

}
