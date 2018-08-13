/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.mykafka.producer;

import org.axonframework.boot.autoconfig.AxonAutoConfiguration;
import org.axonframework.kafka.eventhandling.DefaultKafkaMessageConverter;
import org.axonframework.kafka.eventhandling.KafkaMessageConverter;
import org.axonframework.serialization.Serializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(AxonAutoConfiguration.class)
public class MyConfig {

  @ConditionalOnMissingBean
  @Bean
  public KafkaMessageConverter<String, byte[]> kafkaMessageConverter(
      @Qualifier("eventSerializer") Serializer eventSerializer) {
    return new DefaultKafkaMessageConverter(eventSerializer);
  }
}
