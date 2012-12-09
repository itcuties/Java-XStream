package com.itcuties.java.xstream.data;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * The purpose of this class is to present how to load several tags of the same type into a list.
 * 
 * @author itcuties
 */
@XStreamAlias("library")
public class Library {
	@XStreamAlias("name")
	private String libraryName;
	
	@XStreamImplicit(itemFieldName="book")//use this annotation and tell it what is the tag's name to add to the list
	private List<Book> books;

	@Override
	public String toString() {
		return "Library [libraryName=" + libraryName + ", books=" + books + "]";
	}
}
