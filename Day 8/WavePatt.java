import java.util.*;
public class WavePatt {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        String s2="";
        String s=sc.next();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(i%2==0)sb.append(ch);
            else s2+=ch;
        }
        sb.append(s2);
        System.out.println(sb);
    }
}
