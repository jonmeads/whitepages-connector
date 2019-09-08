package com.jpm.whitepages.exceptions;

import com.jpm.whitepages.model.WhitePagesRequest;

public class WhitePagesTimeoutException extends RuntimeException {

    public WhitePagesTimeoutException(WhitePagesRequest request) {
        super("Timeout while requesting : " + request);
    }
}

