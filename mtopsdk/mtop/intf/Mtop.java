package mtopsdk.mtop.intf;

import android.content.Context;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.global.MtopSDK;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.global.SDKUtils;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/intf/Mtop.class */
public class Mtop {
    private static volatile Mtop a;
    private static volatile boolean b = false;

    private Mtop() {
    }

    public static Mtop a(Context context) {
        return a(context, (String) null);
    }

    public static Mtop a(Context context, String str) {
        if (a == null) {
            synchronized (Mtop.class) {
                try {
                    if (a == null) {
                        a = new Mtop();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!b) {
                b(context, str);
            }
        }
        if (StringUtils.a(str)) {
            SDKConfig.a().d(str);
        }
        return a;
    }

    private static void b(Context context, String str) {
        synchronized (Mtop.class) {
            try {
                if (!b) {
                    if (context == null) {
                        TBSdkLog.d("mtopsdk.Mtop", "[Mtop init] The Parameter context can not be null.");
                        throw new IllegalArgumentException("The Parameter context can not be null.");
                    }
                    if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
                        TBSdkLog.a("mtopsdk.Mtop", "[init] ttid=" + str);
                    }
                    MtopSDK.a(context, str);
                    b = true;
                }
            } finally {
            }
        }
    }

    public Mtop a(String str, String str2) {
        SDKUtils.a(str, str2);
        return this;
    }

    public MtopBuilder a(IMTOPDataObject iMTOPDataObject, String str) {
        return new MtopBuilder(iMTOPDataObject, str);
    }
}
