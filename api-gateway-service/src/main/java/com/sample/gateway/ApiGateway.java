package com.sample.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.sample.gateway.filter.ErrorFilter;
import com.sample.gateway.filter.PostFilter;
import com.sample.gateway.filter.PreFilter;
import com.sample.gateway.filter.RouteFilter;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class ApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateway.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		
		return new PreFilter();
	}
	
	@Bean
	public PostFilter postFilter() {
		
		return new PostFilter();
	}
	
	@Bean
	public RouteFilter routeFilter() {
		
		return new RouteFilter();
	}
	
	@Bean
	public ErrorFilter errorFilter() {
		
		return new ErrorFilter();
	}
}
