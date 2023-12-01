package com.huawei.openalliance.ad.media;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gr;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.bc;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/media/d.class */
public class d implements IMultiMediaPlayingManager {
    private static final String Code = d.class.getSimpleName();
    private static final byte[] I = new byte[0];
    private static d V;
    private b B;
    private Context S;
    private final byte[] Z = new byte[0];
    private Queue<a> C = new ConcurrentLinkedQueue();
    private gr F = new gr() { // from class: com.huawei.openalliance.ad.media.d.1
        private void Code() {
            synchronized (d.this.Z) {
                if (ge.Code()) {
                    ge.Code(d.Code, "checkAndPlayNext current player: %s", d.this.B);
                }
                if (d.this.B == null) {
                    d.this.V();
                }
            }
        }

        @Override // com.huawei.hms.ads.gr
        public void Code(int i, int i2) {
        }

        @Override // com.huawei.hms.ads.gr
        public void Code(b bVar, int i) {
        }

        @Override // com.huawei.hms.ads.gr
        public void I(b bVar, int i) {
            if (ge.Code()) {
                ge.Code(d.Code, "onMediaStop: %s", bVar);
            }
            Code();
        }

        @Override // com.huawei.hms.ads.gr
        public void V(b bVar, int i) {
            if (ge.Code()) {
                ge.Code(d.Code, "onMediaPause: %s", bVar);
            }
            Code();
        }

        @Override // com.huawei.hms.ads.gr
        public void Z(b bVar, int i) {
            if (ge.Code()) {
                ge.Code(d.Code, "onMediaCompletion: %s", bVar);
            }
            d.this.V();
        }
    };
    private go D = new go() { // from class: com.huawei.openalliance.ad.media.d.2
        @Override // com.huawei.hms.ads.go
        public void Code(b bVar, int i, int i2, int i3) {
            if (ge.Code()) {
                ge.Code(d.Code, "onError: %s", bVar);
            }
            synchronized (d.this.Z) {
                bVar.V(this);
            }
            d.this.V();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/media/d$a.class */
    public static class a {
        final String Code;
        final b V;

        a(String str, b bVar) {
            this.Code = str;
            this.V = bVar;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj != null) {
                if (!(obj instanceof a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                a aVar = (a) obj;
                z = false;
                if (TextUtils.equals(this.Code, aVar.Code)) {
                    z = false;
                    if (this.V == aVar.V) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            String str = this.Code;
            int i = -1;
            int hashCode = str != null ? str.hashCode() : -1;
            b bVar = this.V;
            if (bVar != null) {
                i = bVar.hashCode();
            }
            return hashCode & super.hashCode() & i;
        }

        public String toString() {
            return "Task [" + bc.Code(this.Code) + "]";
        }
    }

    private d(Context context) {
        this.S = context.getApplicationContext();
    }

    public static d Code(Context context) {
        d dVar;
        synchronized (I) {
            if (V == null) {
                V = new d(context);
            }
            dVar = V;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (ai.I(this.S)) {
            synchronized (this.Z) {
                a poll = this.C.poll();
                if (ge.Code()) {
                    ge.Code(Code, "playNextTask - task: %s currentPlayer: %s", poll, this.B);
                }
                if (poll != null) {
                    if (ge.Code()) {
                        ge.Code(Code, "playNextTask - play: %s", poll.V);
                    }
                    poll.V.Code(this.F);
                    poll.V.Code(this.D);
                    poll.V.Code(poll.Code);
                    this.B = poll.V;
                } else {
                    this.B = null;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Code(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.Z) {
            if (bVar == this.B) {
                V(this.B);
                this.B = null;
            }
            Iterator<a> it = this.C.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.V == bVar) {
                    V(next.V);
                    it.remove();
                }
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Code(String str, b bVar) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        synchronized (this.Z) {
            if (ge.Code()) {
                ge.Code(Code, "autoPlay - url: %s player: %s", bc.Code(str), bVar);
            }
            if (bVar != this.B && this.B != null) {
                a aVar = new a(str, bVar);
                this.C.remove(aVar);
                this.C.add(aVar);
                str2 = Code;
                str3 = "autoPlay - add to queue";
                ge.V(str2, str3);
            }
            bVar.Code(this.F);
            bVar.Code(this.D);
            bVar.Code(str);
            this.B = bVar;
            str2 = Code;
            str3 = "autoPlay - play directly";
            ge.V(str2, str3);
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void I(String str, b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        synchronized (this.Z) {
            if (ge.Code()) {
                ge.Code(Code, "stop - url: %s player: %s", bc.Code(str), bVar);
            }
            if (bVar == this.B) {
                ge.V(Code, "stop current");
                this.B = null;
                bVar.V(str);
            } else {
                ge.V(Code, "stop - remove from queue");
                this.C.remove(new a(str, bVar));
                V(bVar);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void V(b bVar) {
        synchronized (this.Z) {
            if (bVar != null) {
                bVar.V(this.F);
                bVar.V(this.D);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void V(String str, b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        synchronized (this.Z) {
            if (ge.Code()) {
                ge.Code(Code, "manualPlay - url: %s player: %s", bc.Code(str), bVar);
            }
            if (this.B != null && bVar != this.B) {
                this.B.I();
                ge.V(Code, "manualPlay - stop other");
            }
            ge.V(Code, "manualPlay - play new");
            bVar.Code(this.F);
            bVar.Code(this.D);
            bVar.Code(str);
            this.B = bVar;
            this.C.remove(new a(str, bVar));
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Z(String str, b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        synchronized (this.Z) {
            if (ge.Code()) {
                ge.Code(Code, "pause - url: %s player: %s", bc.Code(str), bVar);
            }
            if (bVar == this.B) {
                ge.V(Code, "pause current");
                bVar.I(str);
            } else {
                ge.V(Code, "pause - remove from queue");
                this.C.remove(new a(str, bVar));
                V(bVar);
            }
        }
    }
}
