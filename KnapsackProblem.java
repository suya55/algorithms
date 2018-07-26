/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
class Gem implements Comparable<Gem> {
    int value, weight; 
    Gem(int weight,int value){
        this.value = value;
        this.weight = weight;
    }


    @Override
    public String toString(){
        return  weight+","+value;
    }
    @Override
    public int compareTo(Gem g){
        if(weight > g.weight){
            return 1;
        }else if(weight == g.weight){
            if(value > g.value) return 1;
            else if(value == g.value) return 0;
            else return -1;
            
        }else{
            return -1;
        }
    }
}
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
            Gem[] gems = new Gem[itemCount];
            for(int j = 0 ; j < itemCount ; j++){
                vals[j] = sc.nextInt();
            }   
            for(int j = 0 ; j < itemCount ; j++){
                weights[j] = sc.nextInt();
                gems[j]= new Gem(weights[j],vals[j]);
                
            }

            // System.out.println(getKnapsack( totalWeight,0, vals, weights, 0));
            Arrays.sort(gems);
            System.out.println(getKnapsackTable( totalWeight,gems));
            // System.out.println("total count :"+CNT);
        }
    }
    public static int getKnapsack(int w,int v, int[] vals, int[] weights, int idx){
        if(w < 0) return -1;
        if(w == 0) return v;
        if(idx < weights.length){
            return Math.max(getKnapsack(w-weights[idx], v+vals[idx], vals,weights, idx+1),getKnapsack(w, v,vals, weights, idx+1));
        }else{
            return v;
        }
    }

    public static int getKnapsackTable( int totalWeight, Gem[] gems){
        int[][] table = new int[gems.length][totalWeight+1];

        for(int itemIdx =0; itemIdx < gems.length;itemIdx++){
            for(int weight = 1 ; weight <= totalWeight ; weight++){
                if( weight >= gems[itemIdx].weight ){
                  table[itemIdx][weight] = itemIdx > 0 ? Math.max(table[itemIdx-1][weight],table[itemIdx-1][weight-gems[itemIdx].weight]+gems[itemIdx].value):gems[itemIdx].value;
                
                }else{
                    table[itemIdx][weight]=itemIdx > 0 ? table[itemIdx-1][weight] : 0;
                }
            }
        }
        return table[gems.length-1][totalWeight];
    }
}