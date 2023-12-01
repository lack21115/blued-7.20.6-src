package com.kwai.filedownloader;

import android.text.TextUtils;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.d;
import com.kwai.filedownloader.x;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/c.class */
public final class c implements com.kwai.filedownloader.a, a.InterfaceC0413a, d.a {
    private final x aEU;
    private final x.a aEV;
    private int aEW;
    private ArrayList<Object> aEX;
    private String aEY;
    private String aEZ;
    private boolean aFa;
    private com.kwai.filedownloader.c.b aFb;
    private i aFc;
    private Object aFd;
    private final Object aFm;
    private final String mUrl;
    private int aFe = 0;
    private boolean aFf = false;
    private boolean aFg = false;
    private int aFh = 100;
    private int aFi = 10;
    private boolean aFj = false;
    volatile int aFk = 0;
    private boolean aFl = false;
    private final Object aFn = new Object();
    private volatile boolean aFo = false;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/c$a.class */
    static final class a implements a.b {
        private final c aFp;

        private a(c cVar) {
            this.aFp = cVar;
            c.a(cVar, true);
        }

        /* synthetic */ a(c cVar, byte b) {
            this(cVar);
        }

        @Override // com.kwai.filedownloader.a.b
        public final int GG() {
            int id = this.aFp.getId();
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            h.GW().c(this.aFp);
            return id;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.mUrl = str;
        Object obj = new Object();
        this.aFm = obj;
        d dVar = new d(this, obj);
        this.aEU = dVar;
        this.aEV = dVar;
    }

    private boolean GI() {
        return this.aEU.Gq() != 0;
    }

    private int GJ() {
        if (!GI()) {
            if (!Gj()) {
                GB();
            }
            this.aEU.GP();
            return getId();
        } else if (isRunning()) {
            throw new IllegalStateException(com.kwai.filedownloader.e.f.j("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
        } else {
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.aEU.toString());
        }
    }

    private void GK() {
        if (this.aFb == null) {
            synchronized (this.aFn) {
                if (this.aFb == null) {
                    this.aFb = new com.kwai.filedownloader.c.b();
                }
            }
        }
    }

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.aFl = true;
        return true;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final int GA() {
        return this.aFk;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final void GB() {
        this.aFk = Gn() != null ? Gn().hashCode() : hashCode();
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final boolean GC() {
        return this.aFo;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final void GD() {
        this.aFo = true;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final void GE() {
        GJ();
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final boolean GF() {
        ArrayList<Object> arrayList = this.aEX;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.kwai.filedownloader.d.a
    public final com.kwai.filedownloader.c.b GL() {
        return this.aFb;
    }

    @Override // com.kwai.filedownloader.d.a
    public final a.InterfaceC0413a GM() {
        return this;
    }

    @Override // com.kwai.filedownloader.d.a
    public final ArrayList<Object> GN() {
        return this.aEX;
    }

    @Override // com.kwai.filedownloader.a
    public final a.b Gh() {
        return new a(this, (byte) 0);
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gi() {
        if (isRunning()) {
            com.kwai.filedownloader.e.d.h(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.aFk = 0;
        this.aFl = false;
        this.aFo = false;
        this.aEU.reset();
        return true;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gj() {
        return this.aFk != 0;
    }

    @Override // com.kwai.filedownloader.a
    public final int Gk() {
        return this.aFh;
    }

    @Override // com.kwai.filedownloader.a
    public final int Gl() {
        return this.aFi;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gm() {
        return this.aFa;
    }

    @Override // com.kwai.filedownloader.a
    public final i Gn() {
        return this.aFc;
    }

    @Override // com.kwai.filedownloader.a
    public final long Go() {
        return this.aEU.GQ();
    }

    @Override // com.kwai.filedownloader.a
    public final long Gp() {
        return this.aEU.getTotalBytes();
    }

    @Override // com.kwai.filedownloader.a
    public final byte Gq() {
        return this.aEU.Gq();
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gr() {
        return this.aFj;
    }

    @Override // com.kwai.filedownloader.a
    public final Throwable Gs() {
        return this.aEU.Gs();
    }

    @Override // com.kwai.filedownloader.a
    public final int Gt() {
        return this.aFe;
    }

    @Override // com.kwai.filedownloader.a
    public final int Gu() {
        return this.aEU.Gu();
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gv() {
        return this.aFf;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gw() {
        return this.aEU.Gw();
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gx() {
        return this.aFg;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final com.kwai.filedownloader.a Gy() {
        return this;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final x.a Gz() {
        return this.aEV;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a a(i iVar) {
        this.aFc = iVar;
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "setListener %s", iVar);
        }
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a al(String str, String str2) {
        GK();
        this.aFb.an(str, str2);
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a bP(boolean z) {
        this.aFj = true;
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a bQ(boolean z) {
        this.aFf = true;
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a bR(boolean z) {
        this.aFg = z;
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean cancel() {
        return pause();
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a cv(int i) {
        this.aFe = 3;
        return this;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final boolean cw(int i) {
        return getId() == i;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a f(String str, boolean z) {
        this.aEY = str;
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "setPath %s", str);
        }
        this.aFa = z;
        this.aEZ = z ? null : new File(str).getName();
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a fj(String str) {
        return f(str, false);
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a fk(String str) {
        if (this.aFb == null) {
            synchronized (this.aFn) {
                if (this.aFb == null) {
                    return this;
                }
            }
        }
        this.aFb.fu(str);
        return this;
    }

    @Override // com.kwai.filedownloader.d.a
    public final void fl(String str) {
        this.aEZ = str;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final void free() {
        this.aEU.free();
        if (h.GW().a(this)) {
            this.aFo = false;
        }
    }

    @Override // com.kwai.filedownloader.a
    public final String getFilename() {
        return this.aEZ;
    }

    @Override // com.kwai.filedownloader.a
    public final int getId() {
        int i = this.aEW;
        if (i != 0) {
            return i;
        }
        if (TextUtils.isEmpty(this.aEY) || TextUtils.isEmpty(this.mUrl)) {
            return 0;
        }
        int k = com.kwai.filedownloader.e.f.k(this.mUrl, this.aEY, this.aFa);
        this.aEW = k;
        return k;
    }

    @Override // com.kwai.filedownloader.a
    public final String getPath() {
        return this.aEY;
    }

    @Override // com.kwai.filedownloader.a
    public final int getSmallFileSoFarBytes() {
        if (this.aEU.GQ() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.aEU.GQ();
    }

    @Override // com.kwai.filedownloader.a
    public final int getSmallFileTotalBytes() {
        if (this.aEU.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.aEU.getTotalBytes();
    }

    @Override // com.kwai.filedownloader.a
    public final int getSpeed() {
        return this.aEU.getSpeed();
    }

    @Override // com.kwai.filedownloader.a
    public final long getStatusUpdateTime() {
        return this.aEU.getStatusUpdateTime();
    }

    @Override // com.kwai.filedownloader.a
    public final Object getTag() {
        return this.aFd;
    }

    @Override // com.kwai.filedownloader.a
    public final String getTargetFilePath() {
        return com.kwai.filedownloader.e.f.a(getPath(), Gm(), getFilename());
    }

    @Override // com.kwai.filedownloader.a
    public final String getUrl() {
        return this.mUrl;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0413a
    public final boolean isOver() {
        return com.kwai.filedownloader.c.d.dd(Gq());
    }

    @Override // com.kwai.filedownloader.a
    public final boolean isRunning() {
        if (r.Hp().Ht().d(this)) {
            return true;
        }
        return com.kwai.filedownloader.c.d.de(Gq());
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a k(Object obj) {
        this.aFd = obj;
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean pause() {
        boolean pause;
        synchronized (this.aFm) {
            pause = this.aEU.pause();
        }
        return pause;
    }

    @Override // com.kwai.filedownloader.a
    public final int start() {
        if (this.aFl) {
            throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
        }
        return GJ();
    }

    public final String toString() {
        return com.kwai.filedownloader.e.f.j("%d@%s", Integer.valueOf(getId()), super.toString());
    }
}
