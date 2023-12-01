package com.kwad.sdk.core.d;

import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/d/a.class */
final class a implements com.kwad.sdk.core.d.kwai.b {
    @Override // com.kwad.sdk.core.d.kwai.b
    public final void d(String str, String str2) {
        if (b.afV && com.kwad.kwai.kwai.a.bI.booleanValue()) {
            Log.d(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void e(String str, String str2) {
        if (b.afV) {
            Log.e(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void i(String str, String str2) {
        if (b.afV) {
            Log.i(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void printStackTraceOnly(Throwable th) {
        if (b.afV && com.kwad.kwai.kwai.a.bI.booleanValue() && th != null) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void v(String str, String str2) {
        if (b.afV && com.kwad.kwai.kwai.a.bI.booleanValue()) {
            Log.v(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void v(String str, String str2, boolean z) {
        Log.v(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void w(String str, String str2) {
        if (b.afV) {
            Log.w(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void w(String str, String str2, boolean z) {
        if (z) {
            Log.w(str, str2);
        }
    }
}
