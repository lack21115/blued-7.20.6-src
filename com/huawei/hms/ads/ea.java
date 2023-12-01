package com.huawei.hms.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.hihonor.android.app.HwMultiWindowEx;
import com.hihonor.android.content.pm.ApplicationInfoEx;
import com.hihonor.android.fsm.HwFoldScreenManagerEx;
import com.hihonor.android.view.DisplaySideRegionEx;
import com.hihonor.android.view.WindowManagerEx;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ea.class */
public class ea extends dx {
    private static ef Code;
    private static final byte[] V = new byte[0];

    private ea(Context context) {
    }

    public static ef Code(Context context) {
        return V(context);
    }

    private static ef V(Context context) {
        ef efVar;
        synchronized (V) {
            if (Code == null) {
                Code = new ea(context);
            }
            efVar = Code;
        }
        return efVar;
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public String B() {
        return "com.hihonor.android.os.Build";
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public String C() {
        return "com.hihonor.android.os.SystemPropertiesEx";
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public int Code(ApplicationInfo applicationInfo) {
        return new ApplicationInfoEx(applicationInfo).getHwFlags();
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public Rect Code(WindowInsets windowInsets) {
        DisplaySideRegionEx displaySideRegion = WindowManagerEx.LayoutParamsEx.getDisplaySideRegion(windowInsets);
        if (displaySideRegion != null) {
            return displaySideRegion.getSafeInsets();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public void Code(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        new WindowManagerEx.LayoutParamsEx(layoutParams).setDisplaySideMode(1);
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public boolean Code() {
        return HwMultiWindowEx.isInMultiWindowMode();
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public String I() {
        return "com.hihonor.android.net.wifi.WifiManagerCommonEx";
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public int S() {
        return HwFoldScreenManagerEx.getDisplayMode();
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public boolean V() {
        return HwFoldScreenManagerEx.isFoldable();
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public String Z() {
        return "com.hihonor.android.os.Build$VERSION";
    }
}
