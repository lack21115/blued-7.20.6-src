package com.kwai.filedownloader.services;

import com.kwai.filedownloader.d.b;
import com.kwai.filedownloader.e.c;
import com.kwai.filedownloader.kwai.c;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/services/c.class */
public final class c {
    private final b aIT;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/services/c$a.class */
    public interface a {
        c.b T();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/services/c$b.class */
    public static final class b {
        c.InterfaceC0589c aIU;
        Integer aIV;
        c.e aIW;
        c.b aIX;
        a aIY;
        c.a aIZ;
        c.d aJa;

        public final b a(c.b bVar) {
            this.aIX = bVar;
            return this;
        }

        public final b a(a aVar) {
            this.aIY = aVar;
            return this;
        }

        public final b df(int i) {
            this.aIV = Integer.MAX_VALUE;
            return this;
        }

        public final String toString() {
            return com.kwai.filedownloader.e.f.j("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.aIU, this.aIV, this.aIW, this.aIX, this.aIZ);
        }
    }

    public c() {
        this.aIT = null;
    }

    public c(b bVar) {
        this.aIT = bVar;
    }

    private static c.d IL() {
        return new com.kwai.filedownloader.services.b();
    }

    private static int IM() {
        return com.kwai.filedownloader.e.e.Jb().aJv;
    }

    private static com.kwai.filedownloader.a.a IN() {
        return new com.kwai.filedownloader.a.c();
    }

    private static c.e IO() {
        return new b.a();
    }

    private static c.b IP() {
        return new c.b();
    }

    private static c.a IQ() {
        return new com.kwai.filedownloader.kwai.a();
    }

    public final int HI() {
        Integer num;
        b bVar = this.aIT;
        if (bVar != null && (num = bVar.aIV) != null) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwai.filedownloader.e.e.dj(num.intValue());
        }
        return IM();
    }

    public final com.kwai.filedownloader.a.a IG() {
        b bVar = this.aIT;
        if (bVar == null || bVar.aIU == null) {
            return IN();
        }
        com.kwai.filedownloader.a.a Ja = this.aIT.aIU.Ja();
        if (Ja != null) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "initial FileDownloader manager with the customize database: %s", Ja);
            }
            return Ja;
        }
        return IN();
    }

    public final c.e IH() {
        c.e eVar;
        b bVar = this.aIT;
        if (bVar != null && (eVar = bVar.aIW) != null) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return IO();
    }

    public final c.b II() {
        c.b T;
        b bVar = this.aIT;
        if (bVar == null) {
            return IP();
        }
        a aVar = bVar.aIY;
        return (aVar == null || (T = aVar.T()) == null) ? IP() : T;
    }

    public final c.a IJ() {
        c.a aVar;
        b bVar = this.aIT;
        if (bVar != null && (aVar = bVar.aIZ) != null) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return IQ();
    }

    public final c.d IK() {
        c.d dVar;
        b bVar = this.aIT;
        if (bVar != null && (dVar = bVar.aJa) != null) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return IL();
    }
}
