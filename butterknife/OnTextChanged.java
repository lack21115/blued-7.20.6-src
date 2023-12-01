package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass
/* loaded from: source-8756600-dex2jar.jar:butterknife/OnTextChanged.class */
public @interface OnTextChanged {

    /* loaded from: source-8756600-dex2jar.jar:butterknife/OnTextChanged$Callback.class */
    public enum Callback {
        TEXT_CHANGED,
        BEFORE_TEXT_CHANGED,
        AFTER_TEXT_CHANGED
    }
}
