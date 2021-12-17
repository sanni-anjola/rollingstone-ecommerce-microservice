package com.example.rollingstoneecommercecategoryapi.listeners;

import com.example.rollingstoneecommercecategoryapi.events.CategoryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CategoryEventListeners {
    private final Logger log = LoggerFactory.getLogger(CategoryEventListeners.class);

    @EventListener
    public void onApplicationEvent(CategoryEvent categoryEvent){
        log.info("Received Category Event: "+categoryEvent.getEventType());
        log.info("Received Category From Category Event: "+categoryEvent.getCategory().toString());
    }
}
