package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.s;
import com.kwai.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/d.class */
public final class d implements a.c, x, x.a, x.b {
    private boolean aFA;
    private boolean aFB;
    private String aFC;
    private final Object aFm;
    private t aFq;
    private final a aFr;
    private volatile long aFt;
    private final s.b aFv;
    private final s.a aFw;
    private long aFx;
    private long aFy;
    private int aFz;
    private volatile byte aFs = 0;
    private Throwable aFu = null;
    private boolean aFD = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/d$a.class */
    public interface a {
        com.kwai.filedownloader.c.b GL();

        a.InterfaceC0583a GM();

        ArrayList<Object> GN();

        void fl(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Object obj) {
        this.aFm = obj;
        this.aFr = aVar;
        b bVar = new b();
        this.aFv = bVar;
        this.aFw = bVar;
        this.aFq = new k(aVar.GM(), this);
    }

    private void c(byte b) {
        this.aFs = b;
        this.aFt = System.currentTimeMillis();
    }

    private void e(MessageSnapshot messageSnapshot) {
        com.kwai.filedownloader.a Gy = this.aFr.GM().Gy();
        byte Gq = messageSnapshot.Gq();
        c(Gq);
        this.aFA = messageSnapshot.Gw();
        if (Gq == -4) {
            this.aFv.reset();
            int cx = h.GW().cx(Gy.getId());
            if (cx + ((cx > 1 || !Gy.Gm()) ? 0 : h.GW().cx(com.kwai.filedownloader.e.f.aq(Gy.getUrl(), Gy.getTargetFilePath()))) <= 1) {
                byte cC = n.Hh().cC(Gy.getId());
                com.kwai.filedownloader.e.d.h(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(Gy.getId()), Integer.valueOf(cC));
                if (com.kwai.filedownloader.c.d.de(cC)) {
                    c((byte) 1);
                    this.aFy = messageSnapshot.Iq();
                    long Is = messageSnapshot.Is();
                    this.aFx = Is;
                    this.aFv.start(Is);
                    this.aFq.f(((MessageSnapshot.a) messageSnapshot).Iu());
                    return;
                }
            }
            h.GW().a(this.aFr.GM(), messageSnapshot);
        } else if (Gq == -3) {
            this.aFD = messageSnapshot.Ir();
            this.aFx = messageSnapshot.Iq();
            this.aFy = messageSnapshot.Iq();
            h.GW().a(this.aFr.GM(), messageSnapshot);
        } else if (Gq == -1) {
            this.aFu = messageSnapshot.It();
            this.aFx = messageSnapshot.Is();
            h.GW().a(this.aFr.GM(), messageSnapshot);
        } else if (Gq == 1) {
            this.aFx = messageSnapshot.Is();
            this.aFy = messageSnapshot.Iq();
            this.aFq.f(messageSnapshot);
        } else if (Gq == 2) {
            this.aFy = messageSnapshot.Iq();
            this.aFB = messageSnapshot.Ig();
            this.aFC = messageSnapshot.getEtag();
            String fileName = messageSnapshot.getFileName();
            if (fileName != null) {
                if (Gy.getFilename() != null) {
                    com.kwai.filedownloader.e.d.h(this, "already has mFilename[%s], but assign mFilename[%s] again", Gy.getFilename(), fileName);
                }
                this.aFr.fl(fileName);
            }
            this.aFv.start(this.aFx);
            this.aFq.h(messageSnapshot);
        } else if (Gq == 3) {
            this.aFx = messageSnapshot.Is();
            this.aFv.aj(messageSnapshot.Is());
            this.aFq.i(messageSnapshot);
        } else if (Gq != 5) {
            if (Gq != 6) {
                return;
            }
            this.aFq.g(messageSnapshot);
        } else {
            this.aFx = messageSnapshot.Is();
            this.aFu = messageSnapshot.It();
            this.aFz = messageSnapshot.Gu();
            this.aFv.reset();
            this.aFq.k(messageSnapshot);
        }
    }

    private int getId() {
        return this.aFr.GM().Gy().getId();
    }

    private void prepare() {
        File file;
        com.kwai.filedownloader.a Gy = this.aFr.GM().Gy();
        if (Gy.getPath() == null) {
            Gy.fj(com.kwai.filedownloader.e.f.fz(Gy.getUrl()));
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "save Path is null to %s", Gy.getPath());
            }
        }
        if (Gy.Gm()) {
            file = new File(Gy.getPath());
        } else {
            String fD = com.kwai.filedownloader.e.f.fD(Gy.getPath());
            if (fD == null) {
                throw new InvalidParameterException(com.kwai.filedownloader.e.f.j("the provided mPath[%s] is invalid, can't find its directory", Gy.getPath()));
            }
            file = new File(fD);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwai.filedownloader.e.f.j("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    @Override // com.kwai.filedownloader.a.c
    public final void GH() {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.i(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(Gq()));
        }
        this.aFv.end(this.aFx);
        if (this.aFr.GN() != null) {
            ArrayList arrayList = (ArrayList) this.aFr.GN().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
            }
        }
        r.Hp().Ht().e(this.aFr.GM());
    }

    @Override // com.kwai.filedownloader.x.a
    public final t GO() {
        return this.aFq;
    }

    @Override // com.kwai.filedownloader.x
    public final void GP() {
        boolean z;
        synchronized (this.aFm) {
            if (this.aFs != 0) {
                com.kwai.filedownloader.e.d.h(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.aFs));
                return;
            }
            c((byte) 10);
            a.InterfaceC0583a GM = this.aFr.GM();
            com.kwai.filedownloader.a Gy = GM.Gy();
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.i(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", Gy.getUrl(), Gy.getPath(), Gy.Gn(), Gy.getTag());
            }
            try {
                prepare();
                z = true;
            } catch (Throwable th) {
                h.GW().b(GM);
                h.GW().a(GM, n(th));
                z = false;
            }
            if (z) {
                q.Hn().a(this);
            }
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.i(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
            }
        }
    }

    @Override // com.kwai.filedownloader.x
    public final long GQ() {
        return this.aFx;
    }

    @Override // com.kwai.filedownloader.x
    public final byte Gq() {
        return this.aFs;
    }

    @Override // com.kwai.filedownloader.x
    public final Throwable Gs() {
        return this.aFu;
    }

    @Override // com.kwai.filedownloader.x
    public final int Gu() {
        return this.aFz;
    }

    @Override // com.kwai.filedownloader.x
    public final boolean Gw() {
        return this.aFA;
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.c.d.B(Gq(), messageSnapshot.Gq())) {
            e(messageSnapshot);
            return true;
        } else if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.aFs), Byte.valueOf(Gq()), Integer.valueOf(getId()));
            return false;
        } else {
            return false;
        }
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        byte Gq = Gq();
        byte Gq2 = messageSnapshot.Gq();
        if (-2 == Gq && com.kwai.filedownloader.c.d.de(Gq2)) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
                return true;
            }
            return true;
        } else if (com.kwai.filedownloader.c.d.C(Gq, Gq2)) {
            e(messageSnapshot);
            return true;
        } else if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.aFs), Byte.valueOf(Gq()), Integer.valueOf(getId()));
            return false;
        } else {
            return false;
        }
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.c.d.f(this.aFr.GM().Gy())) {
            e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        if (this.aFr.GM().Gy().Gm() && messageSnapshot.Gq() == -4 && Gq() == 2) {
            e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwai.filedownloader.x
    public final void free() {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.aFs));
        }
        c((byte) 0);
    }

    @Override // com.kwai.filedownloader.s.a
    public final int getSpeed() {
        return this.aFw.getSpeed();
    }

    @Override // com.kwai.filedownloader.x
    public final long getStatusUpdateTime() {
        return this.aFt;
    }

    @Override // com.kwai.filedownloader.x
    public final long getTotalBytes() {
        return this.aFy;
    }

    @Override // com.kwai.filedownloader.x.a
    public final MessageSnapshot n(Throwable th) {
        c((byte) -1);
        this.aFu = th;
        return com.kwai.filedownloader.message.f.a(getId(), GQ(), th);
    }

    @Override // com.kwai.filedownloader.a.c
    public final void onBegin() {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.i(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(Gq()));
        }
    }

    @Override // com.kwai.filedownloader.x
    public final boolean pause() {
        if (com.kwai.filedownloader.c.d.dd(Gq())) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(Gq()), Integer.valueOf(this.aFr.GM().Gy().getId()));
                return false;
            }
            return false;
        }
        c((byte) -2);
        a.InterfaceC0583a GM = this.aFr.GM();
        com.kwai.filedownloader.a Gy = GM.Gy();
        q.Hn().b(this);
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.i(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        r.Hp();
        if (r.Hr()) {
            n.Hh().cB(Gy.getId());
        } else if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(Gy.getId()));
        }
        h.GW().b(GM);
        h.GW().a(GM, com.kwai.filedownloader.message.f.e(Gy));
        r.Hp().Ht().e(GM);
        return true;
    }

    @Override // com.kwai.filedownloader.x
    public final void reset() {
        this.aFu = null;
        this.aFC = null;
        this.aFB = false;
        this.aFz = 0;
        this.aFD = false;
        this.aFA = false;
        this.aFx = 0L;
        this.aFy = 0L;
        this.aFv.reset();
        if (com.kwai.filedownloader.c.d.dd(this.aFs)) {
            this.aFq.Hf();
            this.aFq = new k(this.aFr.GM(), this);
        } else {
            this.aFq.b(this.aFr.GM(), this);
        }
        c((byte) 0);
    }

    @Override // com.kwai.filedownloader.x.b
    public final void start() {
        if (this.aFs != 10) {
            com.kwai.filedownloader.e.d.h(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.aFs));
            return;
        }
        a.InterfaceC0583a GM = this.aFr.GM();
        com.kwai.filedownloader.a Gy = GM.Gy();
        v Ht = r.Hp().Ht();
        try {
            if (Ht.f(GM)) {
                return;
            }
            synchronized (this.aFm) {
                if (this.aFs != 10) {
                    com.kwai.filedownloader.e.d.h(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.aFs));
                    return;
                }
                c((byte) 11);
                h.GW().b(GM);
                if (com.kwai.filedownloader.e.c.a(Gy.getId(), Gy.getTargetFilePath(), Gy.Gr(), true)) {
                    return;
                }
                boolean a2 = n.Hh().a(Gy.getUrl(), Gy.getPath(), Gy.Gm(), Gy.Gk(), Gy.Gl(), Gy.Gt(), Gy.Gr(), this.aFr.GL(), Gy.Gx());
                if (this.aFs == -2) {
                    com.kwai.filedownloader.e.d.h(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                    if (a2) {
                        n.Hh().cB(getId());
                    }
                } else if (a2) {
                    Ht.e(GM);
                } else if (Ht.f(GM)) {
                } else {
                    MessageSnapshot n = n(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                    if (h.GW().a(GM)) {
                        Ht.e(GM);
                        h.GW().b(GM);
                    }
                    h.GW().a(GM, n);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.GW().a(GM, n(th));
        }
    }
}
