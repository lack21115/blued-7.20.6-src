package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003sl.hs;
import com.autonavi.aps.amapapi.utils.b;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/location/UmidtokenInfo.class */
public class UmidtokenInfo {
    private static AMapLocationClient d;

    /* renamed from: a  reason: collision with root package name */
    static Handler f5491a = new Handler();
    static String b = null;
    private static long e = 30000;

    /* renamed from: c  reason: collision with root package name */
    static boolean f5492c = true;

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/location/UmidtokenInfo$a.class */
    static final class a implements AMapLocationListener {
        a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.d != null) {
                    UmidtokenInfo.f5491a.removeCallbacksAndMessages(null);
                    UmidtokenInfo.d.onDestroy();
                }
            } catch (Throwable th) {
                b.a(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return b;
    }

    public static void setLocAble(boolean z) {
        f5492c = z;
    }

    public static void setUmidtoken(Context context, String str) {
        synchronized (UmidtokenInfo.class) {
            try {
                b = str;
                hs.a(str);
                if (d == null && f5492c) {
                    a aVar = new a();
                    d = new AMapLocationClient(context);
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    d.setLocationOption(aMapLocationClientOption);
                    d.setLocationListener(aVar);
                    d.startLocation();
                    f5491a.postDelayed(new Runnable() { // from class: com.amap.api.location.UmidtokenInfo.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (UmidtokenInfo.d != null) {
                                    UmidtokenInfo.d.onDestroy();
                                }
                            } catch (Throwable th) {
                                b.a(th, "UmidListener", "postDelayed");
                            }
                        }
                    }, 30000L);
                }
            } catch (Throwable th) {
                try {
                    b.a(th, "UmidListener", "setUmidtoken");
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
