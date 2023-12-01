package com.kwad.components.core.d.a;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import com.kwad.components.core.d.a.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.j.k;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/a/a.class */
public final class a extends KSFrameLayout {
    private final b Iv;
    private final b.C0518b Iw;
    private d Ix;
    private InterfaceC0517a Iy;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private Presenter mPresenter;
    private final AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/a/a$a.class */
    public interface InterfaceC0517a {
        void mE();
    }

    public a(Context context, b bVar, b.C0518b c0518b) {
        super(context);
        this.mContext = context;
        this.Iv = bVar;
        this.Iw = c0518b;
        this.mAdTemplate = c0518b.adTemplate;
        k.inflate(context, R.layout.ksad_download_dialog_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        a(adBaseFrameLayout, "rootView is null");
        a((KsAdWebView) this.mRootContainer.findViewById(R.id.ksad_download_tips_web_card_webView), "webView is null");
    }

    private void a(View view, String str) {
        if (view != null) {
            return;
        }
        throw new RuntimeException("inflateView fail " + str + "\n--viewCount:" + getChildCount() + "\n--context:" + this.mContext.getClass().getName() + "\n--LayoutInflater context: " + LayoutInflater.from(this.mContext).getContext().getClass().getName() + "\n--classloader:" + getClass().getClassLoader().getClass().getName());
    }

    private static Presenter an() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        return presenter;
    }

    private d mD() {
        d dVar = new d();
        dVar.Iv = this.Iv;
        dVar.Iw = this.Iw;
        dVar.mAdTemplate = this.mAdTemplate;
        dVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            dVar.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InterfaceC0517a interfaceC0517a = this.Iy;
        if (interfaceC0517a != null) {
            interfaceC0517a.mE();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        this.Ix = mD();
        Presenter an = an();
        this.mPresenter = an;
        an.E(this.mRootContainer);
        this.mPresenter.f(this.Ix);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        d dVar = this.Ix;
        if (dVar != null) {
            dVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void setChangeListener(InterfaceC0517a interfaceC0517a) {
        this.Iy = interfaceC0517a;
    }
}
