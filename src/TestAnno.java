import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@Mypro("yes,i am a annotation")
public class TestAnno {
    public TestAnno() {
    }

    @SuppressWarnings("all")
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> testAnno = Class.forName("TestAnno");
        Constructor<?> constructor = testAnno.getConstructor();
        Mypro annotation = testAnno.getAnnotation(Mypro.class);
        System.out.println(constructor);
        System.out.println(constructor.getName());
        Object o = constructor.newInstance();
        Field[] fields = testAnno.getFields();
        Arrays.asList(fields).forEach((x) -> {
            System.out.println(x);
        });
        System.out.println(testAnno.getMethod("method1"));


        System.out.println(annotation);
    }

    public static void method1() {

    }

    public static void method2() {

    }

    public static void method3() {

    }
}
