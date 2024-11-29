package com.payment_service.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalException {


    @ExceptionHandler(PaypalException.PayPalAuthorizationException.class)
    public ResponseEntity<String> handleAuthorizationException(PaypalException.PayPalAuthorizationException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( "PayPalAuthorizationException: " + ex.getMessage());
    }

    @ExceptionHandler(PaypalException.PayPalPaymentException.class)
    public ResponseEntity<String> handlePaymentException(PaypalException.PayPalPaymentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "PayPalPaymentException: " + ex.getMessage());
    }

    @ExceptionHandler(PaypalException.PayPalResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(PaypalException.PayPalResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body( "PayPalResourceNotFoundException: " + ex.getMessage());
    }

    @ExceptionHandler(PaypalException.PayPalInvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(PaypalException.PayPalInvalidRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PayPalInvalidRequestException: " + ex.getMessage());
    }

    @ExceptionHandler(PaypalException.PayPalException.class)
    public ResponseEntity<String> handleGeneralPayPalException(PaypalException.PayPalException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( "PayPalException: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error: " + ex.getMessage());
    }
}
