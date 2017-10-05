import java.net.*;
import java.io.*;

public class sc1 {
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader inputreader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Which person would you like to look up? ");
        String id = inputreader.readLine();
        
        URL url = new URL("http://www.ecs.soton.ac.uk/people/"+id);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        //the above lines heavily inspired by websites (I don't have the book)
        //http://www.codejava.net/java-se/file-io/3-ways-for-reading-input-from-the-user-in-the-console
        //https://alvinalexander.com/blog/post/java/how-open-read-url-java-url-class-example-code
        
        String current;
        
        for (int i=0;i<8;i++) {
            current = reader.readLine(); //I couldnt work out how to go directly to a specific line, so I'm doing it the lazy and inefficient way
        }
        
        String lastline = reader.readLine();
        
        int character = 11;
        
        do {
           character = character + 1;
        
        } while (!lastline.substring(character,character+1).equals("|")); //the bar must be detected rather than the space because people's names usually have spaces in them
        
        System.out.println(lastline.substring(11,character-1)); //the -1 takes off the space
        
    }
}