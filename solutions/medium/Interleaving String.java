public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	int len1=s1.length(),len2=s2.length(),len3=s3.length();
    	if(len1+len2!=len3){
    		return false;
    	}
    	if(len1==0 || len2==0){
    		return len1==0?s3.equals(s2):s3.equals(s1);
    	}
    	//dp[i][j] means isInterleave(s1[0,i-1],s2[0,j-1],s3[0,i+j-1])
        boolean[][] dp=new boolean[len1+1][len2+1];
        dp[0][0]=true;
        for(int i=1;i<len1+1;i++){
        	if(s3.substring(0,i).equals(s1.substring(0,i))){
        		dp[i][0]=true;
        	}
        }
        for(int j=1;j<len2+1;j++){
        	if(s3.substring(0,j).equals(s2.substring(0,j))){
        		dp[0][j]=true;
        	}
        }
        for(int i=1;i<len1+1;i++){
        	for(int j=1;j<len2+1;j++){
        		int index1=i-1;
        		int index2=j-1;
        		int index3=i+j-1;
        		//if last char of s1&s2 not equals last char of s3,must be false!
        		if(s1.charAt(index1)==s3.charAt(index3)){
        			dp[i][j]=dp[i-1][j];
        		}
        		if(dp[i][j]==false && s2.charAt(index2)==s3.charAt(index3)){
        			dp[i][j]=dp[i][j-1];
        		}
        	}
        }
        return dp[len1][len2];
    }
}