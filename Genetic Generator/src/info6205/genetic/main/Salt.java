/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.genetic.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aditya
 */
public class Salt {
    
    public String generateRandomPassword(String fName, String lName, String dob, String email, String phoneNo) throws FileNotFoundException, IOException
    {
        String saltString = readFile();
        String targetString = concatenateStrings(fName, lName, dob, email, phoneNo, saltString);
        return null;
    }

    private String readFile() {
        try {
            File file = new File("./Salt.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));    
            String randomLine = getRandomLine(br);
            return randomLine;
        } catch (IOException ex) {
            Logger.getLogger(Salt.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private String getRandomLine(BufferedReader br) {
        try {
            String line;
            int lineCount = 0;
            while( (line=br.readLine())!=null )
            {
                lineCount++;
                System.out.println(lineCount+"\t"+line);
            }
            int randomLineNumber = new Random().nextInt(lineCount);
            System.out.println("Random line no : "+randomLineNumber); 
            String randomLine = Files.readAllLines(Paths.get("./Salt.txt")).get(randomLineNumber);
            System.out.println(randomLine);
            return randomLine;
        } catch (IOException ex) {
            Logger.getLogger(Salt.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private String concatenateStrings(String fName, String lName, String dob, String email, String phoneNo, String saltString) {
        StringBuilder builder = new StringBuilder();
        builder.append(fName).append(dob).append(email).append(saltString).append(phoneNo).append(lName);
        return builder.toString();
    } 
}
