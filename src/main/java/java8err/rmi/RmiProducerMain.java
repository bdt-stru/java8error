package java8err.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiProducerMain {

  public static void main(String[] args) {

    Common.deactivateSecurityManager();

    try {
      Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);

      IConsumerService consumerService = (IConsumerService) registry.lookup("ConsumerService");
      consumerService.consume("hallo");
      System.out.println("sent");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}