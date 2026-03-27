public class wordcount {
    public static void main(String[] args) {
        String str = "Hello world this is Java";
        
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
        
            if ((str.charAt(i)!=' ') && (i == 0 || str.charAt(i - 1)==' ')) {
                count++;
            }
        }

        System.out.println("Word count: " + count);
    }
}