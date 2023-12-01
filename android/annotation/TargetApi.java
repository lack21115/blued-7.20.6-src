package android.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted:
  source-8756600-dex2jar.jar:android/annotation/TargetApi.class
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-9557208-dex2jar.jar:android/annotation/TargetApi.class */
public @interface TargetApi {
    int value();
}
