package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/a/a.class */
public abstract class a extends com.kwad.components.core.widget.b<AdTemplate> {
    private boolean ew;
    protected long ex;
    protected SimpleImageLoadingListener ey;

    public a(Context context) {
        super(context);
        this.ey = new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.a.a.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                com.kwad.components.ad.feed.monitor.a.a(a.this.mAdTemplate, 1, 2, str, null, SystemClock.elapsedRealtime() - a.this.ex);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                com.kwad.components.ad.feed.monitor.a.a(a.this.mAdTemplate, 2, 2, str, failReason.toString(), SystemClock.elapsedRealtime() - a.this.ex);
            }
        };
    }

    public final void bi() {
        if (this.ew) {
            return;
        }
        this.ew = true;
        com.kwad.components.ad.feed.monitor.a.a(this.mAdTemplate, 1, getStayTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bj() {
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        if (!com.kwad.sdk.core.response.a.a.aH(this.mAdInfo)) {
            complianceTextView.setVisibility(8);
            return;
        }
        complianceTextView.setVisibility(0);
        complianceTextView.setAdTemplate(this.mAdTemplate);
    }
}
