package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.hihonor.android.util.HwNotchSizeUtil;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dz.class */
public class dz extends dw {
    private static final String B = "true";
    private static final String C = "156";
    private static final String I = "HnDeviceImpl";
    private static final byte[] S = new byte[0];
    private static ee Z;

    private dz(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        String V = V("msc.build.platform.version");
        this.V.V(V);
        return V;
    }

    private static ee I(Context context) {
        ee eeVar;
        synchronized (S) {
            if (Z == null) {
                Z = new dz(context);
            }
            eeVar = Z;
        }
        return eeVar;
    }

    public static ee V(Context context) {
        return I(context);
    }

    private String V(String str) {
        String Code = com.huawei.openalliance.ad.utils.ay.Code(str);
        String str2 = Code;
        if (Code == null) {
            str2 = com.huawei.openalliance.ad.constant.t.aS;
        }
        return str2;
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean B() {
        return !TextUtils.isEmpty(Z());
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public String C() {
        return com.huawei.openalliance.ad.utils.ay.Code(com.huawei.openalliance.ad.utils.j.V);
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public int Code(View view) {
        StringBuilder sb;
        try {
            if (HwNotchSizeUtil.hasNotchInScreen()) {
                int[] notchSize = HwNotchSizeUtil.getNotchSize();
                if (notchSize.length >= 2) {
                    return notchSize[1];
                }
                return 0;
            }
            return 0;
        } catch (Exception e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getNotchHeight error:");
            sb.append(e.getClass().getSimpleName());
            ge.I(I, sb.toString());
            return 0;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            sb.append("getNotchHeight error:");
            sb.append(e.getClass().getSimpleName());
            ge.I(I, sb.toString());
            return 0;
        }
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean Code() {
        return C.equals(com.huawei.openalliance.ad.utils.ay.Code("msc.config.optb"));
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean S() {
        return "true".equalsIgnoreCase(com.huawei.openalliance.ad.utils.ay.Code("msc.pure_mode.enable"));
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public String Z() {
        String C2 = this.V.C();
        if (TextUtils.isEmpty(C2)) {
            C2 = F();
        } else {
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.dz.1
                @Override // java.lang.Runnable
                public void run() {
                    dz.this.F();
                }
            });
        }
        String str = C2;
        if (TextUtils.equals(com.huawei.openalliance.ad.constant.t.aS, C2)) {
            str = null;
        }
        return str;
    }
}
