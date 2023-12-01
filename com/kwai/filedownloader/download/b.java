package com.kwai.filedownloader.download;

import com.kwai.filedownloader.e.c;
import com.kwai.filedownloader.kwai.c;
import com.kwai.filedownloader.services.c;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/b.class */
public final class b {
    private com.kwai.filedownloader.services.c aGW;
    private c.a aGX;
    private c.b aGY;
    private c.e aGZ;
    private volatile com.kwai.filedownloader.a.a aHa;
    private c.d aHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/b$a.class */
    public static final class a {
        private static final b aHc = new b();
    }

    public static b HF() {
        return a.aHc;
    }

    private c.a HK() {
        c.a aVar = this.aGX;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.aGX == null) {
                this.aGX = HM().IJ();
            }
        }
        return this.aGX;
    }

    private c.e HL() {
        c.e eVar = this.aGZ;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.aGZ == null) {
                this.aGZ = HM().IH();
            }
        }
        return this.aGZ;
    }

    private com.kwai.filedownloader.services.c HM() {
        com.kwai.filedownloader.services.c cVar = this.aGW;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.aGW == null) {
                this.aGW = new com.kwai.filedownloader.services.c();
            }
        }
        return this.aGW;
    }

    private c.b T() {
        c.b bVar = this.aGY;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.aGY == null) {
                this.aGY = HM().II();
            }
        }
        return this.aGY;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0254  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.kwai.filedownloader.a.a.InterfaceC0584a r10) {
        /*
            Method dump skipped, instructions count: 666
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.b.a(com.kwai.filedownloader.a.a$a):void");
    }

    public final c.d HG() {
        c.d dVar = this.aHb;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.aHb == null) {
                this.aHb = HM().IK();
            }
        }
        return this.aHb;
    }

    public final com.kwai.filedownloader.a.a HH() {
        synchronized (this) {
            if (this.aHa != null) {
                return this.aHa;
            }
            this.aHa = HM().IG();
            a(this.aHa.Hx());
            return this.aHa;
        }
    }

    public final int HI() {
        return HM().HI();
    }

    public final boolean HJ() {
        HL();
        return true;
    }

    public final int a(int i, String str, String str2, long j) {
        return HK().ak(j);
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.aGW = new com.kwai.filedownloader.services.c(bVar);
            this.aGY = null;
            this.aGZ = null;
            this.aHa = null;
            this.aHb = null;
        }
    }

    public final com.kwai.filedownloader.d.a ab(File file) {
        return HL().ac(file);
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.aGW = new com.kwai.filedownloader.services.c(bVar);
        }
    }

    public final com.kwai.filedownloader.kwai.b fp(String str) {
        try {
            return T().q(str);
        } catch (Throwable th) {
            c.b bVar = new c.b();
            this.aGY = bVar;
            return bVar.q(str);
        }
    }
}
