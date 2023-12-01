package dalvik.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-2895416-dex2jar.jar:dalvik/annotation/TestTargetNew.class */
public @interface TestTargetNew {
    Class<?>[] args() default {};

    Class<?> clazz() default void.class;

    TestLevel level();

    String method() default "";

    String notes() default "";
}
