/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.mykafka.producer;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.GenericEventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Sender {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

  @Autowired
  private EventBus eventBus;

  <T> void send(T event) {
    LOGGER.info("publishing event {}", event);
    EventMessage<T> eventMessage = GenericEventMessage.asEventMessage(event);

    eventBus.publish(eventMessage);
  }
}
