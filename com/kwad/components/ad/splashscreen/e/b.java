package com.kwad.components.ad.splashscreen.e;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.f;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/e/b.class */
public final class b implements com.kwad.sdk.widget.c {
    private a Cv;
    private ViewStub Eg;
    private ViewGroup Eh;
    private View Ei;
    private TextView Ej;
    private boolean Ek;
    private e El;
    private f Em;
    private ViewGroup gv;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    public b(ViewGroup viewGroup, ViewStub viewStub, boolean z, com.kwad.components.core.d.b.c cVar) {
        this.gv = viewGroup;
        this.Eg = viewStub;
        this.mApkDownloadHelper = cVar;
        this.Ek = z;
    }

    private void a(com.kwad.components.ad.splashscreen.d dVar) {
        if (dVar == null) {
            return;
        }
        af(dVar.kq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(String str) {
        TextView textView = this.Ej;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.Ei = viewGroup.findViewById(R.id.ksad_splash_actionbar_native);
        this.Ej = (TextView) viewGroup.findViewById(R.id.ksad_splash_actionbar_text);
        this.Em = new f(this.Ei.getContext(), this.Ei, this);
        this.Ei.getContext();
        a(com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    private void g(boolean z, boolean z2) {
        e eVar = this.El;
        if (eVar != null) {
            eVar.f(z, z2);
        }
    }

    public final void C(AdTemplate adTemplate) {
        a aVar;
        this.mAdTemplate = adTemplate;
        a aVar2 = this.Cv;
        if (aVar2 == null) {
            this.Cv = new a(this.gv.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.e.b.1
                @Override // com.kwad.components.ad.splashscreen.e.a
                protected final void ac(String str) {
                    b.this.af(str);
                }
            };
        } else {
            aVar2.setAdTemplate(adTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        }
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.Cv) == null) {
            return;
        }
        cVar.b(aVar);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        g(true, view.equals(this.Ei));
    }

    public final void a(e eVar) {
        this.El = eVar;
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (this.Ek) {
            g(false, view.equals(this.Ei));
        }
    }

    public final void li() {
        com.kwad.sdk.core.d.b.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.Eg);
        if (this.Eh == null) {
            ViewStub viewStub = this.Eg;
            this.Eh = (ViewGroup) ((viewStub == null || viewStub.getParent() == null) ? this.gv.findViewById(R.id.ksad_splash_actionbar_native_root) : this.Eg.inflate());
            g(this.Eh);
        }
        ViewGroup viewGroup = this.Eh;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void onUnbind() {
        a aVar;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.Cv) == null) {
            return;
        }
        cVar.c(aVar);
    }
}
