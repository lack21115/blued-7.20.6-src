package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.ao;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/g.class */
public final class g {
    private final c anK;
    private volatile e anP;
    private final b anR;
    private final String url;
    private final AtomicInteger anO = new AtomicInteger(0);
    private final List<b> anQ = new CopyOnWriteArrayList();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/g$a.class */
    static final class a extends Handler implements b {
        private final List<b> anQ;
        private final String url;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.anQ = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public final void a(File file, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            for (b bVar : this.anQ) {
                bVar.a((File) message.obj, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.url = ao.eK(str);
        this.anK = (c) ao.checkNotNull(cVar);
        this.anR = new a(str, this.anQ);
    }

    private void yB() {
        synchronized (this) {
            this.anP = this.anP == null ? yD() : this.anP;
        }
    }

    private void yC() {
        synchronized (this) {
            if (this.anO.decrementAndGet() <= 0) {
                this.anP.shutdown();
                this.anP = null;
            }
        }
    }

    private e yD() {
        e eVar = new e(new h(this.url, this.anK.anw, this.anK.anx), new com.kwad.sdk.core.videocache.kwai.b(this.anK.cP(this.url), this.anK.anv));
        eVar.a(this.anR);
        return eVar;
    }

    public final void a(d dVar, Socket socket) {
        yB();
        try {
            this.anO.incrementAndGet();
            this.anP.a(dVar, socket);
        } finally {
            yC();
        }
    }

    public final void shutdown() {
        this.anQ.clear();
        e eVar = this.anP;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.anP = null;
        this.anO.set(0);
    }

    public final int yy() {
        return this.anO.get();
    }
}
