/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class KnapsackProblem {
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
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            System.out.println(getKnapsack(itemCount, totalWeight, vals, weights, 0,map));
        }
    }
    public static int getKnapsack(int itemCount, int w, int[] vals, int weights[], int idx,HashMap<Integer,Integer> map){
        if(idx >= itemCount) return 0;
        int v = vals[idx];
        if(weights[idx] > w) return getKnapsack(itemCount,w,vals,weights,idx+1,map);
        if(map.containsKey(w)) return map.get(w);
        if(weights[idx] == w){
            map.put(w,v);   
            return v;  
        } 
        
        for(int i = 0; i< itemCount; i++){
            if(i==idx) continue;
            v = Math.max(v, v+getKnapsack(itemCount,w-weights[idx],vals,weights,idx+1,map));
        }
        map.put(w,v);
        // System.out.println("weight : "+w+","+"value : "+v+", idx:"+idx);
        return v;
    }
}