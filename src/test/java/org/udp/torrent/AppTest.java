package org.udp.torrent;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.udp.torrent.vlaue.BMap;
import org.udp.torrent.util.BEncodeUtil;
import org.udp.torrent.vlaue.BInt;
import org.udp.torrent.vlaue.BList;
import org.udp.torrent.vlaue.BString;

public class AppTest {


	@Test
	public void dictionaryTest() throws IOException {
		String list = "d4:spaml1:a1:bee";
//		String list = "i-3e:i44:i345623e";
		InputStream in = new ByteArrayInputStream(list.getBytes());
		BMap dictionaryValue = new BMap(in);
		System.out.println("DictionaryValue getValue");
		System.out.println(dictionaryValue);
		System.out.println(dictionaryValue.value());
		System.out.println(dictionaryValue.bEncode());
		dictionaryValue.streamKey().forEach(System.out::println);
		dictionaryValue.streamBEncodeKey().forEach(System.out::println);
	}
	
	
	@Test
	public void listTest() throws IOException {
		String list = "li87e5:ahmedli-8e9:jhgfdsaqwee";
//		String list = "i-3e:i44:i345623e";
		InputStream in = new ByteArrayInputStream(list.getBytes());
		BList listValue = new BList(in);
		System.out.println("list getValue");
		System.out.println(list);
		System.out.println(listValue.bEncode());
		System.out.println(listValue.value());
		listValue.streamString().forEach(System.out::println);
	}
	
	@Test
	public void test1() throws IOException {
		InputStream in = new ByteArrayInputStream("spam".getBytes());
		BString stringValue = new BString(4, in);
		System.out.println(stringValue.value());
		
		in = new ByteArrayInputStream("4:abcd".getBytes());
		stringValue = new BString(in);
		System.out.println(stringValue);
		in.reset();
		System.out.println(BEncodeUtil.readString(in));
		
		in = new ByteArrayInputStream("-3e".getBytes());
		BInt intValue = new BInt(in);
		System.out.println(intValue);

		// error 000
		in = new ByteArrayInputStream("i00084e".getBytes());
		intValue = new BInt(in);
		System.out.println(intValue.value());
		in.reset();
		System.out.println(BEncodeUtil.readInt(in));
	}
	
//	@Test
//	public void test2() {
//		InputStream in = new ByteArrayInputStream("i-3e:i44:i345623e".getBytes());
//		IntListValue intListValue = new IntListValue(in);
//		System.out.println(intListValue.value());
//		
//		in.reset();
//		IntegerListValue integerListValue = new IntegerListValue(in);
//		System.out.println(integerListValue.value());
//		System.out.println(integerListValue.toString());
//		integerListValue
//					.value()
//					.stream()
//					.map(BValue::value)
//					.forEach(System.out::println);
//					   [ 87,  admed,[ -8, jhgfdsaqw
//	}
	
	

}
