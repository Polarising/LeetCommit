// Title: Unique Binary Search Trees
            // Difficulty: Medium
            // Language: Java
            // Link: https://leetcode.com/problems/unique-binary-search-trees/

public class Solution {
    // For BST n:
    // [1,2...,i-1],i,[i+1,i+2,...,n]
    // when i is root node, possible unique trees = numTrees(i-1)*numTrees(n-i)
    // Loop n: each element i will be root, total num of Trees = sum(numTrees(i-1)*numTrees(n-i))
    
    public int numTrees(int n) {
        if(n==0||n==1)
            return 1;
        int[] F = new int[n+1];
        F[0]=1;
        F[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                F[i] += F[j-1]*F[i-j];
            }
        }
        return F[n];
    }
    
    // public int numTrees(int n) {
    //     if(n<=1){
    //         return 1;
    //     }
    //     int sum=0;
    //     for(int i=1;i<=n;++i){
    //         sum += numTrees(i-1)*numTrees(n-i);
    //     }
    //     return sum;
    // }
    
    // public int numTrees(int n) {
    //  Map<Integer,Integer> temp=new HashMap<Integer,Integer>();
    //  temp.put(0,1);
    //  temp.put(1,1);
    //  return helper(n,temp);
    // }
    // private int helper(int n,Map<Integer,Integer> temp){
    //     int total=0;
