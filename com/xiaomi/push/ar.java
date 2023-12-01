package com.xiaomi.push;

import android.os.IBinder;
import com.xiaomi.push.ap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ar.class */
class ar implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBinder f27566a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ap.a f143a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap.a aVar, IBinder iBinder) {
        this.f143a = aVar;
        this.f27566a = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        try {
            ap.this.f141a = ap.b.a(this.f27566a);
            ap.this.f142b = ap.b.m8460a(this.f27566a);
            ap.this.b();
            ap.this.f137a = 2;
            obj5 = ap.this.f140a;
            synchronized (obj5) {
                try {
                    obj6 = ap.this.f140a;
                    obj6.notifyAll();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            ap.this.b();
            ap.this.f137a = 2;
            obj3 = ap.this.f140a;
            synchronized (obj3) {
                try {
                    obj4 = ap.this.f140a;
                    obj4.notifyAll();
                } catch (Exception e3) {
                }
            }
        } catch (Throwable th) {
            ap.this.b();
            ap.this.f137a = 2;
            obj = ap.this.f140a;
            synchronized (obj) {
                try {
                    obj2 = ap.this.f140a;
                    obj2.notifyAll();
                } catch (Exception e4) {
                }
                throw th;
            }
        }
    }
}
