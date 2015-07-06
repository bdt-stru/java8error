package java8err.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

public class RmiConsumerMain {

  public static void main(String args[]) {

    Common.deactivateSecurityManager();

    try {
      LocateRegistry.createRegistry(1099);

      Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);

      ConsumerServiceImp obj = new ConsumerServiceImp();
      IConsumerService consumerService = (IConsumerService) UnicastRemoteObject.exportObject(obj, 1101);
      registry.bind("ConsumerService", consumerService);

    } catch (Exception e) {
      e.printStackTrace();
    }

    JOptionPane.showMessageDialog(null, "click OK to quit " + RmiConsumerMain.class.getSimpleName());
    System.exit(0);
  }

}