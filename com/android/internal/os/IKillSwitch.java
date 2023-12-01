package com.android.internal.os;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/IKillSwitch.class */
public interface IKillSwitch {
    String getAccountId();

    String getDeviceUuid();

    boolean isDeviceLocked();

    void setAccountId(String str);

    void setDeviceLocked(boolean z);

    void setDeviceUuid(String str);
}
