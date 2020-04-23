package org.carrefour.launchdarkly.service;

import org.springframework.stereotype.Service;

@Service
public class SipsService implements IPaymentService{

	@Override
	public String charge() {
		return "Charged By SIPS";
	}

	@Override
	public void collect() {
		// TODO Auto-generated method stub
		
	}

}
