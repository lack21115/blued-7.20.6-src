package com.zego.zegoavkit2.automixstream;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/automixstream/ZegoAutoMixStreamJNI.class */
public final class ZegoAutoMixStreamJNI {
    private static volatile IZegoAutoMixStreamCallback mCallback;
    private static volatile Handler mHandler;
    private static volatile IZegoSoundLevelInAutoMixStreamCallback mSoundLevelCallback;

    private static native void enableAutoMixStreamCallback(boolean z);

    private static native void enableAutoMixStreamSoundLevelCallback(boolean z);

    public static void onSoundLevelInAutoMixStream(final ArrayList<ZegoSoundLevelInAutoMixStreamInfo> arrayList) {
        if (mSoundLevelCallback == null || mHandler == null) {
            return;
        }
        final IZegoSoundLevelInAutoMixStreamCallback iZegoSoundLevelInAutoMixStreamCallback = mSoundLevelCallback;
        mHandler.post(new Runnable() { // from class: com.zego.zegoavkit2.automixstream.ZegoAutoMixStreamJNI.3
            @Override // java.lang.Runnable
            public void run() {
                IZegoSoundLevelInAutoMixStreamCallback iZegoSoundLevelInAutoMixStreamCallback2 = IZegoSoundLevelInAutoMixStreamCallback.this;
                if (iZegoSoundLevelInAutoMixStreamCallback2 != null) {
                    iZegoSoundLevelInAutoMixStreamCallback2.onSoundLevelInAutoMixStream(arrayList);
                }
            }
        });
    }

    public static void onStartAutoMixStream(final int i, final long j) {
        final IZegoAutoMixStreamCallback iZegoAutoMixStreamCallback = mCallback;
        if (iZegoAutoMixStreamCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.automixstream.ZegoAutoMixStreamJNI.1
                @Override // java.lang.Runnable
                public void run() {
                    IZegoAutoMixStreamCallback iZegoAutoMixStreamCallback2 = IZegoAutoMixStreamCallback.this;
                    if (iZegoAutoMixStreamCallback2 != null) {
                        iZegoAutoMixStreamCallback2.onStartAutoMixStream(i, j);
                    }
                }
            });
        }
    }

    public static void onStopAutoMixStream(final int i, final long j) {
        final IZegoAutoMixStreamCallback iZegoAutoMixStreamCallback = mCallback;
        if (iZegoAutoMixStreamCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.automixstream.ZegoAutoMixStreamJNI.2
                @Override // java.lang.Runnable
                public void run() {
                    IZegoAutoMixStreamCallback iZegoAutoMixStreamCallback2 = IZegoAutoMixStreamCallback.this;
                    if (iZegoAutoMixStreamCallback2 != null) {
                        iZegoAutoMixStreamCallback2.onStopAutoMixStream(i, j);
                    }
                }
            });
        }
    }

    public static void setCallback(IZegoAutoMixStreamCallback iZegoAutoMixStreamCallback) {
        mCallback = iZegoAutoMixStreamCallback;
        enableAutoMixStreamCallback(iZegoAutoMixStreamCallback != null);
    }

    public static void setSoundLevelCallback(IZegoSoundLevelInAutoMixStreamCallback iZegoSoundLevelInAutoMixStreamCallback) {
        mSoundLevelCallback = iZegoSoundLevelInAutoMixStreamCallback;
        enableAutoMixStreamSoundLevelCallback(iZegoSoundLevelInAutoMixStreamCallback != null);
        if (iZegoSoundLevelInAutoMixStreamCallback != null) {
            mHandler = new Handler(Looper.getMainLooper());
        } else {
            mHandler = null;
        }
    }

    public static native int startAutoMixStream(String str, String str2, ZegoAutoMixStreamConfig zegoAutoMixStreamConfig);

    public static native int stopAutoMixStream(String str, String str2);
}
