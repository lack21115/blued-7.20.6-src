package com.kwad.sdk.core.b;

import android.os.Bundle;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/b/c.class */
public interface c<T> {
    void onActivityCreated(T t, Bundle bundle);

    void onActivityDestroyed(T t);

    void onActivityPaused(T t);

    void onActivityResumed(T t);

    void onBackToBackground();

    void onBackToForeground();
}
