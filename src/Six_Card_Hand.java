import java.util.HashMap; //Only create this to define straight draw //Hand strength will determined by best 5 cards hand

public class Six_Card_Hand {
	char card1; char card2; char card3; char card4; char card5; char card6;
	char suit1; char suit2; char suit3; char suit4; char suit5; char suit6;
	
	public Six_Card_Hand(char c1, char s1, char c2, char s2, char c3, char s3, char c4, char s4, char c5, char s5, char c6, char s6) {
		card1=c1; card2=c2; card3=c3; card4=c4; card5=c5; card6=c6;
		suit1=s1; suit2=s2; suit3=s3; suit4=s4; suit5=s5; suit6=s6;
	}//Constructor
		
	public boolean isstraight() {
		Five_Cards_Hand fivecard_r6 = new Five_Cards_Hand(card1,suit1,card2,suit2,card3,suit3,card4,suit4,card5,suit5);
		Five_Cards_Hand fivecard_r5 = new Five_Cards_Hand(card1,suit1,card2,suit2,card3,suit3,card4,suit4,card6,suit6);
		Five_Cards_Hand fivecard_r4 = new Five_Cards_Hand(card1,suit1,card2,suit2,card3,suit3,card5,suit5,card6,suit6);
		Five_Cards_Hand fivecard_r3 = new Five_Cards_Hand(card1,suit1,card2,suit2,card4,suit4,card5,suit5,card6,suit6);
		Five_Cards_Hand fivecard_r2 = new Five_Cards_Hand(card1,suit1,card3,suit3,card4,suit4,card5,suit5,card6,suit6);
		Five_Cards_Hand fivecard_r1 = new Five_Cards_Hand(card2,suit2,card3,suit3,card4,suit4,card5,suit5,card6,suit6);
		if (fivecard_r1.isstraight()==true) {return true;}
		else if (fivecard_r2.isstraight()==true) {return true;}
		else if (fivecard_r3.isstraight()==true) {return true;}
		else if (fivecard_r4.isstraight()==true) {return true;}
		else if (fivecard_r5.isstraight()==true) {return true;}
		else if (fivecard_r6.isstraight()==true) {return true;}
		else {return false;}
	}

}
