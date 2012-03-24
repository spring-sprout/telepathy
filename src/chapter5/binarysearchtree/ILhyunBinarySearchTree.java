package chapter5.binarysearchtree;

/**
 * @author ihseo
 * 이진검색트리
 */
public class ILhyunBinarySearchTree {
	
	private Node node;
	
	//=== insert
	public String insert(int insertKey){
		node = treeInsert(node, insertKey);
		
		if(node != null){
			//System.out.println("key " + insertKey+" 등록성공.");
			return "success";
		}
		else{
			//System.out.println("key " + insertKey+" 등록실패.");
			return "fail";
		}
	}

	public Node treeInsert(Node insertNode, int insertKey){
		// 새로운 노드 생성
		if(insertNode == null) {
			insertNode = new Node();
			insertNode.setKey(insertKey);
			insertNode.setRight(null);
			insertNode.setLeft(null);
			
			return insertNode;
		}
		
		// key 값이 존재하는 경우
		if(insertNode.getKey() == insertKey){
			return null;
		}
		
		// 노드의 키값보다 작은 경우 왼쪽 서브트리로 이동
		if(insertKey < insertNode.getKey()) insertNode.setLeft(treeInsert(insertNode.getLeft(), insertKey));
		// 노드의 키값보다 큰 경우 오른쪽 서브트리로 이동
		else if(insertKey > insertNode.getKey()) insertNode.setRight(treeInsert(insertNode.getRight(), insertKey));
		
		return insertNode;
	}

	//=== search
	public String search(int searchKey){
		Node result = treeSearch(node, searchKey);
		
		if(result != null){
			//System.out.println("key " + searchKey+" 검색성공.");
			return "success";
		}
		else{
			//System.out.println("key " + searchKey+" 검색실패.");
			return "fail";
		}
	}
	
	public Node treeSearch(Node searchNode, int searchKey) {
		if(searchNode == null || searchNode.getKey() == searchKey) return searchNode;
		
		// 노드의 키값보다 작은 경우 왼쪽 서브트리로 이동
		if(searchKey < searchNode.getKey()) return treeSearch(searchNode.getLeft(), searchKey);
		// 노드의 키값보다 큰 경우 오른쪽 서브트리로 이동
		else return treeSearch(searchNode.getRight(), searchKey);
	}

	//=== delete
	public String delete(int deleteKey){
		Node deleteNode = node; // 삭제할 Node
		Node parentNode = new Node(); // 부모 Node
		
		// 삭제할 Node 검색
		while(deleteNode != null){
			// 삭제할 Node find
			if(deleteNode.getKey() == deleteKey){
				treeDelete(deleteNode, parentNode);
				//=== success
				return "success";
			}
			// deleteKey 값이 작은 경우 왼쪽 검색
			else if(deleteNode.getKey() > deleteKey){
				parentNode = deleteNode;
				deleteNode = deleteNode.getLeft();
			}
			// deleteKey 값이 큰 경우 오른쪽 검색
			else {
				parentNode = deleteNode;
				deleteNode = deleteNode.getRight();
			}
		}
		
		return "fail";
	}
	
	public void treeDelete(Node deleteNode, Node parentNode){
		//System.out.println();
		//System.out.println("deleteNode: "+ deleteNode.getKey() + " [ " + deleteNode.getLeft() + " || " + deleteNode.getKey() + " || " + deleteNode.getRight() + " ]");
		//System.out.println("parentNode: "+ parentNode.getKey() + " [ " + parentNode.getLeft() + " || " + parentNode.getKey() + " || " + parentNode.getRight() + " ]");
		
		if(node.getKey() == deleteNode.getKey()) {
			node = deleteNode(deleteNode, parentNode);
		}
		
		else if(deleteNode == parentNode.getLeft()){
			parentNode.setLeft(deleteNode(deleteNode, parentNode));
		}
		else {
			parentNode.setRight(deleteNode(deleteNode, parentNode));
		}
	}
	
	public Node deleteNode(Node deleteNode, Node parentNode){
		if(deleteNode.getLeft() == null && deleteNode.getRight() == null) return null;
		else if(deleteNode.getLeft() == null && deleteNode.getRight() != null) return deleteNode.getRight();
		else if(deleteNode.getLeft() != null && deleteNode.getRight() == null) return deleteNode.getLeft();
		
		else {
			// 오른쪽 Node에서 제일 작은 Node
			Node temp = deleteNode.getRight();
			while(temp.getLeft() != null){
				parentNode = temp;
				temp = temp.getLeft();
			}
			
			deleteNode.setKey(temp.getKey());
			
			if(temp.getKey() == deleteNode.getRight().getKey()) deleteNode.setRight(temp.getRight());
			else parentNode.setLeft(temp.getRight());
			
			return deleteNode;
		}
	}
	
	//=== test
	public void print(){
		if(node != null){
			treePrint(node);
		}
		System.out.println();
	}
	
	public void treePrint(Node temp){
		if(temp != null){
			treePrint(temp.getLeft());
			System.out.print(temp.getKey() + "\t");
			// print
			//System.out.println("key: "+ temp.getKey() + " [ " + temp.getLeft() + " || " + temp.getKey() + " || " + temp.getRight() + " ]");
			//System.out.println();
			
			treePrint(temp.getRight());
		}
	}
}