//This will be the main program
public class Main_Flopzilla {
	public static void main(String[] args) {
		//Five_Cards_Hand myhand = new Five_Cards_Hand('9','h','K','h','Q','h','T','h','J','h');
		//System.out.println(myhand.handtype());
		//String[] therestofthedeck = mystartinghand.remainingdeck();
		//for (int j=0; j<therestofthedeck.length; j++) {
		//	System.out.println(therestofthedeck[j]);
		//}
		Starting_Hand mystartinghand = new Starting_Hand('A','h','K','d');
		
		Six_Card_Hand myhand = new Six_Card_Hand('9','h','8','d','Q','h','A','h','7','h','6','s');
		
		System.out.println(myhand.isstraight());

		mystartinghand.enumerateflop();
	}
}
