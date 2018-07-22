/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
/**
Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:

Corresponding to each test case, in a new line, print the starting and ending positions of first such occuring subarray if sum equals to subarray, else print -1.

Note: Position of 1st element of the array should be considered as 1.

Expected Time Complexity: O(n)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ an array element ≤ 200

Example:

Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10

Output:
2 4
1 5

Explanation : 
In first test case, sum of elements from 2nd position to 4th position is 12
In second test case, sum of elements from 1st position to 5th position is 15
**/
// worst : O(n2)
// best : O(n)
class SubarrayWithGivenSum {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
        for(int i = 0; i < loop; i++){
            int size = sc.nextInt();
            int target = sc.nextInt();
            int[] arr= new int[size];
            for(int j = 0 ; j< size; j++){
                arr[j] = sc.nextInt();
            }
            if(size < 2){
                System.out.println(-1);
                return;
            }
            //  5 12
//              1 2 3 7 5
            int startIdx = 0;
            int endIdx = 1;
            int sum = arr[startIdx]+arr[endIdx];
            boolean eureka = false;
            while(true){
                // System.out.println(sum);
                if(startIdx == size-1 && endIdx == size-1){
                    break;    
                }
                
                if(sum == target){
                    eureka = true;
                    break;
                }else if(((sum < target) || (startIdx == endIdx-1)) && endIdx < size-1){
                    endIdx++;
                    sum += arr[endIdx];
                }else{
                    sum -= arr[startIdx];
                    startIdx++;
                }
            }
            if(eureka){
                System.out.println((startIdx+1)+" "+(endIdx+1))  ;
            } else{
                System.out.println("-1");
            }
        }
	}
}

// O(n)
class SubarrayWithGivenSum2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int arr[] = new int[n+1];
            for(int j = 1; j < n+1; j++){
                arr[j] = sc.nextInt();
            }
            int j;
            int curr_sum = 0;
            HashMap<Integer,Integer> hm = new HashMap<>();
            for( j = 1; j <= n; j++){
                for(int k : hm.keySet()){
                    System.out.println(k+","+hm.get(k));
                    
                }
                
                curr_sum += arr[j];
                // System.out.println("-----------"+curr_sum);
                if(curr_sum == sum){
                    System.out.println(1+" "+j);
                    break;
                }
                
                if(hm.get(curr_sum - sum)!= null){
                    System.out.println(hm.get(curr_sum - sum)+1+" "+j);
                    break;
                }      
                
                hm.put(curr_sum,j);
                if(j == n)
                System.out.println(-1);
            }
            
        }
    }
}