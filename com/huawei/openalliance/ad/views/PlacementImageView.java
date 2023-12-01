package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gq;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.js;
import com.huawei.hms.ads.kf;
import com.huawei.hms.ads.lk;
import com.huawei.openalliance.ad.inter.data.r;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PlacementImageView.class */
public class PlacementImageView extends PlacementMediaView implements lk {
    private ImageView D;
    private r L;

    /* renamed from: a  reason: collision with root package name */
    private kf f23032a;
    private gs b;

    public PlacementImageView(Context context) {
        super(context);
        Code(context);
    }

    public PlacementImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PlacementImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        this.f23032a = new js(getContext(), this);
        this.D = new ImageView(context);
        addView(this.D, new RelativeLayout.LayoutParams(-1, -1));
        this.D.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void B() {
        gs gsVar = this.b;
        if (gsVar != null) {
            gsVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    void Code() {
        this.D.setImageDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(int i) {
        this.D.setImageDrawable(null);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(gs gsVar) {
        this.b = gsVar;
    }

    @Override // com.huawei.hms.ads.lk
    public void Code(r rVar, Drawable drawable) {
        this.B = true;
        if (rVar == null || drawable == null) {
            this.C = false;
        } else if (this.L != null && TextUtils.equals(rVar.Z(), this.L.Z())) {
            this.C = true;
            this.D.setImageDrawable(drawable);
        }
        if (this.S) {
            Code(true, true);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I() {
        gs gsVar = this.b;
        if (gsVar != null) {
            gsVar.Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V() {
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V(gs gsVar) {
        this.b = null;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.ls
    public void destroyView() {
        this.D.setImageDrawable(null);
        super.destroyView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public ImageView getLastFrame() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public com.huawei.openalliance.ad.media.c getMediaState() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setMediaPlayerReleaseListener(gq gqVar) {
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setPlacementAd(com.huawei.openalliance.ad.inter.data.h hVar) {
        super.setPlacementAd(hVar);
        ge.Code("PlacementImageView", "setPlacementAd");
        if (this.Code != null) {
            r S = this.Code.S();
            this.L = S;
            if (S.V()) {
                return;
            }
            this.f23032a.Code(this.Code);
            this.V = this.L.e();
        }
    }
}
