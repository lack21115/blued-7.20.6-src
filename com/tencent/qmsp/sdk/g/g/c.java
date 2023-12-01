package com.tencent.qmsp.sdk.g.g;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/g/c.class */
public class c implements com.tencent.qmsp.sdk.base.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f24951a = null;
    private IVendorCallback b = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/g/c$a.class */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1000L);
                if (c.this.b != null) {
                    c.this.b.onResult(b.a(), b.a(c.this.f24951a), b.b(c.this.f24951a));
                }
            } catch (Exception e) {
                if (c.this.b != null) {
                    c.this.b.onResult(false, null, null);
                }
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String a() {
        return "";
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f24951a = context;
        this.b = iVendorCallback;
        b.c(context);
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String b() {
        return "";
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void c() {
        new Thread(new a()).start();
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean e() {
        return b.a();
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void f() {
    }
}
