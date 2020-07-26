//This will be the main program
public class Main_Flopzilla {
	public static void main(String[] args) {
		//Five_Cards_Hand myhand = new Five_Cards_Hand('9','h','K','h','Q','h','T','h','J','h');
		//System.out.println(myhand.handtype());
		//String[] therestofthedeck = mystartinghand.remainingdeck();
		//for (int j=0; j<therestofthedeck.length; j++) {
		//	System.out.println(therestofthedeck[j]);
		//}
		Starting_Hand mystartinghand = new Starting_Hand('J','h','T','h');
		
		//Five_Cards_Hand myhand = new Five_Cards_Hand('9','h','8','d','Q','h','T','s','6','h');
		
		//System.out.println(myhand.is8carddraw());

		mystartinghand.enumerateflop();
	}
}
