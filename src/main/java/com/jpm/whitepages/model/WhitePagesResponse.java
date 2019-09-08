package com.jpm.whitepages.model;

import java.util.Objects;

public class WhitePagesResponse {

	private final String number;
	private final String name;
	
	public WhitePagesResponse(String number, String name) {
		this.number = number;
		this.name = name;
	}
	
	
	public String getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, number);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof WhitePagesResponse))
			return false;
		WhitePagesResponse other = (WhitePagesResponse) obj;
		return Objects.equals(name, other.name) && Objects.equals(number, other.number);
	}
	
	@Override
	public String toString() {
		return "WhitePagesResponse [number=" + number + ", name=" + name + "]";
	}	
	
}
