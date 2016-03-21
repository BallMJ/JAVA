/*This is a program which finds the Factors and Prime Factors of two different numbers
*
*/
import java.text.DecimalFormat;

class factors{	
	public static void factorial(){
		//number we want to find the factors of
		double num = 1244;
		//creating an instance of DecimalFormat to remove the point after the whole number 
		DecimalFormat format = new DecimalFormat("#.#");
		//Iterating over i whilst it is less than the number we want to find the factors of
		// ++i - increment i then return value of i
		for (int i = 0; i<num; ++i){
			//if the remainder of num/i equals 0 then print it out. Else skip to next number
			if (num%i==0){
				System.out.println("factors of: "+format.format(num)+" are: "+i);
			}
		}
	}
	
	public static void primeFactorial(){
		//number we want to find the prime factors of
		double num = 1244;
		//Creating double to iterate over against number
		double i = 1;
		DecimalFormat format = new DecimalFormat("#.#");
		//Printing the number we are finding the prime factors of
		System.out.println("Prime factors of: "+format.format(num)+" are: ");
		
		//While double i less than or equal to number
		while (i <= num){
			//Create variable k which equals 0
			double k = 0;
			//if the remainder of num/i equals 0
			if(num%i == 0){
				//Create a new double variable called l
				double l = 0;
				//While l less than or equal to i
				while (l<=i){
					//if the remainder of i/l equals 0
					if(i%l == 0){
						//return k then increment k
						k++;
					}
					//if the remainder of i/l is not equal to 0 then return i and increment it. THIS ONLY HAPPENS IF - if(i%l == 0) is false
					l++;
				}
				//if l not less than or equal to i, then if k == 2 then print out i. THIS ONLY HAPPENS IF -  while (l<=i) is false
				if(k == 2){
					
					System.out.print(format.format(i)+" ");
				}
			}
			//if the remainder of num/i does not equal 0 then return i and increment it. THIS ONLY HAPPENS IF -  if(num%i == 0) is false
			i++;
		}
	}
	public static void main(String[] args){
		//create instance of classes and run them
		factorial();
		primeFactorial();		
	
	}
}