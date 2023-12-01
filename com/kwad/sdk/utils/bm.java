package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bm.class */
public final class bm extends Handler {
    private WeakReference<a> aBC;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bm$a.class */
    public interface a {
        void a(Message message);
    }

    public bm(a aVar) {
        this.aBC = new WeakReference<>(aVar);
    }

    public bm(a aVar, Looper looper) {
        super(looper);
        this.aBC = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        a aVar;
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
        if (this.aBC == null || (aVar = this.aBC.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }
}
