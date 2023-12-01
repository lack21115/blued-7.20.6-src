package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.splash.R;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSSplashSwipeView.class */
public class PPSSplashSwipeView extends PPSBaseSwipeView {
    public PPSSplashSwipeView(Context context) {
        super(context);
        Code(context);
    }

    public PPSSplashSwipeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSSplashSwipeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        String str;
        ge.V("PPSSplashSwipeView", "init");
        try {
            this.Code = inflate(context, R.layout.hiad_layout_splash_swipe, this);
            this.V = (TextView) this.Code.findViewById(R.id.hiad_swipe_string);
            this.I = (TextView) this.Code.findViewById(R.id.hiad_swipe_desc);
            this.S = (ImageView) this.Code.findViewById(R.id.hiad_arrow);
            this.F = (ScanningView) this.Code.findViewById(R.id.scanning_view);
        } catch (RuntimeException e) {
            str = "init RuntimeException";
            ge.I("PPSSplashSwipeView", str);
        } catch (Exception e2) {
            str = "init error";
            ge.I("PPSSplashSwipeView", str);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseSwipeView
    protected String getViewTag() {
        return "PPSSplashSwipeView";
    }
}
