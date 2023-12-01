package com.tencent.qmsp.sdk.u;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.app.a;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.base.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/u/U.class */
public class U {
    public static final String BEACON_ID_VERSION = "4.1";
    public static final String COMMIT_HASH = "02434ec0969e811e8d211a4583ce2cbfa86ac312";

    static {
        try {
            System.loadLibrary("qmp");
        } catch (Throwable th) {
            th.printStackTrace();
            load_so();
        }
    }

    public static native String a(Context context, int i, Activity activity, String str);

    public static native String[] c(int i);

    public static void clearContent(Context context) {
        e.a(context);
    }

    public static void getOAID(IVendorCallback iVendorCallback) {
        new e().a(iVendorCallback);
    }

    public static String getOAIDSync(Context context) {
        return e.a(context, (String) null, 0);
    }

    private static String getP() {
        try {
            return (String) Class.forName("com.tencent.beacon.event.open.BeaconReport").getDeclaredMethod("getSoPath", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean getSDKIsAlive() {
        return QmspSDK.getSDKIsAlive();
    }

    public static void init_o(Context context, boolean z, boolean z2) {
        e.a(context, z, z2);
    }

    private static boolean load_so() {
        String p = getP();
        try {
            if (TextUtils.isEmpty(p)) {
                return false;
            }
            System.load(p);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void setUserID(String str) {
        a.setmUid(str);
    }

    public static int startQ(Context context, String str, String str2, String str3, String str4, boolean z) {
        QmspSDK.setLogcat(z);
        return QmspSDK.startQmsp(context, str, str2, str3, str4);
    }

    public static void stopQ() {
        QmspSDK.stopQmsp();
    }
}
