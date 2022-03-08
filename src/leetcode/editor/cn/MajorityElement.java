//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

package leetcode.editor.cn;

public class MajorityElement{
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();

        solution.majorityElement( new int[] {3,1,2,2,3,3,3} );
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        // sorted
//        Arrays.sort( nums );
//        return nums[ nums.length / 2 ];
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}