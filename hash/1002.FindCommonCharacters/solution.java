import java.util.LinkedList;

/*
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
 */

class Solution {
    public List<String> commonChars(String[] words) {
        int[] hash = new int[26];
        List<String> result = new LinkedList<String>();
        for(int i = 0; i <words[0].length();i++){
            hash[words[0].charAt(i)- 'a']++;
        }
        // 统计除第一个字符串外字符的出现频率
        for(int i = 1; i<words.length;i++){
            int[] hashOtherStr= new int[26];
            for(int j = 0; j < words[i].length();j++){
                hashOtherStr[words[i].charAt(j)- 'a']++;
            }
            // 更新hash，保证hash里统计26个字符在所有字符串里出现的最小次数
            for(int k = 0; k < 26;k++){
                hash[k] = Math.min(hash[k], hashOtherStr[k]);
            }
        }
        // 将hash统计的字符次数，转成输出形式
        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) { // 注意这里是while，多个重复的字符
                char c= (char) (i+'a');
                result.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return result;
    }
}