package com.anythink.basead.d.c;

import android.text.TextUtils;
import com.anythink.core.common.e.i;
import com.anythink.expressad.foundation.h.j;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/c/b.class */
public final class b {
    public static void a(i iVar) {
        String f = iVar.f();
        if (TextUtils.isEmpty(f)) {
            return;
        }
        iVar.d(j.b(f));
    }
}
