package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.jo;
import com.huawei.hms.ads.ld;
import com.huawei.hms.ads.splash.R;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSImageView.class */
public class PPSImageView extends PPSBaseView implements ld {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f9411a;

    public PPSImageView(Context context) {
        super(context);
        Code(context);
        this.B = new jo(context, this);
    }

    private void Code(Context context) {
        inflate(context, R.layout.hiad_view_image_ad, this);
        this.f9411a = (ImageView) findViewById(R.id.iv_ad_content);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lj
    public boolean C() {
        return true;
    }

    @Override // com.huawei.hms.ads.ld
    public void Code(Drawable drawable) {
        ge.V("PPSImageView", "onAdImageLoaded - set image to view");
        this.f9411a.setImageDrawable(drawable);
        this.B.Code(this.F);
    }
}
