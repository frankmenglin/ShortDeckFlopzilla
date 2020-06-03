import java.util.HashMap;
import java.util.Arrays;

public class Five_Cards_Hand {
	char card1; char card2; char card3; char card4; char card5;
	char suit1; char suit2; char suit3; char suit4; char suit5;
	
	public Five_Cards_Hand(char c1, char s1, char c2, char s2, char c3, char s3, char c4, char s4, char c5, char s5) {
		card1=c1; card2=c2; card3=c3; card4=c4; card5=c5;
		suit1=s1; suit2=s2; suit3=s3; suit4=s4; suit5=s5;
	}//Constructor
	
	public static int[] addX(int n, int arr[], int x) {
		int i;
		int newarr[] = new int[n+1];
		for (i=0; i<n; i++) {
			newarr[i] = arr[i];
		}
		newarr[n] = x;
		return newarr;
	}//Append an element at the end of array
	
	
	//public char[] suit_array(){
	//	char[] suits = {suit1, suit2, suit3, suit4, suit5};
	//	return suits;
	//}An array that contains suits of a 5 cards hand
	
	//public char[] card_array(){
	//	char[] suits = {card1, card2, card3, card4, card5};
	//	return suits;
	//}An array that contains cards of a 5 cards hand
	
	public int[] pattern(char[] A){
		int[] pattern= {};
		int i;
		
		HashMap<Character, Integer> cardcount = new HashMap<Character, Integer>();
		
		for (i=0; i<A.length; i++) {
			if (cardcount.containsKey(A[i])) {
				cardcount.put(A[i], cardcount.get(A[i])+1);
			} else {
				cardcount.put(A[i], 1);
			}
		}
		
		for (Integer value : cardcount.values()) {
			pattern = addX(pattern.length,pattern,value);
		}
		
		Arrays.sort(pattern);
		return pattern;//Return pattern e.g. {"pig","dog","pig","cat","pig"} pattern will be {1,1,3}
	}
	
	public boolean isflush() {
		char[] suits = {suit1, suit2, suit3, suit4, suit5};
		int[] suitpattern = pattern(suits);
		int[] flushpattern = {5};
		if (Arrays.equals(suitpattern,flushpattern)) {return true;
		}else {return false;}
	}//Check if the 5 cards hand is a flush
	
	
}
