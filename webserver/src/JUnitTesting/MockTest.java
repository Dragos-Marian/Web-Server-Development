package JUnitTesting;

import static org.mockito.Mockito.*;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
public class MockTest {

	@Test
	public void setup() {
	LinkedList<String> mockedList = mock(LinkedList.class);
	mockedList.add("index.html");
	mockedList.add("404.html");
	mockedList.add("501.html");
	when(mockedList.get(0).thenReturn("index.html"));
	when(mockedList.get(1).thenReturn("404.html"));
	when(mockedList.get(2).thenReturn("501.html"));
	}

	private LinkedList<String> mock(Class<LinkedList> class1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
