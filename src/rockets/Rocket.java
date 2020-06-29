package rockets;

public class Rocket {
	
	public Rocket (String code, Propeller[] propellers) {
		
		this.code = code;
		this.propeller = propellers;
	}
	
	private String code;
	protected Propeller [] propeller;
	
	public String rocketDesciption() {
		
		return "The rocket " +code+" is fitted with "+ propeller.length+ " propellers";
	}

}
