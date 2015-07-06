package java8err.rmi2;

import java.rmi.RemoteException;

import org.cip4.jdflib.core.JDFDocumentBuilder;

public class ServerServiceImp implements IServerService {

  @Override
  public String getSomething() throws RemoteException {

    new JDFDocumentBuilder();
    return "something";
  }
}