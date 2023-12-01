package com.kwad.sdk.utils;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/j.class */
public abstract class j<T> {
    protected boolean Ig;
    protected boolean azm = false;

    public j(boolean z) {
        this.Ig = z;
    }

    public final void aP(boolean z) {
        this.Ig = z;
    }

    public final T bF(Context context) {
        if (this.Ig && !this.azm) {
            try {
                return bG(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                return null;
            }
        }
        return null;
    }

    protected abstract T bG(Context context);
}
