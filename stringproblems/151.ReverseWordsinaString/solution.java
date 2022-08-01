/*
 * Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */


class Solution {
    /**
      * 不使用Java内置方法实现
      * <p>
      * 1.去除首尾以及中间多余空格
      * 2.反转整个字符串
      * 3.反转各个单词
      */
     public String reverseWords(String s) {
         // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
         // 1.去除首尾以及中间多余空格
         StringBuilder sb = removeSpace(s);
         // 2.反转整个字符串
         reverseString(sb, 0, sb.length() - 1);
         // 3.反转各个单词
         reverseEachWord(sb);
         return sb.toString();
     }
 
     private StringBuilder removeSpace(String s) {
         // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
         int start = 0;
         int end = s.length() - 1;
         while (s.charAt(start) == ' ') start++;
         while (s.charAt(end) == ' ') end--;
         StringBuilder sb = new StringBuilder();
         while (start <= end) {
             char c = s.charAt(start);
             if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                 sb.append(c);
             }
             start++;
         }
         // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
         return sb;
     }
 
     /**
      * 反转字符串指定区间[start, end]的字符
      */
     public void reverseString(StringBuilder sb, int start, int end) {
         // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
         while (start < end) {
             char temp = sb.charAt(start);
             sb.setCharAt(start, sb.charAt(end));
             sb.setCharAt(end, temp);
             start++;
             end--;
         }
         // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
     }
 
     private void reverseEachWord(StringBuilder sb) {
         int start = 0;
         int end = 1;
         int n = sb.length();
         while (start < n) {
             while (end < n && sb.charAt(end) != ' ') {
                 end++;
             }
             reverseString(sb, start, end - 1);
             start = end + 1;
             end = start + 1;
         }
     }
 }

 //解法三：双反转+移位，在原始数组上进行反转。空间复杂度O(1)
class Solution {
    /**
     * 思路：
     *	①反转字符串  "the sky is blue " => " eulb si yks eht"
     *	②遍历 " eulb si yks eht"，每次先对某个单词进行反转再移位
     *	   这里以第一个单词进行为演示：" eulb si yks eht" ==反转=> " blue si yks eht" ==移位=> "blue si yks eht"
     */
    public String reverseWords(String s) {
        //步骤1：字符串整体反转（此时其中的单词也都反转了）
        char[] initialArr = s.toCharArray();
        reverse(initialArr, 0, s.length() - 1);
        int k = 0;
        for (int i = 0; i < initialArr.length; i++) {
            if (initialArr[i] == ' ') {
                continue;
            }
            int tempCur = i;
            while (i < initialArr.length && initialArr[i] != ' ') {
                i++;
            }
            for (int j = tempCur; j < i; j++) {
                if (j == tempCur) { //步骤二：二次反转
                    reverse(initialArr, tempCur, i - 1);//对指定范围字符串进行反转，不反转从后往前遍历一个个填充有问题
                }
                //步骤三：移动操作
                initialArr[k++] = initialArr[j];
                if (j == i - 1) { //遍历结束
                    //避免越界情况，例如=> "asdasd df f"，不加判断最后就会数组越界
                    if (k < initialArr.length) {
                        initialArr[k++] = ' ';
                    }
                }
            }
        }
        if (k == 0) {
            return "";
        } else {
            //参数三：以防出现如"asdasd df f"=>"f df asdasd"正好凑满不需要省略空格情况
            return new String(initialArr, 0, (k == initialArr.length) && (initialArr[k - 1] != ' ') ? k : k - 1);
        }
    }

    public void reverse(char[] chars, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }
    }
}