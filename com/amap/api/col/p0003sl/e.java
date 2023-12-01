package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.anythink.core.common.c.g;
import com.anythink.core.common.g.c;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.e  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/e.class */
public final class e {
    static boolean g = false;
    Context e;
    private List<Messenger> w;
    private boolean o = false;
    private boolean p = false;
    String a = null;
    b b = null;
    private long q = 0;
    private long r = 0;
    private com.autonavi.aps.amapapi.model.a s = null;
    AMapLocation c = null;
    private long t = 0;
    private int u = 0;
    a d = null;
    private j v = null;
    com.autonavi.aps.amapapi.b f = null;
    HashMap<Messenger, Long> h = new HashMap<>();
    g i = null;
    long j = 0;
    long k = 0;
    String l = null;
    private boolean x = true;
    private String y = "";
    AMapLocationClientOption m = null;
    AMapLocationClientOption n = new AMapLocationClientOption();

    /* renamed from: com.amap.api.col.3sl.e$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/e$a.class */
    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01f0 A[Catch: all -> 0x020a, TRY_ENTER, TryCatch #2 {all -> 0x020a, blocks: (B:24:0x0094, B:26:0x00a4, B:32:0x00dc, B:33:0x00f5, B:35:0x00fe, B:37:0x0108, B:39:0x0118, B:41:0x0127, B:43:0x0130, B:45:0x013f, B:46:0x014c, B:48:0x0155, B:50:0x015f, B:52:0x016f, B:54:0x018d, B:55:0x0197, B:56:0x01a3, B:57:0x01ad, B:58:0x01c6, B:62:0x0205, B:59:0x01d9, B:60:0x01f0), top: B:72:0x0094 }] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void handleMessage(android.os.Message r7) {
            /*
                Method dump skipped, instructions count: 535
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.e.a.handleMessage(android.os.Message):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.e$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/e$b.class */
    public final class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                e.this.v = new j(e.this.e);
                com.autonavi.aps.amapapi.utils.a.b(e.this.e);
                com.autonavi.aps.amapapi.utils.a.a(e.this.e);
                e.this.f = new com.autonavi.aps.amapapi.b(false);
                super.onLooperPrepared();
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    public e(Context context) {
        this.e = null;
        this.e = context;
    }

    private static com.autonavi.aps.amapapi.model.a a(int i, String str) {
        try {
            com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
            aVar.setErrorCode(i);
            aVar.setLocationDetail(str);
            return aVar;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        try {
            if (this.o) {
                if (this.f != null) {
                    this.f.a();
                    return;
                }
                return;
            }
            com.autonavi.aps.amapapi.utils.b.a(this.e);
            if (bundle != null) {
                this.n = com.autonavi.aps.amapapi.utils.b.a(bundle.getBundle("optBundle"));
            }
            this.f.a(this.e);
            this.f.b();
            a(this.n);
            this.f.c();
            this.o = true;
            this.x = true;
            this.y = "";
            if (this.w == null || this.w.size() <= 0) {
                return;
            }
            e();
        } catch (Throwable th) {
            this.x = false;
            th.printStackTrace();
            this.y = th.getMessage();
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger) {
        this.h.remove(messenger);
    }

    private static void a(Messenger messenger, int i, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i;
                messenger.send(obtain);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty() || this.p) {
                    return;
                }
                this.p = true;
                b(messenger);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger, AMapLocation aMapLocation, String str, com.autonavi.aps.amapapi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", aVar);
        this.h.put(messenger, Long.valueOf(i.b()));
        a(messenger, 1, bundle);
    }

    private void a(Messenger messenger, String str) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", com.autonavi.aps.amapapi.utils.a.i() * 3);
        bundle.putInt("I_MIN_GEO_DIS", com.autonavi.aps.amapapi.utils.a.i());
        bundle.putParcelable("loc", this.c);
        if ("COARSE_LOC".equals(str)) {
            a(messenger, 103, bundle);
        } else {
            a(messenger, 6, bundle);
        }
    }

    private void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (this.f != null) {
                this.f.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                g = aMapLocationClientOption.isKillProcess();
                if (this.m != null) {
                    if (aMapLocationClientOption.isOffset() != this.m.isOffset() || aMapLocationClientOption.isNeedAddress() != this.m.isNeedAddress() || aMapLocationClientOption.isLocationCacheEnable() != this.m.isLocationCacheEnable() || this.m.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.r = 0L;
                    }
                    if (aMapLocationClientOption.isOffset() != this.m.isOffset() || this.m.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.c = null;
                    }
                }
                this.m = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "setExtra");
        }
    }

    private static AMapLocationClientOption b(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = null;
        try {
            AMapLocationClientOption a2 = com.autonavi.aps.amapapi.utils.b.a(bundle.getBundle("optBundle"));
            String string = bundle.getString("d");
            aMapLocationClientOption = a2;
            if (!TextUtils.isEmpty(string)) {
                hs.a(string);
                return a2;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "APSManager", "parseBundle");
        }
        return aMapLocationClientOption;
    }

    static /* synthetic */ com.autonavi.aps.amapapi.model.a b(String str) {
        return a(10, str);
    }

    private void b(Messenger messenger) {
        try {
            this.f.f();
            if (com.autonavi.aps.amapapi.utils.a.k()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("installMockApp", true);
                a(messenger, 9, bundle);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "initAuth");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01c0 A[Catch: all -> 0x0244, TryCatch #2 {all -> 0x0244, blocks: (B:4:0x0004, B:7:0x000c, B:9:0x0034, B:11:0x003c, B:14:0x0058, B:17:0x0065, B:19:0x00b0, B:21:0x00be, B:23:0x00cb, B:25:0x00ea, B:44:0x01b7, B:46:0x01c0, B:48:0x01c8, B:50:0x01ce, B:52:0x01e3, B:54:0x01e9, B:67:0x0238, B:57:0x0203, B:61:0x020e, B:63:0x0215, B:27:0x00f3, B:29:0x010d, B:32:0x011b, B:34:0x0126, B:40:0x015c, B:35:0x0135, B:37:0x0140, B:38:0x014f), top: B:72:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ce A[Catch: all -> 0x0244, TryCatch #2 {all -> 0x0244, blocks: (B:4:0x0004, B:7:0x000c, B:9:0x0034, B:11:0x003c, B:14:0x0058, B:17:0x0065, B:19:0x00b0, B:21:0x00be, B:23:0x00cb, B:25:0x00ea, B:44:0x01b7, B:46:0x01c0, B:48:0x01c8, B:50:0x01ce, B:52:0x01e3, B:54:0x01e9, B:67:0x0238, B:57:0x0203, B:61:0x020e, B:63:0x0215, B:27:0x00f3, B:29:0x010d, B:32:0x011b, B:34:0x0126, B:40:0x015c, B:35:0x0135, B:37:0x0140, B:38:0x014f), top: B:72:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e9 A[Catch: all -> 0x0244, TRY_LEAVE, TryCatch #2 {all -> 0x0244, blocks: (B:4:0x0004, B:7:0x000c, B:9:0x0034, B:11:0x003c, B:14:0x0058, B:17:0x0065, B:19:0x00b0, B:21:0x00be, B:23:0x00cb, B:25:0x00ea, B:44:0x01b7, B:46:0x01c0, B:48:0x01c8, B:50:0x01ce, B:52:0x01e3, B:54:0x01e9, B:67:0x0238, B:57:0x0203, B:61:0x020e, B:63:0x0215, B:27:0x00f3, B:29:0x010d, B:32:0x011b, B:34:0x0126, B:40:0x015c, B:35:0x0135, B:37:0x0140, B:38:0x014f), top: B:72:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.os.Messenger r7, android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.e.b(android.os.Messenger, android.os.Bundle):void");
    }

    public static void d() {
        g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (i.m(this.e)) {
            return;
        }
        try {
            if (this.f == null || this.f == null) {
                return;
            }
            this.f.a(this.d);
            this.f.g();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "startColl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            com.autonavi.aps.amapapi.utils.a.c(this.e);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    public final void a() {
        try {
            this.i = new g();
            b bVar = new b("amapLocCoreThread");
            this.b = bVar;
            bVar.setPriority(5);
            this.b.start();
            this.d = new a(this.b.getLooper());
            this.w = new ArrayList();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void a(Intent intent) {
        a aVar;
        if (!"true".equals(intent.getStringExtra("as")) || (aVar = this.d) == null) {
            return;
        }
        aVar.sendEmptyMessageDelayed(9, 100L);
    }

    final void a(Messenger messenger, Bundle bundle, String str) {
        AMapLocationClientOption b2;
        float f;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                double d = bundle.getDouble(c.B);
                double d2 = bundle.getDouble(c.C);
                float f2 = bundle.getFloat("radius");
                long j = bundle.getLong(g.a.g);
                if ("FINE_LOC".equals(str)) {
                    AMapLocation aMapLocation = new AMapLocation(GeocodeSearch.GPS);
                    aMapLocation.setLatitude(d);
                    aMapLocation.setLocationType(1);
                    aMapLocation.setLongitude(d2);
                    aMapLocation.setAccuracy(f2);
                    aMapLocation.setTime(j);
                    this.f.a(aMapLocation);
                }
                if (com.autonavi.aps.amapapi.utils.a.h() && (b2 = b(bundle)) != null && b2.isNeedAddress()) {
                    a(b2);
                    if (this.c != null) {
                        float a2 = i.a(new double[]{d, d2, this.c.getLatitude(), this.c.getLongitude()});
                        f = a2;
                        if (a2 < com.autonavi.aps.amapapi.utils.a.i() * 3) {
                            a(messenger, str);
                            f = a2;
                        }
                    } else {
                        f = -1.0f;
                    }
                    if (f == -1.0f || f > com.autonavi.aps.amapapi.utils.a.i()) {
                        a(bundle);
                        com.autonavi.aps.amapapi.model.a a3 = this.f.a(d, d2);
                        this.c = a3;
                        if (a3 == null || TextUtils.isEmpty(a3.getAdCode())) {
                            return;
                        }
                        a(messenger, str);
                    }
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(this.l)) {
            this.l = com.autonavi.aps.amapapi.utils.b.b(this.e);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.l);
    }

    public final Handler b() {
        return this.d;
    }

    public final void b(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            hp.a(this.e, stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("b");
        this.a = stringExtra2;
        ho.a(stringExtra2);
        String stringExtra3 = intent.getStringExtra("d");
        if (TextUtils.isEmpty(stringExtra3)) {
            return;
        }
        hs.a(stringExtra3);
    }

    public final void c() {
        try {
            if (this.h != null) {
                this.h.clear();
                this.h = null;
            }
            if (this.w != null) {
                this.w.clear();
            }
            if (this.v != null) {
                this.v.c();
                this.v = null;
            }
            this.o = false;
            this.p = false;
            this.f.e();
            if (this.d != null) {
                this.d.removeCallbacksAndMessages(null);
            }
            this.d = null;
            if (this.b != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    com.autonavi.aps.amapapi.utils.e.a(this.b, HandlerThread.class, "quitSafely", new Object[0]);
                } else {
                    this.b.quit();
                }
            }
            this.b = null;
            if (this.i != null && this.j != 0 && this.k != 0) {
                long b2 = i.b();
                long j = this.j;
                com.autonavi.aps.amapapi.utils.g.a(this.e, this.i.c(this.e), this.i.d(this.e), this.k, b2 - j);
                this.i.e(this.e);
            }
            com.autonavi.aps.amapapi.utils.g.a(this.e);
            iw.b();
            if (g) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "apm", "tdest");
        }
    }
}
