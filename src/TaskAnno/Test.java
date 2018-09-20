package TaskAnno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        try {

            Class<?> sclass = Class.forName("TaskAnno.Student");
            for (Annotation annotation : sclass.getDeclaredAnnotations()) {
                System.out.println(annotation);

            }
            stuTable annotation = sclass.getAnnotation(stuTable.class);
            System.out.println(annotation.value());
            Field name = sclass.getDeclaredField("name");
            System.out.println(name.getAnnotation(stuField.class));
            System.out.println(name);
            System.out.println(name.getName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
