package com.bytedance.pangle;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/ZeusPluginStateListener.class */
public abstract class ZeusPluginStateListener {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FINISH = 0;
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static void postStateChange(final String str, final int i, final Object... objArr) {
        mHandler.post(new Runnable() { // from class: com.bytedance.pangle.ZeusPluginStateListener.1
            @Override // java.lang.Runnable
            public final void run() {
                List<ZeusPluginStateListener> list = h.a().b;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (ZeusPluginStateListener zeusPluginStateListener : list) {
                    zeusPluginStateListener.onPluginStateChange(TextUtils.isEmpty(String.this) ? "UNKNOWN" : String.this, i, objArr);
                }
            }
        });
        List<ZeusPluginStateListener> list = h.a().b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ZeusPluginStateListener zeusPluginStateListener : list) {
            zeusPluginStateListener.onStateChangeOnCurThread(TextUtils.isEmpty(str) ? "UNKNOWN" : str, i, objArr);
        }
    }

    @Deprecated
    public void onPluginStateChange(String str, int i, Object... objArr) {
    }

    public void onStateChangeOnCurThread(String str, int i, Object... objArr) {
    }
}
