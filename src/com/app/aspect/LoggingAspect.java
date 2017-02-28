package com.app.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {

private Log log=LogFactory.getLog(getClass());
	
	//pointcut
	@Pointcut("execution(public * com.app..*.*(..))")
	public void point1(){}
	
	//advice
	@Around("point1()")
	public Object sampleMsg(ProceedingJoinPoint jp){
		StopWatch watch=new StopWatch(jp.getTarget().getClass().getName());
		Object ob=null;
		try {
			watch.start(jp.getSignature().getName());
			log.info(jp.getSignature().getName()+" is started");
			ob=jp.proceed();
			log.info(jp.getSignature().getName()+" is End");
			watch.stop();
		} catch (Throwable e) {
			log.fatal("Unknown:"+e);
			e.printStackTrace();
		}
		log.debug(watch.prettyPrint());
		return ob;
	}
	@AfterThrowing(pointcut="point1()",throwing="th")
	public void getErrors(Throwable th){
		log.error(th);
	}
}
