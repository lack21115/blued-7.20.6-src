package com.kwad.components.ad.reward.k;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KSCornerButton;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/r.class */
public class r extends w implements View.OnClickListener {
    protected KsLogoView mLogoView;
    protected ImageView xJ;
    protected KsAppTagsView xN;
    protected TextView yY;
    protected KSCornerButton zK;
    protected KsConvertButton zL;
    protected View zM;
    protected TextView zN;
    protected TextView zO;
    protected a zP;
    protected int zQ = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean zR = true;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/r$a.class */
    public interface a {
        void hV();

        void hW();

        void hX();

        void hY();
    }

    private void X(int i) {
        KSCornerButton kSCornerButton = this.zK;
        if (kSCornerButton == null || this.zL == null) {
            return;
        }
        if (i == 1) {
            kSCornerButton.getCornerConf().setAllCorner(true);
            this.zL.getCornerConf().setAllCorner(true);
            this.zM.setVisibility(0);
        } else if (i == 2) {
            kSCornerButton.getCornerConf().bK(true).bN(true).bM(false).bL(false);
            this.zL.getCornerConf().bK(false).bN(false).bM(true).bL(true);
            this.zM.setVisibility(8);
        }
        this.zK.postInvalidate();
        this.zL.postInvalidate();
    }

    public final void a(a aVar) {
        this.zP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        a(com.kwad.components.ad.reward.model.a.a(vVar, this.zR));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.kwad.components.ad.reward.model.a aVar) {
        TextView textView;
        int i;
        int i2;
        int i3;
        if (aVar == null || this.zK == null) {
            return;
        }
        X(aVar.he());
        this.mLogoView.S(aVar.ha());
        this.yY.setText(aVar.getTitle());
        this.zN.setText(aVar.gn());
        TextView textView2 = this.zO;
        if (textView2 != null) {
            textView2.setText(aVar.gn());
            if (TextUtils.isEmpty(aVar.gn())) {
                i2 = 8;
            } else if (aVar.hd()) {
                i3 = 8;
                i = 0;
                this.zN.setVisibility(i3);
                textView = this.zO;
            } else {
                i2 = 0;
            }
            i3 = i2;
            i = 8;
            this.zN.setVisibility(i3);
            textView = this.zO;
        } else {
            textView = this.zN;
            i = TextUtils.isEmpty(aVar.gn()) ? 8 : 0;
        }
        textView.setVisibility(i);
        KsAppTagsView ksAppTagsView = this.xN;
        if (ksAppTagsView != null) {
            ksAppTagsView.a(aVar.hc(), this.zQ);
            KsAppTagsView ksAppTagsView2 = this.xN;
            int i4 = 0;
            if (aVar.hd()) {
                i4 = 8;
            }
            ksAppTagsView2.setVisibility(i4);
        }
        this.zL.a(aVar.hb(), aVar.ha());
        KSImageLoader.loadAppIcon(this.xJ, aVar.gm(), aVar.ha(), 12);
    }

    public final void e(ViewGroup viewGroup) {
        super.a(viewGroup, jY(), jZ());
        g(this.sn);
        if (this.sn != null) {
            this.sn.setOnClickListener(this);
            this.zK.setOnClickListener(this);
            this.zL.setOnClickListener(this);
        }
    }

    protected void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_reward_playable_logo);
        this.xJ = (ImageView) viewGroup.findViewById(R.id.ksad_reward_playable_icon);
        this.yY = (TextView) viewGroup.findViewById(R.id.ksad_reward_playable_name);
        this.xN = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_reward_playable_tags);
        this.zN = (TextView) viewGroup.findViewById(R.id.ksad_reward_playable_desc);
        this.zO = (TextView) viewGroup.findViewById(R.id.ksad_reward_playable_desc2);
        this.zK = (KSCornerButton) viewGroup.findViewById(R.id.ksad_reward_playable_install_try);
        this.zL = (KsConvertButton) viewGroup.findViewById(R.id.ksad_reward_playable_action);
        this.zM = viewGroup.findViewById(R.id.ksad_reward_playable_middle_divider);
    }

    protected int jY() {
        return R.id.ksad_reward_playable_card_stub;
    }

    protected int jZ() {
        return R.id.ksad_reward_playable_card_root;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Tracker.onClick(view);
        if (view.equals(this.zK)) {
            a aVar2 = this.zP;
            if (aVar2 != null) {
                aVar2.hW();
            }
        } else if (view.equals(this.zL)) {
            a aVar3 = this.zP;
            if (aVar3 != null) {
                aVar3.hX();
            }
        } else if (!view.equals(this.sn) || (aVar = this.zP) == null) {
        } else {
            aVar.hY();
        }
    }

    public final void show() {
        if (this.sn != null) {
            this.sn.setVisibility(0);
            a aVar = this.zP;
            if (aVar != null) {
                aVar.hV();
            }
        }
    }
}
