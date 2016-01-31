import java.io.*;
import java.util.Scanner;

/**
 * { your description of the project here }
 */

/**
 * The class containing the main method, the entry point of the application.
 *
 * @author jordanrw
 * @author mliu95
 * @version 1
 */
public class Rectangle1
{

	/**
	 * The entry point of the application.
	 *
	 * @param args
	 *            The name of the command file passed in as a command line
	 *            argument.
	 */
	public static void main(String[] args)
	{
		if (args.length != 1) {
			System.out.println("Not correct number of arguments");
			//            System.exit(0);
		}

		String fileIn = args[0];

		//scan in the information
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(new File(fileIn));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		FileProcessor parser = new FileProcessor();

		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
			parser.parseString(str);
		}
	}
}
