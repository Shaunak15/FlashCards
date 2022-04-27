import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testJunit {
	private Box card;
	private FlashCard b1 = new FlashCard( "Shaunak", "Patel");
	private FlashCard b2 = new FlashCard( "Monday", "Tuesday");
	private FlashCard b3 = new FlashCard( "apple", "banana");
	private FlashCard b4 = new FlashCard( "override", "inheritance");
	private FlashCard b5 = new FlashCard( "Uab", "college");
	
@Before
	public void setupFlashcard() {
		card = new Box();
		card.addCard(b1);
		card.addCard(b2);
		card.addCard(b3);
		card.addCard(b4);
		card.addCard(b5);
		
	}
	@Test
	public void testAddcard() {
		card.addCard(b1);
		assertTrue((card.getFCB().contains(b1)));
	}

	@Test
	public void testremovecard() {
		card.removeCard(b1);
		assertFalse((card.getFCB().contains(b1)));
	}
	@Test
	public void testflipcard() {
		card.FlipCard();
		assertTrue(card.getFCB().contains(b1));
	}
	@Test
	public void testpickacard() {
		card.pickacard();
		assertTrue(card.getFCB().contains(b1));
	}

}
