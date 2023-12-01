package com.zego.zegoavkit2.mixstream;

import android.os.Handler;
import android.os.Looper;
import com.zego.zegoavkit2.entities.ZegoStreamRelayCDNInfo;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mixstream/ZegoMixStreamJNI.class */
public final class ZegoMixStreamJNI {
    private static IZegoMixStreamCallback mCallback;
    private static IZegoMixStreamExCallback mExCallback;
    private static Handler mHandler;
    private static IZegoMixStreamRelayCDNCallback mRelayCDNCallback;
    private static IZegoSoundLevelInMixStreamCallback mSoundLevelCallback;

    public static native boolean mixStream(ZegoCompleteMixStreamInfo zegoCompleteMixStreamInfo, int i);

    public static native int mixStreamEx(ZegoMixStreamConfig zegoMixStreamConfig, String str);

    public static void onMixStreamConfigUpdate(final int i, final String str, final HashMap<String, Object> hashMap) {
        if (mCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.mixstream.ZegoMixStreamJNI.1
            @Override // java.lang.Runnable
            public void run() {
                if (ZegoMixStreamJNI.mCallback != null) {
                    ZegoMixStreamJNI.mCallback.onMixStreamConfigUpdate(i, str, hashMap);
                }
            }
        });
    }

    public static void onMixStreamExConfigUpdate(final int i, final String str, final ZegoMixStreamResultEx zegoMixStreamResultEx) {
        if (mExCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.mixstream.ZegoMixStreamJNI.2
            @Override // java.lang.Runnable
            public void run() {
                if (ZegoMixStreamJNI.mExCallback != null) {
                    ZegoMixStreamJNI.mExCallback.onMixStreamExConfigUpdate(i, str, zegoMixStreamResultEx);
                }
            }
        });
    }

    public static void onMixStreamRelayCDNStateUpdate(final ZegoStreamRelayCDNInfo[] zegoStreamRelayCDNInfoArr, final String str) {
        if (mRelayCDNCallback == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.mixstream.ZegoMixStreamJNI.3
            @Override // java.lang.Runnable
            public void run() {
                if (ZegoMixStreamJNI.mRelayCDNCallback != null) {
                    ZegoMixStreamJNI.mRelayCDNCallback.onMixStreamRelayCDNStateUpdate(zegoStreamRelayCDNInfoArr, str);
                }
            }
        });
    }

    public static void onSoundLevelInMixStreamCallback(final ArrayList<ZegoSoundLevelInMixStreamInfo> arrayList) {
        Handler handler;
        final IZegoSoundLevelInMixStreamCallback iZegoSoundLevelInMixStreamCallback = mSoundLevelCallback;
        if (iZegoSoundLevelInMixStreamCallback == null || (handler = mHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.zego.zegoavkit2.mixstream.ZegoMixStreamJNI.4
            @Override // java.lang.Runnable
            public void run() {
                IZegoSoundLevelInMixStreamCallback iZegoSoundLevelInMixStreamCallback2 = IZegoSoundLevelInMixStreamCallback.this;
                if (iZegoSoundLevelInMixStreamCallback2 != null) {
                    iZegoSoundLevelInMixStreamCallback2.onSoundLevelInMixStream(arrayList);
                }
            }
        });
    }

    public static void setCallback(IZegoMixStreamCallback iZegoMixStreamCallback) {
        mCallback = iZegoMixStreamCallback;
        setMixStreamCallback(iZegoMixStreamCallback != null);
    }

    private static native void setMixStreamCallback(boolean z);

    public static void setMixStreamExCallback(IZegoMixStreamExCallback iZegoMixStreamExCallback) {
        mExCallback = iZegoMixStreamExCallback;
        setMixStreamExCallback(iZegoMixStreamExCallback != null);
    }

    private static native void setMixStreamExCallback(boolean z);

    public static void setRelayCDNCallback(IZegoMixStreamRelayCDNCallback iZegoMixStreamRelayCDNCallback) {
        mRelayCDNCallback = iZegoMixStreamRelayCDNCallback;
    }

    public static void setSoundLevelInMixStreamCallback(IZegoSoundLevelInMixStreamCallback iZegoSoundLevelInMixStreamCallback) {
        mSoundLevelCallback = iZegoSoundLevelInMixStreamCallback;
        setSoundLevelInMixStreamCallback(iZegoSoundLevelInMixStreamCallback != null);
        if (iZegoSoundLevelInMixStreamCallback != null) {
            mHandler = new Handler(Looper.getMainLooper());
        } else {
            mHandler = null;
        }
    }

    private static native void setSoundLevelInMixStreamCallback(boolean z);
}
