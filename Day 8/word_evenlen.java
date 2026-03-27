import java.util.Scanner;

public class word_evenlen {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int count=0;
        String s2="";
        String S=sc.nextLine();
        for(char ch : S.toCharArray()){
            if(ch != ' ') {
                count++;
                s2+=ch;

            }
            else{
                count =0;
                
             if(s2.length()%2==0){
                System.out.print(s2+" ");
             }   
             s2="";                                 // if use srtingbulider then "s2.setLength(0);"

            }
        }
         if(s2.length()%2==0){
                System.out.print(s2+" ");
        }   

    }
}
