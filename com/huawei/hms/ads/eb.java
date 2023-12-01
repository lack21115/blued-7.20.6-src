package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.util.HwNotchSizeUtil;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/eb.class */
public class eb extends dw {
    private static final String B = "display_notch_status";
    private static final int C = 0;
    private static final byte[] D = new byte[0];
    private static ee F;
    private static final String I = "HwDeviceImpl";
    private static final String S = "true";
    private static final String Z = "156";

    private eb(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        String V = V("hw_sc.build.platform.version");
        this.V.V(V);
        return V;
    }

    private static ee I(Context context) {
        ee eeVar;
        synchronized (D) {
            if (F == null) {
                F = new eb(context);
            }
            eeVar = F;
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
        return com.huawei.openalliance.ad.utils.ay.Code(com.huawei.openalliance.ad.utils.j.Code);
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
        return Z.equals(com.huawei.openalliance.ad.utils.ay.Code("ro.config.hw_optb"));
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean I() {
        return com.huawei.openalliance.ad.utils.l.Code(this.Code);
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean S() {
        return "true".equalsIgnoreCase(com.huawei.openalliance.ad.utils.ay.Code("hw_mc.pure_mode.enable"));
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public String Z() {
        String C2 = this.V.C();
        if (TextUtils.isEmpty(C2)) {
            C2 = F();
        } else {
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eb.1
                @Override // java.lang.Runnable
                public void run() {
                    eb.this.F();
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
