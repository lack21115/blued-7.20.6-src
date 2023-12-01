package com.kwad.components.ad.f.kwai.kwai;

import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/f/kwai/kwai/b.class */
public final class b implements com.kwad.sdk.core.webview.b.a {
    public static int nO = 1;
    public static int nP = 2;
    private com.kwad.sdk.core.webview.b.c nN;
    private int nQ;
    private int nR;
    private InterfaceC0302b nT;
    private c nS = new c(this, (byte) 0);
    private Runnable nU = null;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/f/kwai/kwai/b$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int nW;
        public int nX;
    }

    /* renamed from: com.kwad.components.ad.f.kwai.kwai.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/f/kwai/kwai/b$b.class */
    public interface InterfaceC0302b {
        void G(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/f/kwai/kwai/b$c.class */
    public final class c implements Runnable {
        private boolean nY;
        private int nZ;

        private c() {
            this.nY = false;
            this.nZ = -1;
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }

        public final void M(int i) {
            this.nZ = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.nY + ", currentTime: " + this.nZ);
            if (this.nY) {
                bi.a(this, null, 1000L);
                return;
            }
            int i = this.nZ;
            if (i < 0) {
                return;
            }
            b.this.L(i);
            this.nZ--;
            bi.a(this, null, 1000L);
        }

        public final void y(boolean z) {
            this.nY = z;
        }
    }

    private b(int i, int i2) {
        this.nQ = i;
        this.nR = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i) {
        com.kwad.sdk.core.d.b.d("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.nN);
        if (i >= 0 && this.nN != null) {
            InterfaceC0302b interfaceC0302b = this.nT;
            if (interfaceC0302b != null && i == 0) {
                interfaceC0302b.G(this.nQ);
            }
            a aVar = new a();
            aVar.nX = i;
            aVar.nW = this.nQ;
            com.kwad.sdk.core.webview.b.c cVar = this.nN;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    private static int g(AdInfo adInfo) {
        int b = com.kwad.components.ad.interstitial.kwai.b.b(adInfo);
        int i = b;
        if (b <= 0) {
            i = 60;
        }
        int i2 = adInfo.adInsertScreenInfo.autoCloseTime;
        int i3 = i;
        if (i2 > 0) {
            i3 = Math.min(i, i2);
        }
        return i3;
    }

    public static b k(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        if (!com.kwad.sdk.core.response.a.a.aU(cb)) {
            if (com.kwad.sdk.core.response.a.a.bv(cb)) {
                return new b(nP, g(cb));
            }
            if (cb.adInsertScreenInfo.autoCloseTime > 0) {
                return new b(nO, cb.adInsertScreenInfo.autoCloseTime);
            }
            return null;
        }
        return null;
    }

    public final void a(InterfaceC0302b interfaceC0302b) {
        this.nT = interfaceC0302b;
    }

    public final void fc() {
        com.kwad.sdk.core.d.b.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.nN);
        if (this.nN == null) {
            this.nU = new Runnable() { // from class: com.kwad.components.ad.f.kwai.kwai.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.fc();
                }
            };
            return;
        }
        this.nS.M(this.nR);
        bi.runOnUiThread(this.nS);
    }

    public final void fd() {
        this.nS.y(true);
    }

    public final void fe() {
        this.nS.y(false);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.nN = cVar;
        Runnable runnable = this.nU;
        if (runnable != null) {
            runnable.run();
            this.nU = null;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.nN = null;
    }
}
