package org.carrefour.launchdarkly.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;
import com.launchdarkly.client.LDUser.Builder;

@Service
@Primary
public class PaymentDelegateService implements IPaymentService {

	private static final Logger log = LoggerFactory.getLogger(PaymentDelegateService.class);

	@Autowired
	private SdpService sdpService;

	@Autowired
	private SipsService sipsService;

	@Autowired
	private LDClient launchDarklyClient;

	@Override
	public String charge() {
		return charge(null);
	}

	@Override
	public String charge(Long storeId) {
		if (isSdpEnabled(storeId)) {
			return sdpService.charge();
		} else {
			return sipsService.charge();
		}
	}

	private boolean isSdpEnabled(Long storeId) {
		Builder ldUserBuilder = new LDUser.Builder(UUID.randomUUID().toString());
		if (storeId != null) {
			ldUserBuilder.custom("storeId", storeId);
		}
		LDUser ldUser = ldUserBuilder.build();

		boolean sdpEnabled = launchDarklyClient.boolVariation("flag-sdp-enabled", ldUser, false);

		return sdpEnabled;
	}

	@Override
	public void collect() {

	}

}
