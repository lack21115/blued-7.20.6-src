package com.opos.exoplayer.core.g;

import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final m f25438a;
    public final boolean[] b;

    /* renamed from: c  reason: collision with root package name */
    public final g f25439c;
    public final Object d;
    public final u[] e;

    public i(m mVar, boolean[] zArr, g gVar, Object obj, u[] uVarArr) {
        this.f25438a = mVar;
        this.b = zArr;
        this.f25439c = gVar;
        this.d = obj;
        this.e = uVarArr;
    }

    public boolean a(i iVar) {
        boolean z = false;
        if (iVar != null) {
            if (iVar.f25439c.f25435a == this.f25439c.f25435a) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f25439c.f25435a) {
                        z = true;
                        break;
                    }
                    z = false;
                    if (!a(iVar, i2)) {
                        break;
                    }
                    i = i2 + 1;
                }
            } else {
                return false;
            }
        }
        return z;
    }

    public boolean a(i iVar, int i) {
        return iVar != null && this.b[i] == iVar.b[i] && com.opos.exoplayer.core.i.u.a(this.f25439c.a(i), iVar.f25439c.a(i)) && com.opos.exoplayer.core.i.u.a(this.e[i], iVar.e[i]);
    }
}
