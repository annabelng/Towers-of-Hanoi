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
			

		generateMoves();

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
	public void generateMoves() {
		System.out.println("Generating moves");
		
		//each pair corresponds to a move from one peg to the other
		moves.add(0);	//source peg
		moves.add(1);	//destination
			
		moves.add(0);	//source peg
		moves.add(2);	//destination
		
		moves.add(0);	//source peg
		moves.add(2);	//destination
		

	}

}
