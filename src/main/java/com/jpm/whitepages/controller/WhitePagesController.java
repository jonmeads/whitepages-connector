package com.jpm.whitepages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpm.whitepages.model.WhitePagesRequest;
import com.jpm.whitepages.model.WhitePagesResponse;
import com.jpm.whitepages.service.WhitePagesService;

@RestController
public class WhitePagesController {
	
	@Autowired
	private WhitePagesService service;

	@RequestMapping(value = "/getNameFromNumber/{number}", method=RequestMethod.GET)
	public List<WhitePagesResponse> getNameFromNumber(@PathVariable("number") String number) {
		return service.requestWhitePages(new WhitePagesRequest(number, null));
	}
	
	@RequestMapping(value = "/getNumbersFromName/{name}", method=RequestMethod.GET)
	public List<WhitePagesResponse> getNumbersFromName(@PathVariable("name") String name) {
		return service.requestWhitePages(new WhitePagesRequest(null, name));
	}
	
	
}
