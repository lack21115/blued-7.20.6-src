package com.kwad.components.ad.reward;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k.class */
public final class k extends com.kwad.components.core.l.g {
    private static String pX = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    private static String pY = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;
    private a pW;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k$a.class */
    public interface a extends com.kwad.components.core.webview.a.d.c {
        void g(int i, int i2);

        void gf();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k$b.class */
    public static class b implements a {
        @Override // com.kwad.components.core.webview.a.d.c
        public void J(boolean z) {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public void fZ() {
        }

        @Override // com.kwad.components.ad.reward.k.a
        public void g(int i, int i2) {
        }

        @Override // com.kwad.components.ad.reward.k.a
        public void gf() {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public void gg() {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public void gh() {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k$c.class */
    public static class c extends com.kwad.sdk.core.response.kwai.a {
        public com.kwad.components.ad.reward.i.a.a pw;
        public com.kwad.components.ad.reward.i.kwai.a px;
        public String qd;
        public String qe;
        public String qf;
        public String qg;
        public String qh;
        public String qi;
        public String qj;
        public String qk;
        public int style;
        public String title;

        private c() {
        }

        static c N(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.qd = "关闭广告";
            cVar.qe = "继续观看";
            return cVar;
        }

        public static c O(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.qd = "奖励不要了";
            cVar.qe = "返回";
            return cVar;
        }

        public static c P(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
                return cVar;
            } catch (JSONException e) {
                return cVar;
            }
        }

        private void Q(String str) {
            this.qk = str;
        }

        static c a(com.kwad.components.ad.reward.i.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.pw = aVar;
            cVar.qg = str;
            cVar.qh = com.kwad.sdk.core.response.a.a.bM(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        static c a(com.kwad.components.ad.reward.i.kwai.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.px = aVar;
            cVar.qg = str;
            cVar.qh = com.kwad.sdk.core.response.a.a.bM(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        public static c a(AdInfo adInfo, long j) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(adInfo);
            cVar.qi = com.kwad.sdk.core.response.a.a.an(adInfo);
            String name = ct.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.a.a.ap(adInfo);
            }
            cVar.qh = ct.getIcon();
            cVar.Q(j > 0 ? String.valueOf(j) : null);
            return cVar;
        }

        static c a(AdTemplate adTemplate, long j) {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.qh = com.kwad.sdk.core.response.a.a.bM(cb);
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.qi = com.kwad.sdk.core.response.a.a.bK(cb);
            cVar.qj = com.kwad.sdk.core.response.a.a.an(cb);
            cVar.qd = "放弃奖励";
            cVar.qe = "继续观看";
            cVar.qf = com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        static c b(AdTemplate adTemplate, long j) {
            AdMatrixInfo.MerchantLiveReservationInfo bI = com.kwad.sdk.core.response.a.b.bI(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.qh = bI.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.qi = bI.title;
            cVar.qd = "放弃奖励";
            cVar.qe = "继续观看";
            cVar.qf = com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            return cVar;
        }

        static c i(long j) {
            c cVar = new c();
            cVar.style = 6;
            cVar.qd = "残忍离开";
            cVar.qe = "留下看看";
            cVar.Q(j > 0 ? String.valueOf(j) : null);
            return cVar;
        }

        static c i(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(adInfo);
            cVar.title = com.kwad.sdk.core.response.a.a.an(adInfo);
            cVar.qh = ct.getIcon();
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (optJSONObject != null) {
                if (this.pw == null) {
                    this.pw = new com.kwad.components.ad.reward.i.a.a();
                }
                this.pw.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (optJSONObject2 != null) {
                if (this.px == null) {
                    this.px = new com.kwad.components.ad.reward.i.kwai.a();
                }
                this.px.parseJson(optJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.i.a.a aVar = this.pw;
            if (aVar != null) {
                t.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.i.kwai.a aVar2 = this.px;
            if (aVar2 != null) {
                t.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gi() {
            return TextUtils.isEmpty(this.qd) ? "关闭广告" : this.qd;
        }

        public final String gj() {
            return TextUtils.isEmpty(this.qe) ? "继续观看" : this.qe;
        }

        public final com.kwad.components.ad.reward.i.a.a gk() {
            return this.pw;
        }

        public final com.kwad.components.ad.reward.i.kwai.a gl() {
            return this.px;
        }

        public final String gm() {
            return this.qh;
        }

        public final String gn() {
            return this.qi;
        }

        public final String go() {
            return this.qj;
        }

        public final String gp() {
            return TextUtils.isEmpty(this.qk) ? "" : String.format("再看%s秒，可获得优惠", this.qk);
        }
    }

    public static c M(String str) {
        return c.O(str);
    }

    private static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_title)).setText(cVar.getTitle());
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(cVar.gi());
        textView2.setText(cVar.gj());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                DialogFragment.this.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.J(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                DialogFragment.this.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gh();
                }
            }
        });
        return inflate;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gk(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View a(com.kwad.components.ad.reward.i.a aVar, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar2) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.i.a.a) {
            com.kwad.components.ad.reward.i.a.a.a((com.kwad.components.ad.reward.i.a.a) aVar, inflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) inflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.jk(), cVar.qg);
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.ksad_reward_task_dialog_icon), cVar.gm(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_title);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.jl());
        String sb2 = sb.toString();
        String str = cVar.qg;
        boolean equals = "0".equals(str);
        String format = equals ? String.format(pX, sb2) : String.format(pY, str);
        int indexOf = equals ? format.indexOf(sb2) : format.indexOf(str);
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            int i = equals ? indexOf + 1 : str.length() > 1 ? indexOf + 3 : indexOf + 2;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, i, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                DialogFragment.this.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.J(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                DialogFragment.this.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.gh();
                }
            }
        });
        return inflate;
    }

    private View a(final k kVar, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_play_time_tips)).setText(f(inflate.getContext(), cVar.qk));
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(cVar.gi());
        textView2.setText(cVar.gj());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                kVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.J(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                kVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gh();
                }
            }
        });
        return inflate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x003e, code lost:
        if (com.kwad.sdk.core.response.a.d.p(r0) != false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.kwad.components.ad.reward.k.c a(com.kwad.components.ad.reward.j r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.k.a(com.kwad.components.ad.reward.j, java.lang.String):com.kwad.components.ad.reward.k$c");
    }

    public static k a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        k kVar = new k();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        kVar.setArguments(bundle);
        kVar.a(aVar);
        kVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return kVar;
    }

    private void a(a aVar) {
        this.pW = aVar;
    }

    private static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gl(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.ksad_reward_order_dialog_icon), cVar.qh, adTemplate);
        ((TextView) inflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(cVar.getTitle());
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                DialogFragment.this.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gh();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.gf();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.k.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                DialogFragment.this.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.J(false);
                }
            }
        });
        return inflate;
    }

    private static SpannableString f(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.c.kwai.a.getColor(context, R.color.ksad_reward_main_color));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.c.kwai.a.getColor(context, R.color.ksad_reward_main_color));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    @Override // com.kwad.components.core.l.g
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ViewGroup a2;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable th) {
        }
        c P = c.P(string);
        int style = P.getStyle();
        if (style == 1) {
            a2 = a(this, layoutInflater, viewGroup, P, this.mAdTemplate, this.pW);
        } else if (style == 2) {
            a2 = b(this, layoutInflater, viewGroup, P, this.mAdTemplate, this.pW);
        } else if (style == 4) {
            a2 = c(this, layoutInflater, viewGroup, P, this.mAdTemplate, this.pW);
            com.kwad.components.core.r.g.a(new com.kwad.components.core.widget.e(), (ViewGroup) a2);
        } else if (style == 5) {
            com.kwad.components.ad.reward.k.i iVar = new com.kwad.components.ad.reward.k.i(this, this.mAdTemplate, layoutInflater, viewGroup, this.pW);
            iVar.a(P);
            a2 = iVar.gK();
        } else if (style == 6) {
            a2 = a(this, layoutInflater, viewGroup, P, this.pW);
        } else if (style != 8) {
            a2 = a((DialogFragment) this, layoutInflater, viewGroup, P, this.pW);
        } else {
            com.kwad.components.ad.reward.k.l lVar = new com.kwad.components.ad.reward.k.l(this, this.mAdTemplate, layoutInflater, viewGroup, this.pW);
            lVar.a(P);
            a2 = lVar.gK();
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.k.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return a2;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a aVar = this.pW;
        if (aVar != null) {
            aVar.fZ();
        }
    }
}
