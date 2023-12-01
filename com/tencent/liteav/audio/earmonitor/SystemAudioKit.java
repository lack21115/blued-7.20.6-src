package com.tencent.liteav.audio.earmonitor;

import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;

@JNINamespace("liteav::audio")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/SystemAudioKit.class */
public abstract class SystemAudioKit {
    private final long mNativeSystemAudioKit;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemAudioKit(long j) {
        this.mNativeSystemAudioKit = j;
    }

    public static SystemAudioKit create(long j) {
        String manufacturer = LiteavSystemInfo.getManufacturer();
        if (TextUtils.isEmpty(manufacturer)) {
            return null;
        }
        String lowerCase = manufacturer.toLowerCase();
        boolean z = true;
        int hashCode = lowerCase.hashCode();
        if (hashCode != -1206476313) {
            if (hashCode == 3620012 && lowerCase.equals(AssistUtils.BRAND_VIVO)) {
                z = true;
            }
        } else if (lowerCase.equals(AssistUtils.BRAND_HW)) {
            z = false;
        }
        if (z) {
            if (!z) {
                return null;
            }
            return new h(j, ContextUtils.getApplicationContext());
        }
        return new a(j, ContextUtils.getApplicationContext());
    }

    private static native void nativeNotifyEarMonitoringInitialized(long j, SystemAudioKit systemAudioKit, boolean z);

    private static native void nativeNotifySystemError(long j, SystemAudioKit systemAudioKit);

    public abstract void initialize();

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyEarMonitoringInitialized(SystemAudioKit systemAudioKit, boolean z) {
        nativeNotifyEarMonitoringInitialized(this.mNativeSystemAudioKit, systemAudioKit, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifySystemError(SystemAudioKit systemAudioKit) {
        nativeNotifySystemError(this.mNativeSystemAudioKit, systemAudioKit);
    }

    public abstract void setEarMonitoringVolume(int i);

    public abstract void startEarMonitoring();

    public abstract void stopEarMonitoring();

    public abstract void terminate();
}
