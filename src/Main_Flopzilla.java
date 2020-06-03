//This will be the main program
public class Main_Flopzilla {
	public static void main(String[] args) {
		Five_Cards_Hand myhand = new Five_Cards_Hand('6','s','7','h','9','h','T','h','K','h');
		System.out.println(myhand.isflush());
	}
}
