package com.example.demo.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyFilter extends ZuulFilter{

	@Override
	public Object run() throws ZuulException {

		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String test = request.getParameter("test");
		System.out.println("MyFilter:"+test);
		if ("1".equals(test)) {
//			过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseStatusCode(404);
			System.out.println("bad request");
		}else{
			currentContext.addZuulRequestHeader("ljw", "abc");
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {

		return 0;//数字越大，优先级越低
	}

	@Override
	public String filterType() {

		return "pre";//可以在请求被路由之前调用
//		return "route";//在路由请求时候被调用
//		return "error";//处理请求时发生错误时被调用
//		return "post";//在route和error过滤器之后被调用
		
	}

}
