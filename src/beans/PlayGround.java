package beans;

public class PlayGround {
	
	private String name;
	private Address address;
	private int capacity;
	
	public PlayGround(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "{" 
				+ "name: " + this.name
				+ " , " + "address: " + (this.address != null ? this.address.toString() : "null")
				+ " , " + "capacity: " + this.capacity
				+ "}";
	}
}
