package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/h.class */
public final class h {
    private final ArrayList<a.InterfaceC0583a> aFG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/h$a.class */
    public static final class a {
        private static final h aFH = new h((byte) 0);
    }

    private h() {
        this.aFG = new ArrayList<>();
    }

    /* synthetic */ h(byte b) {
        this();
    }

    public static h GW() {
        return a.aFH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void E(List<a.InterfaceC0583a> list) {
        synchronized (this.aFG) {
            Iterator<a.InterfaceC0583a> it = this.aFG.iterator();
            while (it.hasNext()) {
                a.InterfaceC0583a next = it.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.aFG.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(a.InterfaceC0583a interfaceC0583a) {
        return this.aFG.isEmpty() || !this.aFG.contains(interfaceC0583a);
    }

    public final boolean a(a.InterfaceC0583a interfaceC0583a, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte Gq = messageSnapshot.Gq();
        synchronized (this.aFG) {
            remove = this.aFG.remove(interfaceC0583a);
        }
        if (com.kwai.filedownloader.e.d.aJq && this.aFG.size() == 0) {
            com.kwai.filedownloader.e.d.i(this, "remove %s left %d %d", interfaceC0583a, Byte.valueOf(Gq), Integer.valueOf(this.aFG.size()));
        }
        if (!remove) {
            com.kwai.filedownloader.e.d.e(this, "remove error, not exist: %s %d", interfaceC0583a, Byte.valueOf(Gq));
            return remove;
        }
        t GO = interfaceC0583a.Gz().GO();
        if (Gq == -4) {
            GO.l(messageSnapshot);
            return remove;
        } else if (Gq == -3) {
            GO.j(com.kwai.filedownloader.message.f.t(messageSnapshot));
            return remove;
        } else if (Gq == -2) {
            GO.n(messageSnapshot);
            return remove;
        } else if (Gq != -1) {
            return remove;
        } else {
            GO.m(messageSnapshot);
            return remove;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(a.InterfaceC0583a interfaceC0583a) {
        if (!interfaceC0583a.Gy().Gj()) {
            interfaceC0583a.GB();
        }
        if (interfaceC0583a.Gz().GO().Hb()) {
            c(interfaceC0583a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(a.InterfaceC0583a interfaceC0583a) {
        if (interfaceC0583a.GC()) {
            return;
        }
        synchronized (this.aFG) {
            if (this.aFG.contains(interfaceC0583a)) {
                com.kwai.filedownloader.e.d.h(this, "already has %s", interfaceC0583a);
            } else {
                interfaceC0583a.GD();
                this.aFG.add(interfaceC0583a);
                if (com.kwai.filedownloader.e.d.aJq) {
                    com.kwai.filedownloader.e.d.i(this, "add list in all %s %d %d", interfaceC0583a, Byte.valueOf(interfaceC0583a.Gy().Gq()), Integer.valueOf(this.aFG.size()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int cx(int i) {
        int i2;
        synchronized (this.aFG) {
            Iterator<a.InterfaceC0583a> it = this.aFG.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().cw(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<a.InterfaceC0583a> cy(int i) {
        byte Gq;
        ArrayList arrayList = new ArrayList();
        synchronized (this.aFG) {
            Iterator<a.InterfaceC0583a> it = this.aFG.iterator();
            while (it.hasNext()) {
                a.InterfaceC0583a next = it.next();
                if (next.cw(i) && !next.isOver() && (Gq = next.Gy().Gq()) != 0 && Gq != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<a.InterfaceC0583a> cz(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aFG) {
            Iterator<a.InterfaceC0583a> it = this.aFG.iterator();
            while (it.hasNext()) {
                a.InterfaceC0583a next = it.next();
                if (next.cw(i) && !next.isOver()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int size() {
        return this.aFG.size();
    }
}
