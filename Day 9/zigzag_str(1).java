import java.util.Scanner;
public class zigzag_str{
  
public static String zigzag(String S, int N){

    if (N==1) return S;
    StringBuilder[] rows = new StringBuilder[N];
    StringBuilder ans = new StringBuilder();
    for(int i=0;i<N;i++){
        rows[i]= new StringBuilder();
    }

    int curr=0; boolean goingup=true;
    for( char ch : S.toCharArray()){
        rows[curr].append(ch);
        if(curr==0||curr==N-1){
            goingup=!goingup;
        }
        curr+= (goingup)?-1:1;
    }
    for(StringBuilder row: rows){
        ans.append(row);
    }
    return ans.toString();
}


  public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String S= sc.next();
        int N = sc.nextInt();
        System.out.println(zigzag(S,N));
    }





}