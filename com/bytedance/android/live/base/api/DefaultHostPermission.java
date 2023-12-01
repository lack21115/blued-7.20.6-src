package com.bytedance.android.live.base.api;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/DefaultHostPermission.class */
public class DefaultHostPermission implements IHostPermission {
    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        return true;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevImei() {
        return null;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevOaid() {
        return null;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getMacAddress() {
        return null;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public LocationProvider getTTLocation() {
        return null;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        return true;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        return true;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        return true;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        return true;
    }
}
