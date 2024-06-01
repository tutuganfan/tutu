import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectClassDemo {
    //通过反射创建一个对象
    public static void reflectNewInstance() {
        try {
            Class<?> c3 = Class.forName("Student");
            Student student = (Student) c3.newInstance();
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reflectPrivateConstructor() {
        try {
            Class<?> c3 = Class.forName("Student");
            Constructor<?> constructor =
                    c3.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);
            Student student = (Student)constructor.newInstance("gaobo",18);
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static void reflectPrivateField() {
        try {
            Class<?> c3 = Class.forName("Student");
            Field field = c3.getDeclaredField("name");
            field.setAccessible(true);
            Student student = (Student) c3.newInstance();
            field.set(student,"zhangsan");
            System.out.println(student);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reflectPrivateMethod() {
        try {
            Class<?> c3 = Class.forName("Student");
            Method method = c3.getDeclaredMethod("function",String.class);
            method.setAccessible(true);

            Student student = (Student) c3.newInstance();
            method.invoke(student,"hahaha,我测试一下这个方法传个参数！");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        //reflectNewInstance();
        //reflectPrivateConstructor();
        //reflectPrivateField();
        reflectPrivateMethod();
    }
}