package com.payment_service.controller;

import com.payment_service.pojo.CartRequest;
import com.payment_service.services.PaypalService;
import com.paypal.sdk.exceptions.ApiException;
import com.paypal.sdk.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/payment")
public class paypalController {

    @Autowired
    private PaypalService payPalService;

  @PostMapping("/create-order")
    public ResponseEntity<Order> createOrder(@RequestBody CartRequest cart) throws IOException, ApiException {
        return ResponseEntity.ok(payPalService.createOrder(cart));
    }

    @PostMapping("/capture-order/{orderID}")
    public ResponseEntity<Order> captureOrder(@PathVariable String orderID) throws IOException, ApiException {
        return ResponseEntity.ok(payPalService.captureOrder(orderID));
    }
}
