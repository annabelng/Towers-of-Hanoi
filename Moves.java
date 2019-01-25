import java.util.Arrays;

public class Moves {
	/**
	 * An array of disc movements. Each movement is a pair of two ints. For
	 * example one complete movement defined by 0, 1 is a move from peg 0 to peg
	 * 1.
	 */
	DynamicArray moves;
	/**
	 * An indicator set to true if the number of disc in the game is even.
	 */

	boolean even;
	int n;

	/**
	 * The container stands for each peg. There are three pegs in the game in
	 * total. The left, center and right peg. All of the discs will be on the
	 * left most peg at the start of the game. Discs be biggest to smallest from
	 * the start.
	 */
	DynamicArray left;
	DynamicArray center;
	DynamicArray right;

	/**
	 * Construct a move object that contains all the moves using generateMoves
	 * 
	 * @param n
	 *            the number of disc on the game. The
	 */
	public Moves(int n) {
		moves = new DynamicArray();

		// initialize the instance variables(job of a constructor)

		// list to keep track of "left" peg
		left = new DynamicArray();
		// middle peg
		center = new DynamicArray();
		// right peg
		right = new DynamicArray();

		// based on the number of disks(n)
		// add the correct number and order of "disks" on the left "peg"

		int size = n;
		int sum = 0;
		// add the numbers so that the biggest one is first
		while (size > 0) { // the following numbers are always smaller than the
							// previous
			left.add(size); // adding all discs together
			sum++;
			size--; // decrementing size
		}

		generateMoves(n);

	}

	/**
	 * Provide a list of steps for the code to run to solve the game Tower of
	 * Hanoi.
	 * 
	 * Each move should consist of 2 numbers representing the from and to rod
	 * location. For example, if you are wanting to move from rod 0 to rod 2
	 * then you will add 2 numbers to the moves array using moves.add(0),
	 * moves.add(2). These two represent a move from rod 0 to rod 2. There are
	 * three rods in the game. The left rod is 0, center is 1 and right rod is
	 * 2.
	 * 
	 */

	/*
	 * make the legal move between pegs A and B (in either direction) make the
	 * legal move between pegs A and C (in either direction) make the legal move
	 * between pegs B and C (in either direction) repeat until complete
	 */
	public void generateMoves(int n) {
		System.out.println("Generating moves");

		// odd disks
		if (n % 2 != 0) {
			for (int i = 0; i < (Math.pow(2, n) / 3) - 1; i++) {

				// step 1
				// try A -> C
				if (right.getLast() > left.getLast()) {
					moves.add(0); // source peg
					moves.add(2); // destination

					// add to the end of right
					// the element you removed
					// from the end of left
					right.add(left.remove());
				} else if (left.getLast() > right.getLast()) {
					// if a->c is not possible, try c->a
					moves.add(2); // source peg
					moves.add(0); // destination

					// add to the end of left
					// the element you removed
					// from the end of right
					left.add(right.remove());
				}
				// A -> B
				if (center.getLast() > left.getLast()) {
					moves.add(0); // source peg
					moves.add(1); // destination

					// add to the end of middle
					// the element you removed
					// from the end of left
					center.add(left.remove());
				} else if (left.getLast() > center.getLast()) {
					// if a->c is not possible, try c->a
					moves.add(1); // source peg
					moves.add(0); // destination

					// add to the end of left
					// the element you removed
					// from the end of center
					left.add(center.remove());
				}

				// C->B
				if (center.getLast() > right.getLast()) {
					moves.add(2); // source peg
					moves.add(1); // destination

					// add to the end of center
					// the element you removed
					// from the end of right
					center.add(right.remove());
				} else if (right.getLast() > center.getLast()) {
					// if a->c is not possible, try c->a
					moves.add(1); // source peg
					moves.add(2); // destination

					// add to the end of right
					// the element you removed
					// from the end of center
					right.add(center.remove());
				}
			}
			// try A -> C
			if (right.getLast() > left.getLast()) {
				moves.add(0); // source peg
				moves.add(2); // destination

				// add to the end of right
				// the element you removed
				// from the end of left
				right.add(left.remove());
			} else if (left.getLast() > right.getLast()) {
				// if a->c is not possible, try c->a
				moves.add(2); // source peg
				moves.add(0); // destination

				// add to the end of left
				// the element you removed
				// from the end of right
				left.add(right.remove());
			}

		} else {

			for (int i = 0; i < (Math.pow(2, n) / 3) -1; i++) {
				// step 1
				// try A -> B

				if (center.getLast() > left.getLast()) {
					moves.add(0); // source peg
					moves.add(1); // destination

					// add to the end of right
					// the element you removed
					// from the end of left
					center.add(left.remove());
				} else if (left.getLast() > center.getLast()) {
					// if a->c is not possible, try c->a
					moves.add(1); // source peg
					moves.add(0); // destination

					// add to the end of left
					// the element you removed
					// from the end of right
					left.add(center.remove());
				}
				// try A -> C

				if (right.getLast() > left.getLast()) {
					moves.add(0); // source peg
					moves.add(2); // destination

					// add to the end of right
					// the element you removed
					// from the end of left
					right.add(left.remove());
				} else if (left.getLast() > right.getLast()) {
					// if a->c is not possible, try c->a
					moves.add(2); // source peg
					moves.add(0); // destination

					// add to the end of left
					// the element you removed
					// from the end of right
					left.add(right.remove());
				}

				// C->B
				if (center.getLast() > right.getLast()) {
					moves.add(2); // source peg
					moves.add(1); // destination

					// add to the end of center
					// the element you removed
					// from the end of right
					center.add(right.remove());
				} else if (right.getLast() > center.getLast()) {
					// if a->c is not possible, try c->a
					moves.add(1); // source peg
					moves.add(2); // destination

					// add to the end of right
					// the element you removed
					// from the end of center
					right.add(center.remove());
				}
			}
		}
	}

}
