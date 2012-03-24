package chapter5.binarysearchtree;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ihseo
 * 이진트리검색 테스트
 */
public class ILhyunBinarySearchTreeTest {
	
	private ILhyunBinarySearchTree bst;
	
	@Before
	public void setUp(){
		bst = new ILhyunBinarySearchTree();
	}

	@Test
	public void insertTreeTest() throws Exception {
		String result = "";
		result = bst.insert(10);
		assertThat(result, is("success"));
		
		result = bst.insert(5);
		assertThat(result, is("success"));
		
		result = bst.insert(13);
		assertThat(result, is("success"));
		
		result = bst.insert(3);
		assertThat(result, is("success"));
		
		result = bst.insert(6);
		assertThat(result, is("success"));
	}
	
	@Test
	public void duplicateKeyTest() throws Exception {
		bst.insert(10);
		bst.insert(5);
		bst.insert(13);
		
		// key 중복
		String result = bst.insert(10);
		assertThat(result, is("fail"));
	}
	
	@Test
	public void searchTreeTest() throws Exception {
		bst.insert(55);
		bst.insert(15);
		bst.insert(60);
		bst.insert(8);
		bst.insert(28);
		bst.insert(90);
		bst.insert(3);
		bst.insert(18);
		bst.insert(30);
		bst.insert(48);
		bst.insert(38);
		bst.insert(50);
		bst.insert(33);
		bst.insert(32);
		bst.insert(36);
		
		bst.print();
		
		//search Test
		//=== success
		String resultS = "";
		
		resultS = bst.search(30);
		assertThat(resultS, is("success"));
		resultS = bst.search(8);
		assertThat(resultS, is("success"));
		
		//=== fail
		String resultF = "";
		
		resultF = bst.search(99);
		assertThat(resultF, is("fail"));
		resultF = bst.search(2);
		assertThat(resultF, is("fail"));
		
	}
	
	@Test
	public void deleteTreeTest() throws Exception {
		bst.insert(55);
		bst.insert(15);
		bst.insert(60);
		bst.insert(8);
		bst.insert(28);
		bst.insert(90);
		bst.insert(63);
		bst.insert(50);
		bst.insert(73);
		bst.insert(32);
		
		bst.print();
		//=== success
		String resultS = "";

		resultS = bst.delete(63);
		assertThat(resultS, is("success"));
		bst.print();

		resultS = bst.delete(60);
		assertThat(resultS, is("success"));
		bst.print();
	}
}
