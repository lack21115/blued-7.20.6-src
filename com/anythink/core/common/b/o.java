package com.anythink.core.common.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.res.b;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/o.class */
public final class o implements ATCustomLoadListener {
    ATCustomLoadListener a;
    Map<String, Object> b;

    public o(ATCustomLoadListener aTCustomLoadListener, Map<String, Object> map) {
        this.a = aTCustomLoadListener;
        this.b = map;
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public final void onAdCacheLoaded(BaseAd... baseAdArr) {
        if (baseAdArr.length <= 0) {
            ATCustomLoadListener aTCustomLoadListener = this.a;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("10011", "load fail with no adObject");
                return;
            }
            return;
        }
        final BaseAd baseAd = baseAdArr[0];
        if (TextUtils.isEmpty(baseAd.getMainImageUrl())) {
            this.a.onAdCacheLoaded(new com.anythink.core.common.e.a.e(baseAd, this.b));
        } else {
            com.anythink.core.common.res.b.a(n.a().g()).a(new com.anythink.core.common.res.e(2, baseAd.getMainImageUrl()), 0, 0, new b.a() { // from class: com.anythink.core.common.b.o.1
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                    if (o.this.a != null) {
                        o.this.a.onAdLoadError("10011", "load image fail:".concat(String.valueOf(str2)));
                    }
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (!TextUtils.equals(str, baseAd.getMainImageUrl()) || o.this.a == null) {
                        return;
                    }
                    o.this.a.onAdCacheLoaded(new com.anythink.core.common.e.a.e(baseAd, o.this.b));
                }
            });
        }
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public final void onAdDataLoaded() {
        ATCustomLoadListener aTCustomLoadListener = this.a;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdDataLoaded();
        }
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public final void onAdLoadError(String str, String str2) {
        ATCustomLoadListener aTCustomLoadListener = this.a;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdLoadError(str, str2);
        }
    }
}
