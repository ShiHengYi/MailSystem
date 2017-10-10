import java.util.Scanner;
public class Console{
private Scanner myScanner;

public Console(Scanner scan) {
	myScanner = scan;
}

public void speak(String output){
      System.out.println(output);
}

public void run(MailSystem c) {
    boolean more = true;
    
    System.out.println("Welcome to TextChat.");
    while (more) {
    	
    	speak("[L]ogin  [N]ew user  [Q]uit:");
      	String input = myScanner.next();
        if (input == null) return;
        if (input.equalsIgnoreCase("L")){
        	c.login();
        }
        else if (input.equalsIgnoreCase("Q"))more = false;
        else if (input.equalsIgnoreCase("N"))c.createNewUser();
      }

   }



}