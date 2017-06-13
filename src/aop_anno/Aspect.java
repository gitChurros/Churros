package aop_anno;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class Aspect {

		@Pointcut("execution(public * 1071-spring .. *(..)")
		private void publicTarget() {
			
		}
		
		@Around("publicTarget()")
		public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
			long start = System.nanoTime();
			try{
				Object result = joinPoint.proceed();
				return result;
			} finally {
				long finish = System.nanoTime();
				Signature sig = joinPoint.getSignature();
				System.out.printf("%s.%s(%s) 실행시간 : %d ns\n",
						joinPoint.getTarget().getClass().getSimpleName(),
						sig.getName(), Arrays.toString(joinPoint.getArgs()),
						(finish-start));
			}
		}
}
