package com.kwad.components.ad.reward.k;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/i.class */
public final class i extends d implements View.OnClickListener {
    private AdTemplate adTemplate;
    private TextView he;
    private KSCornerImageView lO;
    private TextView lP;
    private TextView lQ;
    private k.a pW;
    private ViewGroup sn;
    private View uK;
    private TextView yA;
    private View yB;
    private View yC;
    private DialogFragment yz;

    public i(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, k.a aVar) {
        this.yz = dialogFragment;
        this.adTemplate = adTemplate;
        this.pW = aVar;
        this.sn = (ViewGroup) layoutInflater.inflate(R.layout.ksad_reward_jinniu_dialog, viewGroup, false);
        initView();
    }

    private void initView() {
        this.lO = (KSCornerImageView) this.sn.findViewById(R.id.ksad_reward_jinniu_dialog_icon);
        this.he = (TextView) this.sn.findViewById(R.id.ksad_reward_jinniu_dialog_title);
        this.lP = (TextView) this.sn.findViewById(R.id.ksad_reward_jinniu_dialog_desc);
        this.yA = (TextView) this.sn.findViewById(R.id.ksad_reward_jinniu_dialog_play_time_tips);
        this.lQ = (TextView) this.sn.findViewById(R.id.ksad_reward_jinniu_dialog_detail);
        this.uK = this.sn.findViewById(R.id.ksad_reward_jinniu_dialog_btn_close);
        this.yB = this.sn.findViewById(R.id.ksad_reward_jinniu_dialog_btn_deny);
        this.yC = this.sn.findViewById(R.id.ksad_reward_jinniu_dialog_btn_continue);
        this.uK.setOnClickListener(this);
        this.yB.setOnClickListener(this);
        this.yC.setOnClickListener(this);
        this.lO.setOnClickListener(this);
        this.he.setOnClickListener(this);
        this.lP.setOnClickListener(this);
        this.lQ.setOnClickListener(this);
    }

    public final void a(k.c cVar) {
        KSImageLoader.loadAppIcon(this.lO, cVar.gm(), this.adTemplate, 4);
        this.he.setText(cVar.getTitle());
        this.lP.setText(cVar.gn());
        this.yA.setText(cVar.gp());
        if (com.kwad.sdk.core.response.a.a.aI(this.adTemplate)) {
            this.lQ.setText(String.format("%s >", com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(this.adTemplate))));
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup gK() {
        return this.sn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k.a aVar;
        Tracker.onClick(view);
        if (view.equals(this.uK)) {
            this.yz.dismiss();
            k.a aVar2 = this.pW;
            if (aVar2 != null) {
                aVar2.gh();
            }
        } else if (view.equals(this.yB)) {
            this.yz.dismiss();
            k.a aVar3 = this.pW;
            if (aVar3 != null) {
                aVar3.J(false);
            }
        } else if (view.equals(this.yC)) {
            this.yz.dismiss();
            k.a aVar4 = this.pW;
            if (aVar4 != null) {
                aVar4.gh();
            }
        } else if (view.equals(this.lO)) {
            k.a aVar5 = this.pW;
            if (aVar5 != null) {
                aVar5.g(127, 2);
            }
        } else if (view.equals(this.he)) {
            k.a aVar6 = this.pW;
            if (aVar6 != null) {
                aVar6.g(128, 2);
            }
        } else if (view.equals(this.lP)) {
            k.a aVar7 = this.pW;
            if (aVar7 != null) {
                aVar7.g(129, 2);
            }
        } else if (!view.equals(this.lQ) || (aVar = this.pW) == null) {
        } else {
            aVar.g(131, 2);
        }
    }
}
