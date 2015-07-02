package java8err.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConsumerService extends Remote {

  public void consume(String msg) throws RemoteException;
}
