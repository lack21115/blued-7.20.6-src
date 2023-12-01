package com.opos.cmn.an.f.a;

import android.os.HandlerThread;
import android.os.Message;
import com.opos.cmn.an.f.a.b.a;
import com.opos.cmn.an.f.a.b.c;
import com.opos.cmn.an.f.a.b.d;
import com.opos.cmn.an.f.a.b.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a/e.class */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f10840a;
    private d b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f10841c = false;

    private void a(int i, String str, Object obj, Throwable th, int i2) {
        if (str == null) {
            return;
        }
        Object obj2 = obj;
        if (obj == null) {
            i2 = 1;
            obj2 = com.igexin.push.core.b.l;
        }
        try {
            if (this.f10841c) {
                Message obtain = Message.obtain();
                com.opos.cmn.an.f.a.b.d a2 = new d.a().a(i).a(obj2).a(str).a(th).a(Thread.currentThread().getId()).b(Thread.currentThread().getName()).b(System.currentTimeMillis()).b(i2).a();
                obtain.what = 2;
                obtain.obj = a2;
                this.b.sendMessage(obtain);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a() {
        if (this.f10841c) {
            this.f10841c = false;
            try {
                Message obtain = Message.obtain();
                com.opos.cmn.an.f.a.b.a a2 = new a.C0450a().a();
                obtain.what = 5;
                obtain.obj = a2;
                this.b.sendMessage(obtain);
                this.f10840a.quitSafely();
                this.f10840a = null;
            } catch (Exception e) {
            }
        }
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(com.opos.cmn.an.f.b.b bVar) {
        try {
            HandlerThread handlerThread = new HandlerThread("adLoganThread");
            this.f10840a = handlerThread;
            handlerThread.start();
            this.b = new d(this.f10840a.getLooper());
            Message obtain = Message.obtain();
            com.opos.cmn.an.f.a.b.c a2 = new c.a().a(bVar).a();
            obtain.what = 1;
            obtain.obj = a2;
            this.b.sendMessage(obtain);
            this.f10841c = true;
        } catch (Exception e) {
        }
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(com.opos.cmn.an.f.b.c cVar, com.opos.cmn.an.f.b.a aVar) {
        if (this.f10841c) {
            try {
                Message obtain = Message.obtain();
                com.opos.cmn.an.f.a.b.f a2 = new f.a().a(cVar).a(aVar).a();
                obtain.what = 3;
                obtain.obj = a2;
                this.b.sendMessage(obtain);
            } catch (Exception e) {
                if (aVar != null) {
                    aVar.onUploaderFailed("unkown error");
                }
            }
        }
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(String str, Object obj) {
        a(2, str, obj, null, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(String str, Object obj, Throwable th) {
        a(3, str, obj, th, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(String str, String str2) {
        a(3, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(String str, String str2, Throwable th) {
        a(3, str, str2, th, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(String str, Object... objArr) {
        a(3, str, objArr, null, 2);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void b(String str, String str2) {
        a(2, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void b(String str, String str2, Throwable th) {
        a(2, str, str2, th, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void b(String str, Object... objArr) {
        a(2, str, objArr, null, 2);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void c(String str, String str2) {
        a(4, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void c(String str, String str2, Throwable th) {
        a(4, str, str2, th, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void c(String str, Object... objArr) {
        a(4, str, objArr, null, 2);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void d(String str, String str2) {
        a(5, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void d(String str, String str2, Throwable th) {
        a(5, str, str2, th, 1);
    }
}
