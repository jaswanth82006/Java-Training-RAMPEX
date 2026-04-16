import java.util.ArrayList;
import java.util.Arrays;


public class Alist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,4,3,4,5,6,7,8));
      for(int i=0;i<list.size();i++){
            if(list.get(i)%2==0){
                list.remove(i);
                i--;
            }
       

       // Set<Integer> l1 =  new HashSet<>(list);    //Duplicate remove
        System.out.println(list);
        
        }
    }
}
