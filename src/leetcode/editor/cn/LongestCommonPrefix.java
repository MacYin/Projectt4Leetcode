//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package leetcode.editor.cn;

import java.util.HashMap;

public class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix( new String[]{} ));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String temp = strs[0];
        for( String str : strs ) {
            if( temp.length() >= str.length() ) {
                temp = str;
            }
        }
        for( String str : strs ) {

            for( int i = temp.length() - 1; i >= 0; i-- ) {
                if(str.charAt( i ) != temp.charAt( i )){
                    temp = temp.substring( 0, i );
                }
            }
        }

        return temp;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}