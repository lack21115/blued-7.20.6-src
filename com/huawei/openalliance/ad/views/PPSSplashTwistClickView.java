package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.splash.R;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSSplashTwistClickView.class */
public class PPSSplashTwistClickView extends PPSBaseTwistView {
    private LinearLayout L;

    public PPSSplashTwistClickView(Context context) {
        super(context);
        Code(context);
    }

    public PPSSplashTwistClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSSplashTwistClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        String str;
        ge.V("PPSSplashTwistClickView", "init");
        try {
            this.Code = inflate(context, R.layout.hiad_layout_splash_twist_click, this);
            this.F = (ImageView) this.Code.findViewById(R.id.hiad_click_phone_jpg);
            this.L = (LinearLayout) this.Code.findViewById(R.id.twist_click_area);
            this.V = (TextView) this.Code.findViewById(R.id.hiad_click_twist_string);
            this.I = (TextView) this.Code.findViewById(R.id.hiad_click_twist_desc);
        } catch (RuntimeException e) {
            str = "init RuntimeException";
            ge.I("PPSSplashTwistClickView", str);
        } catch (Exception e2) {
            str = "init error";
            ge.I("PPSSplashTwistClickView", str);
        }
    }

    public LinearLayout getClickAreaView() {
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseTwistView
    protected String getViewTag() {
        return "PPSSplashTwistClickView";
    }
}
