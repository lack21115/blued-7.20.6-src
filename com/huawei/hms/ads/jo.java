package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jo.class */
public class jo extends jn<ld> implements ka {
    public jo(Context context, ld ldVar) {
        super(context, ldVar);
    }

    @Override // com.huawei.hms.ads.jn
    protected void V(final String str) {
        ((ld) I()).B();
        ge.V("PPSImageViewPresenter", "onMaterialLoaded - begin to load image");
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(str);
        sourceParam.Code(this.Code);
        com.huawei.openalliance.ad.utils.y.Code(this.V, sourceParam, new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.jo.1
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                ge.V("PPSImageViewPresenter", "onMaterialLoaded - image load failed");
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jo.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((ld) jo.this.I()).Code(-9);
                    }
                });
                jo joVar = jo.this;
                joVar.V(joVar.Code);
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str2, final Drawable drawable) {
                if (TextUtils.equals(str2, str)) {
                    ge.V("PPSImageViewPresenter", "onMaterialLoaded - image load success");
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jo.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((ld) jo.this.I()).Code(drawable);
                            ((ld) jo.this.I()).Z();
                        }
                    });
                    return;
                }
                Code();
                eh.Code(jo.this.V, 5, "url not equals filePath", jo.this.Code);
            }
        });
    }
}
