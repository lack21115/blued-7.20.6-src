package com.anythink.expressad.foundation.g.g;

import android.content.Context;
import java.util.WeakHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/g/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5093a = b.class.getSimpleName();
    private static WeakHashMap<Context, c> b = new WeakHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private c f5094c;
    private Context d;

    private b(Context context) {
        this.d = context;
        if (b.get(context) != null) {
            this.f5094c = b.get(this.d);
            return;
        }
        c cVar = new c(this.d, 5);
        this.f5094c = cVar;
        b.put(this.d, cVar);
    }

    private void a(a aVar) {
        this.f5094c.a(aVar);
    }
}
