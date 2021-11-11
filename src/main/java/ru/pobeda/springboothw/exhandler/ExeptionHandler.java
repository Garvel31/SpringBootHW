package ru.pobeda.springboothw.exhandler;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@EnableAspectJAutoProxy
@Aspect
@Component
public class ExeptionHandler {


    @Around("@annotation(ru.pobeda.springboothw.exhandler.IdExeptionHandler) && target(controller)")
    public String handleException(ProceedingJoinPoint jp, Object controller) throws Throwable {
        String view = null;

        try {
            view = (String) jp.proceed();
        } catch (Exception e) {

            return "errors";
        }

        return view;
    }

}