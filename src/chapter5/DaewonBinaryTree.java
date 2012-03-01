package chapter5;

public class DaewonBinaryTree {

	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public TreeNode search(int key) {
		return search(root, key);
	}

	private TreeNode search(TreeNode node, int key) {
		if (node == null || node.getKey() == key)
			return node;

		if (key < node.getKey()) {
			return search(node.getLeft(), key);
		} else {
			return search(node.getRight(), key);
		}
	}

	public void insert(int key) {
		root = insert(root, key);
	}

	private TreeNode insert(TreeNode node, int key) {
		if (node == null) {
			node = new TreeNode(key, null);
			return node;
		}

		if (key < node.key) {
			node.setLeft(insert(node.getLeft(), key));
			return node;
		} else {
			node.setRight(insert(node.getRight(), key));
			return node;
		}
	}

	public void delete(TreeNode node) {
		if (node == null)
			return;

		TreeNode parentNode = node.getParent();

		if (node.equals(root)) {
			deleteNode(root);

		} else if (node.equals(parentNode.getLeft())) {
			parentNode.setLeft(deleteNode(node));
		} else {
			parentNode.setRight(deleteNode(node));
		}
	}

	private TreeNode deleteNode(TreeNode node) {
		if (node.getLeft() == null && node.getRight() == null) {
			return null;
		} else if (node.getLeft() == null && node.getRight() != null) {
			return node.getRight();
		} else if (node.getLeft() != null && node.getRight() == null) {
			return node.getLeft();

		} else {
			TreeNode parentOfSwitchNode = null;
			TreeNode switchNode = node.getRight();
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

	public static class TreeNode {

		private int key;
		private TreeNode parent;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int key, TreeNode parent) {
			this(key, parent, null, null);
		}

		public TreeNode(int key, TreeNode parent, TreeNode left, TreeNode right) {
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

		public TreeNode getParent() {
			return parent;
		}

		public void setParent(TreeNode parent) {
			this.parent = parent;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
			if (this.left != null) {
				this.left.parent = this;
			}
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
			if (this.right != null) {
				this.right.parent = this;
			}
		}

	}

}
