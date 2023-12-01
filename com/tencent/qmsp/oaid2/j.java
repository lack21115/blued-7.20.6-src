package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.qmsp.oaid2.m;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/j.class */
public class j {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/j$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f38479a;
        public final boolean b;

        public a(String str, boolean z) {
            this.f38479a = str;
            this.b = z;
        }

        public final String a() {
            return this.f38479a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public static a a(Context context) {
        String a2 = a();
        Log.i(a2, "getAdvertisingIdInfo " + System.currentTimeMillis());
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c.b("Cannot be called from the main thread");
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            k kVar = new k();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (!context.bindService(intent, kVar, 1)) {
                c.b("bind failed");
                return null;
            }
            Log.i(a(), "bind ok");
            try {
                try {
                    if (kVar.f38484a) {
                        throw new IllegalStateException();
                    }
                    kVar.f38484a = true;
                    m a3 = m.a.a(kVar.b.take());
                    return new a(a3.m(), a3.h());
                } catch (RemoteException e) {
                    c.b("bind hms service RemoteException");
                    context.unbindService(kVar);
                    return null;
                } catch (Throwable th) {
                    c.b("bind hms service InterruptedException");
                    context.unbindService(kVar);
                    return null;
                }
            } finally {
                context.unbindService(kVar);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            c.b("HMS not found");
            return null;
        }
    }

    public static String a() {
        return "AdId";
    }
}
