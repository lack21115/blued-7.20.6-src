package com.anythink.splashad.a;

import android.content.Context;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/e.class */
public final class e extends h {
    int T;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context) {
        super(context);
    }

    private void d(int i) {
        this.T = i;
    }

    @Override // com.anythink.core.common.h
    public final void a(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter instanceof CustomSplashAdapter) {
            ((CustomSplashAdapter) aTBaseAdAdapter).setFetchAdTimeout(this.T);
        }
    }

    @Override // com.anythink.core.common.h
    public final void a(AdError adError) {
        super.a(adError);
    }

    @Override // com.anythink.core.common.h
    public final void a(String str, com.anythink.core.common.l.a aVar) {
        super.a(str, aVar);
    }

    @Override // com.anythink.core.common.h
    public final void g() {
        if (this.j != null) {
            this.j.f = null;
        }
        super.g();
    }

    @Override // com.anythink.core.common.h
    public final void h() {
        super.h();
    }

    public final void j() {
        g();
        a();
    }
}
