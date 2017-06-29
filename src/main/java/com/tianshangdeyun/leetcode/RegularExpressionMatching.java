package com.tianshangdeyun.leetcode;

/**
 * <p>类描述</p>
 * 创建日期 2017/6/29
 *
 * @author tianshangdeyun(wangbo@eefung.com)
 * @since 1.0.1
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // 成功的情况
        if (s.equals(p)) {
            return true;
        }
        if (s.length() == 0) {
            if (p.length() == 0 || isAllStartRegex(p)) {
                return true;
            } else {
                return false;
            }
        }
        if (p.length() == 0) {
            return false;
        }

        // 比较非start正则的部分
        int indexOfRegex = 0;
        int indexOfS = 0;
        while (indexOfS < s.length() && indexOfRegex < p.length()
            && !isStartRegex(indexOfRegex, p)) {
            if (p.charAt(indexOfS) == '.'
                || p.charAt(indexOfRegex) == s.charAt(indexOfS)) {
                indexOfS++;
                indexOfRegex++;
            } else {
                return false;
            }
        }

        if (indexOfS == s.length()) {
            if (indexOfRegex == p.length() || isAllStartRegex(p.substring(indexOfRegex))) {
                return true;
            } else {
                return false;
            }
        }
        if (p.length() == indexOfRegex) {
            return false;
        }

        // 比较start正则的部分
        while (indexOfS <= s.length()) {
            if (isMatch(s.substring(indexOfS), p.substring(indexOfRegex + 2))) {
                return true;
            }
            if (indexOfS == s.length()) {
                break;
            }
            char preStarChar = p.charAt(indexOfRegex);
            if (preStarChar == '.' || preStarChar == s.charAt(indexOfS)) {
                indexOfS++;
            } else {
                return false;
            }
        }
        return false;
    }

    boolean isStartRegex(int index, String p) {
        if (index >= p.length() - 1) {
            return false;
        }
        if (p.charAt(index + 1) == '*') {
            return true;
        } else {
            return false;
        }
    }

    boolean isAllStartRegex(String p) {
        if (p.length() % 2 != 0) {
            return false;
        }
        for (int i = 1; i < p.length(); i = i + 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
