import java.lang.Math;

	
class gravity{
	public static void sRadius(){
		/*Using the Schwarzchild radius to determine if an object
		*is a blackhole
		*mc^2/2 < GMm/r
		*r = Schwarzschild radius. G = gravitational constant
		*m = relative mass of the light photons
		*M = mass of object. c = speed of light in a vacuum
		*/
		
		//Mass of light photons
		//double lightMass = 0.000000000000000001;
		double lightMass = Math.pow(1*10, -18);
		System.out.println("lightMass = "+lightMass);
		
				
		//Variable of the speed of light
		double lightSpeed = Math.pow(299792458, 2);
	
		System.out.println("lightSpeed = "+lightSpeed);
		//Determining  the sum of the KE (Kinetic Energy)
		double KE = lightMass*lightSpeed/2;
		
		System.out.println("KE =  "+KE);
		
		//Determining the universal gravity constant
		//ISSUES WITH GRAVITATIONAL CONSTANT!
		double G = Math.pow(6.671*10, -11);
		//double G = 0.0000000006671;
		
		System.out.println("G = "+G);

		
		//Object with 10^9 Solar masses (10^9 times heavier than the sun)
		//mass of sun below - - -
		//double objectMass = 1.989*Math.pow(10, 33);
		//mass of vy canis majoris below - - - 
		double objectMass = 5.967*Math.pow(10, 31);
		//mass of galatic core which equals blackhole catagory - - -
		//double objectMass = 1.989*Math.pow(10, 30)*Math.pow(10, 9);
		System.out.println("objectMass = "+objectMass);
		
		
		
		/*Determining the Schwarzchild Radius of object 
		*it is proportional to the objects mass.
		*I.e. mass of the Sun = 1.989*10^30kg which equals a Schwarzschild radius of 1.9miles
		*/
		double srad = 2;
		
		//Determining the sum of the PE (Negative Potential Energy)
		double PE = G*objectMass*lightMass/srad;
		
		System.out.println("PE = "+PE);
		
		if(KE<PE){
			//Blackhole density if infinite but the mass is finite which develops a connundrum relating to escape velocity
			//Since even a blackhole at this mass has an escape velocity...
			System.out.println("Maximum escape velocity has been reached. Object is a blackhole and has a mass of: "+objectMass);			
		}else{
			double escape = KE+PE;
			System.out.println("Object is not a blackhole and has a mass of: "+objectMass);
			System.out.println("Calculated minimum escape velocity is: "+escape);
		}
		
		
	}
	public static void gravitation(){
		/*Uisng Newtons law of Universal Gravitation we will 
		*calculate the gravity acting between 2 objects
		*Units being used at Meters and M/s
		*/
		//Determining the universal gravity constant
		double inst = 6.671f*10;
		double G = Math.pow(inst, -11);
		
		//Creating 2 objects and selecting their masses
		int obj1Mass = 1;
		int obj2Mass = 100000000;
		
		//Distance between the centers of each object
		int r = 1;
		
		//Force of attraction between the 2 objects
		double F = G*((obj1Mass*obj2Mass)/Math.pow(r, 2));
		
		System.out.println(F);
	}
	public static void main(String[] args){
		//gravitation();
		sRadius();
	}
}