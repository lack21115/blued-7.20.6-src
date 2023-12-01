package com.tencent.tmsqmsp.sdk.app;

import android.content.Context;
import com.tencent.mapsdk.internal.oj;
import com.tencent.tmsqmsp.sdk.a.c;
import com.tencent.tmsqmsp.sdk.c.f;
import com.tencent.tmsqmsp.sdk.f.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/app/QmspSDK.class */
public class QmspSDK extends oj {
    public static /* bridge */ /* synthetic */ String getAppID() {
        return oj.getAppID();
    }

    public static /* bridge */ /* synthetic */ Context getContext() {
        return oj.getContext();
    }

    public static /* bridge */ /* synthetic */ String getDevId() {
        return oj.getDevId();
    }

    public static /* bridge */ /* synthetic */ String getQImeiVer() {
        return oj.getQImeiVer();
    }

    public static String getQmspVer() {
        return c.d();
    }

    public static boolean getSDKIsAlive() {
        if (oj.getTaskStatus()) {
            return b.e().a();
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ String getUid() {
        return oj.getUid();
    }

    public static /* bridge */ /* synthetic */ String getmOAID() {
        return oj.getmOAID();
    }

    public static int sendCmdToLib(int i, int i2, int i3, Object[] objArr, Object[] objArr2) {
        return f.i().a(i, i2, i3, objArr, objArr2);
    }

    public static void setLogcat(boolean z) {
        g.a(z);
    }

    public static int startQmsp(Context context, String str, String str2, String str3, String str4) {
        return oj.login(context, str, str2, str3, str4);
    }

    public static int startQmsp(Context context, String str, String str2, String str3, String str4, com.tencent.tmsqmsp.sdk.b.f fVar) {
        return oj.login(context, str, str2, str3, str4, fVar);
    }

    public static void stopQmsp() {
        oj.logout();
    }
}
