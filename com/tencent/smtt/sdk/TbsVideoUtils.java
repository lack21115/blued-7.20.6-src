package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsVideoUtils.class */
public class TbsVideoUtils {

    /* renamed from: a  reason: collision with root package name */
    private static s f25102a;

    private static void a(Context context) {
        synchronized (TbsVideoUtils.class) {
            try {
                if (f25102a == null) {
                    f.a(true).a(context, false, false);
                    u a2 = f.a(true).a();
                    DexLoader dexLoader = null;
                    if (a2 != null) {
                        dexLoader = a2.b();
                    }
                    if (dexLoader != null) {
                        f25102a = new s(dexLoader);
                    }
                }
            } finally {
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        a(context);
        s sVar = f25102a;
        if (sVar != null) {
            sVar.a(context, str);
        }
    }

    public static String getCurWDPDecodeType(Context context) {
        a(context);
        s sVar = f25102a;
        return sVar != null ? sVar.a(context) : "";
    }
}
