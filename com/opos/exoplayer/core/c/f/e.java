package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/e.class */
public final class e implements u.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f11503a;
    private final List<Format> b;

    public e() {
        this(0);
    }

    public e(int i) {
        this(i, Collections.emptyList());
    }

    public e(int i, List<Format> list) {
        this.f11503a = i;
        List<Format> list2 = list;
        if (!a(32)) {
            list2 = list;
            if (list.isEmpty()) {
                list2 = Collections.singletonList(Format.a(null, com.anythink.expressad.exoplayer.k.o.W, 0, null));
            }
        }
        this.b = list2;
    }

    private w a(u.b bVar) {
        String str;
        int i;
        if (a(32)) {
            return new w(this.b);
        }
        com.opos.exoplayer.core.i.m mVar = new com.opos.exoplayer.core.i.m(bVar.d);
        ArrayList arrayList = this.b;
        while (mVar.b() > 0) {
            int g = mVar.g();
            int g2 = mVar.g();
            int d = mVar.d();
            if (g == 134) {
                ArrayList arrayList2 = new ArrayList();
                int g3 = mVar.g();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    arrayList = arrayList2;
                    if (i3 < (g3 & 31)) {
                        String e = mVar.e(3);
                        int g4 = mVar.g();
                        if ((g4 & 128) != 0) {
                            i = g4 & 63;
                            str = com.anythink.expressad.exoplayer.k.o.X;
                        } else {
                            str = com.anythink.expressad.exoplayer.k.o.W;
                            i = 1;
                        }
                        arrayList2.add(Format.a((String) null, str, (String) null, -1, 0, e, i, (DrmInitData) null));
                        mVar.d(2);
                        i2 = i3 + 1;
                    }
                }
            }
            mVar.c(d + g2);
        }
        return new w(arrayList);
    }

    private boolean a(int i) {
        return (i & this.f11503a) != 0;
    }

    @Override // com.opos.exoplayer.core.c.f.u.c
    public SparseArray<u> a() {
        return new SparseArray<>();
    }

    @Override // com.opos.exoplayer.core.c.f.u.c
    public u a(int i, u.b bVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new o(new n(bVar.b));
            }
            if (i == 15) {
                if (a(2)) {
                    return null;
                }
                return new o(new d(false, bVar.b));
            } else if (i == 17) {
                if (a(2)) {
                    return null;
                }
                return new o(new m(bVar.b));
            } else if (i != 21) {
                if (i == 27) {
                    if (a(4)) {
                        return null;
                    }
                    return new o(new j(a(bVar), a(1), a(8)));
                } else if (i != 36) {
                    if (i != 89) {
                        if (i != 138) {
                            if (i != 129) {
                                if (i != 130) {
                                    if (i == 134) {
                                        if (a(16)) {
                                            return null;
                                        }
                                        return new r(new s());
                                    } else if (i != 135) {
                                        return null;
                                    }
                                }
                            }
                            return new o(new b(bVar.b));
                        }
                        return new o(new f(bVar.b));
                    }
                    return new o(new g(bVar.f11546c));
                } else {
                    return new o(new k(a(bVar)));
                }
            } else {
                return new o(new l());
            }
        }
        return new o(new i());
    }
}
