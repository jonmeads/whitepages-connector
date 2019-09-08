package com.jpm.whitepages.exceptions;

import com.jpm.whitepages.model.WhitePagesRequest;

public class WhitePagesFailureException extends RuntimeException {

    public WhitePagesFailureException(WhitePagesRequest request) {
        super("Failure while requesting : " + request);
    }
}

