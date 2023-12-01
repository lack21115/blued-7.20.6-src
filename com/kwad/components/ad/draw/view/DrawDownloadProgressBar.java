package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.c.kwai.a;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/view/DrawDownloadProgressBar.class */
public class DrawDownloadProgressBar extends FrameLayout {
    private TextProgressBar dm;
    private View dn;
    private Context mContext;

    public DrawDownloadProgressBar(Context context) {
        super(context);
        D(context);
    }

    public DrawDownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public DrawDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        D(context);
    }

    private void D(Context context) {
        this.mContext = context;
        k.inflate(context, R.layout.ksad_draw_download_bar, this);
        this.dm = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        View findViewById = findViewById(R.id.ksad_download_progress_cover);
        this.dn = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public final void f(String str, int i) {
        View view;
        int i2;
        if (i == 0 || i == getMax()) {
            view = this.dn;
            i2 = 0;
        } else {
            view = this.dn;
            i2 = 8;
        }
        view.setVisibility(i2);
        this.dm.f(str, i);
    }

    public int getMax() {
        return this.dm.getMax();
    }

    public void setTextColor(int i) {
        this.dm.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.dm.setTextDimen(a.a(getContext(), i));
    }
}
