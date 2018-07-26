/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Gem implements Comparable<Gem> {
    int value, weight; 
    float profit;
    Gem(int value, int weight){
        this.value = value;
        this.weight = weight;
        this.profit = (float)value/weight;
    }


    @Override
    public String toString(){
        return  value+","+weight+","+profit;
    }
    @Override
    public int compareTo(Gem g){
        if(profit > g.profit){
            return -1;
        }else if(profit == g.profit){
            return 0;
        }else{
            return 1;
        }
    }
}
class KnapsackProblemWithBound {
    static int MAX = 0;
    static int CNT = 0;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        for(int i = 0 ; i < loop ; i++){
            MAX = 0;
            CNT = 0;
            int itemCount = sc.nextInt();
            int totalWeight = sc.nextInt();
            int[] vals = new int[itemCount];
            Gem[] gems = new Gem[itemCount];

            for(int j = 0 ; j < itemCount ; j++){
                vals[j] = sc.nextInt();
            }
            for(int j = 0 ; j < itemCount ; j++){
                gems[j] = new Gem(vals[j],sc.nextInt());
            }
            Arrays.sort(gems);
            // for(Gem g: gems){
            //     System.out.println(g);
            // }

            int m = getKnapsack( totalWeight,0, gems, 0);
            
            System.out.println(m);
            // System.out.println("total count: "+CNT);
        }
    }
    
    public static int getKnapsack( int w, int v, Gem[] gemList, int idx){
        CNT++;
        if(w < 0) return -2;
        if(w == 0) return v;
        if(idx >= gemList.length) return v;
        // int bound = bound(idx,w,gemList);
        // System.out.println("bound : "+bound);
        if(MAX-v > bound(idx,w,gemList)) return -1;

        return setMax(Math.max(getKnapsack(w-gemList[idx].weight, v+gemList[idx].value, gemList, idx+1),getKnapsack(w, v,gemList, idx+1)));
    }

    public static int setMax(int n){
        if(MAX < n) MAX = n;
        return MAX;
    }
    public static float bound(int idx, int w, Gem[] gemList) {
        if(idx >= gemList.length) return 0;
        if(gemList[idx].weight > w) {return w*gemList[idx].profit;}
        else if(gemList[idx].weight == w){ return gemList[idx].value; }
        else{
            return gemList[idx].value+bound(idx+1,w-gemList[idx].weight, gemList);
        }
    }
}