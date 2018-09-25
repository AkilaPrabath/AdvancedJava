/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.pkg1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
 *
 * @author Akila
 */
public class HandlingFiles {
    /**
     * this function return the file names from a directory
     * @param directory
     * @return 
     */
    public static List<String> fileList(String directory) {
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {}
        return fileNames;
    }
    /**
     * This function read content of a file
     * @param filePath
     * @return 
     */
    public String getContentOfFile(String filePath){
        Path path = Paths.get(filePath);
        String cont="";
        try{
            List contents = Files.readAllLines(path);
            //Read from the stream
            for(Object content:contents){//for each line of content in contents
            //System.out.println(content);// print the line
            cont=cont.concat(content.toString());
            }
          }catch(IOException ex){
          ex.printStackTrace();//handle exception here
        }
        return cont;
    }
    
    /**
     * This function return the text from an HTML file
     * @param filePath
     * @return 
     */
    public String getTextFromHtmlDoc(String filePath){
        Path path = Paths.get(filePath);
        String cont="";
        try{
            List contents = Files.readAllLines(path);
            //Read from the stream
            for(Object content:contents){//for each line of content in contents
            //System.out.println(content);// print the line
            cont=cont.concat(content.toString());
            }
          }catch(IOException ex){
          ex.printStackTrace();//handle exception here
        }
        Document doc = Jsoup.parse(cont);
        String txt = doc.body().text();
        //System.out.println(txt);
        return txt;
    }
    
    /**<p>This procedure read a file line by line </p>
     * <p>It takes data from the file and store it in a hashmap</p>
     * @return 
     */
    public static Map<String, String> readFileIntoHashMap(String filePath){ 
        Map<String, String> dictionary = new HashMap();
        Path path = Paths.get(filePath);
        String cont="";
        try{
            List contents = Files.readAllLines(path);
            //Read from the stream
            for(Object content:contents){//for each line of content in contents
            //System.out.println(content);// print the line
                String[] txtTranslated = content.toString().split("=");
                dictionary.put(txtTranslated[0], txtTranslated[1]); 
            }
          }catch(IOException ex){
          ex.printStackTrace();//handle exception here
        }
        return dictionary;
    }
    
    public static List<String> readFileDocumentation(){
       BufferedReader br = null;
        String strLine = "";
        List<String> documentation = new ArrayList<String>();
        try {
            br = new BufferedReader( new FileReader("res/file2.txt"));
            while( (strLine = br.readLine()) != null){
                if (!strLine.equals("")) {
                   documentation.add(strLine);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return documentation;
    }
}
