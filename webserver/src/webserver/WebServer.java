package webserver;
import webserver.GUI;
import java.net.*;
import java.util.StringTokenizer;
import java.io.*;

public class WebServer extends Thread {
	

	private Socket clientSocket;
	
	public static String DEFAULT_FILE;
	public static String INCORRECT_FILE;
	public static String NOT_FOUND_FILE;
	
	//Config c=new Config("index.html","404.html","notexist.html",10008);
	//DEFAULT_FILE=c.getefaultIndex();
	public static int PORT;
	

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		PORT=GUI.p1();
		DEFAULT_FILE=GUI.f1();
		NOT_FOUND_FILE=GUI.f2();
		INCORRECT_FILE=GUI.f3();
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
			System.err.println("Could not listen on port: "+PORT);
			System.exit(1);
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				System.err.println("Could not close port: "+PORT);
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
		DataOutputStream data=null;
		PrintWriter out=null;
		BufferedReader in=null;
		try {
			  out = new PrintWriter(clientSocket.getOutputStream(),
					true);
			 in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			data=new DataOutputStream(clientSocket.getOutputStream());
			String Request;
			String inputLine;
			inputLine=in.readLine();
			String take=inputLine;
			StringTokenizer parser=new StringTokenizer(take);
			String type = parser.nextToken();
			Request=parser.nextToken();
			 if( type.equals("GET"))
			 {
				if(Request.equals("/"))
				{
				
				File f=new File(DEFAULT_FILE);
				
				int fileLen=(int)f.length();
				 byte file_data[]=ReadFile(f,fileLen);
				 String s=new String(file_data);
				 System.out.println(" "+s);
				 String content="text/html";
				 out.println("HTTP/1.1 200 OK");
				 out.println(content);
				 out.println();
				data.writeBytes(s);
				
				}
				else {
					 File file=new File(NOT_FOUND_FILE);
						int fileLen=(int)file.length();
						 byte file_data[]=ReadFile(file,fileLen);
						 String s=new String(file_data);
						 String content="text/html";
						out.println("HTTP/1.1 404 File Not Found");
						out.println(content);
						out.println();
						 data.writeBytes(s);
				}
			 }
			 else {
				 File f=new File(INCORRECT_FILE);
					int fileLen=(int)f.length();
					 byte file_data[]=ReadFile(f,fileLen);
					 String s=new String(file_data);
					 String content="text/html";
					 out.println("HTTP/1.1 200 OK");
					 out.println(content);
					 data.writeBytes(s);
					
					 
			 }
			out.close();
			in.close();
			data.close();
			clientSocket.close();
			}catch(IOException e){
			System.err.println("Problem with Communication Server");
			System.exit(1);
			}
			}

	private byte[] ReadFile(File f,int f_len) throws IOException 
	{
		FileInputStream in=null;
		byte fData[]=new byte[f_len];
		try {
			in=new FileInputStream(f);
			in.read(fData);
			
		} finally {
			if(in!=null)
			{
			in.close();
			}
		}
		return fData;
	}
	
}