package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/c.class */
public class c extends com.vivo.push.o {

    /* renamed from: a  reason: collision with root package name */
    private String f27346a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f27347c;
    private int d;
    private int e;
    private String f;

    public c(int i, String str) {
        super(i);
        this.f27347c = -1L;
        this.d = -1;
        this.f27346a = null;
        this.b = str;
    }

    public final int a(Context context) {
        if (this.d == -1) {
            String str = this.b;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.p.a("BaseAppCommand", "pkg name is null");
                str2 = a();
                if (TextUtils.isEmpty(str2)) {
                    com.vivo.push.util.p.a("BaseAppCommand", "src is null");
                    return -1;
                }
            }
            this.d = com.vivo.push.util.t.b(context, str2);
            if (!TextUtils.isEmpty(this.f)) {
                this.d = 2;
            }
        }
        return this.d;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void b(String str) {
        this.f27346a = str;
    }

    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f27346a);
        aVar.a("package_name", this.b);
        aVar.a("sdk_version", 323L);
        aVar.a("PUSH_APP_STATUS", this.d);
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
    }

    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        this.f27346a = aVar.a("req_id");
        this.b = aVar.a("package_name");
        this.f27347c = aVar.b("sdk_version", 0L);
        this.d = aVar.b("PUSH_APP_STATUS", 0);
        this.f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.e;
    }

    public final void g() {
        this.f = null;
    }

    public final String h() {
        return this.f27346a;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "BaseAppCommand";
    }
}
