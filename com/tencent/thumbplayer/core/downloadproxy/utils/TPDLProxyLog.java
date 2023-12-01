package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.util.Log;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog.class */
public class TPDLProxyLog {
    private static ITPDLProxyLogListener mLogListener;
    private static int mServiceType;

    public static void d(String str, int i, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.d(str, i, str2, str3);
            return;
        }
        Log.d("[" + str2 + "][" + str + ":" + i + "]", str3);
    }

    public static void e(String str, int i, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.e(str, i, str2, str3);
            return;
        }
        Log.e("[" + str2 + "][" + str + ":" + i + "]", str3);
    }

    public static void i(String str, int i, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.i(str, i, str2, str3);
            return;
        }
        Log.i("[" + str2 + "][" + str + ":" + i + "]", str3);
    }

    public static void setLogListener(int i, ITPDLProxyLogListener iTPDLProxyLogListener) {
        mServiceType = i;
        mLogListener = iTPDLProxyLogListener;
    }

    public static void w(String str, int i, String str2, String str3) {
        ITPDLProxyLogListener iTPDLProxyLogListener = mLogListener;
        if (iTPDLProxyLogListener != null) {
            iTPDLProxyLogListener.w(str, i, str2, str3);
            return;
        }
        Log.w("[" + str2 + "][" + str + ":" + i + "]", str3);
    }
}
