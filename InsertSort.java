public class InsertSort {
	public static void main(String arg[]){
    int[] num = {5,2,86,18,10,56,36,77,35};		
	for(int i = 1 ; i < num.length; i ++){
		int pop = num[i];
        if(pop > num[i-1]){
            continue;
        }
		num[i]=num[i-1];
		for(int j = i-1; j >= 0; j--){
            if(j-1 <= 0){
                num[j] = pop;
            }else if(num[j-1] < pop){
                num[j] = pop;
                break;
            }else{
                num[j]=num[j-1];
            }
        }
	    }
        pp(num,0,0);
	}
	
    public static void p(String s){
        System.out.println(s);
    }
    public static void pp(int[] arr, int i, int j){

        for(int n: arr){
            System.out.print(n+" ");
        }
        System.out.println(" | i:"+i+", j:"+j);
    }

}

