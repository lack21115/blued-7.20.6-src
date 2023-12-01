package androidx.activity.contextaware;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-8756600-dex2jar.jar:androidx/activity/contextaware/ContextAwareHelper.class */
public final class ContextAwareHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Set<OnContextAvailableListener> f1500a = new CopyOnWriteArraySet();
    private volatile Context b;

    public void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        if (this.b != null) {
            onContextAvailableListener.onContextAvailable(this.b);
        }
        this.f1500a.add(onContextAvailableListener);
    }

    public void clearAvailableContext() {
        this.b = null;
    }

    public void dispatchOnContextAvailable(Context context) {
        this.b = context;
        for (OnContextAvailableListener onContextAvailableListener : this.f1500a) {
            onContextAvailableListener.onContextAvailable(context);
        }
    }

    public Context peekAvailableContext() {
        return this.b;
    }

    public void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.f1500a.remove(onContextAvailableListener);
    }
}
