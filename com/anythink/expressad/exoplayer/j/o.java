package com.anythink.expressad.exoplayer.j;

import android.content.Context;
import com.anythink.expressad.exoplayer.j.h;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/o.class */
public final class o implements h.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7595a;
    private final aa<? super h> b;

    /* renamed from: c  reason: collision with root package name */
    private final h.a f7596c;

    private o(Context context, aa<? super h> aaVar, h.a aVar) {
        this.f7595a = context.getApplicationContext();
        this.b = aaVar;
        this.f7596c = aVar;
    }

    public o(Context context, String str) {
        this(context, str, (aa<? super h>) null);
    }

    private o(Context context, String str, aa<? super h> aaVar) {
        this(context, aaVar, new q(str, aaVar));
    }

    private n b() {
        return new n(this.f7595a, this.b, this.f7596c.a());
    }

    @Override // com.anythink.expressad.exoplayer.j.h.a
    public final /* synthetic */ h a() {
        return new n(this.f7595a, this.b, this.f7596c.a());
    }
}
