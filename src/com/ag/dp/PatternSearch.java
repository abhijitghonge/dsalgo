package com.ag.dp;
public class PatternSearch {
    public static boolean isMatch(String text, String pattern) {
        int M=text.length();
        int N=pattern.length();
        Boolean[][] memo = new Boolean[M][N];

        return isMatch(text, pattern, M-1, N-1, memo);
    }

    private static boolean dp(int i, int j, String text, String pattern, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean result;
        if (j == pattern.length()) {
            result = i == text.length();
        } else {
            boolean firstMatch = (i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?'));

            if (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
                result = (dp(i, j + 2, text, pattern, memo)) || (firstMatch && dp(i + 1, j, text, pattern, memo));
            } else {
                result = firstMatch && dp(i + 1, j + 1, text, pattern, memo);
            }
        }

        memo[i][j] = result;
        return result;
    }

    public static void main(String[] args) {
        String text = "mississippi";
        String pattern = "m*iss*ip*i";
        boolean isMatch = isMatch(text, pattern);

        if (isMatch) {
            System.out.println("Pattern matches the text.");
        } else {
            System.out.println("Pattern does not match the text.");
        }
    }

    private  static boolean isMatch(String A, String B, int i, int j, Boolean[][] memo){
        if(i==-1 && j==-1){
            return true; //perfect match
        }else if(j==-1){
            return false;
        }else if(i==-1){
            //i==-1
            if(B.charAt(j)!='*'){
                return false;
            }else{
                while(j>=0){
                    if(B.charAt(j)!='*'){
                        return false;
                    }else{
                        j--;
                    }
                }
                return true;
            }
        }


        if(memo[i][j]!=null){
            return memo[i][j];
        }

        // System.out.printf("%d,%d%n", A.charAt(i), B.charAt(j));
        if(A.charAt(i)==B.charAt(j) || B.charAt(j)=='?'){
            memo[i][j] = isMatch(A, B, i-1, j-1, memo);
        }else if(B.charAt(j)=='*'){
            boolean wildCard = isMatch(A, B, i-1, j, memo);

            boolean withoutWildCard = isMatch(A, B, i, j-1, memo);

            memo[i][j] = wildCard || withoutWildCard;
        }else{
            //no match
            memo[i][j] =false;
        }

        return memo[i][j];
    }
}

