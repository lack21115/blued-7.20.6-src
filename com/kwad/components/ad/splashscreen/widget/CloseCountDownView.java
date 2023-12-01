package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/widget/CloseCountDownView.class */
public class CloseCountDownView extends LinearLayout {
    private a DM;
    private int EA;
    private TextView EB;
    private TextView ED;
    private ImageView EE;
    private Runnable EF;
    private String Ez;
    private boolean nY;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/widget/CloseCountDownView$a.class */
    public interface a {
        void dP();

        void kJ();
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.Ez = "%ss";
        this.EA = 5;
        this.nY = false;
        this.EF = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.EA <= 0) {
                    if (CloseCountDownView.this.DM != null) {
                        CloseCountDownView.this.DM.kJ();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EA);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        X(context);
    }

    public CloseCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ez = "%ss";
        this.EA = 5;
        this.nY = false;
        this.EF = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.EA <= 0) {
                    if (CloseCountDownView.this.DM != null) {
                        CloseCountDownView.this.DM.kJ();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EA);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        X(context);
    }

    public CloseCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ez = "%ss";
        this.EA = 5;
        this.nY = false;
        this.EF = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.EA <= 0) {
                    if (CloseCountDownView.this.DM != null) {
                        CloseCountDownView.this.DM.kJ();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EA);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        X(context);
    }

    public CloseCountDownView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Ez = "%ss";
        this.EA = 5;
        this.nY = false;
        this.EF = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.EA <= 0) {
                    if (CloseCountDownView.this.DM != null) {
                        CloseCountDownView.this.DM.kJ();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EA);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        X(context);
    }

    private void X(Context context) {
        setOrientation(0);
        k.inflate(context, R.layout.ksad_endcard_close_view, this);
        this.EB = (TextView) findViewById(R.id.ksad_ad_endcard_second);
        this.ED = (TextView) findViewById(R.id.ksad_ad_endcard_line);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_splash_endcard_close_img);
        this.EE = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (CloseCountDownView.this.DM != null) {
                    CloseCountDownView.this.DM.dP();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(int i) {
        this.EB.setText(String.format(this.Ez, Integer.valueOf(i)));
    }

    static /* synthetic */ int d(CloseCountDownView closeCountDownView) {
        int i = closeCountDownView.EA;
        closeCountDownView.EA = i - 1;
        return i;
    }

    private void fc() {
        post(this.EF);
    }

    private void fd() {
        this.nY = true;
    }

    private void fe() {
        this.nY = false;
    }

    public final void a(AdInfo adInfo) {
        Context context;
        float f;
        boolean bR = com.kwad.sdk.core.response.a.a.bR(adInfo);
        this.EA = com.kwad.sdk.core.response.a.a.bQ(adInfo);
        if (bR) {
            this.EB.setVisibility(0);
            this.ED.setVisibility(0);
            ag(this.EA);
            context = getContext();
            f = 12.0f;
        } else {
            context = getContext();
            f = 4.0f;
        }
        setPadding(com.kwad.sdk.c.kwai.a.a(context, f), 0, com.kwad.sdk.c.kwai.a.a(getContext(), f), 0);
        fc();
    }

    public final void bn() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public final void onPageInvisible() {
        fd();
    }

    public final void onPageVisible() {
        fe();
    }

    public void setOnViewClickListener(a aVar) {
        this.DM = aVar;
    }
}
