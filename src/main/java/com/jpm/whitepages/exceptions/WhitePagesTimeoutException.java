package com.jpm.whitepages.exceptions;

import com.jpm.whitepages.model.WhitePagesRequest;

public class WhitePagesTimeoutException extends RuntimeException {

	private static final long serialVersionUID = -6149773906737804798L;

	public WhitePagesTimeoutException(WhitePagesRequest request) {
        super("Timeout while requesting: " + request);
    }
}

