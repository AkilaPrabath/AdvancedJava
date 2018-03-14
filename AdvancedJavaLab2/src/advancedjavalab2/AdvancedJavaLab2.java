/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedjavalab2;

/**
 *
 * @author akila
 */
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.nio.file.attribute.BasicFileAttributes;
public class AdvancedJavaLab2 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        createDirectory();
        
        createFile();
        copyFile();
       showPermissions();
       createMoveandDelete();
       
    }
    public static void createDirectory(){
       Path path = Paths.get("D:\\Study Materials\\semster 2\\Advanced Java\\tests");
        try {
            Path newDir = Files.createDirectory(path);
            System.out.println("Directory created" );
        } catch(FileAlreadyExistsException e){
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
    public static void createFile(){
         Path path = Paths.get("D:\\Study Materials\\semster 2\\Advanced Java\\tests\\testFile.txt");
        try {
            Files.createFile(path);
              System.out.println("File created" );
        } catch(FileAlreadyExistsException e){
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
    }
    
    public static void copyFile(){
        Path sourcePath = Paths.get("D:\\Study Materials\\semster 2\\Advanced Java\\tests\\testFile.txt");
        Path destinationPath = Paths.get("D:\\Study Materials\\semster 2\\Advanced Java\\test2\\testFile.txt");
            try {
             Files.copy(sourcePath, destinationPath);
               System.out.println("files copied to new file" );
            } catch(FileAlreadyExistsException e) {
            } catch (IOException e) {
                 e.printStackTrace();
                }

    }
    
    public static void showPermissions(){
        Path filePath = Paths.get("D:\\Study Materials\\semster 2\\Advanced Java\\test2\\testFile.txt");
        System.out.println("File is readable: " + Files.isReadable(filePath));
        System.out.println("File is  writable: " + Files.isWritable(filePath));
        System.out.println("File is  executable: " + Files.isExecutable(filePath));
    }
    
    public static void createMoveandDelete(){
        Path pathOld = Paths.get("D:\\Study Materials\\semster 2\\Advanced Java\\test2\\testFile.txt");
        Path pathnew = Paths.get("D:\\Study Materials\\semster 2\\Advanced Java\\tests3");
        String original = "D:\\Study Materials\\semster 2\\Advanced Java\\tests";
        try {
            Path newDir = Files.createDirectory(pathnew);
            Files.move(pathOld, pathnew.resolve(pathOld.getFileName()), REPLACE_EXISTING);
              System.out.println("Files moved" );
            deleteRecursively(original);
            
        } catch(FileAlreadyExistsException e){
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void deleteRecursively(String path){
        Path rootPath = Paths.get(path);
        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
                    throws IOException {
                System.out.println("delete file: " + file.toString());
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) 
                    throws IOException {
                Files.delete(dir);
                System.out.println("delete dir: " + dir.toString());
                return FileVisitResult.CONTINUE;}});
        } catch(IOException e){e.printStackTrace();
        }
    }
    
}
