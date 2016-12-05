import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Message {
    /*Here to Line 73 are my modifications */
    /*public List<Message> messageItem = new ArrayList<>();  //list of objects   
    Scanner s = new Scanner(System.in); //scanner for input
    String toUser;   //username
    String fromUser;
    String content;
    
    public Message(){
        
    }
    public Message(String toUser, String fromUser, String content){
        this.toUser = toUser;
	this.fromUser = fromUser;
	this.content = content;
    }
    
    public void readMessagesFile(){    //reads inventory from file
        //messageItem = new ArrayList<>();
        try{
            //create buff read with an instance of file read
            BufferedReader br = new BufferedReader(new FileReader("messages.txt"));
            //read line
            String fileRead = br.readLine();
            while(fileRead != null){
		//use string.split to load a string array with the values from each line
		//of the file using a comma as a delimiter
		String[] tempHold = fileRead.split(", ");
                String t0 = tempHold[0];
                String t1 = tempHold[1];
                String t2 = tempHold[2];
                      
		Message tempObj = new Message(t0, t1, t2);
		messageItem.add(tempObj);
                fileRead = br.readLine();
            }
            br.close();
        }
        catch(FileNotFoundException fnfe){
            System.out.println("file not found");
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }   
    //public void writeMessagesFile(String toUser, String fromUser, String content){
    public void writeMessagesFile(String toUser, String fromUser, String content){
        Message message = new Message(toUser, fromUser, content);
        readMessagesFile();
        messageItem.add(message);
        
	try(Writer writer = new BufferedWriter((new OutputStreamWriter(new FileOutputStream("messages.txt"))))){
            
            for(Message each: messageItem){
		writer.write(each+"\n");
            }
            writer.close();
        }
        catch(IOException ex){
            
        }
    
    }*/
    
    
    
    
    
    
	public static void sendMessage(String to, String from, String content) throws IOException{
                String message = to+", "+from+", "+content;
		Files.write(Paths.get("messages.txt"), message.getBytes(), StandardOpenOption.APPEND);		
	}
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
