package rockets;

import java.util.List;
import java.util.function.ToDoubleFunction;


public class RocketsBuilder {
	
	public static void main (String args) {	
		//rocket1.propellantMass =  ComponentBuilder.forEach(propellerRocket1, (Propeller t) -> t.getPeakPower(), 1.3);		
	}
}


class ComponentBuilder{
	

//applies a factor to an attribute's value for each object in a list and add the returned values together
	
	public static <T> double forEach (List <T> list, ToDoubleFunction<T> t, double factor){ 
		
		double total=0; 
		
		for(T l:list) {
			
			total+=factor*(t.applyAsDouble(l));	
		}
		
		return total;
	}

}

