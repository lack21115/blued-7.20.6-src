package com.kwad.components.offline.api.core.api;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/api/IEnvironment.class */
public interface IEnvironment {
    void addOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener);

    String getAppId();

    String getAppVersion();

    String getBiz();

    Context getContext();

    String getDeviceId();

    String getKpf();

    String getKpn();

    double getLatitude(Context context);

    double getLongitude(Context context);

    String getOperator(Context context);

    String getOsVersion();

    String getProcessName(Context context);

    String getSdkVersion();

    int getStatusBarHeight(Context context);

    String getUserAgent();

    boolean isArm64(Context context);

    boolean isDebug();

    boolean isDevelopEnable();

    boolean isInMainProcess(Context context);

    String localIpAddress();

    void removeOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener);

    boolean requestAudioFocus(Context context, boolean z);
}
