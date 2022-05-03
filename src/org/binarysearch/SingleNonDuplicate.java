package org.binarysearch;

public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 8, 8};
        int res = singleNonDuplicate(nums);
        System.out.println(res);
        System.out.println("-------------------------");
        int res2 = singleNonDuplicateByBinSearch(nums);
        System.out.println(res2);
    }

    //  方法1：位运算
    // 一个数同自己异或的结果为0，
    // 异或 就是无进位相加
    private static int singleNonDuplicate(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num ^= i;
        }
        return num;
    }

    // 方法2：二分法
    // 令 index 为"单一元素"在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。
    // 如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
    //
    //从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；
    // 如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
    private static int singleNonDuplicateByBinSearch(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1) {
                mid--;  // 下标mid必须是偶数
            }
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

}
