package com.mykafka.producer;

import com.mykafka.consumer.events.MyEvent;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class ProducerApplication implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
  @Autowired
  private Sender sender;

  public static void main(String[] args) {
    SpringApplication.run(ProducerApplication.class, args);

  }

  @Override
  public void run(String... args) throws Exception {
    LOGGER.info("Start sending");
    for (int i = 0; i < 20; i++) {
      TimeUnit.SECONDS.sleep(5);
      sender.send(new MyEvent(String.format("Hi there %d", i)));
    }
    LOGGER.info("Send completed");
  }
}
