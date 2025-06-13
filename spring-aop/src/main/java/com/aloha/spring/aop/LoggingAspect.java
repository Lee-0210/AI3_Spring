package com.aloha.spring.aop;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.aloha.spring.dto.Board;

@EnableAspectJAutoProxy
@Component
@Aspect
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	/**
	 * 어드바이스 유형
	 * - Around
	 * - Before
	 * - After
	 * - AfterReturning
	 * - AfterThowing
	 */
	
	/**
	 * 포인트컷 표현요소
	 * - 지시자 : execution
	 * - 반환값
	 * - 패키지
	 * - 클래스
	 * - 메서드
	 * - 인수
	 */
	
	// execution( 접근제한자 반환타입 패키지.클래스.메서드(파라미터) )
	@Before("execution(* com.aloha.spring.service.BoardService*.*(..))")
	public void before(JoinPoint jp) {
		// jp.getSignature() 	: 타켓 메서드의 시그니처 정보(반환타입, 패키지.클래스.메서드) 반환
		// jp.getArgs()			: 타겟 메서드의 매개변수를 반환
		logger.info("===================================");
		
		logger.info("[@Before] #########################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info("args : " + Arrays.toString(jp.getArgs()));
		
		// 파라미터 출력
		printParam(jp);
		
		logger.info("====================================");
	}
	
	@After("execution(* com.aloha.spring.service.BoardService*.*(..))")
	public void after(JoinPoint jp) {
		// jp.getSignature() 	: 타켓 메서드의 시그니처 정보(반환타입, 패키지.클래스.메서드) 반환
		// jp.getArgs()			: 타겟 메서드의 매개변수를 반환
		logger.info("===================================");
		
		logger.info("[@After] #########################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info("args : " + Arrays.toString(jp.getArgs()));
		
		// 파라미터 출력
		printParam(jp);
	
		logger.info("====================================");
	}
	
	@AfterReturning(pointcut = "execution(* com.aloha.spring.service.BoardService*.*(..))", returning = "result")
	public void afterReturning(JoinPoint jp, Object result) {
		// jp.getSignature() 	: 타켓 메서드의 시그니처 정보(반환타입, 패키지.클래스.메서드) 반환
		// jp.getArgs()			: 타겟 메서드의 매개변수를 반환
		logger.info("===================================");
		
		logger.info("[@AfterReturning] #########################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info("args : " + Arrays.toString(jp.getArgs()));
		
		// 파라미터 출력
		printParam(jp);
		
		// 반환값 출력
		if(result != null) logger.info("반환값 : " + result.toString());
		
		if(result instanceof Board) {
			result = (Board) result;
			logger.info("반환값 : " + result);
		}
	
		logger.info("====================================");
	}
	
	@AfterThrowing(pointcut = "execution(* com.aloha.spring.service.BoardService*.*(..))", throwing = "exception")
	public void afterThrowing(JoinPoint jp, Exception exception) {
		// jp.getSignature() 	: 타켓 메서드의 시그니처 정보(반환타입, 패키지.클래스.메서드) 반환
		// jp.getArgs()			: 타겟 메서드의 매개변수를 반환
		logger.info("===================================");
		
		logger.info("[@AfterThrowing] #########################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info(exception.toString());
		logger.info("====================================");
	}
	
	/**
	 * ProceedingJoinPoint 	: 어드바이스에서 타겟 메서드의 실행을 제어하고 호출하는 객체
	 * - proceed();			: 타겟 메서드 호출
	 * @param jp
	 * @return
	 */
	@Around("execution(* com.aloha.spring.service.BoardService*.*(..))")
	public Object around(ProceedingJoinPoint jp) {
		// jp.getSignature() 	: 타켓 메서드의 시그니처 정보(반환타입, 패키지.클래스.메서드) 반환
		// jp.getArgs()			: 타겟 메서드의 매개변수를 반환
		logger.info("===================================");
		
		logger.info("[@Around] #########################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info("args : " + Arrays.toString(jp.getArgs()));
		
		LocalDateTime start = LocalDateTime.now();
		logger.info("실행 전 시간 : " + start);
		
		Object result = null;
		try {
			result = jp.proceed();
			if(result != null)
				logger.info("반환값 : " + result.toString());
		} catch(Throwable e) {
			logger.info("예외가 발생하였습니다.");
			e.printStackTrace();
		}
		
		LocalDateTime end = LocalDateTime.now();
		logger.info("실행 후 시간 : " + end);
		logger.info("====================================");
		return result;
	}
	
	public void printParam(JoinPoint jp) {
		Signature signature = jp.getSignature();
		// 타겟 메서드의 파라미터 이름 가져오기
		String[] parameterNames = ((MethodSignature) signature).getParameterNames();
		// 타겟 메서드의 인수 가져오기
		Object[] args = jp.getArgs();
		// 파라미터 이름과 값을 출력
		if(parameterNames != null) {
			for(int i = 0; i < parameterNames.length; i++) {
				String paramName = parameterNames[i];
				Object paramValue = args[i];
				logger.info("파라미터명 : " + paramName + ", 값 : " + paramValue);
			}
		}
	}
}
