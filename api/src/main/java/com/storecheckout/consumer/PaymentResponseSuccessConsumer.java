package com.storecheckout.consumer;

import com.storecheckout.facade.PaymentFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentResponseSuccessConsumer {

    @Autowired
    private PaymentFacade paymentFacade;

    @RabbitListener(queues = {"payment-response-success-queue"})
    public void receive(@Payload Message message) {
        System.out.println("Message " + message + " " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());

        paymentFacade.successPayment(payload);
    }
}
