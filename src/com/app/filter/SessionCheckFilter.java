package com.app.filter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCheckFilter implements Filter {
	
    private List<String> avoidUrlsList=null;

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
				
		try {
			
			res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//http 1.0 
			res.setHeader("Pragma", "no-cache");//http 1.1	
			res.setDateHeader("Expires", 0); 
			
			
			String uri=req.getRequestURI();
			boolean isAvoidUrl=false;
			if(avoidUrlsList.contains(uri)){
				isAvoidUrl=true;//no session check
			}
			if(!isAvoidUrl){
				System.out.println("cp:"+req.getContextPath());
				//check session
				HttpSession ses=req.getSession(false);
				if(ses==null || ses.getAttribute("userName")==null)
					res.sendRedirect(req.getContextPath()+"/mvc/home");
			}
			
		} catch (Exception e) {
		}		
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		String urlsData=fConfig.getInitParameter("avoid-urls");
		StringTokenizer st=new StringTokenizer(urlsData, ",");
		avoidUrlsList=new ArrayList<String>();
		while(st.hasMoreTokens()){
			String token=st.nextToken();
			avoidUrlsList.add(token);
		}
		
	}
  }
