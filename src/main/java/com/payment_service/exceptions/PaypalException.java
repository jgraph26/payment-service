package com.payment_service.exceptions;

import java.io.Serial;

public class PaypalException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public class PayPalException extends RuntimeException {
        public PayPalException(String message) {
            super(message);
        }
    }

    public class PayPalAuthorizationException extends PayPalException {
        public PayPalAuthorizationException(String message) {
            super(message);
        }
    }

    public class PayPalPaymentException extends PayPalException {
        public PayPalPaymentException(String message) {
            super(message);
        }
    }

    public class PayPalResourceNotFoundException extends PayPalException {
        public PayPalResourceNotFoundException(String message) {
            super(message);
        }
    }

    public class PayPalInvalidRequestException extends PayPalException {
        public PayPalInvalidRequestException(String message) {
            super(message);
        }
    }

}
