package com.example.rollingstoneecommercecategoryapi.aspects;

import io.micrometer.core.instrument.Counter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@AllArgsConstructor
@NoArgsConstructor
public class RestControllerAspect {
    private final Logger logger = LoggerFactory.getLogger("RestControllerAspect");

    private Counter createdCategoryCreationCounter;
    @Before("execution(public * com.example.rollingstoneecommercecategoryapi.spring.controller.*Controller.*(..))")
    public void generalMethodAspect(){
        logger.info("All method calls invoke this general ");
    }

    @AfterReturning("execution(public * com.rollingstone.spring.controller.*Controller.createCategory(..))")
    public void getsCalledOnCategorySave() {
        logger.info("This aspect is fired when the createCategory method of the controller is called");
        createdCategoryCreationCounter.increment();
    }
}
