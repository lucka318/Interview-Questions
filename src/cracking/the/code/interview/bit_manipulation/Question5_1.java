package cracking.the.code.interview.bit_manipulation;

public class Question5_1 {
	
	public static void main(String[] args) {
		
		int n = 5;
		int m = 6;
		
		int i = 2;
		int j = 6;
		
		// first create a mask to clear bits between i and j
		int maskOnes = ~0;
		int left = maskOnes << (j + 1);
		int right = ((1 << i) - 1);
		int mask = left | right;
		
		//clear bits between i and j
		int n_cleared = n & mask;
		int m_shifted = m << i;
		
	    int n_inserted = n_cleared | m_shifted;
		
	}

}
