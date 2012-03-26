package chapter5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import chapter5.DaewonRedBlackTree.Color;
import chapter5.DaewonRedBlackTree.Node;

public class DaewonRedBlackTreeTest {

	DaewonRedBlackTree tree = new DaewonRedBlackTree();

	@Before
	public void before() {
		tree.insert(7);
		tree.insert(1);
		tree.insert(2);
		tree.insert(8);
		tree.insert(6);
		tree.insert(3);
		tree.insert(5);
		tree.insert(4);
	}

	@Test
	public void testInsert() {
		DaewonRedBlackTree tree = new DaewonRedBlackTree();
		tree.insert(7);
		Assert.assertEquals(7, tree.getRoot().getKey());
		validateTree(tree.getRoot(), 1);

		tree.insert(1);
		Assert.assertEquals(7, tree.getRoot().getKey());
		validateTree(tree.getRoot(), 1);

		tree.insert(2);
		Assert.assertEquals(2, tree.getRoot().getKey());
		validateTree(tree.getRoot(), 1);

		tree.insert(8);
		Assert.assertEquals(2, tree.getRoot().getKey());
		validateTree(tree.getRoot(), 2);

		tree.insert(6);
		Assert.assertEquals(2, tree.getRoot().getKey());
		validateTree(tree.getRoot(), 2);

		tree.insert(3);
		Assert.assertEquals(2, tree.getRoot().getKey());
		validateTree(tree.getRoot(), 2);

		tree.insert(5);
		validateTree(tree.getRoot(), 2);
		Node root = tree.getRoot();
		Assert.assertEquals(2, root.getKey());
		Assert.assertEquals(root.getColor(), Color.BLACK);
		Assert.assertEquals(root.getLeft().getKey(), 1);
		Assert.assertEquals(root.getLeft().getColor(), Color.BLACK);
		Assert.assertEquals(root.getRight().getKey(), 7);
		Assert.assertEquals(root.getRight().getColor(), Color.RED);
		Assert.assertEquals(root.getRight().getLeft().getKey(), 5);
		Assert.assertEquals(root.getRight().getLeft().getColor(), Color.BLACK);
		Assert.assertEquals(root.getRight().getLeft().getLeft().getKey(), 3);
		Assert.assertEquals(root.getRight().getLeft().getLeft().getColor(), Color.RED);
		Assert.assertEquals(root.getRight().getLeft().getRight().getKey(), 6);
		Assert.assertEquals(root.getRight().getLeft().getLeft().getColor(), Color.RED);
		Assert.assertEquals(root.getRight().getRight().getKey(), 8);
		Assert.assertEquals(root.getRight().getRight().getColor(), Color.BLACK);

		tree.insert(4);
		root = tree.getRoot();
		validateTree(root, 2);
		Assert.assertEquals(5, root.getKey());
		Assert.assertEquals(root.getColor(), Color.BLACK);
		Assert.assertEquals(root.getLeft().getKey(), 2);
		Assert.assertEquals(root.getLeft().getColor(), Color.RED);
		Assert.assertEquals(root.getLeft().getLeft().getKey(), 1);
		Assert.assertEquals(root.getLeft().getLeft().getColor(), Color.BLACK);
		Assert.assertEquals(root.getLeft().getRight().getKey(), 3);
		Assert.assertEquals(root.getLeft().getRight().getColor(), Color.BLACK);
		Assert.assertEquals(root.getLeft().getRight().getRight().getKey(), 4);
		Assert.assertEquals(root.getLeft().getRight().getRight().getColor(), Color.RED);
		Assert.assertEquals(root.getRight().getKey(), 7);
		Assert.assertEquals(root.getRight().getColor(), Color.RED);
		Assert.assertEquals(root.getRight().getLeft().getKey(), 6);
		Assert.assertEquals(root.getRight().getLeft().getColor(), Color.BLACK);
		Assert.assertEquals(root.getRight().getRight().getKey(), 8);
		Assert.assertEquals(root.getRight().getRight().getColor(), Color.BLACK);
	}

	@Test
	public void testSearch() {
		Assert.assertEquals(tree.search(5).getKey(), 5);
		Assert.assertEquals(tree.search(1).getKey(), 1);
		Assert.assertEquals(tree.search(8).getKey(), 8);
		Assert.assertEquals(tree.search(4).getKey(), 4);
		Assert.assertEquals(tree.search(3).getKey(), 3);
		Assert.assertEquals(tree.search(1).getKey(), 1);

		Assert.assertNull(tree.search(100));
		Assert.assertNull(tree.search(65));
		Assert.assertNull(tree.search(17));
	}

	@Test
	public void testDelete5_루트삭제() {
		tree.delete(tree.search(5));
		Assert.assertNull(tree.search(5));
		validateTree(tree.getRoot(), 2);
	}

	@Test
	public void testDelete4_delete_black() {
		tree.delete(tree.search(4));
		Assert.assertNull(tree.search(4));
		validateTree(tree.getRoot(), 2);
	}

	@Test
	public void testDelete3_x_red() {
		tree.delete(tree.search(3));
		Assert.assertNull(tree.search(3));
		validateTree(tree.getRoot(), 2);
	}

	@Test
	public void testDelete2_case1_1() {
		tree.delete(tree.search(2));
		Assert.assertNull(tree.search(2));
		validateTree(tree.getRoot(), 2);
	}

	@Test
	public void testDelete1() {
		tree.delete(tree.search(1));
		validateTree(tree.getRoot(), 2);
	}

	@Test
	public void testDelete7() {
		tree.delete(tree.search(7));
		validateTree(tree.getRoot(), 2);
	}

	@Test
	public void testDelete_8() {
		tree.delete(tree.search(8));
		validateTree(tree.getRoot(), 2);
	}

	@Test
	public void testDelete_6() {
		tree.delete(tree.search(6));
		validateTree(tree.getRoot(), 2);
	}

	private void validateTree(DaewonRedBlackTree.Node node, int expectedNumOfBlack) {
		if (node == null)
			return;

		Assert.assertEquals(node.getRoot().getColor(), Color.BLACK);

		if (node.getColor() == Color.RED) {
			if (node.getLeft() != null)
				Assert.assertEquals(node.getLeft().getColor(), Color.BLACK);
			if (node.getRight() != null)
				Assert.assertEquals(node.getRight().getColor(), Color.BLACK);
		}

		if (node.getLeft() != null) {
			Assert.assertTrue(node.getKey() > node.getLeft().getKey());
		}

		if (node.getRight() != null) {
			Assert.assertTrue(node.getKey() < node.getRight().getKey());
		}

		if (node.getLeft() == null && node.getRight() == null) { // leaf 노드인 경우
			int numBlack = 0;
			Node temp = node;
			while (temp != null) {
				numBlack += (temp.getColor() == Color.BLACK ? 1 : 0);
				temp = temp.getParent();
			}
			Assert.assertEquals(expectedNumOfBlack, numBlack);
		} else {

			validateTree(node.getLeft(), expectedNumOfBlack);
			validateTree(node.getRight(), expectedNumOfBlack);
		}
	}
}
