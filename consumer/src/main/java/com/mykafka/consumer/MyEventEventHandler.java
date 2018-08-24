/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.mykafka.consumer;

import com.mykafka.consumer.events.MyEvent;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
 If ProcessingGroup is not set, then the package name is used.
 The name of the ProcessingGroup is also in the configuration
 and the name must match the name of the TrackingProcessor defined
 in the configuration. Axon adds automatically all the handler to the TrackingProcessor
 The class must be a @Component
 */
@Component
@ProcessingGroup("MyProcessor")
public class MyEventEventHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(MyEventEventHandler.class);

  @EventHandler
  public void handleMyEvent(MyEvent myEvent){
    LOGGER.info("got the event {}", myEvent);
  }

}
