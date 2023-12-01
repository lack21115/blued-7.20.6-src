package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/k.class */
final class k implements t {
    private a.InterfaceC0413a aFR;
    private a.c aFS;
    private Queue<MessageSnapshot> aFT;
    private boolean aFU = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a.InterfaceC0413a interfaceC0413a, a.c cVar) {
        a(interfaceC0413a, cVar);
    }

    private void a(a.InterfaceC0413a interfaceC0413a, a.c cVar) {
        this.aFR = interfaceC0413a;
        this.aFS = cVar;
        this.aFT = new LinkedBlockingQueue();
    }

    private void cA(int i) {
        if (com.kwai.filedownloader.c.d.dd(i)) {
            if (!this.aFT.isEmpty()) {
                MessageSnapshot peek = this.aFT.peek();
                com.kwai.filedownloader.e.d.h(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.getId()), Integer.valueOf(this.aFT.size()), Byte.valueOf(peek.Gq()));
            }
            this.aFR = null;
        }
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "notify completed %s", this.aFR);
        }
        this.aFS.GH();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0413a interfaceC0413a = this.aFR;
        if (interfaceC0413a == null) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Gq()));
            }
        } else if (!this.aFU && interfaceC0413a.Gy().Gn() != null) {
            this.aFT.offer(messageSnapshot);
            j.GY().a(this);
        } else {
            if ((l.isValid() || this.aFR.GF()) && messageSnapshot.Gq() == 4) {
                this.aFS.GH();
            }
            cA(messageSnapshot.Gq());
        }
    }

    @Override // com.kwai.filedownloader.t
    public final boolean Hb() {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "notify begin %s", this.aFR);
        }
        if (this.aFR == null) {
            com.kwai.filedownloader.e.d.h(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.aFT.size()));
            return false;
        }
        this.aFS.onBegin();
        return true;
    }

    @Override // com.kwai.filedownloader.t
    public final void Hc() {
        if (this.aFU) {
            return;
        }
        MessageSnapshot poll = this.aFT.poll();
        byte Gq = poll.Gq();
        a.InterfaceC0413a interfaceC0413a = this.aFR;
        if (interfaceC0413a == null) {
            return;
        }
        a Gy = interfaceC0413a.Gy();
        i Gn = Gy.Gn();
        x.a Gz = interfaceC0413a.Gz();
        cA(Gq);
        if (Gn == null) {
            return;
        }
        if (Gq == 4) {
            try {
                Gn.b(Gy);
                o(((com.kwai.filedownloader.message.a) poll).In());
                return;
            } catch (Throwable th) {
                m(Gz.n(th));
                return;
            }
        }
        g gVar = null;
        if (Gn instanceof g) {
            gVar = (g) Gn;
        }
        if (Gq == -4) {
            Gn.d(Gy);
        } else if (Gq == -3) {
            Gn.c(Gy);
        } else if (Gq == -2) {
            if (gVar == null) {
                Gn.c(Gy, poll.Io(), poll.Ip());
                return;
            }
            poll.Is();
            poll.Iq();
        } else if (Gq == -1) {
            Gn.a(Gy, poll.It());
        } else if (Gq == 1) {
            if (gVar == null) {
                Gn.a(Gy, poll.Io(), poll.Ip());
                return;
            }
            poll.Is();
            poll.Iq();
        } else if (Gq == 2) {
            if (gVar == null) {
                Gn.a(Gy, poll.getEtag(), poll.Ig(), Gy.getSmallFileSoFarBytes(), poll.Ip());
                return;
            }
            poll.getEtag();
            poll.Ig();
            poll.Iq();
        } else if (Gq == 3) {
            if (gVar != null) {
                poll.Is();
            } else {
                Gn.b(Gy, poll.Io(), Gy.getSmallFileTotalBytes());
            }
        } else if (Gq != 5) {
            if (Gq != 6) {
                return;
            }
            Gn.a(Gy);
        } else {
            poll.It();
            poll.Gu();
            if (gVar != null) {
                poll.Is();
            } else {
                poll.Io();
            }
        }
    }

    @Override // com.kwai.filedownloader.t
    public final boolean Hd() {
        return this.aFR.Gy().Gv();
    }

    @Override // com.kwai.filedownloader.t
    public final boolean He() {
        return this.aFT.peek().Gq() == 4;
    }

    @Override // com.kwai.filedownloader.t
    public final void Hf() {
        this.aFU = true;
    }

    @Override // com.kwai.filedownloader.t
    public final void b(a.InterfaceC0413a interfaceC0413a, a.c cVar) {
        if (this.aFR != null) {
            throw new IllegalStateException(com.kwai.filedownloader.e.f.j("the messenger is working, can't re-appointment for %s", interfaceC0413a));
        }
        a(interfaceC0413a, cVar);
    }

    @Override // com.kwai.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "notify pending %s", this.aFR);
        }
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "notify started %s", this.aFR);
        }
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "notify connected %s", this.aFR);
        }
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a Gy = this.aFR.Gy();
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "notify progress %s %d %d", Gy, Long.valueOf(Gy.Go()), Long.valueOf(Gy.Gp()));
        }
        if (Gy.Gk() > 0) {
            p(messageSnapshot);
        } else if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "notify progress but client not request notify %s", this.aFR);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "notify block completed %s %s", this.aFR, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aJq) {
            a Gy = this.aFR.Gy();
            com.kwai.filedownloader.e.d.g(this, "notify retry %s %d %d %s", this.aFR, Integer.valueOf(Gy.Gt()), Integer.valueOf(Gy.Gu()), Gy.Gs());
        }
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "notify warn %s", this.aFR);
        }
        this.aFS.GH();
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aJq) {
            a.InterfaceC0413a interfaceC0413a = this.aFR;
            com.kwai.filedownloader.e.d.g(this, "notify error %s %s", interfaceC0413a, interfaceC0413a.Gy().Gs());
        }
        this.aFS.GH();
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "notify paused %s", this.aFR);
        }
        this.aFS.GH();
        p(messageSnapshot);
    }

    public final String toString() {
        a.InterfaceC0413a interfaceC0413a = this.aFR;
        return com.kwai.filedownloader.e.f.j("%d:%s", Integer.valueOf(interfaceC0413a == null ? -1 : interfaceC0413a.Gy().getId()), super.toString());
    }
}
