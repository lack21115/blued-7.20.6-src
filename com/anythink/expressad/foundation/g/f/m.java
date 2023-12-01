package com.anythink.expressad.foundation.g.f;

import android.content.Context;
import com.anythink.core.common.b.n;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/m.class */
public final class m {

    /* renamed from: c  reason: collision with root package name */
    private static m f7928c;

    /* renamed from: a  reason: collision with root package name */
    private j f7929a;
    private com.anythink.expressad.foundation.g.f.d.b b;

    private m() {
    }

    public static com.anythink.expressad.foundation.g.f.d.b a() {
        m mVar = f7928c;
        if (mVar != null) {
            com.anythink.expressad.foundation.g.f.d.b bVar = mVar.b;
            if (bVar != null) {
                return bVar;
            }
            mVar.b = new com.anythink.expressad.foundation.g.f.d.b(b());
            return f7928c.b;
        }
        m mVar2 = new m();
        f7928c = mVar2;
        if (mVar2.b == null) {
            mVar2.b = new com.anythink.expressad.foundation.g.f.d.b(b());
        }
        return f7928c.b;
    }

    public static void a(Context context) {
        if (f7928c == null) {
            m mVar = new m();
            f7928c = mVar;
            mVar.f7929a = new j(context.getApplicationContext());
            f7928c.b = new com.anythink.expressad.foundation.g.f.d.b(b());
        }
    }

    public static void a(i iVar) {
        b().a(iVar);
    }

    private static j b() {
        m mVar = f7928c;
        if (mVar != null) {
            j jVar = mVar.f7929a;
            if (jVar != null) {
                return jVar;
            }
            mVar.f7929a = new j(n.a().g());
            return f7928c.f7929a;
        }
        m mVar2 = new m();
        f7928c = mVar2;
        if (mVar2.f7929a == null) {
            mVar2.f7929a = new j(n.a().g());
        }
        return f7928c.f7929a;
    }

    private static void c() {
        com.anythink.expressad.foundation.g.f.d.b bVar;
        m mVar = f7928c;
        if (mVar == null || (bVar = mVar.b) == null) {
            return;
        }
        bVar.a();
        f7928c.b = null;
    }
}
