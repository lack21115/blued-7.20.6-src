package com.igexin.c.a.b.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.igexin.c.a.b.a.a.d;
import com.igexin.push.core.d;
import java.net.Socket;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/c.class */
public final class c extends Handler {

    /* renamed from: com.igexin.c.a.b.a.a.c$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/c$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9615a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0052 -> B:39:0x0013). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0056 -> B:35:0x001d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005a -> B:31:0x0027). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005e -> B:41:0x0031). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:37:0x003b). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0066 -> B:33:0x0046). Please submit an issue!!! */
        static {
            int[] iArr = new int[j.a().length];
            f9615a = iArr;
            try {
                iArr[j.d - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9615a[j.e - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9615a[j.f9629c - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9615a[j.f - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9615a[j.g - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f9615a[j.f9628a - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f9615a[j.h - 1] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public c(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            int i = AnonymousClass1.f9615a[j.a()[message.what] - 1];
            if (i == 1) {
                d a2 = d.a();
                boolean z = (a2.f9616a == null || a2.f9616a.isClosed()) ? false : true;
                if (!z && a2.d == null) {
                    com.igexin.c.a.c.a.a("GS-M|disconnect = true, reconnect", new Object[0]);
                    a2.d = new b(new d.AnonymousClass1());
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a2.d, true);
                    return;
                }
                com.igexin.c.a.c.a.a("GS-Mstart connect, isConnected = " + z + ", ctask = " + a2.d, new Object[0]);
            } else if (i == 3) {
                d.a().a((Socket) message.obj);
            } else if (i == 4) {
                d a3 = d.a();
                if (!a3.i() || a3.e) {
                    return;
                }
                a3.b();
                a3.e = true;
            } else if (i == 5) {
                d a4 = d.a();
                a4.j();
                if ((a4.d == null && a4.f9617c == null && a4.b == null) || a4.i()) {
                    a4.b();
                } else {
                    a4.h();
                }
            } else if (i == 6) {
                d.a();
                com.igexin.push.core.d unused = d.a.f9866a;
                com.igexin.push.d.a.a(j.f9628a);
            } else if (i != 7) {
            } else {
                d a5 = d.a();
                Object obj = message.obj;
                com.igexin.c.a.c.a.b("GS-M", ((String) obj) + " write task response timeout");
                a5.c();
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
