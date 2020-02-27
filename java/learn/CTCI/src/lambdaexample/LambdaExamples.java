package lambdaexample;

import java.util.ArrayList;
import java.util.Map;

public class LambdaExamples {

    public static void main(String[] args) {

        MyFunction myFunction = text ->{
            for(Object v : text)
                System.out.println(v);
        };

        myFunction.apply("this is the text", "this is the second text");

        MyComparator comparator = (a1, a2) -> a1 > a2;

        boolean result = comparator.compare(-5, 4);

        System.out.println(result);
    }

}
