package JUnitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import webserver.Config;

public class Config_TEST {

	@Test
	public void PORT_Test() {
		assertNotEquals("Port",10008,Config.PORT);
	}
	@Test
	public void PORT_Not_Null()
	{
		assertNotNull(Config.PORT);
	}
	@Test
	public void PORT_Not_Negative()
	{
		assertNotEquals(-5,Config.PORT);
	}

		Config c1=new Config("C:\\Users\\Dragos\\Desktop\\New folder\\index.html","C:\\Users\\Dragos\\Desktop\\New folder\\notexist.html",9999);
	@Test(expected = IllegalArgumentException.class)
	public void Test_Valid_PORT()
	{
		int p=c1.getPORT();
	}
	@Test
	public void Test_IndexPath()
	{
		String t1=c1.getDefaultIndex();
		assertEquals("C:\\Users\\Dragos\\Desktop\\New folder\\index.html",t1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void Test_Index()
	{
		Config c2=new Config("test", null, 0);
		String t2 = c2.getDefaultIndex();
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void Test_Index2()
	{
		Config c3=new Config("C:\\\\Users\\\\Dragos\\\\Desktop\\\\New folder\\\\index.html", null, 0);
		String t3 = c3.getDefaultIndex();
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void Test_Index3()
	{
		Config c4=new Config("C:\\Users\\Dragos\\Desktop\\New folder\\in#dex.html","C:\\Users\\Dragos\\Desktop\\New folder" , 0);
		String t4 = c4.getDefaultIndex();
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void Test_Not_Found()
	{
		Config c5=new Config("C:\\Users\\Dragos\\Desktop\\New folder\\","C:\\Users\\Dragos\\Desktop\\New folder" , 0);
		String t5 = c5.getDefaultIndex();
	}
}
