package chapter5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import chapter5.DaewonBinaryTree.TreeNode;

public class DaewonBinaryTreeTest {

	DaewonBinaryTree tree = new DaewonBinaryTree();

	@Before
	public void before() {
		tree.insert(30);
		tree.insert(20);
		tree.insert(25);
		tree.insert(40);
		tree.insert(10);
		tree.insert(35);
	}

	@Test
	public void testInsert() {
		DaewonBinaryTree tree = new DaewonBinaryTree();
		tree.insert(30);
		tree.insert(20);
		tree.insert(25);
		tree.insert(40);
		tree.insert(10);
		tree.insert(35);

		TreeNode root = tree.getRoot();

		Assert.assertEquals(root.getKey(), 30);
		Assert.assertEquals(root.getLeft().getKey(), 20);
		Assert.assertEquals(root.getLeft().getRight().getKey(), 25);
		Assert.assertEquals(root.getRight().getKey(), 40);
		Assert.assertEquals(root.getLeft().getLeft().getKey(), 10);
		Assert.assertEquals(root.getRight().getLeft().getKey(), 35);
	}

	@Test
	public void testSearch() {
		Assert.assertEquals(tree.search(30).getKey(), 30);
		Assert.assertEquals(tree.search(20).getKey(), 20);
		Assert.assertEquals(tree.search(25).getKey(), 25);
		Assert.assertEquals(tree.search(40).getKey(), 40);
		Assert.assertEquals(tree.search(10).getKey(), 10);
		Assert.assertEquals(tree.search(35).getKey(), 35);

		Assert.assertNull(tree.search(100));
		Assert.assertNull(tree.search(1));
		Assert.assertNull(tree.search(17));
	}

	@Test
	public void testDelete_루트삭제() {
		tree.delete(tree.search(30));
		Assert.assertNull(tree.search(30));
		Assert.assertEquals(tree.getRoot().getKey(), 35);
	}

	@Test
	public void testDelete_leaf삭제() {
		tree.delete(tree.search(10));
		Assert.assertNull(tree.search(10));
		Assert.assertNull(tree.getRoot().getLeft().getLeft());
	}

	@Test
	public void testDelete_하나의자식만갖는_노드삭제() {
		tree.delete(tree.search(40));
		Assert.assertNull(tree.search(40));
		Assert.assertEquals(tree.getRoot().getRight().getKey(), 35);
	}

	@Test
	public void testDelete_두개의자식을갖는_노드삭제() {
		tree.delete(tree.search(20));
		Assert.assertNull(tree.search(20));
		Assert.assertEquals(tree.getRoot().getLeft().getKey(), 25);
		Assert.assertNull(tree.getRoot().getLeft().getRight());
		Assert.assertEquals(tree.getRoot().getLeft().getLeft().getKey(), 10);
	}
}
