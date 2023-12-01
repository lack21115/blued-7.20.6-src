package com.tencent.tmsqmsp.sdk.g.g;

import android.content.Context;
import com.tencent.tmsqmsp.sdk.base.IVendorCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/g/c.class */
public class c implements com.tencent.tmsqmsp.sdk.base.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f39792a = null;
    private IVendorCallback b = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/g/c$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1000L);
                if (c.this.b != null) {
                    c.this.b.onResult(b.a(), b.a(c.this.f39792a), b.b(c.this.f39792a));
                }
            } catch (Exception e) {
                if (c.this.b != null) {
                    c.this.b.onResult(false, null, null);
                }
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String a() {
        return "";
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f39792a = context;
        this.b = iVendorCallback;
        b.c(context);
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String b() {
        return "";
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void c() {
        new Thread(new a()).start();
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public boolean e() {
        return b.a();
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void f() {
    }
}
