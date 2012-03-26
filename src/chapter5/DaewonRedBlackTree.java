package chapter5;

public class DaewonRedBlackTree {

	private Node root = null;

	public Node getRoot() {
		return root;
	}

	public Node search(int key) {
		return search(root, key);
	}

	private Node search(Node node, int key) {
		if (node == null || node.getKey() == key) {
			return node;

		} else {

			if (key < node.getKey()) {
				return search(node.getLeft(), key);
			} else {
				return search(node.getRight(), key);
			}
		}
	}

	public void insert(int key) {
		Node newNode = new Node(key, Color.RED, null);

		if (root == null) {
			root = newNode;
			newNode.setColor(Color.BLACK);
			return;
		}

		Node parent = null;
		Node tmp = root;
		while (tmp != null) {
			parent = tmp;
			if (key < tmp.getKey()) {
				tmp = tmp.getLeft();
			} else {
				tmp = tmp.getRight();
			}
		}

		if (key < parent.key) {
			parent.setLeft(newNode);
		} else {
			parent.setRight(newNode);
		}

		arrangeColor4Insert(newNode);
	}

	private void arrangeColor4Insert(Node node) {

		if (node.isRoot()) {
			node.setColor(Color.BLACK);
			return;
		}

		Node parent = node.parent;
		if (isBlack(parent)) { // 부모B
			return;

		} else { // 부모R
			Node grandParent = parent.getParent();
			Node uncle = parent.getSibling();
			if (isRed(uncle)) { // 부모R, 삼촌R
				parent.setColor(Color.BLACK);
				uncle.setColor(Color.BLACK);

				grandParent.setColor(Color.RED);
				arrangeColor4Insert(grandParent);

			} else { // 부모R, 삼촌B
				// Case 2-1 : 추가된 노드(x)가 부모(p)의 오른쪽 자식 & 부모는 조부모의 왼쪽 자식
				if (node.isRightChild() && node.getParent().isLeftChild()) {
					rotateLeft(parent);
					arrangeColor4Insert(parent);

				} else if (node.isLeftChild() && node.getParent().isRightChild()) { // Case 2-1 대칭
					rotateRight(parent);
					arrangeColor4Insert(parent);

				} else { // Case 2-2
					if (grandParent != null) {
						grandParent.setColor(Color.RED);
						if (node.isLeftChild()) {
							rotateRight(grandParent);
						} else {
							rotateLeft(grandParent);
						}
					}
					parent.setColor(Color.BLACK);

				}
			}
		}
	}

	public void delete(Node node) {
		Node parentNode = node.getParent();

		if (node.isRoot()) {
			deleteNode(root);

		} else if (node.equals(parentNode.getLeft())) {
			parentNode.setLeft(deleteNode(node));

		} else {
			parentNode.setRight(deleteNode(node));
		}
	}

	private Node deleteNode(Node node) {
		Node returnNode = node;

		Node removedNode = node;
		Node parent = removedNode.getParent();
		if (node.getLeft() == null && node.getRight() == null) {
			returnNode = null;
		} else if (node.getLeft() == null && node.getRight() != null) {
			returnNode = node.getRight();
		} else if (node.getLeft() != null && node.getRight() == null) {
			returnNode = node.getLeft();

		} else {
			removedNode = node.getRight();
			parent = removedNode.getParent();
			while (removedNode.getLeft() != null) {
				parent = removedNode;
				removedNode = removedNode.getLeft();
			}

			node.setKey(removedNode.getKey());
			if (removedNode == node.getRight()) {
				node.setRight(removedNode.getRight());
			} else {
				parent.setLeft(removedNode.getRight());
			}

			returnNode = node;
		}

		Node childNode = removedNode.getRight();
		if (isBlack(removedNode)) {
			if (childNode != null && isRed(childNode)) {
				childNode.setColor(Color.BLACK);
			} else {
				deleteCase1(removedNode); // wikpedia의 설명을 기반으로 구현
				//arrangeColor4Delete(removedNode); // 책의 설명을 기반으로 구현
				replaceNode(removedNode, childNode);
			}
		}

		return returnNode;
	}

	private void deleteCase1(Node node) {
		if (node.isRoot())
			return;

		deleteCase2(node);
	}

	private void deleteCase2(Node node) {
		Node parent = node.getParent();
		Node sibling = node.getSibling();
		if (isRed(sibling)) { // Case 2-4 <p:BLACK, s:RED, l:BLACK, r:BLACK>
			changeColor(parent, sibling);
			if (node.isLeftChild()) {
				rotateLeft(parent);
			} else {
				rotateRight(parent);
			}
		}

		deleteCase3(node);
	}

	private void deleteCase3(Node node) {
		Node parent = node.getParent();
		Node sibling = node.getSibling();
		Node left = sibling != null ? sibling.getLeft() : null;
		Node right = sibling != null ? sibling.getRight() : null;
		// Case 2-1 <p:BLACK, p:BLACK, l:BLACK, r:BLACK>
		if (isBlack(parent) && isBlack(sibling) && isBlack(left) && isBlack(right)) {
			sibling.setColor(Color.RED);
			deleteCase1(parent);
		} else {
			deleteCase4(node);
		}
	}

	private void deleteCase4(Node node) {
		Node parent = node.getParent();
		Node sibling = node.getSibling();
		Node left = sibling != null ? sibling.getLeft() : null;
		Node right = sibling != null ? sibling.getRight() : null;

		// Case 1-1 <p:RED, s:BLACK, l:BLACK, r:BLACK>
		if (isRed(parent) && isBlack(sibling) && isBlack(left) && isBlack(right)) {
			parent.setColor(Color.BLACK);
			if (sibling != null)
				sibling.setColor(Color.RED);

		} else {
			deleteCase5(node);
		}
	}

	private void deleteCase5(Node node) {
		Node sibling = node.getSibling();
		Node left = sibling != null ? sibling.getLeft() : null;
		Node right = sibling != null ? sibling.getRight() : null;

		if (isBlack(sibling)) {
			if (node.isLeftChild() && isRed(left) && isBlack(right)) {
				// Case *-3 <p:?, s:BLACK, l:RED, r:BLACK>
				changeColor(sibling, left);
				rotateRight(sibling);

			} else if (node.isRightChild() && isBlack(left) && isRed(right)) {
				// Case *-3 <p:?, s:BLACK, l:BLACK, r:RED>
				changeColor(sibling, right);
				rotateLeft(sibling);
			}
		}

		deleteCase6(node);
	}

	private void deleteCase6(Node node) {
		Node parent = node.getParent();
		Node sibling = node.getSibling();
		Node left = sibling != null ? sibling.getLeft() : null;
		Node right = sibling != null ? sibling.getRight() : null;

		if (sibling != null)
			sibling.setColor(parent.getColor());
		parent.setColor(Color.BLACK);

		if (node.isLeftChild()) {
			right.setColor(Color.BLACK);
			rotateLeft(parent);
		} else {
			left.setColor(Color.BLACK);
			rotateRight(parent);
		}
	}

	private void arrangeColor4Delete(Node node) {
		if (node.isRoot())
			return;

		Node childNode = node.getRight();
		if (childNode != null && isRed(childNode)) {
			childNode.setColor(Color.BLACK);
			return;
		}

		Node parent = node.getParent();
		Node sibling = node.getSibling();
		Node left = sibling != null ? sibling.getLeft() : null;
		Node right = sibling != null ? sibling.getRight() : null;

		if (isRed(parent) && isBlack(left) && isBlack(right)) {
			// Case 1-1 <P:Red, S:Black, L:Black, R:Black>
			parent.setColor(Color.BLACK);
			if (sibling != null)
				sibling.setColor(Color.RED);

		} else if (isBlack(sibling) && isRed(right)) {
			// Case *-2 <P:*, S:Black, L:*, R:Red>
			changeColor(parent, sibling);

			if (node.isLeftChild()) {
				right.setColor(Color.BLACK);
				rotateLeft(parent);
			} else {
				left.setColor(Color.BLACK);
				rotateRight(parent);
			}

		} else if (isBlack(sibling)) {
			if (node.isLeftChild() && isRed(left) && isBlack(right)) {
				// Case *-3 <p:?, s:BLACK, l:RED, r:BLACK>
				changeColor(sibling, left);
				rotateRight(sibling);

			} else if (node.isRightChild() && isBlack(left) && isRed(right)) {
				// Case *-3 <p:?, s:BLACK, l:BLACK, r:RED>
				changeColor(sibling, right);
				rotateLeft(sibling);
			}

			arrangeColor4Delete(node);

		} else if (isBlack(parent) && isBlack(sibling) && isBlack(left) && isBlack(right)) {
			// Case 2-1 <P:Black, S:Black, L:Black, R:Black>
			sibling.setColor(Color.RED);
			arrangeColor4Delete(parent);

		} else if (isRed(sibling)) { // Case 2-4 <P:Black, S:Red, L:Black, R:Black>
			changeColor(parent, sibling);
			if (node.isLeftChild()) {
				rotateLeft(parent);
			} else {
				rotateRight(parent);
			}

			arrangeColor4Delete(node);
		}
	}

	private boolean isBlack(Node node) {
		return node == null || node.color == Color.BLACK;
	}

	private boolean isRed(Node node) {
		return !isBlack(node);
	}

	private void changeColor(Node node1, Node node2) {
		Color temp = node1.color;
		node1.color = node2.color;
		node2.color = temp;
	}

	public void rotateLeft(Node node) {
		Node parent = node.parent;
		Node right = node.right;

		right.parent = parent;
		if (parent != null) {
			if (node.isRightChild()) {
				parent.setRight(right);
			} else {
				parent.setLeft(right);
			}
		}

		node.setRight(right.left);
		right.setLeft(node);
		root = node.getRoot();
	}

	public void rotateRight(Node node) {
		Node parent = node.parent;
		Node left = node.left;

		left.parent = parent;
		if (parent != null) {
			if (node.isRightChild()) {
				parent.setRight(left);
			} else {
				parent.setLeft(left);
			}
		}

		node.setLeft(left.right);
		left.setRight(node);
		root = node.getRoot();
	}

	private void replaceNode(Node oldNode, Node newNode) {
		if (oldNode.parent == null) {
			root = newNode;

		} else {
			if (oldNode == oldNode.parent.left)
				oldNode.parent.left = newNode;
			else
				oldNode.parent.right = newNode;
		}
		if (newNode != null) {
			newNode.parent = oldNode.parent;
		}
	}

	public static enum Color {
		RED, BLACK
	}

	public static class Node {
		private int key;
		private Color color;
		private Node parent;
		private Node left;
		private Node right;

		public Node(int key, Color color, Node parent) {
			this(key, color, parent, null, null);
		}

		public Node(int key, Color color, Node parent, Node left, Node right) {
			super();
			this.key = key;
			this.color = color;
			this.parent = parent;
			setLeft(left);
			setRight(right);
		}

		public Node getRoot() {
			Node root = this;
			Node parent = this.parent;
			while (parent != null) {
				root = parent;
				parent = parent.parent;
			}

			return root;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}

		public Node getParent() {
			return parent;
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

		public Node getSibling() {
			if (parent == null)
				return null;

			if (parent.left == this) {
				return parent.right;
			} else {
				return parent.left;
			}
		}

		public boolean isRoot() {
			return parent == null;
		}

		public boolean isLeftChild() {
			if (this.parent != null) {
				return parent.left == this;
			} else {
				return false;
			}
		}

		public boolean isRightChild() {
			if (this.parent != null) {
				return parent.right == this;
			} else {
				return false;
			}
		}

		public String toString() {
			return key + "|" + color;
		}
	}
}
