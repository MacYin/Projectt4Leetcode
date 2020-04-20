//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串

package leetcode.editor.cn;

public class ReverseWordsInAStringIii{
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();

        System.out.println( solution.reverseWords( "Let's take LeetCode contest" ) );
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        int strLength = s.length();
        if( strLength <= 1 ){
            return s;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        for( int i = 0; i < strLength ; i++ ) {
            if( chars[i] == ' ' ){
                reverse( chars, left, i - 1 );
                left = i + 1;
            }
            if( i == strLength - 1 ){
                reverse( chars, left, strLength - 1 );
            }
        }


        return new String(chars);

    }

    public void reverse( char[] chars, int left, int right ){
        char temp;
        for( int i = left; i < right; i++ ) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}