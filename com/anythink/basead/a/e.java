package com.anythink.basead.a;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/e.class */
public final class e {
    public static int a(Context context, com.anythink.core.common.e.i iVar) {
        int D = iVar.D();
        return (D == 1 || D == 4) ? com.anythink.core.common.k.h.a(context, "myoffer_cta_install_now", "string") : com.anythink.core.common.k.h.a(context, "myoffer_cta_learn_more", "string");
    }

    public static boolean a(com.anythink.core.common.e.i iVar) {
        return (TextUtils.isEmpty(iVar.t()) && TextUtils.isEmpty(iVar.r()) && TextUtils.isEmpty(iVar.s())) ? false : true;
    }
}
