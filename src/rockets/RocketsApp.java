package rockets;

public class RocketsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Propeller r1p1 = new Propeller("1.1");
		Propeller r1p2 = new Propeller("1.2");
		Propeller r1p3 = new Propeller("1.3");
		
		Propeller[] propellerRocket1 = {r1p1, r1p2, r1p3};
		
		Propeller r2p1 = new Propeller("2.1");
		Propeller r2p2 = new Propeller("2.2");
		Propeller r2p3 = new Propeller("2.3");
		Propeller r2p4 = new Propeller("2.4");
		Propeller r2p5 = new Propeller("2.5");
		Propeller r2p6 = new Propeller("2.6");
		
		Propeller[] propellerRocket2 = {r2p1, r2p2, r2p3, r2p4, r2p5, r2p6};
		
		Rocket rocket1 = new Rocket("LDSFJA32", propellerRocket1); 
		
		Rocket rocket2 = new Rocket("32WESSDS", propellerRocket2); 
		
		System.out.println(rocket1.rocketDesciption());
		System.out.println(rocket2.rocketDesciption());
	}

}
