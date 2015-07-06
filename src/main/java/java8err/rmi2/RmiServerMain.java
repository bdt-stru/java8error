package java8err.rmi2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java8err.rmi.Common;

import javax.swing.JOptionPane;

public class RmiServerMain {

  public static void main(String args[]) {

    Common.deactivateSecurityManager();

    try {
      LocateRegistry.createRegistry(1099);

      Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);

      ServerServiceImp obj = new ServerServiceImp();
      IServerService serverService = (IServerService) UnicastRemoteObject.exportObject(obj, 1101);
      registry.bind("ServerService", serverService);

    } catch (Exception e) {
      e.printStackTrace();
    }

    JOptionPane.showMessageDialog(null, "click OK to quit " + RmiServerMain.class.getSimpleName());
    System.exit(0);
  }

}