package com.kwai.filedownloader;

import android.content.Context;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwai.filedownloader.services.e;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/n.class */
public final class n implements u {
    private final u aFW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/n$a.class */
    public static final class a {
        private static final n aFX = new n((byte) 0);
    }

    private n() {
        this.aFW = com.kwai.filedownloader.e.e.Jb().aJu ? new o() : new p(FileDownloadService.SeparateProcessService.class);
    }

    /* synthetic */ n(byte b) {
        this();
    }

    public static n Hh() {
        return a.aFX;
    }

    public static e.a Hi() {
        if (Hh().aFW instanceof o) {
            return (e.a) Hh().aFW;
        }
        return null;
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        return this.aFW.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cB(int i) {
        return this.aFW.cB(i);
    }

    @Override // com.kwai.filedownloader.u
    public final byte cC(int i) {
        return this.aFW.cC(i);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cD(int i) {
        return this.aFW.cD(i);
    }

    @Override // com.kwai.filedownloader.u
    public final void dr(Context context) {
        this.aFW.dr(context);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean isConnected() {
        return this.aFW.isConnected();
    }
}
