package rockets;

public class Rocket {
	
	public Rocket (String code, Propeller[] propellers) {
		
		this.code = code;
		this.propellers = propellers;
	}
	
	private String code;
	private Propeller [] propellers;
	
	public void rocketDesciption() {
		
		System.out.print("The rocket " +code+" is fitted with "+ propellers.length+ " propellers"+
		" with respective peak power: ");
		
		for(int i=0; i<(propellers.length -1);i++) {
			
			System.out.print(propellers[i].peakPower + ", ");
		}
		System.out.print(propellers[(propellers.length)-1].peakPower);
		System.out.println();
	}

}
