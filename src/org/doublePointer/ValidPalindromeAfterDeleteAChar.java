package org.doublePointer;

// 可以删除一个字符，判断是否能构成回文字符串。
public class ValidPalindromeAfterDeleteAChar {
    public static void main(String[] args) {
        String str = "abcyyba";
        System.out.println("substring: "+str.substring(2,4)); // [2, 4-1]
        System.out.println(validPalindromeAfterDeleteAChar(str));
    }

    private static boolean validPalindromeAfterDeleteAChar(String str) {
        int i=0, j=str.length()-1;
        while (i<=j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else {
                return validPalindrome(str.substring(i,j)) || validPalindrome(str.substring(i+1, j+1));
            }
        }
        return true;
    }

    private static boolean validPalindrome(String str) {
        int i=0, j=str.length()-1;
        while (i<=j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return  true;
    }


}
