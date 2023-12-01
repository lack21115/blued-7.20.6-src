package com.kwad.sdk.api.core.lifecycle;

import androidx.lifecycle.LifecycleObserver;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/lifecycle/KsLifecycleObserver.class */
public class KsLifecycleObserver {
    LifecycleObserver mBase;

    public LifecycleObserver getBase() {
        return this.mBase;
    }

    public void setBase(LifecycleObserver lifecycleObserver) {
        this.mBase = lifecycleObserver;
    }
}
