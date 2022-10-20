package tn.esprit.spring.aspect;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// Aspect / Advise / JointPoint / jointCut
@Component
@Aspect
@Slf4j
public class Logging {

	private long t1, t2;

	@Before("execution(* tn.esprit.spring.services.FournisseurService.*(..))") //PointCut
	public void avant(JoinPoint thisJoinPoint) {
		t1 = System.currentTimeMillis();
		log.info("In the method"+ thisJoinPoint.getSignature().getName());
	}

	@After("execution(* tn.esprit.spring.services.FournisseurService.*(..))")
	public void apres(JoinPoint thisJoinPoint) {
		t2 = System.currentTimeMillis();
		log.info("Exuction Time of methode " + thisJoinPoint.getSignature() + " is  " + (t2 - t1) + " ms");
		log.info("Out of the method (After)"+ thisJoinPoint.getSignature().getName());
	}
	@Around("execution(* tn.esprit.spring.services.FournisseurService.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
	long start = System.currentTimeMillis();
	Object obj = pjp.proceed();
	long elapsedTime = System.currentTimeMillis() - start;
	log.info("Method execution time: " + elapsedTime + " milliseconds.");
	return obj;
	}
	

}