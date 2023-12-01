package com.kwai.filedownloader.event;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/event/DownloadServiceConnectChangedEvent.class */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus aIk;
    private final Class<?> aIl;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/event/DownloadServiceConnectChangedEvent$ConnectStatus.class */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.aIk = connectStatus;
        this.aIl = cls;
    }

    public final ConnectStatus Ij() {
        return this.aIk;
    }
}
