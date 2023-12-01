package com.anythink.core.b.b;

import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/b/b.class */
public abstract class b implements ATBiddingListener {
    protected ATBaseAdAdapter c;

    public b(ATBaseAdAdapter aTBaseAdAdapter) {
        this.c = aTBaseAdAdapter;
    }

    private void a() {
        this.c = null;
    }
}
