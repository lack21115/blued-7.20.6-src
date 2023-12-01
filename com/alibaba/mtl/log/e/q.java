package com.alibaba.mtl.log.e;

import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/q.class */
public class q {
    private static final String TAG = q.class.getSimpleName();

    public static String get(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls.newInstance(), str);
        } catch (Exception e) {
            Log.e(TAG, "get() ERROR!!! Exception!", e);
            return "";
        }
    }

    public static String get(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls.newInstance(), str, str2);
        } catch (Exception e) {
            Log.e(TAG, "get() ERROR!!! Exception!", e);
            return "";
        }
    }
}
