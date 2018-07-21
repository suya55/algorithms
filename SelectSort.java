public class SelectSort{
	public static void swap(int[] arr, int x, int y){
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	public static void main(String args[]){
		int[] num = {5,2,86,18,10,56,36,77,35};
		int idx = 0;
        for(int i = 0; i < num.length; i ++){
            idx = i;
            for(int j= i+1; j < num.length; j++){
                if(num[i] > num[j] && num[idx] > num[j]){
                    idx = j;
                }
            }
            if(idx != 0){
                swap(num,i,idx);
            }
                pp(num);        
        }		

	}
    public static void pp(int[] arr){
        
        for(int n: arr){
			System.out.print(n+" ");
        }
        System.out.println("");
    }
}

