import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FlashCardTester {
	static ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,2,2,2,2,3,3,4));
	//15            //23    //27 

	static ArrayList<Box> boxs = new ArrayList<Box>();

	static Random random2 = new Random();
	static int s = random2.nextInt(31);
	static int d = 0;

	public static void newbox() {
		s = random2.nextInt(31);
		d = integers.get(s);
		if (boxs.get(d).getSize() == 0) {
			newbox();
		}
	}

	public static void main(String[] args) {

		boxs.add(new Box());
		boxs.add(new Box());
		boxs.add(new Box());
		boxs.add(new Box());
		boxs.add(new Box());


		Scanner scanner = new Scanner(System.in);


		for (int i = 0; i < 5; i++) {
			String writeQ;
			String writeA;
			System.out.println("Write your question and Answer");
			writeQ = scanner.nextLine();
			writeA = scanner.nextLine();
			FlashCard FC = new FlashCard( writeQ, writeA);
			boxs.get(d).addCard(FC);;

		}
		
		//System.out.println(boxs.get(d).getSize());
		System.out.println("Your flashcard are as follows : ");
		boxs.get(d).cardList();
		System.out.println("\n");
		
		boolean okay = false;
		int key;
		while (!okay) {
			System.out.println("Your flashcard :");
			System.out.println( boxs.get(d).getCard());
			System.out.println("\n(1)flip a card , (2)know answer, (3)do not know answer , (4)end");
			key = scanner.nextInt();

			switch (key) {
			case 1:
				boxs.get(d).FlipCard();

				break;
			case 2:

				if (d+1 == 5) {
					boxs.get(d).removeCard(boxs.get(d).getPickedCard());

				}else {
					boxs.get(d+1).addCard(boxs.get(d).getPickedCard());
					boxs.get(d).removeCard(boxs.get(d).getPickedCard());

				}

				boolean hasCard = false;
				for (int i = 0; i < boxs.size(); i++) {
					if (boxs.get(i).getSize() > 0){
						hasCard =true;
					}
				}
				if (hasCard) {

					System.out.println("BOX " + d + "\n");
					boxs.get(d).cardList();
					newbox();
					System.out.println("\n");
					boxs.get(d).pickacard();
					
				}else {
					okay = true;
					System.out.println("can I get a 100");
				}


//				boxs.get(d+1).cardList();

				break;
				
			case 3 :

				boxs.get(0).addCard(boxs.get(d).getPickedCard());
				boxs.get(d).removeCard(boxs.get(d).getPickedCard());

				System.out.println("box 0" + "\n");
				boxs.get(0).cardList();
				newbox();
				System.out.println("\n");
				boxs.get(d).pickacard();
				break;


			case 4:
				okay =true;
				System.out.println("Bye - Bye");
				break;

			default:


			}

		}

	}
}
/* for your input:
 
 * 	Question 1 - It is also called as "Many Forms" or "Many behaviour".
	Answer 1 - Polymorphism.
	
	
	Question 2 - Is used for testing a single class.
	Answer 2 - Unit Test.
	
	
	Question 3 - It’s the set of behavior/functionality that you use to interact with an object.
	Answer 3 - Public Interface.
	
	
	Question 4 - It is used for sorting of objects needs to be based on natural order.
	Answer 4 - Comparable.
	
	
	Question 5 - It is used for sorting to be done on attributes of different object. 
	Answer 5 - Comparator.
	
 */









