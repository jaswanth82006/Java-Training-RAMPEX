import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fileread{
    public static void main(String[] args){
        try{
            BufferedReader fr=new BufferedReader(new FileReader("test.txt"));
            //FileReader fr=new FileReader("test1.txt");
            String line;
            //int character;
            /*while((character=fr.read())!=-1){
                System.out.print((char)character);
            }*/
            while((line=fr.readLine())!=null){
                System.out.println(line);
            }
            fr.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}   