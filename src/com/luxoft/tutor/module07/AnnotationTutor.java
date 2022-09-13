package com.luxoft.tutor.module07;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.luxoft.tutor.Logger.log;
import static org.junit.Assert.assertEquals;

public class AnnotationTutor {
    static final String introspectClass = "com.luxoft.tutor.module07.ExampleClass";

    @Test
    public void testAnnotations() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> cls = Class.forName(introspectClass);

        Method method = cls.getDeclaredMethod("printIt", new Class[0]);

        // show information about method annotated with MyAnnotation
        // print name value of the annotation
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        boolean myAnnotation = method.isAnnotationPresent(MyAnnotation.class);
        if (myAnnotation) {
            log("my annotation name = " + annotation.name());
        }

        // TODO: show information about all annotated fields
        // print name and properties of the annotations

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length > 0) {
                for (Annotation annotation1 : annotations) {
                    if (annotation1 instanceof Default) {
                        System.out.println("Field: " + field.getName() + ", annotation name = " + ((Default) annotation1).name() + ", annotation value = " + ((Default) annotation1).value());
                    }
                }

            }
        }
    }

    @Test
    public void testDefaultField() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        ExampleClass ex = new ExampleClass();
        String name = getFieldValue(ex, "name");
        assertEquals(name, "noname");
        ex.name = "my name";
        String name2 = getFieldValue(ex, "name");
        assertEquals(name2, "my name");
    }

//	public String getFieldValue(Object obj, String fieldName) throws ClassNotFoundException {
    // TODO: should return the value of field
    // or defValue, if field was annotated by @Default and field is not set
//	    return null;
//	}

    public String getFieldValue(Object obj, String fieldName) throws IllegalArgumentException, IllegalAccessException {
        Class<? extends Object> cls = obj.getClass();
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            field.setAccessible(true);
            Object value = field.get(obj);
            if (value != null) {
                return value.toString();
            }
            if (name.equals(fieldName)) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length > 0) {
                    for (int i = 0; i < annotations.length; i++) {
                        if (annotations[i] instanceof Default) {
                            Default myAnnotation = (Default) annotations[0];
                            return myAnnotation.value();
                        }
                    }
                }
            }
        }

        return null;
    }

}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String name() default "";
}


@Retention(RetentionPolicy.RUNTIME)
@interface Default {
    String name() default "my text";

    String value() default "noname";
} 
