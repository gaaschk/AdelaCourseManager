package org.adela.is.awesome.coursemanager;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
@EnableDiscoveryClient
@EnableHystrix
public class CloudConfiguration {

}
