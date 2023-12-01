package com.tencent.thumbplayer.core.common;

import android.bluetooth.BluetoothA2dp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPHeadsetPluginDetector.class */
public class TPHeadsetPluginDetector {
    private static final int AUDIO_TYPE_BLUETOOTH_A2DP = 2;
    private static final int AUDIO_TYPE_BUILTIN_OTHERS = 99;
    private static final int AUDIO_TYPE_BUILTIN_SPEAKER = 0;
    private static final int AUDIO_TYPE_HEADPHONES = 1;
    private static final String TAG = "TPHeadsetPluginDetector";
    private static boolean hasRegisterReceiver = false;
    private static boolean isInitted = false;
    private static WeakReference<Context> mContextRef;
    private static BroadcastReceiver mReceiver;
    private static List<HeadsetPluginListener> listeners = new LinkedList();
    private static Set<Integer> mCurOutputs = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPHeadsetPluginDetector$HeadsetPluginListener.class */
    public interface HeadsetPluginListener {
        void onHeadsetPlugin(Set<Integer> set, Set<Integer> set2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPHeadsetPluginDetector$HeadsetPluginReceiver.class */
    public static class HeadsetPluginReceiver extends BroadcastReceiver {
        private HeadsetPluginReceiver() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0090, code lost:
            if (r0 != null) goto L10;
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r5, android.content.Intent r6) {
            /*
                r4 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                java.lang.String r2 = "onReceive: "
                r1.<init>(r2)
                r5 = r0
                r0 = r5
                r1 = r6
                java.lang.String r1 = r1.getAction()
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r5
                java.lang.String r0 = r0.toString()
                r9 = r0
                r0 = 2
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r5 = r0
                r0 = 2
                java.lang.String r1 = "TPHeadsetPluginDetector"
                r2 = r9
                com.tencent.thumbplayer.core.common.TPNativeLog.printLog(r0, r1, r2)
                java.util.Set r0 = com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.access$100()
                r9 = r0
                java.lang.String r0 = "android.intent.action.HEADSET_PLUG"
                r1 = r6
                java.lang.String r1 = r1.getAction()
                boolean r0 = r0.equals(r1)
                r8 = r0
                r0 = 0
                r7 = r0
                r0 = 1
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r10 = r0
                r0 = r8
                if (r0 == 0) goto L82
                r0 = r6
                java.lang.String r1 = "state"
                boolean r0 = r0.hasExtra(r1)
                if (r0 == 0) goto L54
                r0 = r6
                java.lang.String r1 = "state"
                r2 = 0
                int r0 = r0.getIntExtra(r1, r2)
                r7 = r0
            L54:
                r0 = r9
                if (r0 == 0) goto L79
                r0 = r7
                if (r0 != 0) goto L6a
            L5d:
                r0 = r9
                r1 = r10
                boolean r0 = r0.remove(r1)
                goto L79
            L6a:
                r0 = r7
                r1 = 1
                if (r0 != r1) goto L79
                r0 = r9
                r1 = r10
                boolean r0 = r0.add(r1)
            L79:
                java.util.Set r0 = com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.access$000()
                r1 = r9
                com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.access$200(r0, r1)
                return
            L82:
                java.lang.String r0 = "android.media.AUDIO_BECOMING_NOISY"
                r1 = r6
                java.lang.String r1 = r1.getAction()
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L96
                r0 = r9
                if (r0 == 0) goto L79
                goto L5d
            L96:
                java.lang.String r0 = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED"
                r1 = r6
                java.lang.String r1 = r1.getAction()
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto Ld5
                r0 = r6
                java.lang.String r1 = "android.bluetooth.profile.extra.STATE"
                r2 = 0
                int r0 = r0.getIntExtra(r1, r2)
                r7 = r0
                r0 = r9
                if (r0 == 0) goto Lcd
                r0 = r7
                r1 = 2
                if (r0 != r1) goto Lc0
                r0 = r9
                r1 = r5
                boolean r0 = r0.add(r1)
                goto Lcd
            Lc0:
                r0 = r7
                if (r0 != 0) goto Lcd
                r0 = r9
                r1 = r5
                boolean r0 = r0.remove(r1)
            Lcd:
                java.util.Set r0 = com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.access$000()
                r1 = r9
                com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.access$200(r0, r1)
            Ld5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.HeadsetPluginReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    static /* synthetic */ Set access$100() {
        return getAudioOutputs();
    }

    public static void addHeadsetPluginListener(HeadsetPluginListener headsetPluginListener) {
        synchronized (TPHeadsetPluginDetector.class) {
            try {
                if (listeners.add(headsetPluginListener) && !hasRegisterReceiver) {
                    registerReceiver();
                    hasRegisterReceiver = true;
                }
            } finally {
            }
        }
    }

    public static void deinit() {
        synchronized (TPHeadsetPluginDetector.class) {
            try {
                if (isInitted && mContextRef != null) {
                    mContextRef.clear();
                    isInitted = false;
                    TPNativeLog.printLog(2, TAG, "HeadsetPluginDetector deinit succeed!");
                }
            } finally {
            }
        }
    }

    private static AudioManager getAudioManager() {
        String str;
        WeakReference<Context> weakReference;
        if (!isInitted || (weakReference = mContextRef) == null) {
            str = "getAudioManager failed, HeadsetPluginDetector is not init yet!";
        } else {
            Context context = weakReference.get();
            if (context == null) {
                str = "getAudioManager failed, context is null, maybe is invalid!";
            } else {
                AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                if (audioManager != null) {
                    return audioManager;
                }
                str = "getAudioManager failed, audioMgr is null!";
            }
        }
        TPNativeLog.printLog(4, TAG, str);
        return null;
    }

    private static Set<Integer> getAudioOutputs() {
        Integer num;
        HashSet hashSet = new HashSet();
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            return hashSet;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            AudioDeviceInfo[] devices = audioManager.getDevices(2);
            if (devices != null) {
                int length = devices.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    AudioDeviceInfo audioDeviceInfo = devices[i2];
                    if (audioDeviceInfo.getType() == 2) {
                        num = 0;
                    } else if (audioDeviceInfo.getType() == 8) {
                        num = 2;
                    } else if (audioDeviceInfo.getType() == 3) {
                        num = 1;
                    } else {
                        i = i2 + 1;
                    }
                    hashSet.add(num);
                    i = i2 + 1;
                }
            }
        } else {
            hashSet.add(0);
            if (isHeadsetPlugin()) {
                hashSet.add(1);
            }
            if (isBluetoothPlugin()) {
                hashSet.add(2);
            }
        }
        return hashSet;
    }

    public static Set<Integer> getCurrentRoutes() {
        return mCurOutputs;
    }

    public static void init(Context context) {
        synchronized (TPHeadsetPluginDetector.class) {
            try {
                if (isInitted) {
                    return;
                }
                mContextRef = new WeakReference<>(context.getApplicationContext());
                isInitted = true;
                initCurrentOutputs();
                TPNativeLog.printLog(2, TAG, "HeadsetPluginDetector init succeed!");
            } finally {
            }
        }
    }

    private static void initCurrentOutputs() {
        mCurOutputs = getAudioOutputs();
    }

    public static boolean isAudioRouteTypeOn(int i) {
        Set<Integer> set = mCurOutputs;
        if (set == null) {
            return false;
        }
        return set.contains(Integer.valueOf(i));
    }

    public static boolean isBluetoothPlugin() {
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            return false;
        }
        return audioManager.isBluetoothA2dpOn();
    }

    public static boolean isHeadsetPlugin() {
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            return false;
        }
        return audioManager.isWiredHeadsetOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyAudioOutputStateChange(Set<Integer> set, Set<Integer> set2) {
        if (set == null || set2 == null || set.size() != set2.size() || !set2.containsAll(set)) {
            mCurOutputs = set2;
            synchronized (TPHeadsetPluginDetector.class) {
                try {
                    for (HeadsetPluginListener headsetPluginListener : listeners) {
                        headsetPluginListener.onHeadsetPlugin(set, set2);
                    }
                } finally {
                }
            }
        }
    }

    private static boolean registerDeviceCallback() {
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            return false;
        }
        audioManager.registerAudioDeviceCallback(new AudioDeviceCallback() { // from class: com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.1
            @Override // android.media.AudioDeviceCallback
            public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                TPNativeLog.printLog(2, TPHeadsetPluginDetector.TAG, "onAudioDevicesAdded!");
                TPHeadsetPluginDetector.notifyAudioOutputStateChange(TPHeadsetPluginDetector.mCurOutputs, TPHeadsetPluginDetector.access$100());
            }

            @Override // android.media.AudioDeviceCallback
            public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                TPNativeLog.printLog(2, TPHeadsetPluginDetector.TAG, "onAudioDevicesRemoved!");
                TPHeadsetPluginDetector.notifyAudioOutputStateChange(TPHeadsetPluginDetector.mCurOutputs, TPHeadsetPluginDetector.access$100());
            }
        }, null);
        return true;
    }

    private static void registerReceiver() {
        WeakReference<Context> weakReference;
        if (Build.VERSION.SDK_INT < 23 || !registerDeviceCallback()) {
            if (mReceiver == null) {
                mReceiver = new HeadsetPluginReceiver();
            }
            if (!isInitted || (weakReference = mContextRef) == null) {
                TPNativeLog.printLog(4, TAG, "registerReceiver failed, TPHeadsetPluginDetector is not init yet!");
                return;
            }
            Context context = weakReference.get();
            if (context == null) {
                TPNativeLog.printLog(4, TAG, "registerReceiver failed, context is null, maybe is invalid!");
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction(AudioManager.ACTION_AUDIO_BECOMING_NOISY);
            intentFilter.addAction(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED);
            context.registerReceiver(mReceiver, intentFilter);
        }
    }

    public static void removeHeadsetPluginListener(HeadsetPluginListener headsetPluginListener) {
        synchronized (TPHeadsetPluginDetector.class) {
            try {
                listeners.remove(headsetPluginListener);
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
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, HeadsetPluginDetector is not init yet!");
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
