package java8err.rmi2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerServiceImp implements IServerService {

  @Override
  public String getSomethingServed() throws RemoteException {

    try {
      Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);

      IProviderService serverService = (IProviderService) registry.lookup("ProviderService");
      String ret = serverService.getSomething();
      return ret + " served";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}