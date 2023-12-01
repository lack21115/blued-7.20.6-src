package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass
/* loaded from: source-8756600-dex2jar.jar:butterknife/OnPageChange.class */
public @interface OnPageChange {

    /* loaded from: source-8756600-dex2jar.jar:butterknife/OnPageChange$Callback.class */
    public enum Callback {
        PAGE_SELECTED,
        PAGE_SCROLLED,
        PAGE_SCROLL_STATE_CHANGED
    }
}
