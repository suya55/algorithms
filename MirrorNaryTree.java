import java.util.*;
import java.lang.*;
import java.io.*;

class MirrorNaryTree {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        for(int l=0; l < loop ; l++){
            int nodeCount = sc.nextInt();
            int edges = sc.nextInt();
            sc.nextLine();
            int result = convString(sc.nextLine(), false).equals(convString(sc.nextLine(), true)) ? 1 : 0;
            System.out.println(result);
        }
    }

    static String convString(String line,boolean reverse){
        System.out.println("input line:"+line);
        HashSet<Integer> keySequence = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        String[] splited = line.split(" ");
        for(int i = 0; i< splited.length ; i = i+2){
            System.out.print(splited[i]+","+splited[i+1]+",");
            int k = Integer.parseInt(splited[i]);
            int v = Integer.parseInt(splited[i+1]);
            keySequence.add(k);
            if(map.containsKey(k)){
                map.get(k).add(v);
            }else{
                ArrayList<Integer> vl = new ArrayList<Integer>();
                vl.add(v);
                map.put(k,vl);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (Integer k : keySequence) {
            sb.append("[");
            sb.append(k);
            sb.append("]");
            sb.append(listToString(map.get(k),reverse));
            sb.append(",");
        }
        System.out.println("\n");
        System.out.println(sb.toString());
        return sb.toString();
    }

    static String listToString(ArrayList<Integer> l, boolean reverse){
        String s="";
        ArrayList<Integer> tmp = (ArrayList<Integer>)l.clone();
        if(reverse) Collections.reverse(tmp);
        
        for(Integer num:tmp){
            s = num+",";
        }
        return s;
    }
}