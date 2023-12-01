package com.kwad.components.offline.obiwan;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/obiwan/b.class */
public final class b implements com.kwad.sdk.core.d.kwai.b {
    private final IObiwanLogcat Xv;

    public b(IObiwanLogcat iObiwanLogcat) {
        this.Xv = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void d(String str, String str2) {
        this.Xv.d(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void e(String str, String str2) {
        this.Xv.e(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void i(String str, String str2) {
        this.Xv.i(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void printStackTraceOnly(Throwable th) {
        this.Xv.printStackTraceOnly(th);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void v(String str, String str2) {
        this.Xv.v(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void v(String str, String str2, boolean z) {
        this.Xv.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void w(String str, String str2) {
        this.Xv.w(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.b
    public final void w(String str, String str2, boolean z) {
        this.Xv.w(str, str2, z);
    }
}
