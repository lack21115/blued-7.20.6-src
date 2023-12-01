package androidx.activity.contextaware;

import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:androidx/activity/contextaware/ContextAware.class */
public interface ContextAware {
    void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener);

    Context peekAvailableContext();

    void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener);
}
