package java8err.rmi2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import java8err.rmi.Common;

public class RmiServerMain {

  public static void main(String args[]) {

    Common.deactivateSecurityManager();

    try {
      Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);

      ServerServiceImp obj = new ServerServiceImp();
      IServerService serverService = (IServerService) UnicastRemoteObject.exportObject(obj, 1102);
      registry.bind("ServerService", serverService);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}