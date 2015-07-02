package java8err.rmi;

import java.lang.reflect.Field;
import java.util.Map;

public class Common {

  public static Map<ThreadGroup, sun.awt.AppContext> getAppContextMap() {

    try {
      Field field = sun.awt.AppContext.class.getDeclaredField("threadGroup2appContext");
      field.setAccessible(true);
      return (Map<ThreadGroup, sun.awt.AppContext>) field.get(null);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void showAppContextMap() {

    try {
      ThreadGroup ctg = Thread.currentThread().getThreadGroup();
      String strctg = ctg.getClass().getName() + "@" + Integer.toHexString(ctg.hashCode()) + " " + ctg;
      System.out.println("current ThreadGroup: " + strctg);
      System.out.println("map sun.awt.AppContext.threadGroup2appContext:");
      Map<ThreadGroup, sun.awt.AppContext> map = getAppContextMap();
      for (ThreadGroup tg : map.keySet()) {
        sun.awt.AppContext ac = map.get(tg);
        String strtg = tg.getClass().getName() + "@" + Integer.toHexString(tg.hashCode()) + " " + tg;
        String strac = ac.getClass().getName() + "@" + Integer.toHexString(ac.hashCode()) + " " + ac;
        System.out.println("  " + strtg + "\t" + strac);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void deactivateSecurityManager() {

    System.out.println("java.runtime.version=" + System.getProperty("java.runtime.version"));
    System.out.println("javaplugin.version=" + System.getProperty("javaplugin.version"));
    System.out.println("javawebstart.version=" + System.getProperty("javawebstart.version"));
    System.out.println("javafx.version=" + System.getProperty("javafx.version"));

    SecurityManager securityManager = System.getSecurityManager();
    System.setSecurityManager(null);
    System.out.println("SecurityManager changed from " + (securityManager != null ? securityManager.getClass() : "null") + " to null");
  }
}