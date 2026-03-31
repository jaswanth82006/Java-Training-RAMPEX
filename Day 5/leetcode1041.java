//1041. Robot Bounded In Circle
class Solution {
    public boolean isRobotBounded(String instructions) {
        int r = 0, c = 0;
        int dir = 0; 
        
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                if (dir == 0) r++;        
                else if (dir == 1) c++;   
                else if (dir == 2) r--;   
                else c--;                 
            } 
            else if (ch == 'L') {
                dir = (dir + 3) % 4; 
            } 
            else if (ch == 'R') {
                dir = (dir + 1) % 4; 
            }
        }
        return (r == 0 && c == 0) || dir != 0;
    }
}
