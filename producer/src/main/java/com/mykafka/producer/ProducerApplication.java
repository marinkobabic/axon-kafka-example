package com.mykafka.producer;

import com.mykafka.consumer.events.MyEvent;
import com.mykafka.consumer.events.MySagaEndEvent;
import com.mykafka.consumer.events.MySagaStartEvent;

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
    TimeUnit.SECONDS.sleep(5);

    LOGGER.info("Start sending");
    final long processId = 1234;
    sender.send(new MySagaStartEvent(processId));

    for (int i = 1; i <= 20; i++) {
      TimeUnit.SECONDS.sleep(5);
      sender.send(new MyEvent(String.format("Hi there %d", i)));
    }
    sender.send(new MySagaEndEvent(processId));
    LOGGER.info("Send completed");
  }
}
