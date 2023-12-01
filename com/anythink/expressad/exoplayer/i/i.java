package com.anythink.expressad.exoplayer.i;

import com.anythink.expressad.exoplayer.aa;
import com.anythink.expressad.exoplayer.k.af;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f7547a;
    public final aa[] b;

    /* renamed from: c  reason: collision with root package name */
    public final g f7548c;
    public final Object d;

    public i(aa[] aaVarArr, f[] fVarArr, Object obj) {
        this.b = aaVarArr;
        this.f7548c = new g(fVarArr);
        this.d = obj;
        this.f7547a = aaVarArr.length;
    }

    public final boolean a(int i) {
        return this.b[i] != null;
    }

    public final boolean a(i iVar) {
        if (iVar == null || iVar.f7548c.f7544a != this.f7548c.f7544a) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f7548c.f7544a) {
                return true;
            }
            if (!a(iVar, i2)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public final boolean a(i iVar, int i) {
        return iVar != null && af.a(this.b[i], iVar.b[i]) && af.a(this.f7548c.a(i), iVar.f7548c.a(i));
    }
}
