package quize.number03.keesun;

/**
 * @author Keesun Baik
 */
public enum Direction {

	E, W, S, N;

	Direction left;

	Direction right;

	static {
		E.left = N;
		E.right = S;
		
		W.left = S;
		W.right = N;
		
		S.left = E;
		S.right = W;
		
		N.left = W;
		N.right = E;
	}

	public Direction getLeft() {
		return left;
	}

	public Direction getRight() {
		return right;
	}
}
