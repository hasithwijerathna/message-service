package com.example.demo.aspect;

import com.example.demo.model.Message;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SamplePointCut {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Pointcut(value = "execution(* com.example.demo.service.MessageServiceImpl.saveMessage(..)) and args(message)")
    @Pointcut(value = "within(com.example.demo.service.MessageServiceImpl) || within(com.example.demo.repository.MessageRepository)")
//    @Pointcut(value = "target(com.example.demo.service.MessageService)")
//    @Pointcut(value = "this(comm.example.demo.service.MessageService)")
//    @Pointcut(value = "@within(org.springframework.stereotype.Service)")
//    @Pointcut(value = "execution(* com.example.demo.service.MessageServiceImpl.saveMessage(..)) and args(message)")
    public void myPointCutForService(){
    }


    @Around(value = "myPointCutForService()")
    public Object beforeMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before execution of {}", joinPoint.getSignature());
        try {
            final Object proceed = joinPoint.proceed();
            logger.info("After execution of {}", joinPoint.getSignature());
            return proceed;
        } finally {

        }
    }




    /*@After(value = "execution(* com.example.demo.service.MessageServiceImpl.saveMessage(..)) and args(message)")
    public void afterMethodExecution(JoinPoint joinPoint, Message message) {
        logger.info("Going to save {}", message.toString());
    }*/
}
