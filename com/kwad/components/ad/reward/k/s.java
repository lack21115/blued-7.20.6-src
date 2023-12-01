package com.kwad.components.ad.reward.k;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KSCornerButton;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/s.class */
public final class s extends r {
    private int zS;
    private ImageView zT;
    private com.kwad.components.ad.reward.model.a zU;
    private View zV;

    public s(int i) {
        this.zS = i;
        this.zQ = R.layout.ksad_reward_apk_info_card_tag_white_item;
        this.zR = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.ad.reward.k.r
    public final void a(com.kwad.components.ad.reward.model.a aVar) {
        super.a(aVar);
        this.zU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.ad.reward.k.d
    public final void ag(boolean z) {
        super.ag(z);
        if (this.sn == null) {
            return;
        }
        Resources resources = this.sn.getResources();
        if (this.xJ != null && this.zU != null) {
            ViewGroup.LayoutParams layoutParams = this.xJ.getLayoutParams();
            int i = 18;
            if (layoutParams != null) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_play_again_end_icon_size);
                if (!z) {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_play_again_end_icon_size_horizontal);
                    i = 14;
                }
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.xJ.setLayoutParams(layoutParams);
                KSImageLoader.loadAppIcon(this.xJ, this.zU.gm(), this.zU.ha(), i);
            }
        }
        if (this.zN != null && (this.zN.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.zU != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.zN.getLayoutParams();
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_playable_end_desc_margin_top_small);
            int i2 = dimensionPixelSize2;
            if (!this.zU.hd()) {
                i2 = dimensionPixelSize2;
                if (z) {
                    i2 = resources.getDimensionPixelSize(R.dimen.ksad_playable_end_desc_margin_top);
                }
            }
            marginLayoutParams.topMargin = i2;
            this.zN.setLayoutParams(marginLayoutParams);
        }
        View view = this.zV;
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || this.zU == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.zV.getLayoutParams();
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_playable_end_btn_margin_top_small);
        if (z) {
            dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_playable_end_btn_margin_top);
        }
        marginLayoutParams2.topMargin = dimensionPixelSize3;
        this.zV.setLayoutParams(marginLayoutParams2);
    }

    public final void d(AdTemplate adTemplate, boolean z) {
        ImageView imageView = this.zT;
        if (imageView == null || adTemplate == null) {
            return;
        }
        imageView.setVisibility(0);
        com.kwad.components.ad.reward.presenter.b.a(this.zT, com.kwad.sdk.core.response.a.a.O(com.kwad.sdk.core.response.a.d.cb(adTemplate)), adTemplate);
    }

    @Override // com.kwad.components.ad.reward.k.r
    protected final void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_playabale_logo);
        this.xJ = (ImageView) viewGroup.findViewById(R.id.ksad_playabale_end_icon);
        this.yY = (TextView) viewGroup.findViewById(R.id.ksad_playabale_end_title);
        this.xN = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_playable_end_tags);
        this.zN = (TextView) viewGroup.findViewById(R.id.ksad_playabale_end_desc);
        this.zK = (KSCornerButton) viewGroup.findViewById(R.id.ksad_playabale_try);
        this.zL = (KsConvertButton) viewGroup.findViewById(R.id.ksad_playabale_end_btn_action);
        this.zM = viewGroup.findViewById(R.id.ksad_playabale_middle_divider);
        this.zT = (ImageView) viewGroup.findViewById(R.id.ksad_playabale_end_blur_img);
        this.zV = viewGroup.findViewById(R.id.ksad_playabale_end_btn_container);
    }

    @Override // com.kwad.components.ad.reward.k.r
    protected final int jY() {
        return this.zS;
    }

    @Override // com.kwad.components.ad.reward.k.r
    protected final int jZ() {
        return R.id.ksad_playabale_end_card;
    }
}
