import java.util.HashMap;
import java.util.Arrays;

public class Five_Cards_Hand {
	char card1; char card2; char card3; char card4; char card5;
	char suit1; char suit2; char suit3; char suit4; char suit5;
	
	public Five_Cards_Hand(char c1, char s1, char c2, char s2, char c3, char s3, char c4, char s4, char c5, char s5) {
		card1=c1; card2=c2; card3=c3; card4=c4; card5=c5;
		suit1=s1; suit2=s2; suit3=s3; suit4=s4; suit5=s5;
	}//Constructor
	
	public int[] addX(int n, int arr[], int x) {
		int i;
		int newarr[] = new int[n+1];
		for (i=0; i<n; i++) {
			newarr[i] = arr[i];
		}
		newarr[n] = x;
		return newarr;
	}//Append an integer element at the end of array
	
	public boolean isin(int n, char arr[], char x) {
		int i;
		for (i=0; i<n; i++) {
			if (arr[i]==x) {return true;}
		}
		return false;
	}
	
	public char[] remove(int n, char arr[], char x) {
		if (isin(arr.length, arr,x)==false) {return arr;}
		boolean z = false;
		int i;
		int j=0;
		char newarr[] = new char[n-1];
		for (i=0; i<n; i++) {
			if (arr[i]==x & z==false) {z=true; continue;}
			else {newarr[j]=arr[i]; j+=1;}
		}
		return newarr;
	}//Remove a specific char element in the array
	
	public int cardconverter(char x) {
		if (x=='6') {return 6;}else if (x=='7') {return 7;}else if (x=='8') {return 8;}else if (x=='9') {
			return 9;}else if (x=='T') {return 10;}else if (x=='J') {return 11;}else if (x=='Q') {
			return 12;}else if (x=='K') {return 13;} else if (x=='A') {return 14;}else {return -100;}
	}//Convert card in char to number e.g. '6'->6, 'T'->10, 'Q'->12, 'A'->14
	
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
		return Arrays.equals(suitpattern,flushpattern);
	}//Check if the given 5 cards hand is a flush (include straight flush)
		
	public boolean isstraight() {
		char[] cards = {card1, card2, card3, card4, card5};
		int[] cardsrank = {};
		int i;
		for (i=0; i<cards.length; i++) {cardsrank = addX(cardsrank.length, cardsrank, cardconverter(cards[i]));}
		Arrays.sort(cardsrank);
		int[] wheel = {6,7,8,9,14};
		boolean out=true;
		for (i=0;i<4;i++) {out = out && (cardsrank[i]+1==cardsrank[i+1]);}
		if (Arrays.equals(cardsrank, wheel)) {out = true;}
		return out;
	}//Check if the given 5 cards hand is a straight (include straight flush)
	
	public boolean isstraightflush() {
		return isflush() && isstraight();
	}//Check if the given 5 cards hand is a straight flush
	public boolean isjustflush() {
		return isflush() && !isstraight();
	}//Check if the given 5 cards hand is a flush (not straight flush)
	public boolean isjuststraight() {
		return !isflush() && isstraight();
	}//Check if the given 5 cards hand is a straght (not straight flush)
	public boolean isquad() {
		char[] cards = {card1, card2, card3, card4, card5};
		int[] cardpattern = pattern(cards);
		int[] targetpattern = {1,4};
		return (Arrays.equals(cardpattern,targetpattern));
	}
	public boolean isfullhouse() {
		char[] cards = {card1, card2, card3, card4, card5};
		int[] cardpattern = pattern(cards);
		int[] targetpattern = {2,3};
		return (Arrays.equals(cardpattern,targetpattern));
	}
	public boolean istrips() {
		char[] cards = {card1, card2, card3, card4, card5};
		int[] cardpattern = pattern(cards);
		int[] targetpattern = {1,1,3};
		return (Arrays.equals(cardpattern,targetpattern));
	}
	public boolean istwopair() {
		char[] cards = {card1, card2, card3, card4, card5};
		int[] cardpattern = pattern(cards);
		int[] targetpattern = {1,2,2};
		return (Arrays.equals(cardpattern,targetpattern));
	}
	public boolean isonepair() {
		char[] cards = {card1, card2, card3, card4, card5};
		int[] cardpattern = pattern(cards);
		int[] targetpattern = {1,1,1,2};
		return (Arrays.equals(cardpattern,targetpattern));
	}
	public boolean ishighcard() {
		char[] cards = {card1, card2, card3, card4, card5};
		int[] cardpattern = pattern(cards);
		int[] targetpattern = {1,1,1,1,1};
		return (Arrays.equals(cardpattern,targetpattern));
	}//A bunch of boolean functions on poker hand type
	
	public String handtype() {
		if (isstraightflush()) {return "Straight Flush";}
		else if (isquad()) {return "Quad";}
		else if (isjustflush()) {return "Flush";}
		else if (isfullhouse()) {return "Full House";}
		else if (isjuststraight()) {return "Straight";}
		else if (istrips()) {return "Trips";}
		else if (istwopair()) {return "Two Pair";}
		else if (isonepair()) {return "Pair";}
		else {return "High Cards";}
	}
	
	//Drawing hand type start below
	
	public boolean isflushdraw() {
		char[] suits = {suit1, suit2, suit3, suit4, suit5};
		int[] suitpattern = pattern(suits);
		int[] flushpattern = {1,4};
		return Arrays.equals(suitpattern,flushpattern);
	}//Check if the given 5 cards hand contains a 4 card flush (i.e. flush draw)

	
	public boolean isgutshotdraw() {
		char[] cards = {card1, card2, card3, card4, card5};
		char[] remainingrank = new char[]{'6','7','8','9','T','J','Q','K','A'};
		int i;
		for (i=0; i<cards.length; i++) {remainingrank = remove(remainingrank.length, remainingrank, cards[i]);}
		//The rank does not appear in hand and board so far
		int count = 0;
		Six_Card_Hand newpossiblehand;
		for (i=0; i<remainingrank.length; i++) {
			newpossiblehand = new Six_Card_Hand(card1, suit1, card2, suit2, card3, suit3, card4, suit4, card5, suit5, remainingrank[i], 's');
			if (newpossiblehand.isstraight()==true) {count+=1;}
		}
		if(count==1 && isstraight()==false) {return true;}
		else {return false;}
	}

	public boolean is8carddraw() {
		char[] cards = {card1, card2, card3, card4, card5};
		char[] remainingrank = new char[]{'6','7','8','9','T','J','Q','K','A'};
		int i;
		for (i=0; i<cards.length; i++) {remainingrank = remove(remainingrank.length, remainingrank, cards[i]);}
		//The rank does not appear in hand and board so far
		int count = 0;
		Six_Card_Hand newpossiblehand;
		for (i=0; i<remainingrank.length; i++) {
			newpossiblehand = new Six_Card_Hand(card1, suit1, card2, suit2, card3, suit3, card4, suit4, card5, suit5, remainingrank[i], 's');
			if (newpossiblehand.isstraight()==true) {count+=1;}
		}
		if(count==2 && isstraight()==false) {return true;}
		else {return false;}
	}
	
	//Combo Type below
	
	public boolean isstraight_flushdraw() {return handtype()=="Straight" && isflushdraw();}
	public boolean ispair_gutshot() {return handtype()=="Pair" && isgutshotdraw();}
	public boolean ispair_8card() {return handtype()=="Pair" && is8carddraw();}
	public boolean ispair_flushdraw() {return handtype()=="Pair" && isflushdraw();}
	public boolean isgutshot_flushdraw() {return isgutshotdraw() && isflushdraw();}
	public boolean is8card_flushdraw() {return is8carddraw() && isflushdraw();}
	
}
