package com.mykafka.producer;

import com.mykafka.producer.events.MyEvent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class ProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);

	}

	@Autowired
	Sender sender;

	private CountDownLatch latch = new CountDownLatch(1);

	@Override
	public void run(String... args) throws Exception {
		sender.send("boot.t",new MyEvent("Hi there"));
		latch.await(60, TimeUnit.SECONDS);
	}
}
