import java.io.*;
import java.util.Scanner;

//On my honor: 
//
//- I have not used source code obtained from another student, 
//or any other unauthorized source, either modified or 
//unmodified. 
//
//- All source code and documentation used in my program is 
//either my original work, or was derived by me from the 
//source code published in the textbook for this course. 
//
//- I have not discussed coding details about this project with 
//anyone other than my partner (in the case of a joint 
//submission), instructor, ACM/UPE tutors or the TAs assigned 
//to this course. I understand that I may discuss the concepts 
//of this program with other students, and that another student 
//may help me debug my program so long as neither of us writes 
//anything during the discussion or modifies any computer file 
//during the discussion. I have violated neither the spirit nor 
//letter of this restriction.

/**
 * The class containing the main method, the entry point of the application.
 *
 * @author jordanrw
 * @author mliu95
 * @version 1
 */
public class Rectangle1 {

    /**
     * The entry point of the application.
     *
     * @param args
     *            The name of the command file passed in as a command line
     *            argument.
     */
    public static void main(String[] args) {
        String fileIn = args[0];

        // scan in the information
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileIn));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileProcessor parser = new FileProcessor();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            parser.parseString(str);
        }
    }
}
