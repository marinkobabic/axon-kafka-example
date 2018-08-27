/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.mykafka.consumer.events;

public class MySagaStartEvent {

  private String name;
  private long startId;

  private MySagaStartEvent() {
  }

  public MySagaStartEvent(long startId) {
    this.startId = startId;
    this.name = "Start";
  }

  public String getName() {
    return name;
  }

  public long getStartId() {
    return startId;
  }

  @Override
  public String toString() {
    return String.format("Saga %s %d", this.name, this.startId);
  }
}
