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
    e a;
    Context b;
    Messenger c = null;

    public f(Context context) {
        this.a = null;
        this.b = null;
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.a = new e(applicationContext);
    }

    public final IBinder a(Intent intent) {
        this.a.b(intent);
        this.a.a(intent);
        Messenger messenger = new Messenger(this.a.b());
        this.c = messenger;
        return messenger.getBinder();
    }

    public final void a() {
        try {
            e.d();
            this.a.j = i.b();
            this.a.k = i.a();
            this.a.a();
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void b() {
        try {
            if (this.a != null) {
                this.a.b().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onDestroy");
        }
    }
}
