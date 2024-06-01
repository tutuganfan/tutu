import java.util.HashMap;

/**
 * @Author 12629
 * @Description：
 */
class Student{
    //私有属性name
    private String name = "bit";
    //公有属性age
    public int age = 18;
    //不带参数的构造方法
    public Student(){
        System.out.println("Student()");
    }

    private Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String,name)");
    }

    private void eat(){
        System.out.println("i am eating");
    }

    public void sleep(){
        System.out.println("i am sleeping");
    }

    private void function(String str) {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test {

    public static void main(String[] args) {
        //有3种方式可以获取Class对象
        //1.通过对象的getClass()方法
        Student student1 = new Student();
        Class<?> c1 = student1.getClass();
        //2、通过类名.class获取
        Class<?> c2 = Student.class;
        //3. forName(“路径”)
        Class<?> c3 = null;
        try {
            c3 = Class.forName("Student");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c2.equals(c3));
    }
    public static void main1(String[] args) {
        HashMap<String,Integer> map = new HashMap<>(19);
        map.put("hello",2);

    }
}
