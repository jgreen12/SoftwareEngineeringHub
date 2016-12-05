import java.io.*;
import java.util.Scanner;

public class MemberVerification {
	
	
	
	MemberVerification(String actorID) throws IOException{
//		File file = new File("actorDatabase.txt");
	}
	
	public static boolean checkMemberValidity(String actorID) throws IOException{
		File file = new File("actorDatabase.txt");
		String Line;
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()){
			Line = scanner.nextLine();
			if (Line.toLowerCase().contains(actorID.toLowerCase())){
				scanner.close();
				return true;
			}
		}
		scanner.close();
		return false;
	}
	
}
