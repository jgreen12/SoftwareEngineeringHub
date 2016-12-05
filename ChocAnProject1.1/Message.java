import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Message {
	
	 Scanner s = new Scanner(System.in); //scanner for input
	 String toUser;   //username
	 String fromUser;
	 String content;
	 
	 public Message(String toUser, String fromUser, String content){
		 this.toUser = toUser;
		 this.fromUser = fromUser;
		 this.content = content;
	  }

	
	public static void sendMessage(String message) throws IOException{
		message = "\n" + message;
		Files.write(Paths.get("messages.txt"), message.getBytes(), StandardOpenOption.APPEND);		
	}
	
	public static void recieveMessage(String type) throws IOException{
		File file = new File("messages.txt");
		Scanner scanner = new Scanner(file);
		String a;
		while(scanner.hasNextLine()){
			a = scanner.nextLine();
			if (a.toLowerCase().contains(type.toLowerCase())){
				Files.write(Paths.get("myMessages.txt"), a.getBytes(), StandardOpenOption.APPEND);
			}
		}
		scanner.close();
	}
	
	
	 public static String messagePrintout(String type) throws IOException{
			File file = new File("messages.txt");
			Scanner scanner = new Scanner(file);
			String a, b;
	                b = null;
	                int flag = 0;
			while(scanner.hasNextLine()){
				a = scanner.nextLine();
				if (a.toLowerCase().contains(type.toLowerCase())){
	                                if(flag == 0){
	                                    b = a + "\n";
	                                    flag++;
	                                }
	                                else{
	                                    b = b + a + "\n";
	                                }
				}
			}
			scanner.close();
	                return b;
		}
}
