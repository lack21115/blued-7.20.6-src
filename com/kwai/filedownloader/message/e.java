package com.kwai.filedownloader.message;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/e.class */
public final class e {
    private volatile g aIw;
    private volatile b aIx;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/e$a.class */
    public static final class a {
        private static final e aIy = new e();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/e$b.class */
    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static e Iv() {
        return a.aIy;
    }

    public final void a(b bVar) {
        this.aIx = bVar;
        if (bVar == null) {
            this.aIw = null;
        } else {
            this.aIw = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwai.filedownloader.message.b) {
            if (this.aIx != null) {
                this.aIx.r(messageSnapshot);
            }
        } else if (this.aIw != null) {
            this.aIw.u(messageSnapshot);
        }
    }
}
