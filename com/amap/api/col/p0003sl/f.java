package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.i;

/* renamed from: com.amap.api.col.3sl.f  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    e f4950a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    Messenger f4951c = null;

    public f(Context context) {
        this.f4950a = null;
        this.b = null;
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.f4950a = new e(applicationContext);
    }

    public final IBinder a(Intent intent) {
        this.f4950a.b(intent);
        this.f4950a.a(intent);
        Messenger messenger = new Messenger(this.f4950a.b());
        this.f4951c = messenger;
        return messenger.getBinder();
    }

    public final void a() {
        try {
            e.d();
            this.f4950a.j = i.b();
            this.f4950a.k = i.a();
            this.f4950a.a();
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void b() {
        try {
            if (this.f4950a != null) {
                this.f4950a.b().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onDestroy");
        }
    }
}
