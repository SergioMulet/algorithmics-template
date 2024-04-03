package s5;


public class PatternMatching {
    private boolean[][] dp;
    private String text;

    public PatternMatching(String text) {
        this.text = text;
    }

    public boolean match(String pattern) {
        int m = text.length();
        int n = pattern.length();

        dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (pattern.charAt(j - 1) == '*' || pattern.charAt(j - 1) == '?') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                	if (pattern.charAt(j -1) == '?') {
                		dp[i][j] = dp[i-1][j-1];
                		if(dp[i][j-1])
                			dp[i][j] = dp[i][j-1];
                	}
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                else if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }

    public boolean checkPattern(String pattern) {
        int m = text.length();
        int n = pattern.length();

        if (m == 0 && n > 0 && pattern.charAt(0) != '?') 
        	return false;
        
        return match(pattern);
    }
    
    public void printsTable() {
        System.out.println("Table for pattern matching:");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] ? "T" : "F");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
