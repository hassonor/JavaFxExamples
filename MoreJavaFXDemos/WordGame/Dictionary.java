import java.util.Random;

public class Dictionary {
	
	public boolean isLegal(String word) {
		return Math.random() >= 0.5;
	}
	 public char getRandomLetter() {
		 Random r = new Random();
		 char c = (char)(r.nextInt(26) + 'a');
		 return c;
	 }
}
