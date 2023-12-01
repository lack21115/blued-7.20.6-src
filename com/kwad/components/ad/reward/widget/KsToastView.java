package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/widget/KsToastView.class */
public class KsToastView extends LinearLayout {
    TextView AF;
    private String AG;
    private Runnable AH;
    private int countDown;

    public KsToastView(Context context) {
        super(context);
        this.countDown = 3;
        this.AG = "%ss后自动进入";
        this.AH = null;
        init(context);
    }

    public KsToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 3;
        this.AG = "%ss后自动进入";
        this.AH = null;
        init(context);
    }

    public KsToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 3;
        this.AG = "%ss后自动进入";
        this.AH = null;
        init(context);
    }

    public KsToastView(Context context, boolean z) {
        super(context);
        this.countDown = 3;
        this.AG = "%ss后自动进入";
        this.AH = null;
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i) {
        this.AF.setText(String.format(this.AG, Integer.valueOf(i)));
    }

    static /* synthetic */ int b(KsToastView ksToastView) {
        int i = ksToastView.countDown;
        ksToastView.countDown = i - 1;
        return i;
    }

    private void init(Context context) {
        k.inflate(context, R.layout.ksad_interstitial_toast_layout, this);
        this.AF = (TextView) findViewById(R.id.ksad_total_count_down_text);
    }

    public final void Y(int i) {
        if (this.AH == null) {
            this.AH = new Runnable() { // from class: com.kwad.components.ad.reward.widget.KsToastView.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (KsToastView.this.countDown == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.A(ksToastView.countDown);
                    KsToastView.b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.countDown = 3;
        post(this.AH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.AH);
    }
}
