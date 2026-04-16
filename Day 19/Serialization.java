import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;


class Student implements Serializable{
    String name; int mark;
    Student(String name,int mark){
        this.name=name;
        this.mark=mark;
    }
}
class CustomObjectOutputStream extends ObjectOutputStream{
    CustomObjectOutputStream(OutputStream objS) throws IOException{
        super(objS);
    }
    @Override
    protected void writeStreamHeader(){

    }
}

public class Serialization{
        public static void main(String[] args) throws IOException {
        Student s= new Student("Abc",98);
        File file= new File("Student.txt");
        FileOutputStream fo= new FileOutputStream(file,true);
       // ObjectOutputStream obj = new ObjectOutputStream(fo);
        
       if(file.length()==0){
        ObjectOutputStream obj = new ObjectOutputStream(fo);
       }
       else{
        ObjectOutputStream obj = new CustomObjectOutputStream(fo);
       }
       obj.writeObject(s);
        fo.close();
        obj.close();
    }
}