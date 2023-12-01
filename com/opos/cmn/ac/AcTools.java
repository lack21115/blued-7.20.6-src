package com.opos.cmn.ac;

import android.text.TextUtils;
import com.opos.cmn.an.f.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/ac/AcTools.class */
public class AcTools {
    private static final String DEFAULT_DATA = "";
    private static volatile boolean SO_ENABLED = false;
    private static final String TAG = "AcTools";
    private static volatile String sBoot;
    private static volatile String sUpdate;

    static {
        try {
            System.loadLibrary("ads-ac");
            SO_ENABLED = true;
        } catch (Throwable th) {
            SO_ENABLED = false;
            a.c(TAG, "so error:", th);
        }
        sUpdate = "";
        sBoot = "";
    }

    public static final String getBootMark() {
        if (SO_ENABLED) {
            try {
                if (TextUtils.isEmpty(sBoot)) {
                    String nativeBootMark = getNativeBootMark();
                    sBoot = nativeBootMark;
                    if (!TextUtils.isEmpty(nativeBootMark)) {
                        sBoot = sBoot.trim();
                    }
                }
                if (sBoot == null) {
                    sBoot = "";
                }
                return sBoot;
            } catch (Throwable th) {
                a.c(TAG, "getBoot", th);
                return "";
            }
        }
        return "";
    }

    private static final native String getNativeBootMark();

    private static final native String getNativeUpdateMark();

    public static final String getUpdateMark() {
        if (SO_ENABLED) {
            try {
                if (TextUtils.isEmpty(sUpdate)) {
                    sUpdate = getNativeUpdateMark();
                }
                if (sUpdate == null) {
                    sUpdate = "";
                }
                return sUpdate;
            } catch (Throwable th) {
                a.c(TAG, "getUpdate", th);
                return "";
            }
        }
        return "";
    }

    public static boolean isSoEnabled() {
        return SO_ENABLED;
    }
}
