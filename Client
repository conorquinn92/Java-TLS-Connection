
import javax.swing.JOptionPane;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import java.io.*;

import java.util.Arrays;


public abstract class Client{
	public abstract String[] getEnabledProtocols(); 
	public abstract String[] getDefaultCipherSuites();
	public abstract String[] getSession();
	public static void main(String[] arstring) {
		//This section of code deals with the input of the path to keystore and truststore
		String truststore;
		String keystore;
		String truststorePS;
		String keystorePS;
		//trustStore is to verify credentials and keyStore is to provide credential
		//create own truststore and keystore using OpenSSL or Keytool and put proper certificates in each store
		truststore = (String) JOptionPane.showInputDialog(null,"Enter path to truststore","TLS CONNECTION",JOptionPane.INFORMATION_MESSAGE,null,null, "");
		truststorePS = (String) JOptionPane.showInputDialog(null,"Enter truststore password","TLS CONNECTION",JOptionPane.INFORMATION_MESSAGE,null,null, "");
		keystore = (String) JOptionPane.showInputDialog(null,"Enter path to keystore","TLS CONNECTION",JOptionPane.INFORMATION_MESSAGE,null, null, "");
		keystorePS = (String) JOptionPane.showInputDialog(null,"Enter keystore password","TLS CONNECTION",JOptionPane.INFORMATION_MESSAGE,null, null, "");

		System.setProperty("javax.net.ssl.trustStore", truststore);
		System.setProperty("javax.net.ssl.trustStorePassword", truststorePS);

		System.setProperty("javax.net.ssl.keyStore", keystore);
		System.setProperty("javax.net.ssl.keyStorePassword", keystorePS);

		byte[] TS = new byte[1024];
		byte[] TSP = new byte[1024];
		byte[] KS = new byte[1024];
		byte[] KSP = new byte[1024];
		byte[] SendData = new byte[2048];
		byte[] ReadData = new byte[2048];

		try{

			//creation of the SSL Socket for the TLS hadshake
			SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(/*(IP Address to connect to, Port number to connect to)*/);

			//enables TLSv1.2 is used
			sslsocket.setEnabledProtocols(new String[] {"TLSv1.2"} );

			String[] prots = sslsocket.getEnabledProtocols();
			System.out.println(Arrays.toString(prots));

			//setting what truststore and keystore to use
			//default truststore and keystore passwords usually 'changeit'
			String trustStore = System.getProperty("javax.net.ssl.trustStore");
			String trustStorePassword = System.getProperty("javax.net.ssl.trustStorePassword");
			TS = trustStore.getBytes();
			TSP = trustStorePassword.getBytes();
			String keyStore = System.getProperty("javax.net.ssl.keyStore");
			String keyStorePassword = System.getProperty("javax.net.ssl.keyStorePassword");
			KS = keyStore.getBytes();
			KSP = keyStorePassword.getBytes();

			//creates streams for sending data
			DataOutputStream OuttoClient = new DataOutputStream (sslsocket.getOutputStream());;
			DataInputStream ReadFromClient = new DataInputStream(sslsocket.getInputStream());

			SendData = hexStringtoByteArray.hexStringToByteArray("HEX STRING TO SEND DOWN STREAM (CONVERTED TO BYTE ARRAY)");

			OuttoClient.write(SendData);
			ReadFromClient.read(ReadData);

			sslsocket.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
