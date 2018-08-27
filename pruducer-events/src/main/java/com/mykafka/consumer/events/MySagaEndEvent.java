/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package com.mykafka.consumer.events;

public class MySagaEndEvent {

  private String name;
  private long endId;

  private MySagaEndEvent() {
  }

  public MySagaEndEvent(long endId) {
    this.endId = endId;
    this.name = "End";
  }

  public String getName() {
    return name;
  }

  public long getEndId() {
    return endId;
  }

  @Override
  public String toString() {
    return String.format("Saga %s %d", this.name, this.endId);
  }
}
