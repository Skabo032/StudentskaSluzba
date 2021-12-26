package model;

public class Address {
	private String street;
	private int number;
	private String city;
	private String country;
	
	
	public Address() {
		super();
	}
	public Address(String street, int number, String city, String country) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) throws Exception {
		if (number >= 1)
			this.number = number;
		else
			throw new Exception("Invalid value for address number, cannot be less than 1!");
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return street + "," + number + "," + city + "," + country;
	}
	
}
