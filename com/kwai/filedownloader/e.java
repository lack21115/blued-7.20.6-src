package com.kwai.filedownloader;

import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e.class */
public abstract class e extends com.kwai.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus aFE;

    public abstract void GR();

    public abstract void GS();

    public final DownloadServiceConnectChangedEvent.ConnectStatus GT() {
        return this.aFE;
    }

    @Override // com.kwai.filedownloader.event.c
    public final boolean a(com.kwai.filedownloader.event.b bVar) {
        if (bVar instanceof DownloadServiceConnectChangedEvent) {
            DownloadServiceConnectChangedEvent.ConnectStatus Ij = ((DownloadServiceConnectChangedEvent) bVar).Ij();
            this.aFE = Ij;
            if (Ij == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
                GR();
                return false;
            }
            GS();
            return false;
        }
        return false;
    }
}
