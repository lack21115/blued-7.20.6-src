package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-8756600-dex2jar.jar:androidx/annotation/BinderThread.class */
public @interface BinderThread {
}
