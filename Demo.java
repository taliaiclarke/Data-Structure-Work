
import java.io.IOException;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) throws IOException {
 			AnimalTree bst = new AnimalTree();
			System.out.println("Do you have another animal to identify? (Y/N) > ");
			Scanner sc = new Scanner (System.in);
			String input=sc.nextLine();
			while(input.equals("Y")){
				bst.identifyAnimal();
				System.out.println("Do you have another animal to identify? (Y/N) > ");
				input=sc.nextLine();
			}
			while(input.equals("N")) {
				bst.breathSearchTagSave();
				
			}
		
			//bst.printTree(bst.getRoot());
			
			//IF y call method 
			//if no save tree
			
	}
}
