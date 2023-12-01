package android.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-9557208-dex2jar.jar:android/test/FlakyTest.class */
public @interface FlakyTest {
    int tolerance() default 1;
}
