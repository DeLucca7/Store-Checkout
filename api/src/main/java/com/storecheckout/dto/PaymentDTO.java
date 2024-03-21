package com.storecheckout.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentDTO {
    private String order;
    private BigDecimal price;
    private String product;
}
