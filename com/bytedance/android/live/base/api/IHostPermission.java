package com.bytedance.android.live.base.api;

import com.bytedance.android.live.base.IService;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/IHostPermission.class */
public interface IHostPermission extends IService {
    boolean alist();

    String getDevImei();

    String getDevOaid();

    String getMacAddress();

    LocationProvider getTTLocation();

    boolean isCanUseLocation();

    boolean isCanUsePhoneState();

    boolean isCanUseWifiState();

    boolean isCanUseWriteExternal();
}
