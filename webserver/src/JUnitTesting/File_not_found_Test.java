package JUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import webserver.WebServer;

public class File_not_found_Test {

	@Test
	public void test() {
		assertEquals("Not_found","404.html",WebServer.FILE_Not_Found);
	}

}
