package com.kwad.components.ad.reward.presenter;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/b.class */
public class b extends a {
    private ImageView rR;
    private AdInfo rS;

    public b(AdInfo adInfo) {
        this.rS = adInfo;
    }

    public static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.b.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdTemplate adTemplate = this.qt.mAdTemplate;
        if (adTemplate.adInfoList.size() > 0) {
            String O = com.kwad.sdk.core.response.a.a.O(adTemplate.adInfoList.get(0));
            this.rR.setVisibility(hs());
            try {
                a(this.rR, O, adTemplate);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    protected int hr() {
        return R.id.ksad_blur_video_cover;
    }

    protected int hs() {
        getContext();
        if (!com.kwad.components.ad.reward.j.p(this.qt.mAdTemplate) || ai.DL()) {
            if (!com.kwad.components.ad.reward.j.o(this.qt.mAdTemplate) || ai.DL()) {
                if ((!com.kwad.sdk.core.response.a.d.co(this.qt.mAdTemplate) || ai.DL()) && !com.kwad.components.ad.reward.j.h(this.rS)) {
                    return (com.kwad.sdk.core.response.a.a.ci(this.rS) && com.kwad.components.ad.reward.kwai.b.gJ() && !ai.DL()) ? 0 : 8;
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.rR = (ImageView) findViewById(hr());
    }
}
