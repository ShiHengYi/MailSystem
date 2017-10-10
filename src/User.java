public class User {
	private MailBox myBox;
	private String name;
	private String passcode;
	public User(String a,String b) {
		name = a;
		passcode = b;
		myBox = new MailBox();
	}

	public MailBox getBox(){
		return myBox;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean checkPasscode(String a){
		return a.equals(passcode);
	}
	
}