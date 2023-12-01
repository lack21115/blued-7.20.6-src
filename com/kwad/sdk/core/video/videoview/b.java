package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/videoview/b.class */
public abstract class b extends RelativeLayout {
    private Runnable QH;
    protected final c anr;

    public b(Context context, c cVar) {
        super(context);
        this.anr = cVar;
    }

    public void m(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onPlayStateChanged(int i);

    protected abstract void qc();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void qi() {
        qj();
        if (this.QH == null) {
            this.QH = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.qc();
                    if (b.this.QH != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.QH, 1000L);
                    }
                }
            };
        }
        post(this.QH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void qj() {
        Runnable runnable = this.QH;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.QH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void reset();
}
