
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnimalTree {
private Node root;
//private File file= new File ("tree.txt"); //scope issue
private int size = 0;
private int currentValue = 0;
private  int cValue = 0;

	public AnimalTree() throws FileNotFoundException {
		this.root= null;
		Scanner sc = new Scanner(new FileReader("tree.txt"));
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String [] linearray = line.split(",");
			int value=Integer.parseInt(linearray[0]);
			String name = linearray[1]; 
			//System.out.println(value + " " + name);
			insertItems(value, name);
		}
			
	}

	
	public void insertItems(int value, String name) {
   		if(root==null) {
			root=new Node(value,name);
		}
		else {
			Node currentNode = root;
			boolean placed = false; 
			
			while(!placed) {
				if(currentNode.getValue()==value) {
					placed= true;
					System.out.println("duplicate value: not allowed");
				}
				
				else if( value < currentNode.getValue()) { //was else if
					//left -> insert Node
				if(currentNode.getLeft()==null) {
					currentNode.setLeft(new Node(value,name));
					currentNode.getLeft().setParent(currentNode);
					placed=true;
				
				}
				else {
					//othewise just move Left
					currentNode =currentNode.getLeft();
				}
				}else {//move to the Right
					if(currentNode.getRight()==null) { // cant move right -> insert new node
					currentNode.setRight(new Node(value,name));
					currentNode.getRight().setParent(currentNode);
					placed=true;
				}else {
					//move right
					currentNode = currentNode.getRight();
				}
			}

			}
		}
   		//updateNodeNumbers(root);
	}
	
	
//	public void insertItems(int value, String name) {
//		if (root ==null) {
//			root= new Node(value,name);	
//		}
//		else if(value<root.getValue()) {
//			root.getLeft()=insertItems(root.getLeft(),value)
//		}
//		
//	}
		public void breathSearch() {
			Queue<Node> queue = new LinkedList<Node>();
			if(root != null) {
				queue.add(root);
				
				while(!queue.isEmpty()) {
					Node node = queue.remove();
					System.out.println(node.getName());
					for ( Node n : node.getChildren()) {
						queue.add(n);
						size++;
					}
				}
				}	
				}
		
		//new insert method to insert to the l to the r and then traverse tree to update rest off tree ( inorder)
	
		public void newInsertInOrder(Node c, String newLname, String newRname) {
		Node current = c;
		Node l = new Node (7,newLname);
		Node R = new Node (7,newRname);
		current.setLeft(l);//yes
		l.setParent(current);
		current.setRight(R);
		R.setParent(current);
		updateNodeNumbers(root);
//		if(root!=null) {
//			newInsertInOrder(current.getLeft());
//			newInsertInOrder(current.getRight());
//		}
		
	}
		/*
		public Node getRoot() {
			return this.root;
		}
		public void printTree(Node n){
			if(n == null) {
				return;
			}
			else {
				System.out.println(n.getValue());
				printTree(n.getLeft());
				printTree(n.getRight());
			}
			
		}
		*/
		//update numbers
		
//		public void inOrder(Node n) {
//			if(n == null) {
//				return;
//			}
//			else {
//				printTree(n.getLeft());
//				System.out.println(n.getValue());
//				printTree(n.getRight());
//			}
		   // Inorder traversal to update node numbers
	    public void updateNodeNumbers(Node root) {
	        //cValue = 0; // Reset counter
	        reNumberInOrder(root);
	    }
		
		public void reNumberInOrder(Node root) {
			if(root==null) {
				return;
			}
				reNumberInOrder(root.getLeft());
				reNumberInOrder(root.getRight());
			}
		
		//printTree(root.getLeft());
		//System.out.println(root.getValue());
		//printTree(root.getRight());
	
		
		
		public void identifyAnimal () {

			LinkedList<String> path = new LinkedList<String>();
			path.add(root.getName());
			Node current = root; //start at root
			while(current.getLeft()!=null && current.getRight() !=null) { // while neither children is null aka not a leaf
				//System.out.println("test");
				Scanner scanner = new Scanner (System.in);
				
				System.out.println("Is this animal "+ current.getName()); //ask about root
				String input=scanner.nextLine();
				if(input.equals("Y")) { //if animal = Y go left 
				//System.out.println("test2 ");
				current= current.getLeft();
				//System.out.println("Is this animal "+current.getName());
				//current= current.getLeft();
				path.add(current.getName());
				
				}
				if(input.equals("N")) {
				//System.out.println("Is this animal "+current.getName());
				//current=current.getChildren()[0];	
				current=current.getRight();
				path.add("not "+current.getName());
				
				}
				if(current.getRight()==null && current.getLeft()==null) {	//is leaf
					  System.out.println("Hmmm...I think I know.");
					  System.out.println("Is it "+current.getName()+"?");
					  input=scanner.nextLine();
					    if(input.equals("Y")) {
					    	 System.out.println("Good!All done." );
					    }
					    if(input.equals("N")) {
					    	 System.out.println("I was wrong...");
					    	int pathLenth= path.size();
					    	 path.remove(pathLenth-1);
					    	 
					    	
					    	 System.out.println("I dont know any are "+ path); 
					    	 System.out.println("What is this new animal? >");
					    	 String newAnimal=scanner.nextLine(); //new animal name
					    	 System.out.println("What characteristic does "+ newAnimal+ " have that "+current.getName()+ "does not?");
					    	 String newCharacteristic =scanner.nextLine();
					    	 
					    	 //current.setName(newCharacteristic)
					    	 String oldAnimal = current.getName();
					    	 current.setName(newCharacteristic);
					    	 //Create two new child nodes at current leaf.
					    	 newInsertInOrder(current,newAnimal, oldAnimal );
					    	 //call renumber function that is inorder 
					    	 reNumberInOrder(root);
							}
						}
				}
			}
				
		
				
			
			
		//part 3
		//print tree
		/*
		
		public Node getRoot() {
			return this.root;
		}
		public void printTree(Node n){
			if(n == null) {
				return;
			}
			else {
				System.out.println(n.getValue());
				printTree(n.getLeft());
				printTree(n.getRight());
			}
			
		}
		//update numbers
		public void inOrder(Node n) {
			if(n == null) {
				return;
			}
			else {
				printTree(n.getLeft());
				System.out.println(n.getValue());
				printTree(n.getRight());
			}
			
		}
		
		public void breathFileWrite() throws IOException {
			Queue<Node> queue = new LinkedList<Node>();
		
			if(root != null) {
				queue.add(root);
			}
				while(!queue.isEmpty()) {
					Node node = queue.remove();
					//System.out.println(node.getName());
					FileWriter fwriter = new FileWriter("tree.txt");
					fwriter.write(node.getValue()+","+node.getName());
					for ( Node n : node.getChildren()) {
						queue.add(n);
					}
					
				}
				}	
				*/
		
//		//save to new file
//			public class CreateFile{
//				File myObj = new File("tree.txt");
//				if(myObj.createNewFile()) {
//				}
//		}
 
		//Save to file
		
		public void breathSearchTagSave() throws IOException {
			BufferedWriter writer = new BufferedWriter(new FileWriter("tree.txt"));
			Queue<Node> queue = new LinkedList<Node>();
			if(root != null) {
				queue.add(root);
				
				while(!queue.isEmpty()) {
					Node node = queue.remove();
					//System.out.println(node.getName());
					for ( Node n : node.getChildren()) {
						queue.add(n);
						String nodeInfo= node.getValue()+node.getName();
						writer.write(nodeInfo);
						size++;
					}
				}
				}	
		}
}



		



	



