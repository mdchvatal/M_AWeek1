import stanford.karel.*;

public class VotingBox extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			move();
			checkVote();
			move();
		}
		
				
	}
	
	private void checkVote() {
		if (!beepersPresent()) {
			checkForChads();
		}
	}
	
	private void checkForChads() {
		turnLeft();
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
		turnRight();
		turnRight();
		move();
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
		turnLeft();
		turnLeft();
		move();
		turnRight();
	}
	
		
}
