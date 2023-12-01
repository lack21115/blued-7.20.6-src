package com.kwad.components.core.page.a.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/kwai/e.class */
public final class e extends a {
    private LinearLayout Le;
    private TextView Lf;
    private ImageView Lg;

    private void or() {
        this.Le = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.LG.mPageTitle)) {
            this.Le.setVisibility(8);
            return;
        }
        this.Lf = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.Lg = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.a.kwai.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                e.this.Le.setVisibility(8);
            }
        });
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate);
        boolean bn = com.kwad.sdk.core.response.a.a.bn(cb);
        String bj = com.kwad.sdk.core.response.a.a.bj(cb);
        if (bn) {
            this.Le.setVisibility(0);
            this.Lf.setText(bj);
            this.Lf.setSelected(true);
        } else {
            this.Le.setVisibility(8);
        }
        this.LG.a(os());
    }

    private KsAdWebView.c os() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.a.kwai.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void ot() {
                if (e.this.LG.oa() && e.this.Le.getVisibility() == 0) {
                    e.this.Le.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        or();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
