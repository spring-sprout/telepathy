package chapter4;

/**
 * @author ihseo
 */
public class Node {

	private Node right;
	private int key;
	private Node left;
	
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}

	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	
	@Override
	public String toString() {
		String result = "< node key : " + key + " >";
		return result;
	}
}
