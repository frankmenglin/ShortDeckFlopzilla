//This will be the main program
public class Main_Flopzilla {
	public static void main(String[] args) {
		Five_Cards_Hand myhand = new Five_Cards_Hand('Q','h','K','s','Q','c','6','d','K','d');
		System.out.println(myhand.istwopair());
		Starting_Hand mystartinghand = new Starting_Hand('A','h','A','d');
		String[] therestofthedeck = mystartinghand.remainingdeck();
		for (int j=0; j<therestofthedeck.length; j++) {
			System.out.println(therestofthedeck[j]);
		}
	}
}
