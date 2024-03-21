package com.storecheckout.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.storecheckout.dto.PaymentDTO;
import com.storecheckout.producer.PaymentRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentFacade {

    @Autowired
    private PaymentRequestProducer producer;

    public String requestPayment(PaymentDTO request) {
        try {
            producer.compose(request);
        } catch (JsonProcessingException ex){
            return "an error occurred when requesting payment... " + ex.getMessage();
        }
        return "Waiting for payment confirmation...";
    }
}
