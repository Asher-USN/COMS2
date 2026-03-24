import java.lang.reflect.Constructor;

public class Rating {
	String username;
	int score;
	public Rating(String name, int num) {
		username = name;
		score = num;
	}
	public void setUsername(String name) {
		username = name;
	}
	public void setScore(int num) {
		score = num;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getScore() {
		return score;
	}
}

