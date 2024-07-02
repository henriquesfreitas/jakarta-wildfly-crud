package com.jakarta.common.debug;

import java.io.Serializable;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class LogInterceptor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@AroundInvoke
    public Object interceptor(InvocationContext contex) throws Exception {

        long millis = System.currentTimeMillis();

        Object o = contex.proceed();
        
//        String logInterceptor = System.getProperty("logInterceptor");
//		if(logInterceptor.equals("true")) {
//	        String nomeClasse = contex.getTarget().getClass().getSimpleName();
//	        String nomeMetodo = contex.getMethod().getName();
//	
//	        System.out.println("[INFO] " + nomeClasse + "->" + nomeMetodo);
//	
//	        System.out.println("[INFO] Total: "
//	                + (System.currentTimeMillis() - millis) + "ms");
//		}

        return o;

    }

}
