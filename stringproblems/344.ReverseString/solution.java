/*
 * Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.
 */

 // 双指针

class Solution {
    public void reverseString(char[] s) {
        int begin = 0;
        int end = s.length - 1;
        while(begin < end){
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;
            end--;
        } 
    }
}