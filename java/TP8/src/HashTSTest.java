import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HashTSTest {
	public HashTS<String, String> dico;
	@Before
	public void init() throws ExceptionFullHashTable, ExceptionCléDéjàExistante {
		dico = new HashTS<String, String>();
		dico.add("BIOS", "Basic Input-Output System");
		dico.add("BYTE", "A byte is a storage unit for data");
		dico.add("CPU", "Central Processing Unit");
		dico.add("IP", "Internet Protocol");
		dico.add("MAC", "Apple Macintosh");
		dico.add("OS", "Operating System");
		dico.add("PC", "Personal Computer");
		dico.add("PDF", "Portable Document Format");
		dico.add("RAM", "Random Access Memory");
		dico.add("ROM", "Read-Only Memory");
		dico.add("RTFM", "Read The F****** Manual");
		dico.add("USB", "Universal Serial Bus");
		dico.add("VGA", "Video Graphics Array");
		dico.add("WYSIWYG", "What You See Is What You Get");
	}
	
	@Test
	public void testNextEmptyCell() throws ExceptionFullHashTable, ExceptionCléDéjàExistante {
		assertEquals(dico.nextEmptyCell("foo"), 6);
		dico.add("GPU", "Graphics Processing Unit");
		assertEquals(dico.nextEmptyCell("foo"), -1);
	}

	
	@Test
	public void testIndexByKey() throws ExceptionFullHashTable, ExceptionCléDéjàExistante {
		assertEquals(dico.indexByKey("foo"), -1);
		assertEquals(dico.indexByKey("RAM"), 0);
		dico.add("GPU", "Graphics Processing Unit");
		assertEquals(dico.indexByKey("GPU"), 6);
	}
	
	@Test
	public void testAdd() throws ExceptionFullHashTable, ExceptionCléDéjàExistante {
		dico.add("GPU", "Graphics Processing Unit");
	}

	@Test (expected = ExceptionFullHashTable.class)
	public void testAddFail() throws ExceptionFullHashTable, ExceptionCléDéjàExistante {
		dico.add("GPU", "Graphics Processing Unit");
		dico.add("GIF", "Graphics Interchange Format");
	}
	
	@Test (expected = ExceptionCléDéjàExistante.class)
	public void testAddFail2() throws ExceptionFullHashTable, ExceptionCléDéjàExistante {
		dico.add("WYSIWYG", "What you see is what you google");
	}

	@Test
	public void testDel() {
		dico.del("PC");
		assertEquals(dico.exists("PC"), false);
		dico.del("ROM");
		assertEquals(dico.exists("ROM"), false);
	}

	@Test
	public void testExists() {
		assertEquals(dico.exists("RTFM"), true);
	}

	@Test
	public void testLookup() throws ExceptionCléIntrouvable {
		dico.lookup("ROM");
	}

	@Test (expected = ExceptionCléIntrouvable.class)
	public void testLookupFail() throws ExceptionCléIntrouvable {
		dico.lookup("foo");
	}

}
