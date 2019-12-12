package sample;

// A Record class holds one set of score and round.
public class Record implements Comparable<Record> {
	
	private int score;
	private int round;
	
	public Record(int score, int round) {
		this.score = score;
		this.round = round;
	}
	public int getScore() {
		return this.score;
	}
	public int getRound() {
		return this.round;
	}
	public int compareTo(Record record) {
		// TODO Auto-generated method stub
		if(this.score < record.score)
			return -1;
		else
			return 1;
			
	}
}
