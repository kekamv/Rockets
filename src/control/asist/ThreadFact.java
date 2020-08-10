package control.asist;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFact implements ThreadFactory { 
	//will aim to have as many threads as propellers in the system
	
	private String name; //this name will make a reference to the rocket
	
	// it will reach the number of propellers in a rocket
	private AtomicInteger nPropInRock= new AtomicInteger(1); 
	

	public ThreadFact(String name) {
		
		this.name = name;
	}
	@Override
	public Thread newThread(Runnable r) {
		
		return new Thread(r, name+" "+nPropInRock.getAndIncrement());
	}
	
}
