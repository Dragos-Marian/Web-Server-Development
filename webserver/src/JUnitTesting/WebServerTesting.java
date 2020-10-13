package JUnitTesting;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import webserver.WebServer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebServerTesting {
	
	
	private static final String Accepted = null;
	private Socket Soc;

	@Before
	public void SetupSocket()
	{
		Soc= new Socket();
	}
	
	@Test
	public void TestPORT()
	{
		assertEquals(Accepted, 10008,WebServer.PORT);
	}
	
	
}
