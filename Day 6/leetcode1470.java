//1470. Shuffle the Array
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans1[]=new int[n];
        int ans2[]=new int[n];
        int ans[]=new int[2*n];
        for(int i=0;i<n;i++){
            ans1[i]=nums[i];
            ans2[i]=nums[i+n];
        }
       int j=0,k=0;
       while(j<2*n){
        ans[j++]=ans1[k];
        ans[j++]=ans2[k];
        k++;
       }
       return ans;
    }
}
