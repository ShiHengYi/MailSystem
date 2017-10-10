import java.util.ArrayList;
import java.util.Scanner;
public class MailSystem{
	
	private Scanner myScanner;
	private Console c;
	private ArrayList<User> user;
	
	public MailSystem(Console con){
		c = con;
		myScanner = new Scanner(System.in);
		user = new ArrayList<User>();
	
	}


	public User findUser(String name){
		
		for(User a : user){
			if (a.getName().equals(name)) return a;
		}
		return null;
	}


	public void login() {
		c.speak("User name:");
		String in1 = myScanner.next();
		c.speak("Password:");
		String in2 = myScanner.next();
		User current = findUser(in1);
		if(!current.checkPasscode(in2)){
			c.speak("Welcome to TextChat.");
			return;
		}
		else{
			c.speak("Welcome "+in1);
			userManue(in1);
			return;
			
		}
	} 
	
	public void sendMessage(String in1){
		c.speak("To:");
		String a = myScanner.next();
		User sendTo = findUser(a);
		
		if(sendTo!= null){
			c.speak("Message text, . to end:");
			String send = myScanner.next();
			if(send.equals("."))userManue(in1);	
			
			while(myScanner.hasNext()){
				String b = myScanner.next();
				if(b.equals(".")){
					sendTo.getBox().addMessage(in1,send);
					c.speak("Message sent.");
					userManue(in1);
					return;
					}
				send += "\n" +b;
				}
				
			}
		
		else{
			c.speak("Message text, . to end:");
			String send = myScanner.next();
			while(myScanner.hasNext()){
				String b = myScanner.next();
				if(b.equals(".")){
					c.speak("Message not sent.");
					userManue(in1);
					return;
				}
			}					
		}
	}
	
	
	public void userManue(String in1){
		c.speak("[S]end message  [R]ead messages  [L]ogout:");
		String temp = myScanner.next();
		
		if(temp.equalsIgnoreCase("S")){
			sendMessage(in1);
			return;
			
		}
		if(temp.equalsIgnoreCase("R")){
			read(in1);
		}
		if(temp.equalsIgnoreCase("L")){
			c.speak("Welcome to TextChat.");
			return;
		}
		
	}
	
	public void read(String in1){
		User a = findUser(in1);
		if(a.getBox().getName()!=null){
		String name = a.getBox().getName();
		String message = a.getBox().getMessage();
		
		c.speak("From: "+name);
		c.speak(message);
		c.speak("[K]eep  [E]rase");
		String s = myScanner.next();
		if(s.equalsIgnoreCase("K")){
			a.getBox().keep();
			}
		if(s.equalsIgnoreCase("E")){
			a.getBox().erase();
			}
		}
		else{
			userManue(in1);
			return;
		}
		
		
		c.speak("[N]ext  [D]one with messages:");
		String s2 = myScanner.next();
		if(s2.equalsIgnoreCase("N")){
			read(in1);
		}
		else if(s2.equalsIgnoreCase("D")){
			userManue(in1);
			return;
		}
		
	}
	
	public void createNewUser() {
		c.speak("Select a user name:");
		String in1 = myScanner.next();
		c.speak("Select a password:");
		String in2 = myScanner.next();
		if(findUser(in1)!=null){
			c.speak("User not added.");
			c.speak("Welcome to TextChat.");
			return;
		}
		user.add(new User(in1,in2));
		c.speak("User added.");
		c.speak("Welcome to TextChat.");
	}
	
	
}