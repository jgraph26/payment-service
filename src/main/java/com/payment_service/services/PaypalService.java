package com.payment_service.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment_service.pojo.CartRequest;
import com.paypal.sdk.PaypalServerSdkClient;
import com.paypal.sdk.controllers.OrdersController;
import com.paypal.sdk.exceptions.ApiException;
import com.paypal.sdk.http.response.ApiResponse;
import com.paypal.sdk.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Collections;


@Service
@Slf4j
public class PaypalService {

    @Value("${paypal.clientId}")
    private  String clientId;
    @Value("${paypal.clientSecret}")
    private String clientSecret;
    @Value("${paypal.mode}")
    private String mode;

    private final PaypalServerSdkClient client;

    public PaypalService(ObjectMapper objectMapper, PaypalServerSdkClient client) {
        this.client = client;
    }

  public Order createOrder(CartRequest cart) throws IOException, ApiException {
      OrdersCreateInput ordersCreateInput = new OrdersCreateInput.Builder(
              null,
              new OrderRequest.Builder(
                      CheckoutPaymentIntent.CAPTURE,
                      Collections.singletonList(
                              new PurchaseUnitRequest.Builder(
                                      new AmountWithBreakdown.Builder(
                                              cart.getCurrency(),
                                              cart.getTotalAmount()
                                      ).build()
                              ).build()
                      )).build()
              ).build();
      OrdersController ordersController = client.getOrdersController();

      ApiResponse<Order> apiResponse = ordersController.ordersCreate(ordersCreateInput);

      return apiResponse.getResult();


  }

  public Order captureOrder(String orderId) throws IOException, ApiException {
        OrdersCaptureInput captureInput = new OrdersCaptureInput.Builder(
                orderId,
                null).build();
        OrdersController ordersController = client.getOrdersController();
        ApiResponse<Order> apiResponse = ordersController.ordersCapture(captureInput);
        return apiResponse.getResult();
  }
}


