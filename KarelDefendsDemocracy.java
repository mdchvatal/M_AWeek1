/* VotingBox.java
 * 
 * Program to clear out hanging chads from the VotingBox world. 
 * Karel checks ballots to see if, after a vote is registered, there are any beepers hanging about.
 * He cleans them up and stops once he's moved through them all from West to East.
 * 
 */



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
