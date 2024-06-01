import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author 12629
 * @Description：
 */
public class ReflectEnum {

    public static void reflectPrivateConstructor() {
        Class<?> c ;
        try {
            c = Class.forName("TestEnum");
            Constructor<?> constructor =
                    c.getDeclaredConstructor(String.class,int.class,String.class,int.class);
            constructor.setAccessible(true);

            TestEnum testEnum = (TestEnum)constructor.
                    newInstance("呼伦贝尔草原色",99,"fsfa",10);

            System.out.println(testEnum);

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

    public static void main(String[] args) {
        reflectPrivateConstructor();
    }
}
