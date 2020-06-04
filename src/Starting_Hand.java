
public class Starting_Hand {
	char card1; char card2;
	char suit1; char suit2;
	
	public Starting_Hand(char c1, char s1, char c2, char s2) {
		card1=c1; card2=c2;
		suit1=s1; suit2=s2;
	}//Constructor
	
	public String[] addX(int n, String arr[], String x) {
		int i;
		String newarr[] = new String[n+1];
		for (i=0; i<n; i++) {
			newarr[i] = arr[i];
		}
		newarr[n] = x;
		return newarr;
	}//Append an element at the end of array
	
	String[] shortdeck=
	{"6c","7c","8c","9c","Tc","Jc","Qc","Kc","Ac",
	 "6d","7d","8d","9d","Td","Jd","Qd","Kd","Ad",
	 "6h","7h","8h","9h","Th","Jh","Qh","Kh","Ah",
	 "6s","7s","8s","9s","Ts","Js","Qs","Ks","As"};//The deck that is used to play short deck poker
	
	String[] remainingdeck() {
		int i;
		String[] out= {};
		for (i=0; i<shortdeck.length; i++) {
			String thiscard = shortdeck[i];
			char thiscardrank = thiscard.charAt(0);
			char thiscardsuit = thiscard.charAt(1);
			if ((thiscardrank==card1 && thiscardsuit==suit1)||(thiscardrank==card2 && thiscardsuit==suit2)) {continue;}
			else {out=addX(out.length, out, thiscard);}
		}
		return out;
	}//rest of the deck
	
	
}
