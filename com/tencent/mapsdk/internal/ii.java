package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tmsqmsp.oaid2.IVendorCallback;
import com.tencent.tmsqmsp.oaid2.VendorManager;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ii.class */
public final class ii {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23867a = "TMS-Oaid";
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f23868c = true;
    private static IVendorCallback d = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ii$a.class */
    public static final class a implements IVendorCallback {
        @Override // com.tencent.tmsqmsp.oaid2.IVendorCallback
        public void onResult(boolean z, String str, String str2) {
            Log.e(ii.f23867a, "isSupport: " + z + " s: " + str + " oaid: " + str2);
            boolean unused = ii.f23868c = z;
            if (z) {
                String unused2 = ii.b = str2;
            }
        }
    }

    public static String a(Context context) {
        if (f23868c) {
            if (TextUtils.isEmpty(b) || !f23868c) {
                try {
                    new VendorManager().getVendorInfo(context, d);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return b;
            }
            return b;
        }
        return "undefined";
    }
}
