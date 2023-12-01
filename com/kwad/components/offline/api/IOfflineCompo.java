package com.kwad.components.offline.api;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/IOfflineCompo.class */
public interface IOfflineCompo {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/IOfflineCompo$Priority.class */
    public interface Priority {
        public static final int HIGH = -100;
        public static final int HIGHEST = -200;
        public static final int LOW = 100;
        public static final int LOWEST = 200;
        public static final int NORMAL = 0;
    }

    Class getComponentsType();

    void init(Context context);

    int priority();
}
