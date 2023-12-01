package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.splash.R;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSSplashTwistView.class */
public class PPSSplashTwistView extends PPSBaseTwistView {
    public PPSSplashTwistView(Context context) {
        super(context);
        Code(context);
    }

    public PPSSplashTwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSSplashTwistView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        String str;
        ge.V("PPSSplashTwistView", "init");
        try {
            this.Code = inflate(context, R.layout.hiad_layout_splash_twist, this);
            this.F = (ImageView) this.Code.findViewById(R.id.hiad_phone_jpg);
            this.V = (TextView) this.Code.findViewById(R.id.hiad_twist_string);
            this.I = (TextView) this.Code.findViewById(R.id.hiad_twist_desc);
        } catch (RuntimeException e) {
            str = "init RuntimeException";
            ge.I("PPSSplashTwistView", str);
        } catch (Exception e2) {
            str = "init error";
            ge.I("PPSSplashTwistView", str);
        }
    }
}
