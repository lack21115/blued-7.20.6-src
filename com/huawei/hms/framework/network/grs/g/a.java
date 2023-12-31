package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected d f9087a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final c f9088c;
    private final int d;
    private final Context e;
    private final String f;
    private final GrsBaseInfo g;
    private final com.huawei.hms.framework.network.grs.e.c h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.framework.network.grs.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/a$a.class */
    public enum EnumC0258a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public a(String str, int i, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.b = str;
        this.f9088c = cVar;
        this.d = i;
        this.e = context;
        this.f = str2;
        this.g = grsBaseInfo;
        this.h = cVar2;
    }

    private String a(String str) {
        return Uri.parse(str).getPath();
    }

    private EnumC0258a h() {
        if (this.b.isEmpty()) {
            return EnumC0258a.GRSDEFAULT;
        }
        String a2 = a(this.b);
        return a2.contains("1.0") ? EnumC0258a.GRSGET : a2.contains("2.0") ? EnumC0258a.GRSPOST : EnumC0258a.GRSDEFAULT;
    }

    public Context a() {
        return this.e;
    }

    public c b() {
        return this.f9088c;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.f;
    }

    public com.huawei.hms.framework.network.grs.e.c f() {
        return this.h;
    }

    public Callable<d> g() {
        if (EnumC0258a.GRSDEFAULT.equals(h())) {
            return null;
        }
        return EnumC0258a.GRSGET.equals(h()) ? new f(this.b, this.d, this.f9088c, this.e, this.f, this.g) : new g(this.b, this.d, this.f9088c, this.e, this.f, this.g, this.h);
    }
}
