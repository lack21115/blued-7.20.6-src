package com.kwai.filedownloader.services;

import com.kwai.filedownloader.y;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/services/g.class */
public final class g implements y {
    private final com.kwai.filedownloader.a.a aJe;
    private final h aJf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        com.kwai.filedownloader.download.b HF = com.kwai.filedownloader.download.b.HF();
        this.aJe = HF.HH();
        this.aJf = new h(HF.HI());
    }

    private boolean dg(int i) {
        return a(this.aJe.cI(i));
    }

    public final void IT() {
        List<Integer> IW = this.aJf.IW();
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "pause all tasks %d", Integer.valueOf(IW.size()));
        }
        for (Integer num : IW) {
            cB(num.intValue());
        }
    }

    public final void Il() {
        this.aJe.clear();
    }

    @Override // com.kwai.filedownloader.y
    public final boolean a(com.kwai.filedownloader.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean di = this.aJf.di(cVar.getId());
        if (com.kwai.filedownloader.c.d.dd(cVar.Gq())) {
            return di;
        } else if (di) {
            return true;
        } else {
            com.kwai.filedownloader.e.d.e(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.Gq()));
            return false;
        }
    }

    public final boolean ao(String str, String str2) {
        return dg(com.kwai.filedownloader.e.f.aq(str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x027c A[Catch: all -> 0x02d3, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0002, B:7:0x000f, B:9:0x0029, B:13:0x0046, B:15:0x0063, B:17:0x006f, B:19:0x0075, B:21:0x0090, B:22:0x009f, B:24:0x00ab, B:26:0x00b1, B:32:0x00cb, B:35:0x00df, B:37:0x00ea, B:39:0x00f0, B:45:0x010a, B:48:0x0119, B:51:0x012c, B:53:0x0139, B:55:0x013f, B:57:0x015b, B:63:0x017a, B:65:0x0184, B:67:0x018d, B:69:0x0196, B:71:0x01a0, B:74:0x01ab, B:76:0x01b3, B:79:0x01e7, B:82:0x01f3, B:84:0x01fc, B:97:0x027c, B:98:0x0287, B:98:0x0287, B:99:0x028a, B:86:0x021d, B:88:0x0229, B:92:0x023f, B:94:0x024a, B:49:0x0123, B:33:0x00d5), top: B:112:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.String r8, java.lang.String r9, boolean r10, int r11, int r12, int r13, boolean r14, com.kwai.filedownloader.c.b r15, boolean r16) {
        /*
            Method dump skipped, instructions count: 756
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.services.g.b(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.kwai.filedownloader.c.b, boolean):void");
    }

    public final boolean cB(int i) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "request pause the task %d", Integer.valueOf(i));
        }
        com.kwai.filedownloader.c.c cI = this.aJe.cI(i);
        if (cI == null) {
            return false;
        }
        cI.e((byte) -2);
        this.aJf.cancel(i);
        return true;
    }

    public final byte cC(int i) {
        com.kwai.filedownloader.c.c cI = this.aJe.cI(i);
        if (cI == null) {
            return (byte) 0;
        }
        return cI.Gq();
    }

    public final boolean cD(int i) {
        if (i == 0) {
            com.kwai.filedownloader.e.d.h(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        } else if (dg(i)) {
            com.kwai.filedownloader.e.d.h(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        } else {
            this.aJe.cL(i);
            this.aJe.cK(i);
            return true;
        }
    }

    public final boolean cV(int i) {
        boolean cV;
        synchronized (this) {
            cV = this.aJf.cV(i);
        }
        return cV;
    }

    public final long cX(int i) {
        com.kwai.filedownloader.c.c cI = this.aJe.cI(i);
        if (cI == null) {
            return 0L;
        }
        return cI.getTotal();
    }

    public final long dh(int i) {
        com.kwai.filedownloader.c.c cI = this.aJe.cI(i);
        if (cI == null) {
            return 0L;
        }
        int ID = cI.ID();
        if (ID <= 1) {
            return cI.IB();
        }
        List<com.kwai.filedownloader.c.a> cJ = this.aJe.cJ(i);
        if (cJ == null || cJ.size() != ID) {
            return 0L;
        }
        return com.kwai.filedownloader.c.a.H(cJ);
    }

    public final boolean isIdle() {
        return this.aJf.IV() <= 0;
    }

    @Override // com.kwai.filedownloader.y
    public final int r(String str, int i) {
        return this.aJf.r(str, i);
    }
}
