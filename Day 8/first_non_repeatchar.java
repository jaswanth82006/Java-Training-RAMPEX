import java.util.Scanner;

public class first_non_repeatchar {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str=sc.nextLine();

        int[] freq = new int[26]; 
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)-'a']++;
        }

   
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)-'a'] == 1) {
                System.out.println(str.charAt(i));
                return;
            }
        }
    }
}
