package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import com.huawei.openalliance.ad.utils.aa;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ed.class */
public class ed extends dv {
    private static final int B = 32;
    private static final int C = 8;
    private static final byte[] F = new byte[0];
    public static final String I = "CN";
    private static ee S;
    private static final String Z = "ThirdDeviceImpl";

    protected ed(Context context) {
        super(context);
    }

    private static ee I(Context context) {
        ee eeVar;
        synchronized (F) {
            if (S == null) {
                S = new ed(context);
            }
            eeVar = S;
        }
        return eeVar;
    }

    public static ee V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public int Code(View view) {
        int i;
        if (view == null) {
            return -1;
        }
        int i2 = -1;
        int i3 = -1;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                i2 = -1;
                if (view.getRootWindowInsets() != null) {
                    DisplayCutout displayCutout = view.getRootWindowInsets().getDisplayCutout();
                    i2 = -1;
                    if (displayCutout != null) {
                        List<Rect> boundingRects = displayCutout.getBoundingRects();
                        i2 = -1;
                        if (!aa.Code(boundingRects)) {
                            i2 = boundingRects.get(0).height();
                        }
                    }
                }
            }
            int i4 = i2;
            if (i2 < 0) {
                int identifier = this.Code.getResources().getIdentifier("notch_height", "dimen", "android");
                i4 = i2;
                if (identifier > 0) {
                    i4 = this.Code.getResources().getDimensionPixelSize(identifier);
                }
            }
            i = i4;
            if (i4 < 0) {
                int identifier2 = this.Code.getResources().getIdentifier("status_bar_height", "dimen", "android");
                int i5 = i4;
                if (identifier2 > 0) {
                    i3 = i4;
                    i5 = this.Code.getResources().getDimensionPixelSize(identifier2);
                }
                i = i5;
                if (i5 == 0) {
                    return 110;
                }
            }
        } catch (Throwable th) {
            ge.V(Z, "getNotchHeight err: %s", th.getClass().getSimpleName());
            i = i3;
        }
        return i;
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean Code() {
        return "CN".equalsIgnoreCase(fk.Code(this.Code).W());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean Code(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ed.Code(android.content.Context):boolean");
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean V() {
        return Code();
    }
}
