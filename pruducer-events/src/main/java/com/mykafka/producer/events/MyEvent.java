/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.mykafka.producer.events;

import java.io.Serializable;

public class MyEvent implements Serializable {

  private String greeting;

  public MyEvent(String greeting){

    this.greeting = greeting;
  }

  public String getGreeting() {
    return greeting;
  }

  @Override
  public String toString() {
    return this.greeting;
  }
}
