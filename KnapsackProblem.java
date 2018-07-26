/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class KnapsackProblem {
    static int CNT = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        for(int i = 0 ; i < loop ; i++){
            int itemCount = sc.nextInt();
            int totalWeight = sc.nextInt();
            int[] vals = new int[itemCount];
            int[] weights = new int[itemCount];
            for(int j = 0 ; j < itemCount ; j++){
                vals[j] = sc.nextInt();
            }
            for(int j = 0 ; j < itemCount ; j++){
                weights[j] = sc.nextInt();
                
            }
            System.out.println(getKnapsack( totalWeight,0, vals, weights, 0));
            System.out.println("total count :"+CNT);
        }
    }
    public static int getKnapsack( int w,int v, int[] vals, int weights[], int idx){
        CNT++;
        if(w < 0) return -1;
        if(w == 0) return v;
        if(idx < weights.length){
            return Math.max(getKnapsack(w-weights[idx], v+vals[idx], vals,weights, idx+1),getKnapsack(w, v,vals, weights, idx+1));
        }else{
            return v;
        }
    }
}