package com.kwad.components.ad.splashscreen.b.kwai;

import android.view.View;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bb;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/kwai/b.class */
public final class b extends com.kwad.components.ad.splashscreen.b.e implements View.OnClickListener {
    private TextView DB;
    private TextView DC;
    private TextView DD;
    private TextView DE;
    private AdInfo.DownloadSafeInfo DF;

    private void initView() {
        this.DB = (TextView) findViewById(R.id.ksad_ad_endcard_appversion);
        this.DC = (TextView) findViewById(R.id.ksad_ad_permission_text);
        this.DD = (TextView) findViewById(R.id.ksad_ad_privacy_text);
        this.DE = (TextView) findViewById(R.id.ksad_ad_developer_text);
    }

    private void ll() {
        if (com.kwad.sdk.core.response.a.a.aH(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate))) {
            StringBuilder sb = new StringBuilder();
            String str = this.DF.appVersion;
            if (bb.eO(str)) {
                sb.append("版本号：");
                sb.append(str);
                sb.append("  |  ");
            }
            long j = this.DF.packageSize;
            if (j > 0) {
                sb.append("应用大小：");
                sb.append(com.kwad.components.core.r.e.a(j, true));
            }
            if (bb.eO(sb.toString())) {
                this.DB.setText(sb);
            }
            String str2 = this.DF.appPermissionInfoUrl;
            String str3 = this.DF.appPrivacyUrl;
            if (bb.eO(str2)) {
                this.DC.setText("权限信息");
                this.DC.setOnClickListener(this);
            }
            StringBuilder sb2 = new StringBuilder();
            if (bb.eO(str2)) {
                sb2.append(" | ");
            }
            if (bb.eO(str3)) {
                sb2.append("隐私政策");
                this.DD.setText(sb2);
                this.DD.setOnClickListener(this);
            }
            StringBuilder sb3 = new StringBuilder();
            String str4 = this.DF.appName;
            if (bb.eO(str4)) {
                sb3.append("应用名：");
                sb3.append(str4);
                sb3.append("；");
            }
            String str5 = this.DF.corporationName;
            if (bb.eO(str5)) {
                sb3.append("开发者：");
                sb3.append(str5);
            }
            if (bb.eO(sb3.toString())) {
                this.DE.setText(sb3);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.DF = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate).downloadSafeInfo;
        ll();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.DD) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0359a().au("隐私政策").av(this.DF.appPrivacyUrl).aA(true).L(this.Cg.mAdTemplate).oc());
        } else if (view == this.DC) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0359a().au("权限信息").aA(true).av(this.DF.appPermissionInfoUrl).L(this.Cg.mAdTemplate).oc());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
