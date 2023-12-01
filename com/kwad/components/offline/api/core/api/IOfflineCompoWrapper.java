package com.kwad.components.offline.api.core.api;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/api/IOfflineCompoWrapper.class */
public abstract class IOfflineCompoWrapper {
    protected String mOfflinePackageName;

    public IOfflineCompoWrapper(String str) {
        this.mOfflinePackageName = str;
    }

    @Deprecated
    public abstract Context unwrapContextIfNeed(Context context);

    public abstract Context wrapContextIfNeed(Context context);

    public abstract Application wrapGetApplication(Context context);

    public abstract LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater);
}
