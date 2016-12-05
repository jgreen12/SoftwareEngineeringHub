/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*For the moment I've commented out the package in case you have something different*/


//package chocandatabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Josh
 */
public class ModifyActors {
    public void newActor(String actorInfo) throws IOException{
        if(!MemberVerification.checkMemberValidity(actorInfo)){
            System.out.println("Actor already present");
            return;
        }
        Files.write(Paths.get("actorDatabase.txt"), actorInfo.getBytes(), StandardOpenOption.APPEND);
        System.out.println("Actor Added");
    }
    public void removeActor(String actorInfo)throws IOException{
        if(MemberVerification.checkMemberValidity(actorInfo)){
            
            File inputFile = new File("actorDatabase.txt");
            File tempFile = new File("actorDataTemp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = actorInfo;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 
            boolean successful = tempFile.renameTo(inputFile);
            System.out.println("Actor Removed");
        }
        
    }
    public void alterActor(String actorInfo, String newActorInfo) throws IOException{
        if(MemberVerification.checkMemberValidity(actorInfo)){
            //input alterations
            //write to file
            
            File inputFile = new File("actorDatabase.txt");
            File tempFile = new File("actorDataTemp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = actorInfo;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)){
                    currentLine = newActorInfo;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 
            boolean successful = tempFile.renameTo(inputFile);
            System.out.println("Actor Removed");
        }
    }
    
}