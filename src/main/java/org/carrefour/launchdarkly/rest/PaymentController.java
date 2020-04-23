package org.carrefour.launchdarkly.rest;

import org.carrefour.launchdarkly.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	private IPaymentService paymentService;

	@PostMapping("/charge")
	public String charge() {
		return paymentService.charge();
	}
	
	@PostMapping("/chargeWithParams")
	public String charge(@RequestParam long storeId) {
		return paymentService.charge(storeId);
	}

}
