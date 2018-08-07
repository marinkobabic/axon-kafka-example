/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.mykafka.consumer;

import com.mykafka.producer.events.MyEvent;

import java.util.concurrent.CountDownLatch;

import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyEventEventHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(MyEventEventHandler.class);

  @EventHandler
  public void handleMyEvent(MyEvent myEvent){
    LOGGER.debug("got the event {}", myEvent);
  }

}
