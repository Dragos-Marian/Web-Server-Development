package webserver;

public class Config {
	public static String DefaultIndex;
	public static String NotFound;
	public static int PORT;
	public static String ROOT = "C:\\Users\\Dragos\\Desktop\\New folder";
	public Config(String index,String notfound,int PORT) 
	{
		this.DefaultIndex=index;
		this.NotFound=notfound;
		this.PORT=PORT;
		if (!DefaultIndex.contains(ROOT))
		{
			throw new IllegalArgumentException();
		}
		if (!NotFound.contains(ROOT))
		{
			throw new IllegalArgumentException();
		}
		
	}
	public String getDefaultIndex()
	{
		if (!DefaultIndex.contains("index.html"))
			throw new IllegalArgumentException();
		return DefaultIndex;
	}
	public String getNotFound()
	{
		return NotFound;
	}
	public int getPORT()
	{
		if(PORT!=10008)
		{
			throw new IllegalArgumentException();
		}
		return PORT;
	}
}
