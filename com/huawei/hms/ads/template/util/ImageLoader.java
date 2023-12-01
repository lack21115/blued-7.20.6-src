package com.huawei.hms.ads.template.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.huawei.hms.ads.template.IDrawableSetter;
import com.huawei.hms.ads.template.IImageLoader;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.y;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/util/ImageLoader.class */
public class ImageLoader implements IImageLoader {
    private Context Code;
    private aj V;

    public ImageLoader(Context context, aj ajVar) {
        this.Code = context;
        this.V = ajVar;
    }

    @Override // com.huawei.hms.ads.template.IImageLoader
    public void load(final ImageView imageView, String str, String str2, int i) {
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(str);
        sourceParam.Code(52428800L);
        boolean z = true;
        sourceParam.I(true);
        if (i != 0) {
            z = false;
        }
        sourceParam.V(z);
        sourceParam.V(str2);
        y.Code(this.Code, sourceParam, new aj() { // from class: com.huawei.hms.ads.template.util.ImageLoader.1
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                if (ImageLoader.this.V != null) {
                    ImageLoader.this.V.Code();
                }
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str3, final Drawable drawable) {
                ba.Code(new Runnable() { // from class: com.huawei.hms.ads.template.util.ImageLoader.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageDrawable(drawable);
                    }
                });
                if (ImageLoader.this.V != null) {
                    ImageLoader.this.V.Code(str3, drawable);
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.template.IImageLoader
    public void loadDrawable(final IDrawableSetter iDrawableSetter, String str) {
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(str);
        sourceParam.Code(52428800L);
        y.Code(this.Code, sourceParam, new aj() { // from class: com.huawei.hms.ads.template.util.ImageLoader.2
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str2, Drawable drawable) {
                iDrawableSetter.setDrawable(drawable);
            }
        });
    }
}
