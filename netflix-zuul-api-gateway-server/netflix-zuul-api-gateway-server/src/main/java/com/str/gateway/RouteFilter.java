package com.str.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("Using Router Filter");
		return null;
	}

	@Override
	public String filterType() {
		return "router";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
