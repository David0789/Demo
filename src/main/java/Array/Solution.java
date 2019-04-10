package main.java.Array;

import java.util.*;

public class Solution {

    /**
     * 排序数组删除重复项
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            nums[index] = nums[i];
            set.add(nums[i]);
            index++;
        }
        return index;
    }

    /**
     * 买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        return 0;
    }

    /**
     * 旋转数组
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int[] after = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int key = Integer.valueOf(i);
            while (key + k > nums.length - 1) {
                key = key - nums.length;
            }
            after[key + k] = nums[i];
        }
        for (int i = 0; i < after.length; i++) {
            nums[i] = after[i];
        }
    }

    /**
     * 是否存在重复
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
/*        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;*/
        if (nums.length < 2) return false;

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (max == nums[i]) {
                return true;
            } else {
                for (int j = i - 2; j >= 0; j--) {
                    if (nums[j] == nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 只出现一次的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;

/*        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    set.add(nums[i]);
                    break;
                }
                if (j == nums.length -1) {
                    return nums[i];
                }
            }
        }
        return nums[nums.length-1];*/
    }

    /**
     * 2个数组的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] tmp;
        if (nums1.length > nums2.length) {
            tmp = nums1.clone();
            nums1 = nums2.clone();
            nums2 = tmp.clone();
        }

        List<Integer> list = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = k; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    k = j + 1;
                    break;
                }
            }
        }

        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    /**
     * 加一
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;

                if (i == 0) {
                    int[] res = new int[digits.length + 1];
                    for (int i1 = 0; i1 < digits.length; i1++) {
                        res[i + 1] = digits[i];
                    }
                    res[0] = 1;
                    return res;
                }
            }
        }
        return digits;
    }

    /**
     * 移动零
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while (j < nums.length) {
            nums[j++] = 0;
        }
/*        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }

            int tmp;
            for (int j = i; j < nums.length - 1 - num; j++) {
                int k = 1;
                while (nums[j + k] == 0 && j + k < nums.length - 1) {
                    k++;
                }
                tmp = nums[j];
                nums[j] = nums[j + k];
                nums[j + k] = tmp;
                j += k - 1;
            }
            num++;
        }*/
    }

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int diff;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];

/*        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (nums[i] + nums[i1] == target) {
                    return new int[]{i,i1};
                }
            }

        }
        return new int[2];*/
/*        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 中分法
            int k = (nums.length - i) / 2;
            if (nums[i] + nums[k] < target) {
                for (int j = k + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            } else if (nums[i] + nums[k] > target) {
                for (int j = k - 1; j > i; j--) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            } else {
                return new int[]{i, k};
            }
        }
        return new int[2];*/
    }

    /**
     * 有效的数独
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] heng = new boolean[9][9];
        boolean[][] shu = new boolean[9][9];
        boolean[][] kuang = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                if (Objects.equals(board[i][k], '.')) continue;
                int s = Integer.valueOf(String.valueOf(board[i][k])) - 1;
                int num = i / 3 * 3 + k / 3;
                if (heng[i][s] || shu[k][s] || kuang[num][s]) {
                    return false;
                }
                heng[i][s] = true;
                shu[k][s] = true;
                kuang[num][s] = true;
            }
        }
        return true;
    }


    /**
     * 旋转图像
     * @param matrix
     */
    public void rotate(int[][] matrix) {

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] c = {{'8','3','.','.','7','.','.','.','.'}
                                ,{'6','.','.','1','9','5','.','.','.'}
                                ,{'.','9','8','.','.','.','.','6','.'}
                                ,{'8','.','.','.','6','.','.','.','3'}
                                ,{'4','.','.','8','.','3','.','.','1'}
                                ,{'7','.','.','.','2','.','.','.','6'}
                                ,{'.','6','.','.','.','.','2','8','.'}
                                ,{'.','.','.','4','1','9','.','.','5'}
                                ,{'.','.','.','.','8','.','.','7','9'}};
        solution.isValidSudoku(c);
    }
}
