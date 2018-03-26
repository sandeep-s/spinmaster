import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionArrayPairs {

	public int countPairs(Long[] arrayOfNumbers, Long sum) {
		Set<Long> numbersSet = new HashSet<Long>(Arrays.asList(arrayOfNumbers));
		Set<String> uniqueNumbersSet = new HashSet<String>();	
		for (Long number : numbersSet) {
			if (numbersSet.contains(sum - number)) {
				long[] uniqueNumbersArray = new long[] {(sum - number), number};
				Arrays.sort(uniqueNumbersArray);
				uniqueNumbersSet.add(Arrays.toString(uniqueNumbersArray));				
			}
		}
		return uniqueNumbersSet.size();
	}

	public static void main(String[] args) {
		SolutionArrayPairs solutionArrayPairs = new SolutionArrayPairs();
		Instant start = Instant.now();
		Long[] arrayOfNumbers = { 1l,9l,1l,35l,30l,20l };
		long sum = 36;
		int sum_of_array_pairs = solutionArrayPairs.countPairs(arrayOfNumbers, sum);
		Instant end = Instant.now();
		System.out.println(sum_of_array_pairs);
		System.out.println(Duration.between(start, end));
	}

}
