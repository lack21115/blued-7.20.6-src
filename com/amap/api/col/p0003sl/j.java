package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.android.internal.widget.LockPatternUtils;
import com.anythink.core.common.k.f;
import com.autonavi.aps.amapapi.security.a;
import com.autonavi.aps.amapapi.storage.b;
import com.autonavi.aps.amapapi.storage.c;
import com.autonavi.aps.amapapi.utils.i;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.j  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/j.class */
public final class j {
    static b b;
    static ja e;
    static long g;
    String a = null;
    b c = null;
    b d = null;
    long f = 0;
    boolean h = false;
    private Context i;

    public j(Context context) {
        this.i = context.getApplicationContext();
    }

    private void e() {
        if (b == null || i.b() - g > 180000) {
            b f = f();
            g = i.b();
            if (f == null || !i.a(f.a())) {
                return;
            }
            b = f;
        }
    }

    private b f() {
        b bVar;
        b bVar2;
        b bVar3;
        byte[] b2;
        String str = null;
        if (this.i == null) {
            return null;
        }
        a();
        try {
        } catch (Throwable th) {
            th = th;
            bVar = null;
        }
        if (e == null) {
            return null;
        }
        List b3 = e.b("_id=1", b.class);
        if (b3 == null || b3.size() <= 0) {
            bVar3 = null;
        } else {
            b bVar4 = (b) b3.get(0);
            bVar = bVar4;
            try {
                byte[] b4 = ht.b(bVar4.c());
                String str2 = (b4 == null || b4.length <= 0 || (b2 = a.b(b4, this.a)) == null || b2.length <= 0) ? null : new String(b2, "UTF-8");
                byte[] b5 = ht.b(bVar4.b());
                String str3 = null;
                if (b5 != null) {
                    str3 = null;
                    if (b5.length > 0) {
                        byte[] b6 = a.b(b5, this.a);
                        str3 = null;
                        if (b6 != null) {
                            str3 = null;
                            if (b6.length > 0) {
                                str3 = new String(b6, "UTF-8");
                            }
                        }
                    }
                }
                bVar4.a(str3);
                String str4 = str2;
                bVar3 = bVar4;
                str = str4;
            } catch (Throwable th2) {
                th = th2;
                com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "readLastFix");
                bVar2 = bVar;
                return bVar2;
            }
        }
        bVar2 = bVar3;
        if (!TextUtils.isEmpty(str)) {
            b bVar5 = bVar3;
            AMapLocation aMapLocation = new AMapLocation("");
            b bVar6 = bVar3;
            com.autonavi.aps.amapapi.utils.b.a(aMapLocation, new JSONObject(str));
            b bVar7 = bVar3;
            bVar2 = bVar3;
            if (i.b(aMapLocation)) {
                bVar = bVar3;
                bVar3.a(aMapLocation);
                return bVar3;
            }
        }
        return bVar2;
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str, long j) {
        boolean a;
        if (aMapLocation == null) {
            return aMapLocation;
        }
        AMapLocation aMapLocation2 = aMapLocation;
        if (aMapLocation.getErrorCode() != 0) {
            aMapLocation2 = aMapLocation;
            if (aMapLocation.getLocationType() != 1) {
                if (aMapLocation.getErrorCode() == 7) {
                    return aMapLocation;
                }
                try {
                    e();
                    if (b != null && b.a() != null) {
                        if (TextUtils.isEmpty(str)) {
                            long b2 = i.b() - b.d();
                            a = false;
                            if (b2 >= 0) {
                                a = false;
                                if (b2 <= j) {
                                    a = true;
                                }
                            }
                            aMapLocation.setTrustedLevel(3);
                        } else {
                            a = i.a(b.b(), str);
                            aMapLocation.setTrustedLevel(2);
                        }
                        aMapLocation2 = aMapLocation;
                        if (a) {
                            AMapLocation a2 = b.a();
                            try {
                                a2.setLocationType(9);
                                a2.setFixLastLocation(true);
                                a2.setLocationDetail(aMapLocation.getLocationDetail());
                                return a2;
                            } catch (Throwable th) {
                                th = th;
                                aMapLocation = a2;
                                com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "fixLastLocation");
                                aMapLocation2 = aMapLocation;
                                return aMapLocation2;
                            }
                        }
                    }
                    return aMapLocation;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return aMapLocation2;
    }

    public final void a() {
        if (this.h) {
            return;
        }
        try {
            if (this.a == null) {
                this.a = a.a(f.a, hs.v(this.i));
            }
            if (e == null) {
                e = new ja(this.i, ja.a((Class<? extends iz>) c.class));
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "<init>:DBOperation");
        }
        this.h = true;
    }

    public final boolean a(AMapLocation aMapLocation, String str) {
        if (this.i == null || aMapLocation == null || !i.a(aMapLocation) || aMapLocation.getLocationType() == 2 || aMapLocation.isMock() || aMapLocation.isFixLastLocation()) {
            return false;
        }
        b bVar = new b();
        bVar.a(aMapLocation);
        if (aMapLocation.getLocationType() == 1) {
            bVar.a((String) null);
        } else {
            bVar.a(str);
        }
        try {
            b = bVar;
            g = i.b();
            this.c = bVar;
            if (this.d == null || i.a(this.d.a(), bVar.a()) > 500.0f) {
                return i.b() - this.f > LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS;
            }
            return false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "setLastFix");
            return false;
        }
    }

    public final AMapLocation b() {
        e();
        b bVar = b;
        if (bVar != null && i.a(bVar.a())) {
            return b.a();
        }
        return null;
    }

    public final void c() {
        try {
            d();
            this.f = 0L;
            this.h = false;
            this.c = null;
            this.d = null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "destroy");
        }
    }

    public final void d() {
        try {
            a();
            if (this.c == null || !i.a(this.c.a()) || e == null || this.c == this.d || this.c.d() != 0) {
                return;
            }
            String str = this.c.a().toStr();
            String b2 = this.c.b();
            this.d = this.c;
            String str2 = null;
            String str3 = null;
            if (TextUtils.isEmpty(str)) {
                str2 = null;
            } else {
                str3 = ht.b(a.a(str.getBytes("UTF-8"), this.a));
                if (!TextUtils.isEmpty(b2)) {
                    str2 = ht.b(a.a(b2.getBytes("UTF-8"), this.a));
                }
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            b bVar = new b();
            bVar.b(str3);
            bVar.a(i.b());
            bVar.a(str2);
            e.a(bVar, "_id=1");
            this.f = i.b();
            if (b != null) {
                b.a(i.b());
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "saveLastFix");
        }
    }
}
