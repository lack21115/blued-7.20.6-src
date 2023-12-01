package com.tencent.qmsp.sdk.app;

import android.content.Context;
import com.tencent.qmsp.sdk.a.c;
import com.tencent.qmsp.sdk.c.f;
import com.tencent.qmsp.sdk.f.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/app/QmspSDK.class */
public class QmspSDK extends a {
    public static String getQmspVer() {
        return c.d();
    }

    public static boolean getSDKIsAlive() {
        if (a.getTaskStatus()) {
            return b.e().a();
        }
        return false;
    }

    public static int sendCmdToLib(int i, int i2, int i3, Object[] objArr, Object[] objArr2) {
        return f.i().a(i, i2, i3, objArr, objArr2);
    }

    public static void setLogcat(boolean z) {
        g.a(z);
    }

    public static int startQmsp(Context context, String str, String str2, String str3, String str4) {
        return a.login(context, str, str2, str3, str4);
    }

    public static int startQmsp(Context context, String str, String str2, String str3, String str4, com.tencent.qmsp.sdk.b.f fVar) {
        return a.login(context, str, str2, str3, str4, fVar);
    }

    public static void stopQmsp() {
        a.logout();
    }
}
