import java.util.ArrayList;
import java.util.Random;

public class Box {

	private  ArrayList<FlashCard> FCB  = new ArrayList<FlashCard>();
	int randCard;
	int randSide;
	
	public Box() {

	}
	
	int CardIndex = 0;
	boolean showingAnswer = true;
	int a = 0;
	
	public void addCard(FlashCard fCard) {
		getFCB().add(fCard);
	}

	public void removeCard(FlashCard rCard) {
		getFCB().remove(rCard);
	}

	public int getSize() {
		return getFCB().size();
	}

	public void  cardList() {
		for(int i =0; i < getFCB().size() ; i++) {
			System.out.println("Question :" + getFCB().get(i).getQuestion());
			System.out.println("Answer :" + getFCB().get(i).getAnswer());
		}
	}

	public void pickacard() {
		Random random2 = new Random();
		randCard = random2.nextInt(getFCB().size());
		CardIndex = randCard;

	}
	
	public void FlipCard() {
		Random random = new Random();
		int r = 0;
		if ( r == a) {
			showingAnswer = false;
			a = 1;
		}else {
			showingAnswer = true;
			a = 0;
		}
	}
	
	public String getCard() {
		if (showingAnswer) {
			return getFCB().get(CardIndex).getAnswer();
		}
		else {
			return getFCB().get(CardIndex).getQuestion();
		}
	}
	
	public FlashCard getPickedCard() {
		return getFCB().get(CardIndex);
	}
	
	public String nextFlashcard() {
		Random random2 = new Random();
		randCard = random2.nextInt(getFCB().size());
		randSide = getFCB().get(randCard).randomside();
		if (randSide == 1 ) {
			return getFCB().get(randCard).getQuestion();
		}
		else {
			return getFCB().get(randCard).getAnswer();
		}
	}

	public ArrayList<FlashCard> getFCB() {
		return FCB;
	}

	public void setFCB(ArrayList<FlashCard> fCB) {
		FCB = fCB;
	}



}
