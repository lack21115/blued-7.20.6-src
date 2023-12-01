package com.tencent.tmsqmsp.oaid2;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/f0.class */
public class f0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public Context f39626a = null;
    public IVendorCallback b = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/f0$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1000L);
                if (f0.this.b != null) {
                    f0.this.b.onResult(e0.a(), e0.a(f0.this.f39626a), e0.b(f0.this.f39626a));
                }
            } catch (Exception e) {
                if (f0.this.b != null) {
                    f0.this.b.onResult(false, com.igexin.push.core.b.l, com.igexin.push.core.b.l);
                }
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String a() {
        return "";
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f39626a = context;
        this.b = iVendorCallback;
        e0.c(context);
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String d() {
        return "";
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean e() {
        return e0.a();
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void j() {
        new Thread(new a()).start();
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean k() {
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void l() {
    }
}
