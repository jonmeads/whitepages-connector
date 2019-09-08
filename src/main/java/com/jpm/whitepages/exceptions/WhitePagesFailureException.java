package com.jpm.whitepages.exceptions;

import com.jpm.whitepages.model.WhitePagesRequest;

public class WhitePagesFailureException extends RuntimeException {

	private static final long serialVersionUID = -5399577989185676270L;

	public WhitePagesFailureException(WhitePagesRequest request) {
        super("Failure while requesting: " + request);
    }
}

