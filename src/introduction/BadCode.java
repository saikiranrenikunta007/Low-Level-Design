package introduction;

import java.util.List;

//This is a Bad code because it doesn't follow DRY principle
public class BadCode {

    public static int sumByAll(List<Integer> nums) {
       int sum = 0;
       for(int num : nums){
           sum += num;
       }
       return sum;
    }
    public static int sumByOdd(List<Integer>nums){
        int sum = 0;
        for(int num : nums){
            if((num&1) != 0) sum+=num;
        }
        return sum;
    }
    public static int sumByEven(List<Integer>nums){
        int sum = 0;
        for(int num : nums){
            if((num&1)==0) sum+=num;
        }
        return sum;
    }
    public static void main(String args[]) {
        List<Integer> arr = List.of(1,2,3);
        System.out.println(sumByAll(arr));
        System.out.println(sumByOdd(arr));
        System.out.println(sumByEven(arr));
    }
}
