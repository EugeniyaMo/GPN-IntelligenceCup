package ru.task.gpnintelligencecup;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class GpnIntelligenceCupApplication {

	public static void main(String[] args) {
		Properties props = System.getProperties();
		props.setProperty("java.util.logging.config.file", "logging.properties");
		SpringApplication.run(GpnIntelligenceCupApplication.class, args);
	}


	@Bean
	public VkApiClient getVkApiClient(){
		TransportClient transportClient = new HttpTransportClient();
		VkApiClient vk = new VkApiClient(transportClient);
		return vk;
	}
}
