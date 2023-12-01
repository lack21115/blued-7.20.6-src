package com.tencent.qimei.u;

import android.content.Context;
import com.tencent.qimei.shellapi.IDependency;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/u/d.class */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f24728a;
    public c b;

    public static d b() {
        if (f24728a == null) {
            synchronized (d.class) {
                try {
                    if (f24728a == null) {
                        f24728a = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f24728a;
    }

    @Override // com.tencent.qimei.u.c
    public Context J() {
        synchronized (this) {
            if (a() == null) {
                return null;
            }
            return a().J();
        }
    }

    @Override // com.tencent.qimei.u.c
    public String O() {
        return a() == null ? "" : a().O();
    }

    public final c a() {
        IDependency a2 = com.tencent.qimei.t.b.a().a("SdkInfo");
        if (a2 instanceof c) {
            c cVar = (c) a2;
            this.b = cVar;
            return cVar;
        }
        return null;
    }

    @Override // com.tencent.qimei.u.c
    public String getSdkVersion() {
        return a() == null ? "" : a().getSdkVersion();
    }
}
