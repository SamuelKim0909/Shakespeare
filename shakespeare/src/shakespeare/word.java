package shakespeare;

public class word {
	private int count;
	private String word;
	
	public word(String s){
		count = 0;
		word = s;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public void addCount() {
		count++;
	}
	public int getCount() {
		return count;
	}
}
