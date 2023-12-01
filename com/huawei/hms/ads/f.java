package com.huawei.hms.ads;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.huawei.hms.ads.dynamic.DynamicModule;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/f.class */
public class f {
    private static String B;
    private static b C;
    private static final String Code = "RemoteSdkInitializer";
    private static volatile Context I;
    private static final List<String> S;
    private static final String V = "adsuiengine";
    private static IRemoteCreator Z;

    static {
        ArrayList arrayList = new ArrayList();
        S = arrayList;
        arrayList.add(com.huawei.openalliance.ad.constant.t.f9352cn);
    }

    public static IRemoteCreator Code(Context context) {
        synchronized (f.class) {
            try {
                ge.V(Code, "newCreator: ");
                if (Z != null) {
                    ge.V(Code, "newCreator: mRemoteCreator != null return");
                    return Z;
                }
                Context V2 = V(context);
                if (V2 == null) {
                    Log.i(Code, "newCreator: remoteContext= null");
                    return null;
                }
                IRemoteCreator Code2 = IRemoteCreator.b.Code((IBinder) V2.getClassLoader().loadClass("com.huawei.hms.ads.uiengine.remote.RemoteCreator").newInstance());
                Z = Code2;
                B = Code2.getVersion();
                Z.setGlobalUtil(com.huawei.openalliance.ad.inter.e.Code(context));
                C = Z.getUiEngineUtil();
                Log.i(Code, "newRemoteContext: mRemoteCreator :" + Z);
                return Z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String Code() {
        String str;
        synchronized (f.class) {
            try {
                str = B;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    private static Integer I(Context context) {
        return Integer.valueOf(S.contains(context.getPackageName()) ? 2 : 1);
    }

    private static Context V(Context context) {
        ge.V(Code, "newRemoteContext: ");
        if (I != null) {
            return I;
        }
        try {
            I = DynamicModule.load(context, I(context), V).getModuleContext();
        } catch (Throwable th) {
            ge.Z(Code, "newRemoteContext failed: " + th.getLocalizedMessage());
        }
        return I;
    }

    public static b V() {
        return C;
    }
}
