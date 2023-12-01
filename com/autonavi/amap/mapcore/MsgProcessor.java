package com.autonavi.amap.mapcore;

import android.content.Context;
import com.amap.api.col.p0003sl.jf;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/amap/mapcore/MsgProcessor.class */
public class MsgProcessor {
    private static jf mDelegate = new jf();

    public static native int nativeInit(Context context);

    public static void nativeInitInfo(Context context, boolean z, String str, String str2, String str3, String[] strArr) {
        mDelegate.a(context, z, str, str2, str3, strArr);
        nativeInit(context);
    }

    public static void nativeMsgProcessor(String str, String str2) {
        mDelegate.a(str, str2);
    }
}
