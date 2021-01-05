package JUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import webserver.WebServer;

public class Default_File_test {

	@Test
	public void test() {
		assertEquals("Default file","index.html",WebServer.DEFAULT_FILE);
	}

}
