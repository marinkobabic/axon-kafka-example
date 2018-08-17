# axon-kafka-example
Example of axon-kafka module usage. This example uses Spring Boot 2.0 and Axon Framework. It's a good starting point for event driven development.

Here the link to the official documentation for axon-kafka  https://docs.axonframework.org/part-iii-infrastructure-components/event-processing#apache-kafka
## Producer
Produces events which are consumed by the consumer. 

## Producer-events
Every public API represents a contract. When using message the exchanged messages are the contracts. In this example the contract is the MyEvent

## Consumer
 Cosumer is there to consume the published event by the producer. Therefor is the @EventHandler is needed which is automatically scanned by the Axon framework and assigned to the trackingProcessor matching the ProcessingGroup
 ```
 axon:
   eventhandling:
     processors:
       "[MyProcessor]":
         source: kafkaMessageSource
         mode: TRACKING
```
In our example you can find the name **MyProcessor**. This is the name you can find in the @EventHandler class
```java
@Component
@ProcessingGroup("MyProcessor")
public class MyEventEventHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(MyEventEventHandler.class);

  @EventHandler
  public void handleMyEvent(MyEvent myEvent){
    LOGGER.debug("got the event {}", myEvent);
  }

}
```
For reference see the Spring Boot Autoconfiguraton https://docs.axonframework.org/part-ii-domain-logic/event-handling

###Docker
If you don't have a kafka environment running on your machine, you can use the docker-compose.yaml here. All you need to do is to navigate to this directore and execute the command
```
docker-compose up
```
