package java8err.rmi;

import java.rmi.RemoteException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImp implements IConsumerService {

  @Override
  public void consume(String msg) throws RemoteException {

    System.out.println("received: " + msg);
    Common.showAppContextMap();
    try {
      SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {

          // nothing
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      new JPanel();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}