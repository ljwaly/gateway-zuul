package com.example.demo.filter.post;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class PostFilter1 extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("POST:PostFilter1");
		
		
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
