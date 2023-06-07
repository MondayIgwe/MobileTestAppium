package TestAnyThing;

import java.util.ArrayList;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

public class TestSomething {

    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<>();
        number.add(21);
        number.add(22);
        number.add(23);
        number.add(24);
        
// OOP
        for(Integer num : number){
            System.out.println(num.toString());
        }

        //
        number.forEach((n) -> System.out.println(n));

    }
}
