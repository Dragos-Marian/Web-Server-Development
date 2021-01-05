package webserver;

import java.io.File;

public class Config {
	public  String ROOT;
	public static  int PORT;
	public String DefaultIndex;
	public String NotFound;
	public String NotExist;
	File f1;
	File f2;
	File f3;
	public Config(String root,int PORT) 
	{
		
		this.PORT=PORT;
		this.ROOT=root;
		
		DefaultIndex=ROOT+"\\index.html";
		NotFound=ROOT+"\\404.html";
		NotExist=ROOT+"\\501.html";
		f1=new File(DefaultIndex);
		f2=new File(NotFound);
		f3=new File(NotExist);
		
	}
	public String getDefaultIndex()
	{
		if (!DefaultIndex.contains("\\index.html")&& f1.isFile())
			throw new IllegalArgumentException();
		return DefaultIndex;
	}
	public String getNotFound()
	{
		if (!NotFound.contains("\\404.html")&& f2.isFile())
			throw new IllegalArgumentException();
		return NotFound;
	}
	public String getNotExist()
	{
		if (!NotExist.contains("\\501.html")&& f3.isFile())
			throw new IllegalArgumentException();
		return NotExist;
	}
	public int getPORT()
	{
		
		return PORT;
	}
}
