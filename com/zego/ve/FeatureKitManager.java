package com.zego.ve;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/FeatureKitManager.class */
public class FeatureKitManager {
    private IAudioKitCallback mCallBack = null;
    private static final Object SET_CALL_BACK_LOCK = new Object();
    private static final Object NEW_FEATUREMANAGER_LOCK = new Object();
    private static final Object BIND_SERVICE_LOCK = new Object();
    private static final Object UNBIND_SERVICE_LOCK = new Object();
    private static FeatureKitManager sInstance = null;

    private FeatureKitManager() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static FeatureKitManager getInstance() {
        FeatureKitManager featureKitManager;
        synchronized (NEW_FEATUREMANAGER_LOCK) {
            if (sInstance == null) {
                sInstance = new FeatureKitManager();
            }
            featureKitManager = sInstance;
        }
        return featureKitManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bindService(Context context, ServiceConnection serviceConnection, String str) {
        synchronized (BIND_SERVICE_LOCK) {
            if (context != null) {
                Intent intent = new Intent();
                intent.setClassName("com.huawei.multimedia.audioengine", str);
                try {
                    context.bindService(intent, serviceConnection, 1);
                } catch (SecurityException e) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HwAudioKaraokeFeatureKit createFeatureKit(int i, Context context) {
        if (context != null && i == 1) {
            HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = new HwAudioKaraokeFeatureKit(context);
            hwAudioKaraokeFeatureKit.initialize(context);
            return hwAudioKaraokeFeatureKit;
        }
        return null;
    }

    protected IAudioKitCallback getCallBack() {
        return this.mCallBack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isMediaKitSupport(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                return packageManager.getPackageInfo("com.huawei.multimedia.audioengine", 0) != null;
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCallBack(int i) {
        synchronized (SET_CALL_BACK_LOCK) {
            if (getCallBack() != null) {
                getCallBack().onResult(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCallBack(IAudioKitCallback iAudioKitCallback) {
        this.mCallBack = iAudioKitCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        synchronized (UNBIND_SERVICE_LOCK) {
            if (context != null) {
                context.unbindService(serviceConnection);
            }
        }
    }
}
