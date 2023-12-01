package com.anythink.core.common;

import com.anythink.core.api.AdError;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e.class */
public final class e extends IllegalStateException {
    public AdError a;
    public String b;

    public e(AdError adError, String str) {
        this.a = adError;
        this.b = str;
    }
}
