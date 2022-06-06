package com.vivek.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private  final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customedId) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customedId);
        log.info("Fraud check request for customer {}", customedId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
