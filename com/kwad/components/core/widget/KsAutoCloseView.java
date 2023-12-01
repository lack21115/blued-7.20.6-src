package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/KsAutoCloseView.class */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    private static String AG = "%s秒后自动关闭";
    private TextView WO;
    private ImageView WP;
    private a WQ;
    private boolean WR;
    private boolean WS;
    private int countDown;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/KsAutoCloseView$a.class */
    public interface a {
        void dO();

        void dP();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.WR = true;
        this.WS = false;
        Q(context);
    }

    public KsAutoCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.WR = true;
        this.WS = false;
        Q(context);
    }

    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 10;
        this.WR = true;
        this.WS = false;
        Q(context);
    }

    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.countDown = 10;
        this.WR = true;
        this.WS = false;
        Q(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i) {
        this.WO.setText(String.format(AG, Integer.valueOf(i)));
    }

    private void Q(Context context) {
        k.inflate(context, R.layout.ksad_auto_close, this);
        this.WO = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.WP = imageView;
        imageView.setOnClickListener(this);
    }

    static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i - 1;
        return i;
    }

    public final void Y(int i) {
        if (i <= 0) {
            return;
        }
        this.countDown = i;
        post(new Runnable() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (KsAutoCloseView.this.WR) {
                    if (!KsAutoCloseView.this.WS) {
                        if (KsAutoCloseView.this.countDown == 0) {
                            if (KsAutoCloseView.this.WQ != null) {
                                KsAutoCloseView.this.WQ.dO();
                                return;
                            }
                            return;
                        }
                        KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                        ksAutoCloseView.A(ksAutoCloseView.countDown);
                        KsAutoCloseView.e(KsAutoCloseView.this);
                    }
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                }
            }
        });
    }

    public final void aS(boolean z) {
        this.WR = z;
        int i = z ? 0 : 8;
        TextView textView = this.WO;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (this.WQ != null && view.equals(this.WP)) {
            this.WQ.dP();
        }
    }

    public void setCountDownPaused(boolean z) {
        this.WS = z;
    }

    public void setViewListener(a aVar) {
        this.WQ = aVar;
    }
}
