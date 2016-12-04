import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Message {
	
	public static void sendMessage(String message) throws IOException{
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
}
