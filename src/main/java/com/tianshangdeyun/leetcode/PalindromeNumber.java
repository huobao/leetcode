package com.tianshangdeyun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>类描述</p>
 * 创建日期 2017/6/14
 *
 * @author tianshangdeyun(wangbo@eefung.com)
 * @since 1.0.1
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {//负数不是回文
            return false;
        }
        List<Integer> nums = new ArrayList<Integer>();
        while (x != 0) {
            nums.add(x % 10);
            x = x / 10;
        }

        boolean isPalindromeFlag = true;
        for (int i = 0, j = nums.size() - 1; i < nums.size() / 2 && j >= nums.size() / 2; i++, j--) {
            if (nums.get(i) != nums.get(j)) {
                isPalindromeFlag = false;
                break;
            }
        }
        return isPalindromeFlag;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int temp = 0;
        while (x > temp) {
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        return x == temp || (x == temp / 10);
    }
}
