

//FOR PROJECET 
public class Node {
private int value;
private String name; 

private Node parent;
private Node noChild;
private Node yesChild;

private Node left;
private Node right;

	public Node(int value, String name) {
		this.value = value;
		this.name = name;
	}
	public Node getParent() {
		return this.parent;
	}
	public Node[] getChildren() {
	Node[] NodeArray = new Node[] {noChild, yesChild};
	return NodeArray;
		
	}
	public String getName() {
		return this.name;
		}
	public int getValue() {
		return this.value;

}
	public Node getLeft() {
		return this.left;
	}
	public Node getRight() {
		return this.right;
	}
	public void setLeft(Node newLeft) {
		this.left= newLeft;
	}
	public String setName(String newName) {
		return this.name= newName;
	}
	public void setRight(Node newRight) {
		this.right=newRight;
	}
	public void setParent(Node newParent) {
		this.parent = newParent;
	}
	public void setValue(int newValue) {
		// TODO Auto-generated method stub
		this.value= newValue;
	}
}

