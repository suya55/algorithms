import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.*;
class AssignmentProblem2 {
	public static int cnt = 0;
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        for(int i = 0; i < loop; i++){
        	int wc = sc.nextInt();
        	int[][] times = new int[wc][wc];
        	int[][] visited = new int[wc][wc];
        	int[] status = new int[wc];
        	Arrays.fill(status,0);
        	for(int k = 0; k < wc; k++){
	        	for(int j = 0; j < wc; j++){
	        		times[k][j] = sc.nextInt();
	        		visited[k][j] = -1;
	        	}
        	}
        	int min = Integer.MAX_VALUE;
    		for(int k = 0; k < wc; k++){
    			min = Math.min(min,dfsR(times,0,k,status, visited));
    		}

        	System.out.println(min);
        	System.out.println(cnt);

        }
	}

	public static int dfsR(int[][] arr,int positionY,int positionX, int[] status, int[][] visited){
		cnt++;
		// pp(positionY + ","+positionX, positionY);
		if(positionY == arr.length-1) return arr[positionY][positionX];
		if(visited[positionY][positionX] != -1) return visited[positionY][positionX];
		int[] st = status.clone();
		st[positionX] = 1;
		int min = Integer.MAX_VALUE;
		// call child
		for(int i=0; i< arr.length ; i++){	
			if(st[i] == 0){
				min = Math.min(min,dfsR(arr, positionY+1,i, st,visited));
			}
		}
		// pp("--->"+positionY + ","+positionX+": min: "+min+",self:"+arr[positionY][positionX]+","+(min+arr[positionY][positionX]), positionY);
		int sum = min+arr[positionY][positionX];
		visited[positionY][positionX] = sum;
		return sum;
	}
	public static void pp(Object o, int depth){
		for(int i = 0; i< depth;i++){
			System.out.print("  ");
		}
		System.out.println(o.toString());
	}
}
