import java.util.HashMap;
import java.util.Arrays;

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
	
	public String[] shortdeck=
	{"6c","7c","8c","9c","Tc","Jc","Qc","Kc","Ac",
	 "6d","7d","8d","9d","Td","Jd","Qd","Kd","Ad",
	 "6h","7h","8h","9h","Th","Jh","Qh","Kh","Ah",
	 "6s","7s","8s","9s","Ts","Js","Qs","Ks","As"};//The deck that is used to play short deck poker
	
	public String[] remainingdeck() {
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
	
	public void enumerateflop() {
		String[] theremainingdeck=remainingdeck();
		HashMap<String, Integer> handtypecount = new HashMap<String, Integer>();
		handtypecount.put("Straight Flush",0);
		handtypecount.put("Quad",0);
		handtypecount.put("Flush",0);
		handtypecount.put("Full House",0);
		handtypecount.put("Straight",0);
		handtypecount.put("Trips",0);
		handtypecount.put("Two Pair",0);
		handtypecount.put("Pair",0);
		handtypecount.put("High Cards",0);
		
		int j1; int j2; int j3;
		for (j1=0; j1<theremainingdeck.length; j1++) {
			for (j2=j1+1; j2<theremainingdeck.length; j2++) {
				for (j3=j2+1; j3<theremainingdeck.length; j3++) {
					String flopcard1 = theremainingdeck[j1];
					String flopcard2 = theremainingdeck[j2];
					String flopcard3 = theremainingdeck[j3];
					char f1card = flopcard1.charAt(0);
					char f1suit = flopcard1.charAt(1);
					char f2card = flopcard2.charAt(0);
					char f2suit = flopcard2.charAt(1);
					char f3card = flopcard3.charAt(0);
					char f3suit = flopcard3.charAt(1);
					Five_Cards_Hand thishand = new Five_Cards_Hand(card1,suit1,card2,suit2,f1card,f1suit,f2card,f2suit,f3card,f3suit);
					String thishandtype = thishand.handtype();
					handtypecount.put(thishandtype, handtypecount.get(thishandtype)+1);
				}
			}
		}
		
		for (String thistype : handtypecount.keySet()) {
			System.out.println(thistype);
			System.out.println(handtypecount.get(thistype));
		}
	}


}
