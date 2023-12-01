package com.kwad.components.core.page.a.kwai;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.a.a;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/kwai/f.class */
public final class f extends com.kwad.components.core.page.a.kwai.a {
    private boolean Md;
    private com.kwad.components.core.a.a mTitleBarHelper;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/kwai/f$a.class */
    public interface a {
        void az(int i);
    }

    private String getTitle() {
        return !TextUtils.isEmpty(this.LG.mPageTitle) ? this.LG.mPageTitle : (this.LG.mAdTemplate.adInfoList == null || this.LG.mAdTemplate.adInfoList.size() <= 0 || this.LG.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bK(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate));
    }

    private boolean ou() {
        return TextUtils.isEmpty(this.LG.mPageTitle);
    }

    private void ov() {
        com.kwad.components.core.a.a aVar = new com.kwad.components.core.a.a(this.LG.gv);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.a.b(getTitle()));
        this.mTitleBarHelper.am(ou());
        this.mTitleBarHelper.a(new a.InterfaceC0509a() { // from class: com.kwad.components.core.page.a.kwai.f.1
            @Override // com.kwad.components.core.a.a.InterfaceC0509a
            public final void t(View view) {
                f.this.w(view);
            }

            @Override // com.kwad.components.core.a.a.InterfaceC0509a
            public final void u(View view) {
                f.this.x(view);
            }
        });
        ViewGroup gK = this.mTitleBarHelper.gK();
        int i = 0;
        if (!this.LG.mAdTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.a.b.cJ(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate))) {
            i = 8;
        }
        gK.setVisibility(i);
        this.LG.a(new a() { // from class: com.kwad.components.core.page.a.kwai.f.2
            @Override // com.kwad.components.core.page.a.kwai.f.a
            public final void az(int i2) {
                f.this.mTitleBarHelper.gK().setVisibility(i2 == 1 ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(View view) {
        if (this.LG.mAdWebView == null || !this.LG.mAdWebView.canGoBack()) {
            if (this.LG.LH != null) {
                this.LG.LH.dK();
                return;
            }
            return;
        }
        this.LG.mAdWebView.goBack();
        if (this.Md) {
            com.kwad.sdk.core.report.a.aw(this.LG.mAdTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view) {
        if (this.LG.mAdWebView == null || !this.LG.mAdWebView.canGoBack()) {
            if (this.LG.LH != null) {
                this.LG.LH.dL();
                return;
            }
            return;
        }
        this.LG.mAdWebView.goBack();
        if (this.Md) {
            com.kwad.sdk.core.report.a.aw(this.LG.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Md = TextUtils.equals(this.LG.mPageUrl, com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate)));
        ov();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
