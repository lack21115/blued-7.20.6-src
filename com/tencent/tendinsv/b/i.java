package com.tencent.tendinsv.b;

import android.content.Context;
import android.os.Build;
import com.tencent.tendinsv.utils.t;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/b/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f25318a;

    /* renamed from: c  reason: collision with root package name */
    private Context f25319c;
    private k b = g.a(Build.MANUFACTURER.toUpperCase());
    private boolean d = false;
    private boolean e = false;

    public static i a() {
        if (f25318a == null) {
            f25318a = new i();
        }
        return f25318a;
    }

    private void b(Context context) {
        if (this.b != null && context != null) {
            this.f25319c = context.getApplicationContext();
        }
        boolean b = b();
        this.d = b;
        if (b) {
            this.e = this.b.c_(this.f25319c);
        }
    }

    private boolean b() {
        boolean z = false;
        try {
            if (this.f25319c != null) {
                if (this.b == null) {
                    return false;
                }
                z = this.b.b_(this.f25319c);
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    private String c() {
        String str = null;
        try {
            if (this.f25319c != null) {
                str = null;
                if (this.b != null) {
                    if (!this.e) {
                        return null;
                    }
                    str = this.b.b(this.f25319c);
                }
            }
            return str;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Context context) {
        b(context);
        if (this.e) {
            return c();
        }
        return null;
    }

    public void a(final Context context) {
        new Thread(new Runnable() { // from class: com.tencent.tendinsv.b.i.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    t.a(context, t.V, i.this.c(context));
                } catch (Exception e) {
                }
            }
        }).start();
    }
}
