package org.carrefour.launchdarkly.service;

import org.springframework.stereotype.Service;

@Service
public class SdpService  implements IPaymentService{

	@Override
	public String charge() {
		return "Charged by SDP";
	}

	@Override
	public void collect() {
		// TODO Auto-generated method stub
		
	}

}
