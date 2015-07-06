package java8err.rmi2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java8err.rmi.Common;

import javax.swing.JOptionPane;

public class RmiProviderMain {

  public static void main(String args[]) {

    Common.deactivateSecurityManager();

    try {
      LocateRegistry.createRegistry(1099);

      Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);

      ProviderServiceImp obj = new ProviderServiceImp();
      IProviderService providerService = (IProviderService) UnicastRemoteObject.exportObject(obj, 1101);
      registry.bind("ProviderService", providerService);

    } catch (Exception e) {
      e.printStackTrace();
    }

    JOptionPane.showMessageDialog(null, "click OK to quit " + RmiProviderMain.class.getSimpleName());
    System.exit(0);
  }

}