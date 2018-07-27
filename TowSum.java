import java.util.*;
class TwoSum{
    public static void main(String[] args){
        int[] arr = {-1,-2,-3,-4,-5};
        int [] r = twoSum(arr, -8 );
        System.out.println("["+r[0]+","+r[1]);

    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer,Integer>();
        int [] ret={0,0};
		for(int i = 0 ; i< nums.length; i++){
			if(m.containsKey(nums[i])){
                ret[1]=i;
                ret[0]=m.get(nums[i]);
				return ret;
			}

			m.put(target-nums[i],i);
			

		}
        return ret;
    }
}
