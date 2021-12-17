package com.example.rollingstoneecommercecategoryapi.spring.controller;

import com.example.rollingstoneecommercecategoryapi.exceptions.Http400Exception;
import com.example.rollingstoneecommercecategoryapi.exceptions.Http404Exception;
import com.example.rollingstoneecommercecategoryapi.exceptions.RestAPIExceptionInfo;
import io.micrometer.core.instrument.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController implements ApplicationEventPublisherAware {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    protected ApplicationEventPublisher eventPublisher;
    protected static final String DEFAULT_PAGE_SIZE = "20";
    protected static final String DEFAULT_PAGE_NUMBER = "0";

    @Autowired
    Counter http404ExceptionCounter;

    @Autowired
    Counter http400ExceptionCounter;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Http400Exception.class)
    public @ResponseBody RestAPIExceptionInfo handleBadRequestException(Http400Exception ex, WebRequest request, HttpServletResponse response){
        log.info("Received Bad Request Exception "+ ex.getLocalizedMessage());
        http404ExceptionCounter.increment();
        return new RestAPIExceptionInfo(ex.getLocalizedMessage(), "The Request did not have the correct parameters");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public @ResponseBody RestAPIExceptionInfo handleBadRequestExceptionForJsonBody(HttpMessageNotReadableException ex,
                                                                                   WebRequest request, HttpServletResponse response)
    {
        log.info("Received Bad Request Exception"+ex.getLocalizedMessage());
        http400ExceptionCounter.increment();
        return new RestAPIExceptionInfo("JSON Parse Error", "The Request did not have the correct json body");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Http404Exception.class)
    public @ResponseBody RestAPIExceptionInfo handleResourceNotFoundException(Http404Exception ex,
                                                                              WebRequest request, HttpServletResponse response)
    {
        log.info("Received Resource Not Found Exception"+ex.getLocalizedMessage());
        http404ExceptionCounter.increment();
        return new RestAPIExceptionInfo(ex.getLocalizedMessage(), "The Requested Resource was not found");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher  = eventPublisher;
    }

    public static <T> T checkResourceFound(final T resource) {
        if (resource == null) {
            throw new Http404Exception("Resource Not Found");
        }
        return resource;
    }

}
