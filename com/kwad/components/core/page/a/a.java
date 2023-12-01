package com.kwad.components.core.page.a;

import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/a.class */
public final class a extends Presenter {
    private int Lv;
    private FeedVideoView Lw;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        final com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) Bh();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.Lw = feedVideoView;
        feedVideoView.bindView(eVar.adTemplate);
        this.Lw.a(build, eVar.IM);
        this.Lw.setVisibility(0);
        final AdInfo cb = com.kwad.sdk.core.response.a.d.cb(eVar.adTemplate);
        this.Lw.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (com.kwad.sdk.core.response.a.a.ax(cb)) {
                    if (eVar.IM != null) {
                        com.kwad.components.core.d.b.a.a(new a.C0349a(a.this.getActivity()).ao(false).ap(false).at(true).I(eVar.adTemplate).ar(false));
                        com.kwad.sdk.core.report.a.a(eVar.adTemplate, 50, a.this.Lw.getTouchCoords());
                    }
                } else if (eVar.MS == null || eVar.MS.getAdapter() == null || eVar.MS.getAdapter().getItemCount() <= 1) {
                } else {
                    eVar.MS.scrollToPosition(1);
                    com.kwad.sdk.core.report.a.a(eVar.adTemplate, 50, a.this.Lw.getTouchCoords());
                }
            }
        });
        if (com.kwad.sdk.core.response.a.a.ah(cb)) {
            this.Lw.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.a.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    if (com.kwad.sdk.core.response.a.a.ax(cb)) {
                        if (eVar.IM != null) {
                            com.kwad.components.core.d.b.a.a(new a.C0349a(a.this.getActivity()).ao(false).ap(false).at(true).I(eVar.adTemplate).ar(false));
                            com.kwad.sdk.core.report.a.a(eVar.adTemplate, 171, a.this.Lw.getTouchCoords());
                        }
                    } else if (eVar.MS == null || eVar.MS.getAdapter() == null || eVar.MS.getAdapter().getItemCount() <= 1) {
                    } else {
                        eVar.MS.scrollToPosition(1);
                        com.kwad.sdk.core.report.a.a(eVar.adTemplate, 171, a.this.Lw.getTouchCoords());
                    }
                }
            });
        }
        this.Lw.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.a.a.3
            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void oh() {
                if (eVar.MS != null) {
                    a.this.Lv = eVar.MS.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void oi() {
                if (eVar.MS != null) {
                    eVar.MS.scrollToPosition(a.this.Lv);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Lw.release();
    }
}
