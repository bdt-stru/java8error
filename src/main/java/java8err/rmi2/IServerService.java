package java8err.rmi2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServerService extends Remote {

  public String getSomethingServed() throws RemoteException;
}
