package rockets;

import java.util.List;
import java.util.function.ToDoubleFunction;

public class Rocket {
	
	public Rocket (String code, double payloadMass, Propeller[] propellers) {
		
		this.code = code;
		this.propellers = propellers;
		this.payloadMass = payloadMass;
	}
	
	private String code;
	protected Propeller [] propellers;
	
	double structuralMass = 50;
	//double propellantMass;
	double payloadMass;
	double emptyMass= structuralMass + payloadMass;
	//double fullMass = emptyMass + propellantMass;
	volatile double rocketCurrentPower=0;
	volatile double rocketPeakPower =0;

	/*public double getProprellantMass() {
		return propellantMass;
	}
	*/

	
	public void rocketDescription() {
		
		System.out.print("The rocket " +code+" is fitted with "+ propellers.length+ " propellers"+
		" with respective peak power: ");
		
		for(int i=0; i<(propellers.length -1);i++) {
			
			System.out.print(propellers[i].getPeakPower() + ", ");
		}
		System.out.print(propellers[(propellers.length)-1].getPeakPower());
		System.out.println();
		//System.out.println("Its propellant mass ist: "+propellantMass+" units.");
	}


	public String getCode() {
		return code;
	}


	public Propeller[] getPropellers() {
		return propellers;
	}


	public double getEmptyMass() {
		return emptyMass;
	}

	public double getRocketCurrentPower() {
		
		rocketCurrentPower = 0;
		
		for (Propeller p:propellers) {
			
			rocketCurrentPower+=p.getCurrentPower();
		}
		
		return rocketCurrentPower;
	}
	
	public double getRocketPeakPower() {
		
		rocketPeakPower = 0;
		
		for (Propeller p:propellers) {
			
			rocketPeakPower+=p.getPeakPower();
		}
		
		return rocketPeakPower;
	}
	
	public void counterForLaunch() {
		
		System.out.print("Rocket's "+ code+ " engine ignition in ");
	
		for(int i=10; i>0; i--) {
		
			System.out.print(i+ " ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} System.out.println("Launching");
			System.out.println();
	}
}
