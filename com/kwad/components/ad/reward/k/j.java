package com.kwad.components.ad.reward.k;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/j.class */
public final class j extends d implements com.kwad.sdk.widget.c {
    private TextView he;
    private KSCornerImageView lO;
    private TextView lP;
    private com.kwad.components.ad.reward.j qt;
    private ViewStub yD;
    private ViewGroup yE;
    private KsStyledTextButton yF;
    private KsStyledTextButton yG;
    private KsPriceView yf;
    private TextView yi;
    private TextView yj;
    private View yk;

    public j(com.kwad.components.ad.reward.j jVar, ViewGroup viewGroup) {
        this.yE = viewGroup;
        this.qt = jVar;
    }

    public j(com.kwad.components.ad.reward.j jVar, ViewStub viewStub) {
        this.yD = viewStub;
        this.qt = jVar;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        int i = 8;
        KSImageLoader.loadAppIcon(this.lO, aVar.gm(), adTemplate, 8);
        this.he.setText(aVar.getTitle());
        this.lP.setText(aVar.gn());
        int dimensionPixelSize = this.yE.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
        this.yf.getConfig().aj(dimensionPixelSize).al(dimensionPixelSize).ak(this.yE.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
        this.yf.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String gY = aVar.gY();
        View view = this.yk;
        if (!TextUtils.isEmpty(gY)) {
            i = 0;
        }
        view.setVisibility(i);
        if (gY != null) {
            this.yi.setText(gY);
        }
        this.yj.setText(aVar.gZ());
    }

    private void d(View view, boolean z) {
        int i = 153;
        if (view.equals(this.yG)) {
            com.kwad.components.ad.reward.j jVar = this.qt;
            Context context = view.getContext();
            if (z) {
                i = 38;
            }
            jVar.a(2, context, i, 1);
        } else if (view.equals(this.yF)) {
            com.kwad.components.ad.reward.j jVar2 = this.qt;
            Context context2 = view.getContext();
            if (z) {
                i = 37;
            }
            jVar2.a(2, context2, i, 1);
        } else if (view.equals(this.yE)) {
            com.kwad.components.ad.reward.j jVar3 = this.qt;
            Context context3 = view.getContext();
            if (z) {
                i = 2;
            }
            jVar3.a(2, context3, i, 2);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        d(view, true);
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        a(vVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.t(vVar.getAdTemplate()));
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.qt.mAdTemplate)) {
            d(view, false);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup gK() {
        return this.yE;
    }

    public final void hide() {
        ViewGroup viewGroup = this.yE;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}
