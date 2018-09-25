/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.pkg1;

import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**This program is aim to translate a technical documentation from English to French using dictionary
 *
 * @author Akila
 */
public class Test1 {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //extractTextFromHtmlDOc();
        HandlingFiles hf = new HandlingFiles();
        List<String> fileNames = new ArrayList<>();
        fileNames=hf.fileList("dist/javadoc/test/pkg1/");
        /**
         * Here the use of the collection Iterator
         */
        System.out.println("=====Files without filter============");
        Iterator<String> it= fileNames.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            
        }
        System.out.println("=====Files w/ filter============");
        
        /**
         * Here we use the lamda expressions to filter the name of the file
         * if not an html file so no need to store it in the list
         */
        List<String> collect  = fileNames.stream().filter(x->x.toUpperCase().contains(".HTML")).collect(Collectors.toList());
        collect.forEach(System.out::println);
        
        List<String> filesTxt = new ArrayList<>();
        List<Long> filesTxtWords = new ArrayList<>();
        List<Long> maxWords = new ArrayList<>();
        List<Long> minWords = new ArrayList<>();
        Iterator<String> it2=collect.iterator();
        while (it2.hasNext()) {
            String FilePath = it2.next();
            String next = hf.getTextFromHtmlDoc(FilePath);
            //hf.WriteInTxtFile(FilePath, next);
            filesTxt.add(next);
            filesTxtWords.add(Pattern.compile(" ").splitAsStream(next).count());
            System.out.println("-------------------------------------------------------------");
            System.out.println("Words in file : "+FilePath + " are : "+Pattern.compile(" ").splitAsStream(next).count());
            List<String> wrd = Arrays.asList(next.split(" "));
            System.out.println("Max Length word in  : "+FilePath + " is : "+wrd.stream().max(Comparator.comparingInt(String::length)));
            System.out.println("Max Length word in  : "+FilePath + " is : "+wrd.stream().min(Comparator.comparingInt(String::length)));
            
        }
        
        //filesTxt.forEach(x->x.split(" ").count());
        //List<Integer> filesTxtSen = Pattern.compile(",").splitAsStream(string);
        //filesTxt.forEach(System.out::println);
        //filesTxtWords.forEach(System.out::println);
        
        
        
        /*
        Map<String, String> dictionary = new HashMap();
        List<String> docs = new ArrayList<String>();
        dictionary = hf.readFileIntoHashMap("res/file1.txt");
        Iterator it1 = dictionary.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry pair = (Map.Entry)it1.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it1.remove(); // avoids a ConcurrentModificationException
        }
        
        docs = hf.readFileDocumentation();
        List<String> lines = new ArrayList<String>();
        for (int i=0; i< docs.size(); i++){
            StringBuilder result = new StringBuilder();
            StringTokenizer st = new StringTokenizer(docs.get(i), " ");
            while (st.hasMoreTokens()) {
            String key = st.nextToken();
            String translatedWord = dictionary.get(key);
            if (translatedWord != null) {
                result.append(translatedWord);
            } else {
                result.append("*" + key + "*"); // Unknown word
            }
            result.append(" ");
            }

            lines.add(result.toString());
            System.out.println(result.toString());
            
        }
        */
    }
    
}
