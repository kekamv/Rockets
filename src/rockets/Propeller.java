package rockets;

public class Propeller {
	
	public Propeller (String code, double peakPower) {
		
		this.code = code;
		this.peakPower = peakPower;
		currentPower=0;
	}
	
	public double getCurrentPower() {
		return currentPower;
	}

	public double getPeakPower() {
		return peakPower;
	}
	
	public void setCurrentPower(double d) {
		
		currentPower+=d;	
	}
	
	public String getCode() {
		
		return this.code;
	}

	private String code;
	protected double peakPower;
	protected double currentPower;
	

	
}
	
