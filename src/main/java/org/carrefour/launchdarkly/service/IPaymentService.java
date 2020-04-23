package org.carrefour.launchdarkly.service;

public interface IPaymentService {

	String charge();

	void collect();

	default String charge(Long storeId) {
		return "default implementation";
	}

}
