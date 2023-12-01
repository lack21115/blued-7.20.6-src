package com.opos.cmn.e.a.c.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import com.opos.cmn.e.a.c.c.e;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/c/d/d.class */
public class d extends a implements c {

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.e.a.c.c.d f11104c;
    private com.opos.cmn.e.a.c.a.a d;
    private View e;
    private String f;
    private boolean g;
    private Queue<com.opos.cmn.e.a.c.b.b> h;
    private final Handler i;

    public d(Context context, e eVar) {
        super(context, eVar);
        this.g = false;
        this.h = new ConcurrentLinkedQueue();
        this.i = new Handler(Looper.getMainLooper()) { // from class: com.opos.cmn.e.a.c.d.d.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message != null) {
                    try {
                        int i = message.what;
                        if (i == 1 || i == 2) {
                            d.this.b(null, null, d.this.f, new Object[0]);
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
                    }
                }
            }
        };
        c();
    }

    private void a(com.opos.cmn.e.a.c.b.b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("show toastParams=");
        sb.append(bVar != null ? bVar.toString() : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("ReminderToastWidget", sb.toString());
        if (bVar != null) {
            this.d.a(bVar.a(), bVar.b(), bVar.c());
            if (k()) {
                g();
            } else {
                if (this.e == null) {
                    this.e = this.d.a();
                    d();
                }
                h();
            }
            String a2 = bVar.a();
            this.f = a2;
            a((View) null, a2, new Object[0]);
            this.g = true;
        }
    }

    private void c() {
        com.opos.cmn.e.a.c.a.b bVar = new com.opos.cmn.e.a.c.a.b(this.f11101a, this);
        this.d = bVar;
        this.e = bVar.a();
        if (k()) {
            e();
        } else {
            d();
        }
    }

    private void d() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2002;
            layoutParams.flags = 136;
            layoutParams.width = com.opos.cmn.an.h.f.a.b(this.f11101a);
            layoutParams.height = com.opos.cmn.an.h.f.a.a(this.f11101a, 90.0f);
            layoutParams.gravity = 49;
            layoutParams.format = 1;
            if (this.e != null) {
                this.e.setVisibility(8);
                com.opos.cmn.an.h.f.a.a(this.f11101a, this.e, layoutParams);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    private void e() {
        try {
            com.opos.cmn.e.a.c.c.c cVar = new com.opos.cmn.e.a.c.c.c(this.f11101a, null);
            this.f11104c = cVar;
            if (this.e != null) {
                cVar.a(this.e);
            }
            WindowManager.LayoutParams a2 = this.f11104c.a();
            if (a2 != null) {
                a2.flags = 136;
                a2.width = com.opos.cmn.an.h.f.a.b(this.f11101a);
                a2.height = com.opos.cmn.an.h.f.a.a(this.f11101a, 90.0f);
            }
            this.f11104c.a(49, 0, 0);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    private void f() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "showNext mIsShowing=" + this.g);
        try {
            if (this.g) {
                return;
            }
            a(this.h.poll());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    private void g() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "showCustomToast");
        try {
            this.f11104c.a(1);
            if (this.i.hasMessages(2)) {
                this.i.removeMessages(2);
            }
            this.f11104c.b();
            this.i.sendEmptyMessageDelayed(2, 4000L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    private void h() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "showFloatWindow ");
        try {
            if (this.i.hasMessages(1)) {
                this.i.removeMessages(1);
            }
            this.e.setVisibility(0);
            this.e.invalidate();
            this.i.sendEmptyMessageDelayed(1, 3500L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    private void i() {
        if (this.i.hasMessages(2)) {
            this.i.removeMessages(2);
        }
    }

    private void j() {
        if (this.i.hasMessages(1)) {
            this.i.removeMessages(1);
        }
        this.e.setVisibility(8);
        this.e.invalidate();
    }

    private boolean k() {
        boolean z;
        try {
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
        if (com.opos.cmn.an.b.c.b() >= 19) {
            z = true;
            com.opos.cmn.an.f.a.b("ReminderToastWidget", "isToastSupportClick=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "isToastSupportClick=" + z);
        return z;
    }

    @Override // com.opos.cmn.e.a.c.d.c
    public void a() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "cancelNotification");
        try {
            if (k()) {
                i();
            } else {
                j();
            }
            this.g = false;
            f();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    public void a(View view, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onShow view=");
        sb.append(view != null ? view : com.igexin.push.core.b.l);
        sb.append(",pkgName=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        sb.append(",objects=");
        Object[] objArr2 = com.igexin.push.core.b.l;
        if (objArr != null) {
            objArr2 = objArr;
        }
        sb.append(objArr2);
        com.opos.cmn.an.f.a.b("ReminderToastWidget", sb.toString());
        this.b.a(view, str, objArr);
    }

    @Override // com.opos.cmn.e.a.c.d.c
    public void a(View view, int[] iArr, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onClick view=");
        sb.append(view != null ? view : com.igexin.push.core.b.l);
        sb.append(",pkgName=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        sb.append(",objects=");
        Object[] objArr2 = com.igexin.push.core.b.l;
        if (objArr != null) {
            objArr2 = objArr;
        }
        sb.append(objArr2);
        com.opos.cmn.an.f.a.b("ReminderToastWidget", sb.toString());
        this.b.a(view, iArr, str, objArr);
    }

    @Override // com.opos.cmn.e.a.c.d.c
    public void a(String str, boolean z, Object... objArr) {
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("show pkgName=");
            sb.append(str);
            sb.append(",gbClick=");
            sb.append(z);
            sb.append(",objects=");
            sb.append(objArr != null ? objArr : com.igexin.push.core.b.l);
            com.opos.cmn.an.f.a.b("ReminderToastWidget", sb.toString());
            this.h.offer(new com.opos.cmn.e.a.c.b.b(str, z, objArr));
            f();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.e.a.c.d.c
    public void b() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "destroyContext");
        try {
            if (k()) {
                if (this.f11104c != null) {
                    this.f11104c.c();
                }
            } else if (this.e != null) {
                com.opos.cmn.an.h.f.a.a(this.f11101a, this.e);
                this.e = null;
            }
            this.g = false;
            this.h.clear();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.e.a.c.d.c
    public void b(View view, int[] iArr, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onClose view=");
        sb.append(view != null ? view : com.igexin.push.core.b.l);
        sb.append(",pkgName=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        sb.append(",objects=");
        Object[] objArr2 = com.igexin.push.core.b.l;
        if (objArr != null) {
            objArr2 = objArr;
        }
        sb.append(objArr2);
        com.opos.cmn.an.f.a.b("ReminderToastWidget", sb.toString());
        this.b.b(view, iArr, str, objArr);
    }
}
