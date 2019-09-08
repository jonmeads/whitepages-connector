package com.jpm.whitepages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.jpm.whitepages.exceptions.WhitePagesFailureException;
import com.jpm.whitepages.exceptions.WhitePagesTimeoutException;
import com.jpm.whitepages.model.WhitePagesRequest;
import com.jpm.whitepages.model.WhitePagesResponse;

@Component
public class WhitePagesService {

	private final ExecutorService executor;

	public WhitePagesService() {
		this.executor = Executors.newSingleThreadExecutor();
	}

	public List<WhitePagesResponse> requestWhitePages(WhitePagesRequest request) {
		List<WhitePagesResponse> response = new ArrayList<>();

		try {
			Future<List<WhitePagesResponse>> result = executor.submit(() -> {
				return whitePagesConnector(request);
			});

			response.addAll(result.get(5, TimeUnit.MINUTES));

		} catch (java.util.concurrent.TimeoutException e) {
			throw new WhitePagesTimeoutException(request);
		} catch (Exception e) {
			throw new WhitePagesFailureException(request);	
		}
		return response;
	}

	protected List<WhitePagesResponse> whitePagesConnector(WhitePagesRequest request) throws InterruptedException {
		// send request and obtain response
		List<WhitePagesResponse> response = new ArrayList<>();

		Faker faker = new Faker();

		if (request.isNameLookup()) {

			response.add(new WhitePagesResponse(request.getNumber(), faker.name().fullName()));
		} else {
			response.add(new WhitePagesResponse(faker.phoneNumber().phoneNumber(), request.getName()));
			faker = new Faker();
			response.add(new WhitePagesResponse(faker.phoneNumber().phoneNumber(), request.getName()));
		}

		Thread.sleep(6000);
		return response;
	}

}
