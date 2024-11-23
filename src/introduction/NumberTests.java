package introduction;

import java.util.function.Predicate;

public class NumberTests {
    public static Predicate<Integer>isOdd(){
        return x -> (x&1)!=0;
    }
    public static Predicate<Integer> isEven(){
        return x -> (x&1)==0;
    }
    public static Predicate<Integer> all(){
        return x->true;
    }
}
