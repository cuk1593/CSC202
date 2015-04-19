import javax.swing.*;
import java.util.Scanner;

public class DefaultClass {

    public static String output = "";

    public static void main(String[] args) {

        int num;
        Scanner scancheck = new Scanner(System.in);

        String input = JOptionPane.showInputDialog("\n Make a selection from the following:"
                + "\n 1. Insert an item into the tree."
                + "\n 2. Delete an item from the tree."
                + "\n 3. Print the tree in in order."
                + "\n 4. Print the tree using post order."
                + "\n 5. Count the number of nodes in the tree."
                + "\n 6. Exit program.");

        int inputInt = Integer.parseInt(input);
        BinarySearchTree bst = new BinarySearchTree();



        switch (inputInt) {
            case 1:
                num = scancheck.nextInt();
                bst.insert(num);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                int exit = JOptionPane.showConfirmDialog(null, "Exit?", null, JOptionPane.YES_NO_OPTION);
                if(exit == JOptionPane.YES_OPTION) {
                    output += "End of program";
                    System.exit(0);
                }
                else if (exit == JOptionPane.NO_OPTION) {

                }
        }


    }

}
