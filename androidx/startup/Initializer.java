package androidx.startup;

import android.content.Context;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/startup/Initializer.class */
public interface Initializer<T> {
    T create(Context context);

    List<Class<? extends Initializer<?>>> dependencies();
}
