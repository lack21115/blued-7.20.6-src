package com.kwai.filedownloader.message;

import com.kwai.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/g.class */
public final class g {
    private final e.b aIx;
    private final List<a> aIz = new ArrayList();

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/g$a.class */
    public final class a {
        private final List<Integer> aIA = new ArrayList();
        private final Executor aIB;

        public a(int i) {
            this.aIB = com.kwai.filedownloader.e.b.n(1, "Flow-" + i);
        }

        public final void cZ(int i) {
            this.aIA.add(Integer.valueOf(i));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.aIB.execute(new Runnable() { // from class: com.kwai.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.aIx.r(messageSnapshot);
                    try {
                        a.this.aIA.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i, e.b bVar) {
        this.aIx = bVar;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 5) {
                return;
            }
            this.aIz.add(new a(i3));
            i2 = i3 + 1;
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar;
        a aVar2;
        a aVar3 = null;
        try {
            synchronized (this.aIz) {
                int id = messageSnapshot.getId();
                Iterator<a> it = this.aIz.iterator();
                do {
                    aVar = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    aVar = it.next();
                } while (!aVar.aIA.contains(Integer.valueOf(id)));
                aVar2 = aVar;
                if (aVar == null) {
                    int i = 0;
                    Iterator<a> it2 = this.aIz.iterator();
                    while (true) {
                        aVar2 = aVar;
                        if (!it2.hasNext()) {
                            break;
                        }
                        a aVar4 = aVar;
                        aVar2 = it2.next();
                        a aVar5 = aVar;
                        if (aVar2.aIA.size() <= 0) {
                            break;
                        } else if (i == 0 || aVar2.aIA.size() < i) {
                            a aVar6 = aVar;
                            i = aVar2.aIA.size();
                            aVar = aVar2;
                        }
                    }
                }
                if (aVar2 != null) {
                    aVar2.cZ(id);
                }
                aVar3 = aVar2;
            }
            if (aVar2 != null) {
                aVar2.u(messageSnapshot);
            }
        } catch (Throwable th) {
            if (aVar3 != null) {
                aVar3.u(messageSnapshot);
            }
            throw th;
        }
    }
}
