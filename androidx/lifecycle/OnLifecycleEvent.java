package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/OnLifecycleEvent.class */
public @interface OnLifecycleEvent {
    Lifecycle.Event value();
}
