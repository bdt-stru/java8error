# java8error

shows how to cause 3 exceptions:

<pre>
1)
java.lang.NullPointerException
	at sun.awt.SunToolkit.getSystemEventQueueImplPP(Unknown Source)
	at sun.awt.SunToolkit.getSystemEventQueueImplPP(Unknown Source)
	at sun.awt.SunToolkit.getSystemEventQueueImpl(Unknown Source)
	at java.awt.Toolkit.getEventQueue(Unknown Source)
	at java.awt.EventQueue.invokeLater(Unknown Source)
	at javax.swing.SwingUtilities.invokeLater(Unknown Source)
	...
2)
java.lang.NullPointerException
	at javax.swing.SwingUtilities.appContextGet(Unknown Source)
	at javax.swing.JComponent.getDefaultLocale(Unknown Source)
	at javax.swing.JComponent.<init>(Unknown Source)
	at javax.swing.JPanel.<init>(Unknown Source)
	at javax.swing.JPanel.<init>(Unknown Source)
	at javax.swing.JPanel.<init>(Unknown Source)
	...
3)
java.lang.NullPointerException
	at com.sun.jnlp.JNLPClassLoader.getPermissions(Unknown Source)
	at java.security.SecureClassLoader.getProtectionDomain(Unknown Source)
	at java.security.SecureClassLoader.defineClass(Unknown Source)
	at java.net.URLClassLoader.defineClass(Unknown Source)
	at java.net.URLClassLoader.access$100(Unknown Source)
	at java.net.URLClassLoader$1.run(Unknown Source)
	at java.net.URLClassLoader$1.run(Unknown Source)
	...
</pre>

# how to build and run

run create_keystore.bat to generate a keystore for signing. answer all questions with: y

run: mvn clean verify

run: target\staging\server\bin\run_webserver.bat

go with webbrowser to: http://127.0.0.1:80/

activate java console

start Rmi Applications in the order they are listed on the website ( <a href="jnlp/index.html">jnlp/index.html</a> )


