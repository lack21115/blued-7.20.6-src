package com.xiaomi.push;

import android.os.IBinder;
import com.xiaomi.push.ap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ar.class */
class ar implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBinder f41257a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ap.a f190a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap.a aVar, IBinder iBinder) {
        this.f190a = aVar;
        this.f41257a = iBinder;
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
            ap.this.f188a = ap.b.a(this.f41257a);
            ap.this.f189b = ap.b.m11510a(this.f41257a);
            ap.this.b();
            ap.this.f184a = 2;
            obj5 = ap.this.f187a;
            synchronized (obj5) {
                try {
                    obj6 = ap.this.f187a;
                    obj6.notifyAll();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            ap.this.b();
            ap.this.f184a = 2;
            obj3 = ap.this.f187a;
            synchronized (obj3) {
                try {
                    obj4 = ap.this.f187a;
                    obj4.notifyAll();
                } catch (Exception e3) {
                }
            }
        } catch (Throwable th) {
            ap.this.b();
            ap.this.f184a = 2;
            obj = ap.this.f187a;
            synchronized (obj) {
                try {
                    obj2 = ap.this.f187a;
                    obj2.notifyAll();
                } catch (Exception e4) {
                }
                throw th;
            }
        }
    }
}
