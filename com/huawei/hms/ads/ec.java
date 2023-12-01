package com.huawei.hms.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.android.app.HwMultiWindowEx;
import com.huawei.android.content.pm.ApplicationInfoEx;
import com.huawei.android.fsm.HwFoldScreenManagerEx;
import com.huawei.android.view.DisplaySideRegionEx;
import com.huawei.android.view.WindowManagerEx;
import com.huawei.hms.framework.common.EmuiUtil;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ec.class */
public class ec extends dx {
    private static ef Code;
    private static final byte[] V = new byte[0];

    private ec(Context context) {
    }

    public static ef Code(Context context) {
        return V(context);
    }

    private static ef V(Context context) {
        ef efVar;
        synchronized (V) {
            if (Code == null) {
                Code = new ec(context);
            }
            efVar = Code;
        }
        return efVar;
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public String B() {
        return "com.huawei.android.os.BuildEx";
    }

    @Override // com.huawei.hms.ads.dx, com.huawei.hms.ads.ef
    public String C() {
        return "com.huawei.android.os.SystemPropertiesEx";
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
        return "com.huawei.android.net.wifi.WifiManagerCommonEx";
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
        return EmuiUtil.BUILDEX_VERSION;
    }
}
