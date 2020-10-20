package webserver;

import java.net.*;
import java.io.*;

public class WebServer extends Thread {
	protected  Socket clientSocket;
	static Config c=new Config("C:\\Users\\Dragos\\Desktop\\New folder\\index.html","C:\\Users\\Dragos\\Desktop\\New folder\\notfound.html",10008);
	public static final int PORT=c.getPORT();
	public static final String Default_file=c.getDefaultIndex();
	public static final String FILE_Not_Found=c.getNotFound();
	
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Connection Socket Created");
			try {
				while (true) {
					System.out.println("Waiting for Connection");
					new WebServer(serverSocket.accept());
				}
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
		} catch (IOException e) {
			System.err.println("Could not listen on port: 10008.");
			System.exit(1);
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				System.err.println("Could not close port: 10008.");
				System.exit(1);
			}
		}
	}

	private WebServer(Socket clientSoc) {
		clientSocket = clientSoc;
		start();
	}

	public void run() {
		System.out.println("New Communication Thread Started");
		
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
					true);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Server: " + inputLine);
				out.println(inputLine);

				if (inputLine.trim().equals(""))
					break;
			}

			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			System.err.println("Problem with Communication Server");
			System.exit(1);
		}
	}
}