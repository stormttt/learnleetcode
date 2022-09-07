import java.util.LinkedList;
import java.util.List;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
class Solution {
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        String[] numStrings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits == null || digits.length()==0) return result;
        backTracking(digits,result,numStrings,0);
        return result;
    }
    private void backTracking(String digits, List<String> result, String[] numStrings, int num){
        
        if(num == digits.length()){
            result.add(path.toString());
            
            return;
        }
        String str = numStrings[digits.charAt(num) - '0'];
        for(int i =0;i<str.length();i++){
            path.append(str.charAt(i));
            backTracking(digits, result, numStrings, num + 1);
            path.deleteCharAt(path.length()-1);
            
        }

    }
}