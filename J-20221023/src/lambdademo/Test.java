package lambdademo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @Author 12629
 * @Description：
 */










//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}

//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}
//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}

//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

public class Test {

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("hello",2);
        map.put("abc",12);
        map.put("def",21);
        map.put("opp",5);

        /*map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println("key: "+s+" val: "+integer);
            }
        });*/

        ///map.forEach((key,val)->{System.out.println("key: "+key+" val: "+val);});
        map.forEach((key,val)->System.out.println("key: "+key+" val: "+val));

    }

    public static void main9(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("lambda");
        list.add("bit");


       /* list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/

        list.forEach(s-> System.out.println(s));
        System.out.println("=========");

       /* list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/
        //list.sort((x,y)->{return x.compareTo(y);});
        list.sort((x,y)->x.compareTo(y));
        list.forEach(s-> System.out.println(s));
    }

    public static void main8(String[] args) {
        int a = 10;
        NoParameterNoReturn noParameterNoReturn = new NoParameterNoReturn(){
            @Override
            public void test() {
                System.out.println("这是test方法");
                //System.out.println(a);
            }
        };
        noParameterNoReturn.test();

        NoParameterNoReturn noParameterNoReturn2 = ()->{
            System.out.println("这是test方法！");
            /*a = 999;
            System.out.println(a);*/
        };
        noParameterNoReturn2.test();
    }

    public static void main7(String[] args) {
        //MoreParameterReturn moreParameterReturn = (x,y) -> {return x+y;};
        MoreParameterReturn moreParameterReturn = (x,y) ->  x+y ;
        System.out.println(moreParameterReturn.test(10, 20));
    }
    public static void main6(String[] args) {
        //OneParameterReturn oneParameterReturn = (x)->{return x+1;};
        OneParameterReturn oneParameterReturn = x -> x+1 ;
        System.out.println(oneParameterReturn.test(10));
    }

    public static void main5(String[] args) {
        //NoParameterReturn noParameterReturn = () -> {return 10;};
        NoParameterReturn noParameterReturn = () -> 10 ;
        int ret = noParameterReturn.test();
        System.out.println(ret);

    }

    public static void main4(String[] args) {
        MoreParameterNoReturn moreParameterNoReturn = ( x, y)-> System.out.println(x+y);
        moreParameterNoReturn.test(10,30);

    }
    public static void main3(String[] args) {
        //OneParameterNoReturn oneParameterNoReturn = (x)->{System.out.println(x);};
        //OneParameterNoReturn oneParameterNoReturn = (x)->System.out.println(x);
        OneParameterNoReturn oneParameterNoReturn = x->System.out.println(x);
        //OneParameterNoReturn oneParameterNoReturn = System.out::println;// 方法的引用 不用了解
        oneParameterNoReturn.test(10);
    }
    public static void main2(String[] args) {
        NoParameterNoReturn noParameterNoReturn = ()-> System.out.println("这是test方法");
        noParameterNoReturn.test();
    }




    public static void main1(String[] args) {
        int a = 10;
        NoParameterNoReturn noParameterNoReturn = new NoParameterNoReturn(){
            @Override
            public void test() {
                System.out.println("这是test方法");
                System.out.println(a);
            }
        };
        noParameterNoReturn.test();
    }


    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    });
}
