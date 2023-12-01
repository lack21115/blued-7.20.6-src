package com.opos.exoplayer.core.f.h;

import com.opos.exoplayer.core.f.h.c;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/h/a.class */
public final class a extends com.opos.exoplayer.core.f.c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f11703a = u.f("payl");
    private static final int b = u.f("sttg");

    /* renamed from: c  reason: collision with root package name */
    private static final int f11704c = u.f("vttc");
    private final m d;
    private final c.a e;

    public a() {
        super("Mp4WebvttDecoder");
        this.d = new m();
        this.e = new c.a();
    }

    private static com.opos.exoplayer.core.f.b a(m mVar, c.a aVar, int i) {
        aVar.a();
        while (i > 0) {
            if (i < 8) {
                throw new com.opos.exoplayer.core.f.f("Incomplete vtt cue box header found.");
            }
            int o = mVar.o();
            int o2 = mVar.o();
            int i2 = o - 8;
            String str = new String(mVar.f11808a, mVar.d(), i2);
            mVar.d(i2);
            int i3 = (i - 8) - i2;
            if (o2 == b) {
                d.a(str, aVar);
                i = i3;
            } else {
                i = i3;
                if (o2 == f11703a) {
                    d.a((String) null, str.trim(), aVar, Collections.emptyList());
                    i = i3;
                }
            }
        }
        return aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public h a(byte[] bArr, int i, boolean z) {
        this.d.a(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.d.b() > 0) {
            if (this.d.b() < 8) {
                throw new com.opos.exoplayer.core.f.f("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int o = this.d.o();
            if (this.d.o() == f11704c) {
                arrayList.add(a(this.d, this.e, o - 8));
            } else {
                this.d.d(o - 8);
            }
        }
        return new h(arrayList);
    }
}
