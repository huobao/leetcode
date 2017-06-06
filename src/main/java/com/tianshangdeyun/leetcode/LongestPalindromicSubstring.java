package com.tianshangdeyun.leetcode;

/**
 * <p>对称轴原理</p>
 * 创建日期 2017/6/6
 *
 * @author tianshangdeyun(wangbo@eefung.com)
 * @since 1.0.1
 */
public class LongestPalindromicSubstring {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String input = "cbbd";
        System.out.println(longestPalindromicSubstring.longestPalindrome(input));
    }
}
