package java8err.rmi2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IProviderService extends Remote {

  public String getSomething() throws RemoteException;
}
