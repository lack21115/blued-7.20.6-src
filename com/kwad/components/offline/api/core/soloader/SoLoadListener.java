package com.kwad.components.offline.api.core.soloader;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/soloader/SoLoadListener.class */
public interface SoLoadListener {
    void onFailed(int i, Throwable th);

    void onLoaded();

    void onPreUpdate();
}
