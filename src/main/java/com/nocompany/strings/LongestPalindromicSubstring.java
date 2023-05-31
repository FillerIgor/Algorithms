package com.nocompany.strings;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
//        String input = "babad";
//        String input = "cbbd";
//        String input = "aaca";
//        String input = "babadada";
//        String input = "dtgrtoxuybwyfskikukcqlvprfipgaygawcqnfhpxoifwgpnzjfdnhpgmsoqzlpsaxmeswlhzdxoxobxysgmpkhcylvqlzenzhzhnakctrliyyngrquiuvhpcrnccapuuwrrdufwwungaevzkvwbkcietiqsxpvaaowrteqgkvovcoqumgrlsxvouaqzwaylehybqchsgpzbkfugujrostopwhtgrnrggocprnxwsecmvofawkkpjvcchtxixjtrnngrzqpiwywmnbdnjwqpmnifdiwzpmabosrmzhgdwgcgidmubywsnshcgcrawjvfiuxzyzxsbpfhzpfkjqcpfyynlpshzqectcnltfimkukopjzzmlfkwlgbzftsddnxrjootpdhjehaafudkkffmcnimnfzzjjlggzvqozcumjyazchjkspdlmifvsciqzgcbehqvrwjkusapzzxyiwxlcwpzvdsyqcfnguoidiiekwcjdvbxjvgwgcjcmjwbizhhcgirebhsplioytrgjqwrpwdciaeizxssedsylptffwhnedriqozvfcnsmxmdxdtflwjvrvmyausnzlrgcchmyrgvazjqmvttabnhffoe";
        String result = findLongestPalindromeSubstring(input.toLowerCase());
        System.out.println("Result: " + result);
    }

    public static String findLongestPalindromeSubstring(String input) {
        String longestString = "";
        int i = 0;
        int j = input.length();

        if(isPalindrome(input.toCharArray())){
            return input;
        }

        while (i<=j){
            String substring = input.substring(i, j);
            if (isPalindrome(substring.toCharArray())){
                if(longestString.length() < substring.length()){
                    longestString = substring;
                    i++;
                    j=input.length();
                } else if (i<=input.length()) {
                    i++;
                    j=input.length();
                }
            } else if (i==j) {
                i++;
                j=input.length();
            } else {
                j--;
            }
        }

        return longestString;
    }

    private static boolean isPalindrome(char[] chars) {
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(chars[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[j])) {
                j--;
                continue;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
