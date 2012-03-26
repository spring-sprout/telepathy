package chapter5;

public class DaewonBinaryTree {

	private Node root;

	public Node getRoot() {
		return root;
	}

	public Node search(int key) {
		return search(root, key);
	}

	private Node search(Node parentNode, int key) {
		if (parentNode == null || parentNode.getKey() == key)
			return parentNode;

		if (key < parentNode.getKey()) {
			return search(parentNode.getLeft(), key);
		} else {
			return search(parentNode.getRight(), key);
		}
	}

	public void insert(int key) {
		root = insert(root, key);
	}

	private Node insert(Node parentNode, int key) {
		if (parentNode == null) {
			Node newNode = new Node(key, null);
			return newNode;
		}

		if (key < parentNode.key) {
			parentNode.setLeft(insert(parentNode.getLeft(), key));
		} else {
			parentNode.setRight(insert(parentNode.getRight(), key));
		}

		return parentNode;
	}

	public void delete(Node node) {
		if (node == null)
			return;

		Node parentNode = node.getParent();

		if (node.equals(root)) {
			deleteNode(root);

		} else if (node.equals(parentNode.getLeft())) {
			parentNode.setLeft(deleteNode(node));

		} else {
			parentNode.setRight(deleteNode(node));
		}
	}

	private Node deleteNode(Node node) {
		if (node.getLeft() == null && node.getRight() == null) {
			return null;
		} else if (node.getLeft() == null && node.getRight() != null) {
			return node.getRight();
		} else if (node.getLeft() != null && node.getRight() == null) {
			return node.getLeft();

		} else {
			Node parentOfSwitchNode = null;
			Node switchNode = node.getRight();
			while (switchNode.getLeft() != null) {
				parentOfSwitchNode = switchNode;
				switchNode = switchNode.getLeft();
			}
			node.setKey(switchNode.getKey());
			if (switchNode == node.getRight()) {
				node.setRight(switchNode.getRight());
			} else {
				parentOfSwitchNode.setLeft(switchNode.getRight());
			}

			return node;
		}
	}

	public static class Node {

		private int key;
		private Node parent;
		private Node left;
		private Node right;

		public Node(int key, Node parent) {
			this(key, parent, null, null);
		}

		public Node(int key, Node parent, Node left, Node right) {
			super();
			this.key = key;
			this.left = left;
			this.right = right;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
			if (this.left != null) {
				this.left.parent = this;
			}
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
			if (this.right != null) {
				this.right.parent = this;
			}
		}
	}

}
