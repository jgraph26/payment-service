package com.payment_service.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class CartRequest {
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("totalAmount")
    private String totalAmount;
}
