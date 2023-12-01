package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-8756600-dex2jar.jar:androidx/annotation/ChecksSdkIntAtLeast.class */
public @interface ChecksSdkIntAtLeast {
    int api() default -1;

    String codename() default "";

    int lambda() default -1;

    int parameter() default -1;
}
