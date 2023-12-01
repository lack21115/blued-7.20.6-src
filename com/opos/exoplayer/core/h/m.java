package com.opos.exoplayer.core.h;

import android.content.Context;
import com.opos.exoplayer.core.h.g;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/m.class */
public final class m implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f25459a;
    private final t<? super g> b;

    /* renamed from: c  reason: collision with root package name */
    private final g.a f25460c;

    public m(Context context, t<? super g> tVar, g.a aVar) {
        this.f25459a = context.getApplicationContext();
        this.b = tVar;
        this.f25460c = aVar;
    }

    public m(Context context, String str) {
        this(context, str, (t<? super g>) null);
    }

    public m(Context context, String str, t<? super g> tVar) {
        this(context, tVar, new o(str, tVar));
    }

    @Override // com.opos.exoplayer.core.h.g.a
    /* renamed from: b */
    public l a() {
        return new l(this.f25459a, this.b, this.f25460c.a());
    }
}
