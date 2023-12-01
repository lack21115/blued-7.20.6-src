package dalvik.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
/* loaded from: source-2895416-dex2jar.jar:dalvik/annotation/TestTarget.class */
public @interface TestTarget {
    String conceptName() default "";

    Class<?>[] methodArgs() default {};

    String methodName() default "";
}
