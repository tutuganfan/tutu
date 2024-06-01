import java.lang.ref.PhantomReference;
import java.util.Map;

/**
 * @Author 12629
 * @Description：
 */
public enum TestEnum {
    RED("RED",1),BLACK("BLACK",10),GREEN("GREEN",3),
    WHITE("WHITE",8);

    private String color;
    private int ori;

    //默认是私有的
    TestEnum(String color,int ori) {
        this.color = color;
        this.ori = ori;
    }

    public static void main(String[] args) {
        TestEnum[] testEnum = TestEnum.values();
        for (int i = 0; i < testEnum.length; i++) {
            System.out.println(testEnum[i] +" ori: "+testEnum[i].ordinal());
        }
        System.out.println();
        System.out.println("============");

        TestEnum testEnum2 = TestEnum.valueOf("WHITE");
        System.out.println(testEnum2);
        System.out.println("============");

        System.out.println(RED.compareTo(GREEN));
        System.out.println(GREEN.compareTo(BLACK));
    }


    public static void main1(String[] args) {
        TestEnum testEnum = TestEnum.BLACK;
        switch (testEnum) {
            case RED:
                System.out.println("红色");
                break;
            case BLACK:
                System.out.println("黑色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            case WHITE:
                System.out.println("白色");
                break;
            default:
                System.out.println("没有对应的颜色");
                break;
        }

    }
}
