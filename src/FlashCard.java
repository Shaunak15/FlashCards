import java.util.Random;

public class FlashCard{
	private String question;
	private String answer;

	public FlashCard(String question, String answer) {
		this.question =question;
		this.answer = answer;
	}


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int randomside() {
		Random spRandom = new Random();
		int sp = spRandom.nextInt(2)+1;
		if(sp == 1) {
			return 1;
		}
		else {
			return 2;
		}
	}

}

