package com.itcuties.java.xstream.data;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * This class shows how xml tag attributes can be loaded.
 * 
 * @author itcuties
 */
@XStreamAlias("shop")
public class Shop {
	@XStreamAsAttribute//just add this annotation to inform XStream that it will deal with attribute
	@XStreamAlias("shop")
	private String owner;
	
	@XStreamAlias("open-hour")
	@XStreamAsAttribute//it can be also placed after alias definition (just put it before the field)
	private int openHour;
	
	@XStreamAsAttribute
	@XStreamAlias("close-hour")
	private int closeHour;
	
	@XStreamImplicit(itemFieldName="product")
	private List<String> products;

	@Override
	public String toString() {
		return "Shop [owner=" + owner + ", openHour=" + openHour
				+ ", closeHour=" + closeHour + ", products=" + products + "]";
	}
}
