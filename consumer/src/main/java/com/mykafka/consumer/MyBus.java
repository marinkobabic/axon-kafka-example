/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.mykafka.consumer;

import org.axonframework.eventhandling.AbstractEventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventsourcing.eventstore.TrackingEventStream;
import org.axonframework.eventsourcing.eventstore.TrackingToken;
import org.axonframework.kafka.eventhandling.consumer.KafkaMessageSource;
import org.axonframework.kafka.eventhandling.consumer.KafkaMessageStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBus extends AbstractEventBus {

  private final KafkaMessageSource kafkaMessageSource;
  private static final Logger logger = LoggerFactory.getLogger(SimpleEventBus.class);

  @Autowired
  public MyBus(KafkaMessageSource kafkaMessageSource) {
    super();
    this.kafkaMessageSource = kafkaMessageSource;
  }

  @Override
  public TrackingEventStream openStream(TrackingToken trackingToken) {

    return (KafkaMessageStream) this.kafkaMessageSource.openStream(trackingToken);

  }
}
