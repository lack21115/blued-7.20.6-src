package dalvik.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-2895416-dex2jar.jar:dalvik/annotation/TestTargets.class */
public @interface TestTargets {
    TestTargetNew[] value();
}
