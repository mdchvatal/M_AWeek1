import stanford.karel.*;

public class DoubleBeeper extends SuperKarel{
	
	public void run() {
		findBeepers();
		doubleBeepers();
		goHome();
	}
	
	private void putBeeperAtNextIntersection() {
		pickBeeper();
		move();
		putBeeper();
		moveBack();
	}
	
	private void moveBack() {
		turnAround();
		move();
		turnAround();
	}
	
	private void doubleBeepers() {
		while (beepersPresent()) {
			putBeeperAtNextIntersection();
		}
		findBeepers();
		putTwoBeepersAtOriginalSpot();
	}
	
	private void goHome() {
		while (!facingWest()) {
			turnLeft();
		}
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
	
	private void findBeepers() {
		while (!beepersPresent()) {
			move();
		}
	}
		
	private void putTwoBeepersAtOriginalSpot() {
		while (beepersPresent()) {
			pickBeeper();
			moveBack();
			putBeeper();
			putBeeper();
			move();
		}
			
	}
}