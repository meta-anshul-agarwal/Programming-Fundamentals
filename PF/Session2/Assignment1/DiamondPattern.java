package PF.Session2.Assignment1;

import PF.Session2.UserException.IllegalExpressionException;
/**
 * 
 * @author Anshul Agarwal
 * This class is used to print pattern
 * if n=3,
 *   1
 *  121
 * 12321
 *  121
 *   1  
 *  
 * Custom Exception is called if row number is greater than 2*n  
 */
public class DiamondPattern {

	/**
	 * 
	 * @param n
	 * @return array of string pattern
	 * @throws IllegalExpressionException
	 */
	public String[] printPattern(int n) throws IllegalExpressionException{
		if(n>=0){
			String result[] = n==0 ? new String[0] : new String[(n-1)*2 + 1];
			for(int i=0;i<2*n-1;i++){
				System.out.println(spaces(i,n)+numbers(i, n)); // print pattern
				result[i] = spaces(i,n) + numbers(i, n); // save pattern as string
			}
			return result;
			} else {
			throw new IllegalExpressionException("Negative value not allowed");
		}
	}
		/**
		 * 
		 * @param row
		 * @param n
		 * @return spaces as string according to pattern
		 * @throws IllegalExpressionException
		 */
		public String spaces(int row, int n) throws IllegalExpressionException {
			
			int i;
			String space = "";
			// row used be less than 2*n otherwise it will throw exception
			if(row < 2*n) {
				row = row < n ? n-row-1 : row-n+1; // condition which changes row size according to space requirement
				if(row <= n) {
					for(i=0 ;i<row;i++) {
						space = space.concat(" ");
					}
				}	
			} else {
				
				throw new IllegalExpressionException("Illegal Expression");	// exception thrown if row is greater than n
			}
			return space;
		}
		
		/**
		  * 
		  * @param row
		  * @param n
		  * @return number as string according to question
		  * @throws IllegalExpressionException
		  */
		public String numbers(int row,int n) throws IllegalExpressionException {
		
		String number = "";
		int j; 
		
		if(row < 2*n) {
			row = row < n ? row : 2*n - row - 2 ; // condition which changes row size according to number requirement
			if(row < n) {   // first half of the number eg. if number is 121 then 12 is generated by this
					for(j = 0; j <= row ; j++) {
						number = number.concat(String.valueOf(j+1));
				}
			}
			if(row < n) { // second half of the number eg. if number is 121 then last 1 is generated by this
					for(j = 0; j < row ; j++) {
						number = number.concat(String.valueOf(row-j));
				}
			}
		} else {
			
			throw new IllegalExpressionException("Illegal Expression"); // exception thrown if row is greater than n
		} 
		return number;	
	}
}
