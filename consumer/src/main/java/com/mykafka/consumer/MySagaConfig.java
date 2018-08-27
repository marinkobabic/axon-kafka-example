/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.mykafka.consumer;

import org.axonframework.boot.autoconfig.KafkaAutoConfiguration;
import org.axonframework.config.SagaConfiguration;
import org.axonframework.eventhandling.saga.repository.SagaStore;
import org.axonframework.eventhandling.saga.repository.inmemory.InMemorySagaStore;
import org.axonframework.kafka.eventhandling.consumer.KafkaMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(KafkaAutoConfiguration.class)
/*
  https://docs.axonframework.org/part-ii-domain-logic/sagas#saga-repository-and-saga-store
 */
public class MySagaConfig {

  @Bean
  public SagaStore mySagaStore() {
    return new InMemorySagaStore(); //JdbcSagaStore, InMemorySagaStore, JpaSagaStore and MongoSagaStore.
  }

  @Bean
  public SagaConfiguration<MySaga> mySagaConfiguration(@Autowired KafkaMessageSource<String, Object> kafkaMessageSource) {
    return SagaConfiguration.trackingSagaManager(MySaga.class, "MyProcessor", configuration -> kafkaMessageSource);
  }
}
