package com.jpm.whitepages.model;

import java.util.Objects;

public class WhitePagesRequest {

	private final String number;
	private final String name;
	
	public WhitePagesRequest(String number, String name) {
		this.number = number;
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isNameLookup() {
		return name == null;
	}
	
	public boolean isNumberLookup() {
		return number == null;
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
		if (!(obj instanceof WhitePagesRequest))
			return false;
		WhitePagesRequest other = (WhitePagesRequest) obj;
		return Objects.equals(name, other.name) && Objects.equals(number, other.number);
	}
	
	@Override
	public String toString() {
		return "WhitePagesResponse [number=" + number + ", name=" + name + "]";
	}	
	
}
