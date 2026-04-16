import java.io.File;
import java.io.IOException;

public class FileEx {
    public static void main(String[] args) throws IOException {
        File newFile = new File("test.txt");
        if(newFile.createNewFile()){
            System.out.println("File Created!");
        }
        else{
            System.out.println("Already Exists");
        }
    }    
}
