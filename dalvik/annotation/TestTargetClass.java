package dalvik.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
/* loaded from: source-2895416-dex2jar.jar:dalvik/annotation/TestTargetClass.class */
public @interface TestTargetClass {
    TestTargetNew[] untestedMethods() default {};

    Class<?> value();
}
