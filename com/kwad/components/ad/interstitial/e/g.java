package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import com.kwad.sdk.utils.ai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/e/g.class */
public final class g extends FrameLayout {
    protected h hO;
    protected boolean ij;
    protected Context mContext;
    private boolean my;

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.ij = ai.DL();
    }

    private void eH() {
        boolean DL = ai.DL();
        if (!this.my || DL == this.ij) {
            return;
        }
        this.ij = DL;
        h hVar = this.hO;
        if (hVar != null) {
            hVar.j(!DL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        eH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.my = i == 0;
        eH();
    }

    public final void setOrientationChangeListener(h hVar) {
        this.hO = hVar;
    }
}
