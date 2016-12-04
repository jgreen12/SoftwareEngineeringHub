import java.io.*;

public class Enroll {
	
	public static boolean enroll(String actorId, String actorType, String fName, String lName, String eMail) throws IOException{
		if (MemberVerification.checkMemberValidity(actorId)){
			return false;
		}
		else{
			String message = ("Provider guest Requesting membership - " + actorType + " " + fName  + " " + lName + " " + eMail);
			Message.sendMessage(message);
			return true;
		}
	}
	
	public static void unEnroll(String actorId) throws IOException{
		actorId = ("Provider " + actorId + " - Requesting cancelation of membership");
		Message.sendMessage(actorId);
	}
}