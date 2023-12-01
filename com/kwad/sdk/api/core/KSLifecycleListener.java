package com.kwad.sdk.api.core;

import android.app.Activity;
import android.os.Bundle;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/KSLifecycleListener.class */
public interface KSLifecycleListener {
    void onActivityCreated(Activity activity, Bundle bundle);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onBackToBackground();

    void onBackToForeground();
}
