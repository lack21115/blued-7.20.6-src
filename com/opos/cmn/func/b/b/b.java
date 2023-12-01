package com.opos.cmn.func.b.b;

import android.content.Context;
import com.opos.cmn.func.b.a.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/b.class */
public class b implements com.opos.cmn.func.b.a.d, com.opos.cmn.func.b.a.e {
    private static b b;

    /* renamed from: a  reason: collision with root package name */
    f f24857a = com.opos.cmn.func.b.a.a.a.a();

    private b() {
    }

    public static b a() {
        b bVar;
        b bVar2 = b;
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (b.class) {
            try {
                if (b == null) {
                    b = new b();
                }
                bVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    @Override // com.opos.cmn.func.b.a.e
    public e a(Context context, d dVar) {
        f fVar = this.f24857a;
        if (fVar != null) {
            return fVar.a(context, dVar);
        }
        return null;
    }

    @Override // com.opos.cmn.func.b.a.d
    public void a(Context context) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        f fVar = this.f24857a;
        if (fVar != null) {
            fVar.a(context);
        }
    }
}
