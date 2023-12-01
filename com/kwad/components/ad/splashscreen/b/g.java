package com.kwad.components.ad.splashscreen.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/g.class */
public final class g extends e {
    private static void j(View view, int i) {
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i;
            view.setLayoutParams(layoutParams);
        } else if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.topMargin = i;
            view.setLayoutParams(layoutParams2);
        }
    }

    private void kM() {
        bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.g.1
            @Override // java.lang.Runnable
            public final void run() {
                if (g.this.getActivity() != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) g.this.getActivity().getWindow().getDecorView();
                        if (com.kwad.sdk.c.kwai.a.A(viewGroup) && com.kwad.sdk.c.kwai.a.aw(g.this.getActivity()) == viewGroup.getHeight()) {
                            g.this.kN();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kN() {
        if (this.Cg.Bz == 1 || this.Cg.Bz == 0) {
            j(this.Cg.mRootContainer.findViewById(R.id.ksad_preload_container), kO());
        }
        if (this.Cg.Bz == 0) {
            j(this.Cg.mRootContainer.findViewById(R.id.ksad_splash_logo_container), com.kwad.sdk.c.kwai.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.kwai.a.a(getContext(), 12.0f));
            j(this.Cg.mRootContainer.findViewById(R.id.ksad_splash_sound), com.kwad.sdk.c.kwai.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.kwai.a.a(getContext(), 32.0f));
            j(this.Cg.mRootContainer.findViewById(R.id.ksad_skip_view_area), com.kwad.sdk.c.kwai.a.getStatusBarHeight(getActivity()));
        }
        if (com.kwad.sdk.core.response.a.a.aU(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate))) {
            return;
        }
        if (this.Cg.Bz == 2 || this.Cg.Bz == 3) {
            j(this.Cg.mRootContainer.findViewById(R.id.ksad_compliance_view), com.kwad.sdk.c.kwai.a.getStatusBarHeight(getActivity()));
        }
    }

    private int kO() {
        Activity activity;
        float f;
        if (this.Cg.Bz == 1) {
            activity = getActivity();
            f = 16.0f;
        } else if (this.Cg.Bz != 0) {
            return 0;
        } else {
            activity = getActivity();
            f = 32.0f;
        }
        return com.kwad.sdk.c.kwai.a.a(activity, f) + com.kwad.sdk.c.kwai.a.getStatusBarHeight(getActivity());
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        kM();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
