//This will be the main program
public class Main_Flopzilla {
	public static void main(String[] args) {
		Five_Cards_Hand myhand = new Five_Cards_Hand('Q','h','K','s','Q','c','6','d','K','d');
		System.out.println(myhand.istwopair());
	}
}
