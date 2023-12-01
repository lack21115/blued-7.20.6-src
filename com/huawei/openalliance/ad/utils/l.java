package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.hihonor.android.fsm.HwFoldScreenManagerEx;
import com.huawei.hms.ads.du;
import com.huawei.hms.ads.ge;
import com.tencent.thumbplayer.core.common.TPSystemInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/l.class */
public class l {
    static final String B = "CN";
    private static final String C = "DeviceUtil";
    static final String Code = "content";
    private static final int D = 2;
    private static final int F = 1;
    static final String I = "/switch/query";
    private static final float S = 1.5f;
    static final String V = "com.huawei.hwid.pps.apiprovider";
    static final String Z = "isSwitchChecked";

    public static boolean B(Context context) {
        return "1".equalsIgnoreCase(k.Code(context).Code());
    }

    public static boolean C(Context context) {
        return "0".equalsIgnoreCase(k.Code(context).Code());
    }

    public static String Code() {
        String Code2 = ay.Code(TPSystemInfo.KEY_PROPERTY_MODEL);
        String str = Code2;
        if (TextUtils.isEmpty(Code2)) {
            str = Build.MODEL;
        }
        return str;
    }

    public static void Code(final am amVar, final Context context) {
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.l.1
            /* JADX WARN: Code restructure failed: missing block: B:26:0x00cb, code lost:
                if (0 == 0) goto L24;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 235
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.l.AnonymousClass1.run():void");
            }
        });
    }

    public static boolean Code(Context context) {
        am Code2 = am.Code(context);
        boolean V2 = Code2.V();
        Code(Code2, context);
        return V2;
    }

    public static int D(Context context) {
        return ((float) c.B(context)) / ((float) c.Z(context)) > S ? 2 : 1;
    }

    public static boolean F(Context context) {
        int D2;
        boolean z = false;
        try {
            D2 = du.Code(context).S();
        } catch (Throwable th) {
            D2 = D(context);
            ge.I(C, "getFoldableStatus %s", th.getClass().getSimpleName());
        }
        if (D2 == 1) {
            z = true;
        }
        return z;
    }

    public static int I(Context context) {
        am Code2 = am.Code(context);
        if (Code2.S() != null) {
            return Code2.S().intValue();
        }
        int I2 = k.Code(context).I();
        Code2.Code(I2);
        return I2;
    }

    public static Context L(Context context) {
        Context context2 = context;
        if (V()) {
            context2 = context.createDeviceProtectedStorageContext();
        }
        return context2;
    }

    public static boolean S(Context context) {
        try {
            return c.I() ? HwFoldScreenManagerEx.isFoldable() : com.huawei.android.fsm.HwFoldScreenManagerEx.isFoldable();
        } catch (Throwable th) {
            ge.I(C, "isFoldablePhone exception: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public static boolean V() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean V(Context context) {
        am Code2 = am.Code(context);
        if (Code2.B() != null) {
            return Code2.B().booleanValue();
        }
        boolean V2 = k.Code(context).V();
        Code2.I(V2);
        return V2;
    }

    public static boolean Z(Context context) {
        boolean z;
        am Code2 = am.Code(context);
        try {
            if (Code2.F() != null) {
                return Code2.F().booleanValue();
            }
            z = ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(1) != null;
            try {
                Code2.Code(Boolean.valueOf(z));
                return z;
            } catch (Throwable th) {
                th = th;
                ge.I(C, "getHasAccAndRotate err: %s", th.getClass().getSimpleName());
                return z;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }
}
