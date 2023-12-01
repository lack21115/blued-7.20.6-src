package android.test.suitebuilder.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-9557208-dex2jar.jar:android/test/suitebuilder/annotation/Suppress.class */
public @interface Suppress {
}
