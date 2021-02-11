/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;



public class MidpointFindingKarel extends SuperKarel {
	
	public void run() {
		clearBeepers();
		countByTwos();
		stop();
		arrangeBeepersContiguously();
	}
	
	private void clearBeepers() {
		while (beepersPresent()) {
			pickBeeper();
		}
		while (frontIsClear()) {
			move();
			while (beepersPresent()) {
				pickBeeper();
			}
		}
		turnAround();
	}
	
	private void countByTwos() {
		while (frontIsClear()) {
			putBeeper();
			if (frontIsClear()) {
				move();
			}
			if (frontIsClear()) {
				move();
			}
		}
		putBeeper();
		turnAround();
	}
	
	private void arrangeBeepersContiguously() {
			if (!beepersPresent()) {
				while (frontIsClear()) {
					moveNextBeeper();
				}
			} else {
				move();
				while (frontIsClear()) {
					moveNextBeeper();
				}
			}
	}

	
	
	private void moveNextBeeper() {
			while (!beepersPresent()) {
				if (frontIsClear()) {
					move();
					} else {
						turnAround();
						leaveBeeperAtHalf();
					}
				}
				pickBeeper(); 
				turnAround();
				moveItBack();
	}
				
	
	private void moveItBack() {
		while (!beepersPresent()) {
			if (frontIsClear()) {
				move(); } else {
					turnAround();
			}
			
		}
		turnAround();
		move();
		putBeeper();
		move();
		}
	 
	
	private void leaveBeeperAtHalf() {
		while (!beepersPresent()) {
			move();
		}
		move();
		if (beepersPresent()) {
			pickBeeper();
			while (frontIsClear()) {
				move();
				pickBeeper();
			}
		}
	}
}

