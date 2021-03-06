package com.springboot.frame.common.aop;

import com.springboot.frame.common.ResultBean;
import com.springboot.frame.common.annotation.Permission;
import com.springboot.frame.exception.BusinessException;
import com.springboot.frame.exception.ErrorCode;
import com.springboot.frame.exception.GlobalExceptionHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


/**
 * 处理和包装异常
 * 
 * @author
 * */
@Aspect
@Component
public class ControllerAOP {
	private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);

	ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	@Value("${spring.profiles}")
	private String env;

	/**
	 * 定义拦截规则：拦截com.springboot.frame.web.controller包下面的所有类中，有@RequestMapping注解的方法。
	 * 定义一个切入点.
	 * 解释下：
	 *
	 * ~ 第一个 * 代表任意修饰符及任意返回值.
	 * ~ 第二个 * 任意包名
	 * ~ 第三个 * 代表任意方法.
	 * ~ 第四个 * 定义在web包或者子包
	 * ~ 第五个 * 任意方法
	 * ~ .. 匹配任意数量的参数.
	 */
	@Pointcut("execution(* com.springboot.frame.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void log(){

	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		startTime.set(System.currentTimeMillis());
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		logger.info("url={}",request.getRequestURL());
		//method
		logger.info("method={}",request.getMethod());
		//ip
		logger.info("ip={}",request.getRemoteAddr());
		//class_method
		logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
		//args[]
		logger.info("args={}",joinPoint.getArgs());

	}

	/*@Around("log()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod(); //获取被拦截的方法
		String methodName = method.getName(); //获取被拦截的方法名
		Set<Object> allParams = new LinkedHashSet<>(); //保存所有请求参数，用于输出到日志中
		logger.info("请求开始，方法：{}", methodName);
		ResultBean<?> result=null;
		*//*Object[] args = pjp.getArgs();
		for(Object arg : args){
			//logger.debug("arg: {}", arg);
			if (arg instanceof Map<?, ?>) {
				//提取方法中的MAP参数，用于记录进日志中
				Map<String, Object> map = (Map<String, Object>) arg;

				allParams.add(map);
			}else if(arg instanceof HttpServletRequest){
				HttpServletRequest request = (HttpServletRequest) arg;
				if(isLoginRequired(method)){
					if(!isLogin(request)){
						result = new ResultBean();
						result.setMsg(ErrorCode.NO_LOGIN.getMessage());
						result.setCode(ResultBean.NO_LOGIN);
					}
				}
				//获取query string 或 posted form data参数
				Map<String, String[]> paramMap = request.getParameterMap();
				if(paramMap!=null && paramMap.size()>0){
					allParams.add(paramMap);
				}
			}else if(arg instanceof HttpServletResponse){
				//do nothing...
			}else{
				//allParams.add(arg);
			}
		}*//*
		try {
			if(null == result) {
				// 一切正常的情况下，继续执行被拦截的方法
				result = (ResultBean<?>) pjp.proceed();
				logger.info(pjp.getSignature() + "use time:{}ms" + (System.currentTimeMillis()-startTime.get()));
			}

		} catch (Exception e) {
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			//result = globalExceptionHandler.runtimeExceptionHandler(request,e);
		}

		*//*if(result instanceof ResultBean){
			long costMs = System.currentTimeMillis()-startTime.get();
			logger.info("{}请求结束，耗时：{}ms", methodName, costMs);
		}*//*

		return result;
	}*/
	/*@After("log()")
	public void after(){
		logger.info("--------------------------执行后3----------------------");
	}
*/
	@AfterReturning(pointcut = "log()",returning = "object")//打印输出结果
	public void doAfterReturing(Object object){
		logger.info("response={}",object.toString());
		logger.info("SPEND TIME {}ms",(System.currentTimeMillis() - startTime.get()));
	}


	/**
	 * 判断一个方法是否需要登录
	 * @param method
	 * @return
	 */
	private boolean isLoginRequired(Method method){
		if(!env.equals("prod")){ //只有生产环境才需要登录
			return false;
		}

		boolean result = true;
		if(method.isAnnotationPresent(Permission.class)){
			result = method.getAnnotation(Permission.class).loginReqired();
		}

		return result;
	}

	//判断是否已经登录
	private boolean isLogin(HttpServletRequest request) {
		return true;
        /*String token = XWebUtils.getCookieByName(request, WebConstants.CookieName.AdminToken);
        if("1".equals(redisOperator.get(RedisConstants.Prefix.ADMIN_TOKEN+token))){
            return true;
        }else {
            return false;
        }*/
	}

}
