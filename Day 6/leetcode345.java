//345. Reverse Vowels of a String
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (isVowel(arr[start]) && isVowel(arr[end])) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } 
            else if (!isVowel(arr[start])) {
                start++;
            } 
            else {
                end--;
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
