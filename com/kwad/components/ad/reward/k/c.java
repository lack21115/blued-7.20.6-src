package com.kwad.components.ad.reward.k;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSRatingBar;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/c.class */
public final class c extends com.kwad.sdk.core.download.kwai.a implements com.kwad.sdk.widget.c {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private View xE;
    private View xF;
    private Button xG;
    private Button xH;
    private TextView xI;
    private ImageView xJ;
    private TextView xK;
    private TextView xL;
    private KSRatingBar xM;
    private KsAppTagsView xN;
    private a xO;
    private volatile boolean xP = false;
    private com.kwad.components.ad.g.a xQ;
    private Runnable xR;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/c$a.class */
    public interface a {
        void c(boolean z, int i);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/c$b.class */
    static final class b {
        private String appName;
        private String qh;
        private String qi;
        private float xT;
        private List<String> xU;
        private int xV = 15;
        private String xW;

        b() {
        }

        public static b z(AdTemplate adTemplate) {
            String str;
            if (adTemplate == null) {
                return null;
            }
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            b bVar = new b();
            bVar.appName = com.kwad.sdk.core.response.a.d.p(adTemplate) ? com.kwad.sdk.core.response.a.a.ap(cb) : com.kwad.sdk.core.response.a.a.ao(cb);
            bVar.xT = com.kwad.sdk.core.response.a.a.au(cb);
            bVar.qi = com.kwad.sdk.core.response.a.a.an(cb);
            bVar.qh = com.kwad.sdk.core.response.a.d.p(adTemplate) ? com.kwad.sdk.core.response.a.a.cn(cb) : com.kwad.sdk.core.response.a.a.bM(cb);
            if (com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
                bVar.xV = com.kwad.components.ad.reward.kwai.b.gy();
                str = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.xV = com.kwad.sdk.core.config.d.uA();
                str = "浏览详情页%s秒，领取奖励";
            }
            bVar.xW = str;
            bVar.xU = com.kwad.sdk.core.response.a.c.bS(adTemplate);
            return bVar;
        }

        public final String jK() {
            return String.format(this.xW, Integer.valueOf(this.xV));
        }
    }

    public c(View view) {
        this.xE = view;
        initView();
        this.xQ = new com.kwad.components.ad.g.a(view);
    }

    private void c(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_install_container || id == R.id.ksad_reward_apk_info_install_action || id == R.id.ksad_reward_apk_info_install_start) {
            com.kwad.sdk.core.d.b.d("ApkInfoCardViewHelper", "onClick install");
            this.xP = true;
            a aVar = this.xO;
            if (aVar != null) {
                aVar.c(z, 1);
            }
        }
    }

    private void initView() {
        this.xG = (Button) this.xE.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.xH = (Button) this.xE.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.xF = this.xE.findViewById(R.id.ksad_reward_apk_info_install_container);
        this.xJ = (ImageView) this.xE.findViewById(R.id.ksad_reward_apk_info_icon);
        this.xI = (TextView) this.xE.findViewById(R.id.ksad_reward_apk_info_name);
        this.xK = (TextView) this.xE.findViewById(R.id.ksad_reward_apk_info_desc);
        this.xM = (KSRatingBar) this.xE.findViewById(R.id.ksad_reward_apk_info_score);
        this.xN = (KsAppTagsView) this.xE.findViewById(R.id.ksad_reward_apk_info_tags);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        c(view, true);
    }

    public final void a(a aVar) {
        this.xO = aVar;
    }

    public final void a(com.kwad.components.core.d.b.c cVar) {
        this.mApkDownloadHelper = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            c(view, false);
        }
    }

    public final void c(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        b z2 = b.z(adTemplate);
        if (z2 == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.xJ, z2.qh, adTemplate, 12);
        this.xI.setText(z2.appName);
        this.xK.setText(z2.qi);
        this.xM.setStar(z2.xT);
        if (com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
            this.xH.setText(com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
            this.xM.setVisibility(0);
        } else {
            this.xH.setText("查看详情");
            this.xM.setVisibility(8);
        }
        this.xG.setText(z2.jK());
        this.xG.setClickable(true);
        this.xH.setClickable(true);
        this.xF.setClickable(true);
        new com.kwad.sdk.widget.f(this.xG, this);
        new com.kwad.sdk.widget.f(this.xH, this);
        new com.kwad.sdk.widget.f(this.xF, this);
        List<String> list = z2.xU;
        if (z && list.size() == 0) {
            this.xK.setVisibility(8);
            TextView textView = (TextView) this.xE.findViewById(R.id.ksad_reward_apk_info_desc_2);
            this.xL = textView;
            textView.setVisibility(0);
            this.xL.setText(z2.qi);
        }
        if (list.size() == 0) {
            this.xN.setVisibility(8);
        }
        this.xN.setAppTags(list);
        if (this.xR == null) {
            this.xR = new Runnable() { // from class: com.kwad.components.ad.reward.k.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    int height = c.this.xF.getHeight();
                    com.kwad.sdk.core.d.b.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + height);
                    if (c.this.xP) {
                        return;
                    }
                    c.this.xQ.lB();
                }
            };
        }
        this.xF.postDelayed(this.xR, 1600L);
    }

    public final void j(String str, int i) {
        Button button = this.xH;
        if (button == null || str == null || i == 0) {
            return;
        }
        button.setText(str);
    }

    public final void jI() {
        Runnable runnable;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.g.a aVar = this.xQ;
        if (aVar != null) {
            aVar.jI();
        }
        View view = this.xF;
        if (view == null || (runnable = this.xR) == null) {
            return;
        }
        view.removeCallbacks(runnable);
        this.xR = null;
    }

    public final void jJ() {
        this.xQ.lD();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.xH.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.xH.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.aH(adTemplate));
    }

    @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.xH.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.xH.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.T(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void onPaused(int i) {
        super.onPaused(i);
        if (i != 0) {
            this.xQ.lD();
            this.xH.setText(com.kwad.sdk.core.response.a.a.bz(i));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        if (i != 0) {
            this.xQ.lD();
            this.xH.setText(com.kwad.sdk.core.response.a.a.by(i));
        }
    }
}
