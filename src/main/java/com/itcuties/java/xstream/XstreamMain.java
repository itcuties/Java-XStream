package com.itcuties.java.xstream;

import java.io.File;

import com.itcuties.java.xstream.data.Book;
import com.itcuties.java.xstream.data.Library;
import com.itcuties.java.xstream.data.Shop;
import com.thoughtworks.xstream.XStream;

/**
 * This class shows how to use XStream library to parse xml files straight into
 * the java classes. It shows the most simple cases to give a quick kick start
 * into using the library.
 * 
 * It uses annotations to make the code most redable. But this is not the only
 * way. XStream allows to register xml-java mapping manually using methods in
 * XStream class. It allows to create custom converters for types. Converters
 * for basic types are of course available.
 * 
 * For further reading about advanced usage of XStream go to:
 * <b>http://xstream.codehaus.org/</b>
 * 
 * @author itcuties
 */
public class XstreamMain {

	public static void main(String[] args) {
		try {
			XstreamMain.presentLoadingBook();
			System.out.println("==========================================");
			XstreamMain.presentLoadingLibrary();
			System.out.println("==========================================");
			XstreamMain.presentLoadingShop();
		} catch (Exception e) {
			System.err.println("This exception should not happen: "
					+ e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method loads a single book into a Book class.
	 */
	private static void presentLoadingBook() throws Exception {
		// first create the xstream instance
		XStream xStream = new XStream();
		// then process the annotations on our class
		xStream.processAnnotations(Book.class);
		// load the xml and get the result
		Object readObject = xStream.fromXML(new File("xmls/book.xml"));
		// print the result
		System.out.println("Object loaded by xstream: " + readObject);
	}

	/**
	 * This method presents how to load tags that repeat many times into a list.
	 */
	private static void presentLoadingLibrary() throws Exception {
		XStream xStream = new XStream();
		xStream.processAnnotations(Library.class);
		Object readObject = xStream.fromXML(new File("xmls/library.xml"));
		System.out.println("Object loaded by xstream: " + readObject);
	}

	/**
	 * This method presents how to load tag attributes.
	 */
	private static void presentLoadingShop() throws Exception {
		XStream xStream = new XStream();
		xStream.processAnnotations(Shop.class);
		Object readObject = xStream.fromXML(new File("xmls/shop.xml"));
		System.out.println("Object loaded by xstream: " + readObject);
	}

}
