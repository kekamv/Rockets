package control.asist;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import rockets.*;

public class RocketMethod implements Runnable {
	
	volatile double totalPower=0;	
	
	public synchronized double propulsionSystem(Rocket r, double peakPercent) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(r.getPropellers().length, new ThreadFact(r.getCode()));
		
		
		for(Propeller p:r.getPropellers()) {
			
			double targetPower= p.getPeakPower()*peakPercent;
			
			// this row adapt the current power of the propeller to the target power		
			
			executor.execute(new PropellerMethod(p, targetPower)); 
			
		}

		totalPower = r.getRocketCurrentPower();
		
		executor.shutdown();
		
		return totalPower;
	}

	public double getTotalPower(Rocket r) {
		
		return totalPower;
	}
	
	public void start() {
		run();
	}
		
	public void run() {
		
		double peakPercent=0.6;
		
		for(Rocket r:launchSystem) r.rocketDescription();
			
		for(Rocket r:launchSystem)		{
		try {
		lock.lock();

			propulsionSystem(r, peakPercent);

		} catch (InterruptedException e) {
			e.printStackTrace();
	
		}
		lock.unlock();
		
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			 r.counterForLaunch();

	}
	}
	
	private Lock lock = new ReentrantLock();

	
		Propeller r1p1 = new Propeller("LDSFJA32.1", 10);
		Propeller r1p2 = new Propeller("LDSFJA32.2", 30);
		Propeller r1p3 = new Propeller("LDSFJA32.3", 80);
		
		Propeller[] propellerRocket1 = {r1p1, r1p2, r1p3};
		
		Propeller r2p1 = new Propeller("32WESSDS.1", 30);
		Propeller r2p2 = new Propeller("32WESSDS.2", 40);
		Propeller r2p3 = new Propeller("32WESSDS.3", 50);
		Propeller r2p4 = new Propeller("32WESSDS.4", 50);
		Propeller r2p5 = new Propeller("32WESSDS.5", 30);
		Propeller r2p6 = new Propeller("32WESSDS.6", 10);
		
		Propeller[] propellerRocket2 = {r2p1, r2p2, r2p3, r2p4, r2p5, r2p6};
		
		Rocket rocket1 = new Rocket("LDSFJA32", 20, propellerRocket1); 
		
		Rocket rocket2 = new Rocket("32WESSDS", 30, propellerRocket2); 
		
		Rocket[] launchSystem = {rocket1, rocket2};	
}
