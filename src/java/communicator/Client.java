package communicator;

import java.io.*;
import java.net.*;

public class Client {

	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	
	public static final String IP = "192.168.178.21";
	public static final int PORT = 2323;
 
	public static String getText() {
		String text = "This is my Test-Message!";
		return text;
	}
	
	public void send() {
		out.println(getText());
	}

	public void setSocket() {
		try {
			socket = new Socket(IP, PORT);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.out.println("Unknown host: " + IP
					+ e.getLocalizedMessage());
			System.exit(1);
		} catch (IOException e) {
			System.out.println("No I/O: " + e.getLocalizedMessage());
			System.exit(1);
		}

	}

	public static void main(String[] args) {
		Client client = new Client();
		client.setSocket();
		client.send();
	}

}
