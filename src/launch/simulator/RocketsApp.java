package launch.simulator;


import control.asist.PropellerMethod;
import control.asist.RocketMethod;
import rockets.Propeller;
import rockets.Rocket;
import rockets.RocketsBuilder;

public class RocketsApp {

	public static void main(String[] args) {

			

Thread t= new Thread(new RocketMethod());
t.start();
		

	}

}
