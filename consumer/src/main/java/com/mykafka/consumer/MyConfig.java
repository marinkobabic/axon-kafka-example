/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.mykafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.axonframework.boot.autoconfig.AxonAutoConfiguration;
import org.axonframework.config.EventHandlingConfiguration;
import org.axonframework.config.EventProcessingConfiguration;
import org.axonframework.kafka.eventhandling.DefaultKafkaMessageConverter;
import org.axonframework.kafka.eventhandling.KafkaMessageConverter;
import org.axonframework.kafka.eventhandling.consumer.KafkaMessageSource;
import org.axonframework.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(AxonAutoConfiguration.class)
public class MyConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(MyEventEventHandler.class);

  @ConditionalOnMissingBean
  @Bean
  public KafkaMessageConverter<String, byte[]> kafkaMessageConverter(
      @Qualifier("eventSerializer") Serializer eventSerializer) {
    return new DefaultKafkaMessageConverter(eventSerializer);
  }

  @Autowired
  public void configure(EventProcessingConfiguration config) {
    config.usingTrackingProcessors(); // default all processors to tracking mode.
  }

}
