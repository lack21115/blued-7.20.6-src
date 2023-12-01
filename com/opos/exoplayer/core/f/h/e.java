package com.opos.exoplayer.core.f.h;

import android.text.TextUtils;
import com.opos.exoplayer.core.f.h.c;
import com.opos.exoplayer.core.i.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/h/e.class */
public final class e extends com.opos.exoplayer.core.f.c {

    /* renamed from: a  reason: collision with root package name */
    private final d f25403a;
    private final m b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f25404c;
    private final g d;
    private final List<b> e;

    public e() {
        super("WebvttDecoder");
        this.f25403a = new d();
        this.b = new m();
        this.f25404c = new c.a();
        this.d = new g();
        this.e = new ArrayList();
    }

    private static int a(m mVar) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = mVar.d();
            String z = mVar.z();
            i = z == null ? 0 : "STYLE".equals(z) ? 2 : "NOTE".startsWith(z) ? 1 : 3;
        }
        mVar.c(i2);
        return i;
    }

    private static void b(m mVar) {
        do {
        } while (!TextUtils.isEmpty(mVar.z()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public i a(byte[] bArr, int i, boolean z) {
        this.b.a(bArr, i);
        this.f25404c.a();
        this.e.clear();
        f.a(this.b);
        do {
        } while (!TextUtils.isEmpty(this.b.z()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int a2 = a(this.b);
            if (a2 == 0) {
                return new i(arrayList);
            }
            if (a2 == 1) {
                b(this.b);
            } else if (a2 == 2) {
                if (!arrayList.isEmpty()) {
                    throw new com.opos.exoplayer.core.f.f("A style block was found after the first cue.");
                }
                this.b.z();
                b a3 = this.d.a(this.b);
                if (a3 != null) {
                    this.e.add(a3);
                }
            } else if (a2 == 3 && this.f25403a.a(this.b, this.f25404c, this.e)) {
                arrayList.add(this.f25404c.b());
                this.f25404c.a();
            }
        }
    }
}
