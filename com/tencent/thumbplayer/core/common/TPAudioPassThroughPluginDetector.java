package com.tencent.thumbplayer.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPAudioPassThroughPluginDetector.class */
public class TPAudioPassThroughPluginDetector {
    private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
    private static final String TAG = "TPAudioPassThroughPluginDetector";
    private static boolean hasRegisterReceiver = false;
    private static boolean isInitted = false;
    private static WeakReference<Context> mContextRef;
    private static Handler mHandler;
    private static BroadcastReceiver mReceiver;
    private static List<AudioPassThroughPluginListener> listeners = new LinkedList();
    private static boolean mIsAudioPassThroughPlugin = false;
    private static TPAudioPassThroughCapabilities mAudioPassThroughCapabilities = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPAudioPassThroughPluginDetector$AudioPassThroughPluginListener.class */
    public interface AudioPassThroughPluginListener {
        void onAudioPassThroughPlugin(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPAudioPassThroughPluginDetector$HdmiAudioPlugBroadcastReceiver.class */
    public static class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        private HdmiAudioPlugBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TPNativeLog.printLog(2, TPAudioPassThroughPluginDetector.TAG, "HdmiAudioPlugBroadcastReceiver onReceive: " + intent.getAction());
            if (intent != null) {
                boolean z = false;
                int intExtra = intent.getIntExtra(AudioManager.EXTRA_AUDIO_PLUG_STATE, 0);
                if (intExtra != 0 && intExtra == 1) {
                    z = true;
                }
                TPNativeLog.printLog(2, TPAudioPassThroughPluginDetector.TAG, "HdmiAudioPlugBroadcastReceiver audioPassThroughState:" + intExtra + " bPlugin:" + z);
                TPAudioPassThroughPluginDetector.onUpdateAudioCapabilities(new TPAudioPassThroughCapabilities(intent.getIntArrayExtra(AudioManager.EXTRA_ENCODINGS), intent.getIntExtra(AudioManager.EXTRA_MAX_CHANNEL_COUNT, 8)));
                TPAudioPassThroughPluginDetector.notifyAudioPassThroughStateChange(z);
            }
        }
    }

    public static void addListener(AudioPassThroughPluginListener audioPassThroughPluginListener) {
        synchronized (TPAudioPassThroughPluginDetector.class) {
            try {
                if (listeners.add(audioPassThroughPluginListener) && !hasRegisterReceiver) {
                    registerReceiver();
                    hasRegisterReceiver = true;
                }
            } finally {
            }
        }
    }

    public static void deinit() {
        synchronized (TPAudioPassThroughPluginDetector.class) {
            try {
                if (isInitted && mContextRef != null) {
                    mContextRef.clear();
                    isInitted = false;
                    TPNativeLog.printLog(2, TAG, "TPAudioPassThroughPluginDetector deinit succeed!");
                }
            } finally {
            }
        }
    }

    private static Looper getLooper() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    public static void init(Context context) {
        synchronized (TPAudioPassThroughPluginDetector.class) {
            try {
                TPNativeLog.printLog(2, TAG, "TPAudioPassThroughPluginDetector init enter!");
                if (isInitted) {
                    return;
                }
                mContextRef = new WeakReference<>(context.getApplicationContext());
                isInitted = true;
                mHandler = new Handler(getLooper());
                registerReceiver();
                hasRegisterReceiver = true;
                TPNativeLog.printLog(2, TAG, "TPAudioPassThroughPluginDetector init succeed!");
            } finally {
            }
        }
    }

    public static boolean isAudioPassThroughPlugin() {
        boolean z;
        synchronized (TPAudioPassThroughPluginDetector.class) {
            try {
                z = mIsAudioPassThroughPlugin;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static boolean isAudioPassThroughSupport(int i, int i2) {
        TPAudioPassThroughCapabilities tPAudioPassThroughCapabilities = mAudioPassThroughCapabilities;
        if (tPAudioPassThroughCapabilities != null) {
            return tPAudioPassThroughCapabilities.supportsEncoding(i) && i2 <= mAudioPassThroughCapabilities.getMaxChannelCount();
        }
        TPNativeLog.printLog(4, TAG, "isAudioPassThroughSupport failed, mAudioPassThroughCapabilities is not init yet!");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyAudioPassThroughStateChange(boolean z) {
        if (mIsAudioPassThroughPlugin != z) {
            mIsAudioPassThroughPlugin = z;
            synchronized (TPAudioPassThroughPluginDetector.class) {
                try {
                    for (AudioPassThroughPluginListener audioPassThroughPluginListener : listeners) {
                        audioPassThroughPluginListener.onAudioPassThroughPlugin(z);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onUpdateAudioCapabilities(TPAudioPassThroughCapabilities tPAudioPassThroughCapabilities) {
        if (tPAudioPassThroughCapabilities.equals(mAudioPassThroughCapabilities)) {
            return;
        }
        mAudioPassThroughCapabilities = tPAudioPassThroughCapabilities;
        TPNativeLog.printLog(2, TAG, "onUpdateAudioCapabilities AudioCapabilities:" + mAudioPassThroughCapabilities.toString());
    }

    private static void registerReceiver() {
        TPNativeLog.printLog(2, TAG, "registerReceiver enter");
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        if (!isInitted || mContextRef == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, TPAudioPassThroughPluginDetector is not init yet!");
            return;
        }
        Intent intent = null;
        if (mReceiver == null) {
            mReceiver = new HdmiAudioPlugBroadcastReceiver();
        }
        Context context = mContextRef.get();
        if (context == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, context is null, maybe is invalid!");
            return;
        }
        if (mReceiver != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(AudioManager.ACTION_HDMI_AUDIO_PLUG);
            intent = context.registerReceiver(mReceiver, intentFilter, null, mHandler);
        }
        mAudioPassThroughCapabilities = TPAudioPassThroughCapabilities.getCapabilities(context, intent);
        TPNativeLog.printLog(2, TAG, "registerReceiver leave");
    }

    public static void removeListener(AudioPassThroughPluginListener audioPassThroughPluginListener) {
        synchronized (TPAudioPassThroughPluginDetector.class) {
            try {
                listeners.remove(audioPassThroughPluginListener);
                if (listeners.isEmpty() && hasRegisterReceiver) {
                    unregisterReceiver();
                    hasRegisterReceiver = false;
                }
            } finally {
            }
        }
    }

    private static void unregisterReceiver() {
        WeakReference<Context> weakReference;
        if (!isInitted || (weakReference = mContextRef) == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, TPAudioPassThroughPluginDetector is not init yet!");
            return;
        }
        Context context = weakReference.get();
        if (context == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, context is null, maybe is invalid!");
        } else {
            context.unregisterReceiver(mReceiver);
        }
    }
}
