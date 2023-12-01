package com.tencent.tmsqmsp.sdk.g.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.tmsqmsp.sdk.g.b.d;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/b/a.class */
public class a {

    /* renamed from: com.tencent.tmsqmsp.sdk.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/b/a$a.class */
    public static final class C1050a {

        /* renamed from: a  reason: collision with root package name */
        private final String f39765a;
        private final boolean b;

        public C1050a(String str, boolean z) {
            this.f39765a = str;
            this.b = z;
        }

        public final String a() {
            return this.f39765a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public static C1050a a(Context context) {
        String str;
        b bVar;
        Intent intent;
        String str2;
        String a2 = a();
        Log.i(a2, "getAdvertisingIdInfo " + System.currentTimeMillis());
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.tencent.tmsqmsp.sdk.base.c.b("Cannot be called from the main thread");
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            bVar = new b();
            intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
        } catch (PackageManager.NameNotFoundException e) {
            str = "HMS not found";
        }
        if (!context.bindService(intent, bVar, 1)) {
            str = "bind failed";
            com.tencent.tmsqmsp.sdk.base.c.b(str);
            return null;
        }
        Log.i(a(), "bind ok");
        try {
            try {
                if (bVar.f39766a) {
                    throw new IllegalStateException();
                }
                bVar.f39766a = true;
                d a3 = d.a.a((IBinder) bVar.b.take());
                return new C1050a(a3.i(), a3.f());
            } catch (RemoteException e2) {
                str2 = "bind hms service RemoteException";
                com.tencent.tmsqmsp.sdk.base.c.b(str2);
                context.unbindService(bVar);
                return null;
            } catch (InterruptedException e3) {
                str2 = "bind hms service InterruptedException";
                com.tencent.tmsqmsp.sdk.base.c.b(str2);
                context.unbindService(bVar);
                return null;
            }
        } finally {
            context.unbindService(bVar);
        }
    }

    private static String a() {
        return "AdId";
    }
}
