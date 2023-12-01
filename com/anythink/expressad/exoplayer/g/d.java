package com.anythink.expressad.exoplayer.g;

import com.anythink.expressad.exoplayer.k.o;
import com.anythink.expressad.exoplayer.m;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/d.class */
public interface d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f7377a = new d() { // from class: com.anythink.expressad.exoplayer.g.d.1
        @Override // com.anythink.expressad.exoplayer.g.d
        public final boolean a(m mVar) {
            String str = mVar.h;
            return o.V.equals(str) || o.ai.equals(str) || o.ag.equals(str);
        }

        @Override // com.anythink.expressad.exoplayer.g.d
        public final b b(m mVar) {
            boolean z;
            String str = mVar.h;
            int hashCode = str.hashCode();
            if (hashCode == -1248341703) {
                if (str.equals(o.V)) {
                    z = false;
                }
                z = true;
            } else if (hashCode != 1154383568) {
                if (hashCode == 1652648887 && str.equals(o.ag)) {
                    z = true;
                }
                z = true;
            } else {
                if (str.equals(o.ai)) {
                    z = true;
                }
                z = true;
            }
            if (z) {
                if (!z) {
                    if (z) {
                        return new com.anythink.expressad.exoplayer.g.c.c();
                    }
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                }
                return new com.anythink.expressad.exoplayer.g.a.b();
            }
            return new com.anythink.expressad.exoplayer.g.b.g();
        }
    };

    boolean a(m mVar);

    b b(m mVar);
}
