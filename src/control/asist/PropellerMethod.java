package control.asist;

import java.util.concurrent.TimeUnit;

import rockets.Propeller;

public class PropellerMethod implements Runnable{
	
	private Propeller propeller;
	
	private final double targetPower;
	
	public PropellerMethod(Propeller p, double targetPower) { //constructor for thread
		
		propeller=p;
		this.targetPower = targetPower;
	}

	public double adaptCurrentPowerPropeller(Propeller p, double targetPower) { // change current power (+1) or (-1) until reaching target power
		
		if (p.getCurrentPower()< targetPower) { //increase current power in 1 
		
			while(p.getCurrentPower()<targetPower)  //until the target power is reached
				try {
					p.setCurrentPower(1);
					TimeUnit.MILLISECONDS.sleep(200);
					
					if(targetPower-p.getCurrentPower()==10) { // 5 power units/second (sleep 200 ms), therefore 10 to 2 seconds to target
						
						System.out.println("Response from "+Thread.currentThread().getName()+ " 2 seconds to target power");
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		if (p.getCurrentPower()> targetPower) { //decrease current power in 1 
			
			while(p.getCurrentPower()>targetPower)  //until the target power is reached
				try {
					p.setCurrentPower(-1);
					TimeUnit.MILLISECONDS.sleep(200);
					
					if(-targetPower+p.getCurrentPower()==10) { // 5 power units/second (sleep 200 ms), therefore 10 to 2 seconds to target
						
						System.out.println("Response from "+Thread.currentThread().getName()+ " 2 seconds to target power");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		if (p.getCurrentPower()==targetPower) { //produce msg target power reached
			
			System.out.println("Response from "+Thread.currentThread().getName()+" : target power "+targetPower+ " for Propeller " +p.getCode()+ " reached");
		
			
		
		}
		return p.getCurrentPower();
			
	}
	
	public void run() {
		
		adaptCurrentPowerPropeller(propeller, targetPower);
	}
}
