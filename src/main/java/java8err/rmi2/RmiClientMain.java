package java8err.rmi2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java8err.rmi.Common;

import javax.swing.JOptionPane;

public class RmiClientMain {

  public static void main(String args[]) {

    Common.deactivateSecurityManager();

    try {
      Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);

      IServerService serverService = (IServerService) registry.lookup("ServerService");
      String ret = serverService.getSomething();
      System.out.println(ret);
    } catch (Exception e) {
      e.printStackTrace();
    }

    JOptionPane.showMessageDialog(null, "click OK to quit " + RmiClientMain.class.getSimpleName());
    System.exit(0);
  }

}