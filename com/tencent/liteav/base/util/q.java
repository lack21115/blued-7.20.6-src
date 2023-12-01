package com.tencent.liteav.base.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.liteav.base.util.a;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/q.class */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f36344a;
    private static a<CpuUsageMeasurer> b = new a<>(new a.InterfaceC0925a<CpuUsageMeasurer>() { // from class: com.tencent.liteav.base.util.q.1
        @Override // com.tencent.liteav.base.util.a.InterfaceC0925a
        public final /* synthetic */ CpuUsageMeasurer a() {
            return new CpuUsageMeasurer();
        }
    });

    public static n a(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                LiteavLog.i("SystemUtil", "DeviceScreen:[width:%d][height:%d]", Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
                return new n(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        } catch (Exception e) {
            LiteavLog.e("SystemUtil", "get screen resolution failed.", e);
        }
        return new n(0, 0);
    }

    public static int[] a() {
        if (!f36344a) {
            b.a();
            return CpuUsageMeasurer.a();
        }
        f36344a = false;
        b.a();
        CpuUsageMeasurer.a();
        return new int[]{0, 0};
    }
}
