package android.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: source-9557208-dex2jar.jar:android/annotation/StringDef.class */
public @interface StringDef {
    String[] value() default {};
}
