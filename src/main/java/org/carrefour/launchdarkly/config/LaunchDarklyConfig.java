package org.carrefour.launchdarkly.config;

import java.io.IOException;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.launchdarkly.client.LDClient;

@Configuration
public class LaunchDarklyConfig {
	
	@Value("${launchdarkly.sdkKey}")
	private String sdkKey;
	
	@Bean
	public LDClient launchDarklyClient() {
		return new LDClient(sdkKey);
	}
	
	@PreDestroy
	public void releaseLDClient() throws IOException {
		launchDarklyClient().flush();
		launchDarklyClient().close();
	}

}
