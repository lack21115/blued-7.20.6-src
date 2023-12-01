package com.xiaomi.push;

import android.content.Context;
import android.os.IBinder;
import com.xiaomi.push.az;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bb.class */
class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBinder f27582a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ az.b f167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az.b bVar, IBinder iBinder) {
        this.f167a = bVar;
        this.f27582a = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Context context;
        String b;
        Object obj5;
        Object obj6;
        try {
            context = az.this.f160a;
            String packageName = context.getPackageName();
            b = az.this.b();
            az.a aVar = new az.a();
            aVar.b = az.c.a(this.f27582a, packageName, b, "OUID");
            az.this.f162a = aVar;
            az.this.m8467b();
            az.this.f159a = 2;
            obj5 = az.this.f163a;
            synchronized (obj5) {
                try {
                    obj6 = az.this.f163a;
                    obj6.notifyAll();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            az.this.m8467b();
            az.this.f159a = 2;
            obj3 = az.this.f163a;
            synchronized (obj3) {
                try {
                    obj4 = az.this.f163a;
                    obj4.notifyAll();
                } catch (Exception e3) {
                }
            }
        } catch (Throwable th) {
            az.this.m8467b();
            az.this.f159a = 2;
            obj = az.this.f163a;
            synchronized (obj) {
                try {
                    obj2 = az.this.f163a;
                    obj2.notifyAll();
                } catch (Exception e4) {
                }
                throw th;
            }
        }
    }
}
