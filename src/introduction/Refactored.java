package introduction;

import java.util.List;
import java.util.function.Predicate;

public class Refactored {

    public static int sumByTest(List<Integer>nums, Predicate<Integer>selector){
        return nums.stream().filter(selector).reduce(0, Integer::sum);
    }
    public static Predicate<Integer> combineTests(List<Predicate<Integer>>selectors){
        return selectors.stream().reduce(x-> true,Predicate::and);
    }
    public static void main(String[] args) {
        List<Integer> arr = List.of(1,2,3);
        System.out.println(sumByTest(arr,NumberTests.isEven()));
        System.out.println(sumByTest(arr,NumberTests.isOdd()));
        System.out.println(sumByTest(arr,NumberTests.all()));
        System.out.println(sumByTest(arr,combineTests(List.of(NumberTests.isEven(),NumberTests.isOdd()))));
    }
}
