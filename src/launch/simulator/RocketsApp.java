package launch.simulator;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import control.asist.RocketMethod;

public class RocketsApp {

	public static void main(String[] args) {

				
	ExecutorService rockets=Executors.newCachedThreadPool();
	
	rockets.execute(new RocketMethod());
	rockets.shutdown();

	}

}
