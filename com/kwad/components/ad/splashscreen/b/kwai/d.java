package com.kwad.components.ad.splashscreen.b.kwai;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/kwai/d.class */
public final class d extends com.kwad.components.ad.splashscreen.b.e implements com.kwad.sdk.core.g.c {
    private CloseCountDownView DG;
    private ImageView DJ;
    private TextView DK;
    private TextView DL;
    private ViewGroup DO;
    private ImageView DP;
    private KsLogoView DQ;
    private TextView DR;
    private TextView DS;

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(20).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.b.kwai.d.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(String str) {
        this.DR.setText(str);
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_endcard_view_stub);
        this.DO = (ViewGroup) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_splash_end_card_native_root));
        this.DP = (ImageView) findViewById(R.id.ksad_splash_end_card_native_bg);
        this.DJ = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.DK = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.DL = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
        this.DQ = (KsLogoView) findViewById(R.id.ksad_ad_endcard_logo);
        this.DR = (TextView) findViewById(R.id.ksad_ad_btn_title);
        this.DS = (TextView) findViewById(R.id.ksad_ad_btn_sub_title);
        this.DG = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
    }

    private void lm() {
        if (com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate))) {
            com.kwad.components.ad.splashscreen.e.a aVar = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.kwai.d.1
                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void ac(String str) {
                    d.this.af(str);
                }
            };
            if (this.Cg.mApkDownloadHelper != null) {
                this.Cg.mApkDownloadHelper.b(aVar);
            }
        }
    }

    private void ln() {
        this.DO.setVisibility(0);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        a(this.DP, com.kwad.sdk.core.response.a.a.aM(cb).materialUrl, this.Cg.mAdTemplate);
        this.DJ.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.DJ, com.kwad.sdk.core.response.a.a.bM(cb), this.Cg.mAdTemplate, 24);
        this.DK.setText(com.kwad.sdk.core.response.a.a.bK(cb));
        this.DL.setText(com.kwad.sdk.core.response.a.a.an(cb));
        this.DQ.S(this.Cg.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.ax(cb)) {
            t(cb);
        } else {
            this.DR.setText("点击查看");
            this.DS.setVisibility(0);
            this.DS.setText("跳转详情页/第三方应用");
        }
        this.DG.a(cb);
    }

    private void t(AdInfo adInfo) {
        if (this.Cg.mApkDownloadHelper == null) {
            return;
        }
        int nb = this.Cg.mApkDownloadHelper.nb();
        AdMatrixInfo.DownloadTexts cQ = com.kwad.sdk.core.response.a.b.cQ(adInfo);
        String str = nb != 8 ? nb != 12 ? cQ.adActionDescription : cQ.openAppLabel : cQ.installAppLabel;
        if (TextUtils.isEmpty(str)) {
            this.DR.setText(com.kwad.sdk.core.response.a.a.aw(adInfo));
        } else {
            this.DR.setText(str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Cg.BH.a(this);
        com.kwad.sdk.core.report.a.b(this.Cg.mAdTemplate, 87, (JSONObject) null);
        lm();
        ln();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
        this.DG.onPageInvisible();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        this.DG.onPageVisible();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.DG.bn();
        this.Cg.BH.b(this);
    }
}
