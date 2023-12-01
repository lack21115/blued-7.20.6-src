package androidx.versionedparcelable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: source-8756600-dex2jar.jar:androidx/versionedparcelable/ParcelField.class */
public @interface ParcelField {
    String defaultValue() default "";

    int value();
}
