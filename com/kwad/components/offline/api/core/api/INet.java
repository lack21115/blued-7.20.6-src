package com.kwad.components.offline.api.core.api;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/api/INet.class */
public interface INet {
    public static final int HTTP_STATUS_CODE_INVALID = -1;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/api/INet$HostType.class */
    public @interface HostType {
        public static final String API = "api";
        public static final String CDN = "cdn";
        public static final String ULOG = "ulog";
        public static final String ZT = "zt";
    }

    int getActiveNetworkType(Context context);

    String getCurrHost(String str, String str2);

    void handleSwitchHost(String str, String str2, int i, Throwable th);

    boolean isMobileConnected(Context context);

    boolean isNetworkConnected(Context context);

    boolean isWifiConnected(Context context);
}
