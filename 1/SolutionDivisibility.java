import java.time.Duration;
import java.time.Instant;

public class SolutionDivisibility {	
	public int count_divisible(int A,int B,int K) {
		/*if(B == 0) {
			return 0;
		} else if (A == 0) {		
			 * Used max value to say that it's undefined since we are using int
			 * If we're using double or float we could have returned POSITIVE_INFINITY constant			 
			return Integer.MAX_VALUE;
		} else if(A <= B) {	*/				
			return Math.round(B / K - (A - 1) / K);
		} /*else {
			//-1 returned for all values when A > B
			return -1;
		}	
	} */

	public static void main(String[] args) {
		SolutionDivisibility solutionDivisibility = new SolutionDivisibility();	
		Instant start = Instant.now();
		int number_of_divisibles = solutionDivisibility.count_divisible(9, 100000, 18);
		Instant end = Instant.now();
		System.out.println(number_of_divisibles);
		System.out.println(Duration.between(start, end));
	}

}
