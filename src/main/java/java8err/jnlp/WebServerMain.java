package java8err.jnlp;

import java.io.File;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class WebServerMain {

  public static void main(String[] args) throws Exception {

    System.out.println("workdir=" + new File("").getAbsolutePath());
    startWebServer("127.0.0.1");
  }

  public static void startWebServer(String hostname) {

    try {
      Server server = new Server(new InetSocketAddress(hostname, 80));

      String absRootWeb = new File("").getAbsolutePath();

      System.out.println("web-server-root: " + absRootWeb);

      List<Handler> handlers = new ArrayList<>();
      ResourceHandler handleResourceWeb = new ResourceHandler();
      handleResourceWeb.setResourceBase(absRootWeb);
      handleResourceWeb.setDirectoriesListed(true);
      handlers.add(handleResourceWeb);

      HandlerList hl = new HandlerList();
      hl.setHandlers(handlers.toArray(new Handler[0]));
      server.setHandler(hl);
      server.start();

      System.out.println("web-server ready at " + "http://" + hostname);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
