package com.kwad.components.ad.reward.k;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/l.class */
public final class l extends d implements View.OnClickListener {
    private ImageView fp;
    private TextView he;
    private k.a pW;
    private View yC;
    private ViewGroup yR;
    private View yS;
    private TextView yT;
    private TextView yU;
    private TextView yV;
    private View yW;
    private DialogFragment yz;

    public l(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, k.a aVar) {
        this.yz = dialogFragment;
        this.pW = aVar;
        if (com.kwad.sdk.core.response.a.a.cq(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            this.yR = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_origin_dialog, viewGroup, false);
            s(true);
            return;
        }
        this.yR = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_subscribe_dialog, viewGroup, false);
        s(false);
    }

    private void s(boolean z) {
        this.yS = this.yR.findViewById(R.id.ksad_live_subscribe_dialog_btn_close);
        this.he = (TextView) this.yR.findViewById(R.id.ksad_live_subscribe_dialog_title);
        this.fp = (ImageView) this.yR.findViewById(R.id.ksad_live_subscribe_dialog_icon);
        this.yU = (TextView) this.yR.findViewById(R.id.ksad_live_subscribe_dialog_content_txt);
        this.yT = (TextView) this.yR.findViewById(R.id.ksad_live_subscribe_dialog_content);
        this.yC = this.yR.findViewById(R.id.ksad_live_subscribe_dialog_btn_continue);
        this.yW = this.yR.findViewById(R.id.ksad_live_subscribe_dialog_btn_deny);
        this.yV = (TextView) this.yR.findViewById(R.id.ksad_live_subscribe_dialog_vide_detail);
        if (z) {
            this.yS.setVisibility(8);
        }
        this.yS.setOnClickListener(this);
        this.yC.setOnClickListener(this);
        this.yW.setOnClickListener(this);
        this.yV.setOnClickListener(this);
    }

    public final void a(k.c cVar) {
        KSImageLoader.loadCircleIcon(this.fp, cVar.gm(), this.yR.getContext().getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        String title = cVar.getTitle();
        if (this.he != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = gK().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.he.setText(spannableString);
        }
        this.yT.setText(cVar.gn());
        this.yU.setText(cVar.go());
        this.yV.setText(String.format("%s", cVar.qf));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup gK() {
        return this.yR;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k.a aVar;
        Tracker.onClick(view);
        if (view.equals(this.yS)) {
            this.yz.dismiss();
            k.a aVar2 = this.pW;
            if (aVar2 != null) {
                aVar2.gh();
            }
        } else if (view.equals(this.yC)) {
            this.yz.dismiss();
            k.a aVar3 = this.pW;
            if (aVar3 != null) {
                aVar3.gh();
            }
        } else if (!view.equals(this.yW)) {
            if (!view.equals(this.yV) || (aVar = this.pW) == null) {
                return;
            }
            aVar.g(131, 2);
        } else {
            this.yz.dismiss();
            k.a aVar4 = this.pW;
            if (aVar4 != null) {
                aVar4.J(false);
            }
        }
    }
}
