import java.util.Scanner;

public class MailSystemTester {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		Console b = new Console(a);
		MailSystem c = new MailSystem(b);
		b.run(c);
	}
}
