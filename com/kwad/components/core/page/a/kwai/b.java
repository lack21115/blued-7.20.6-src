package com.kwad.components.core.page.a.kwai;

import android.content.Context;
import android.view.ViewGroup;
import com.kwad.components.core.page.a.kwai.f;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/kwai/b.class */
public final class b extends com.kwad.sdk.mvp.a {
    public com.kwad.components.core.page.kwai.a LH;
    public KsAdWebView.c LI;
    public f.a LJ;
    public al.b LK;
    public boolean LL = false;
    public boolean LM = false;
    public ViewGroup gv;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;
    public Context mContext;
    public String mPageTitle;
    public String mPageUrl;
    public boolean mShowPermission;
    public com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener;

    private void aD(boolean z) {
        this.LM = true;
    }

    public final void a(f.a aVar) {
        this.LJ = aVar;
    }

    public final void a(al.b bVar) {
        this.LK = bVar;
        aD(true);
    }

    public final void a(KsAdWebView.c cVar) {
        this.LI = cVar;
    }

    public final boolean oa() {
        return this.mShowPermission;
    }

    public final void oe() {
        al.b bVar = this.LK;
        if (bVar != null) {
            bVar.ox();
        }
    }

    public final boolean ok() {
        return this.LM;
    }

    public final boolean ol() {
        return !oa();
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.LI = null;
        this.LJ = null;
        this.mWebCardCloseListener = null;
        this.LK = null;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.c.kwai.b bVar) {
        this.mWebCardCloseListener = bVar;
    }
}
