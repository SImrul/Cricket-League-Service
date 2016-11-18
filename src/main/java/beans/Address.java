package beans;

public class Address {
	
	public enum COUNTRY { 	AFGANISTAN, AUSTRALIA, BANGLADESH, 
							ENDGLAND, INDIA, IRELAND, 
							NEW_ZEALAND, PAKISTAN, SOUTH_AFRICA, 
							SRILANKA, WEST_INDIES
						}
	private String street;
	private String street2;
	private String city;
	private COUNTRY country;
	private String area_code; // zip_code, postal_code etc.
	
}
