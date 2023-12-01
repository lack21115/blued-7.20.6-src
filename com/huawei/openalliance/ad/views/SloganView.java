package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ju;
import com.huawei.hms.ads.kh;
import com.huawei.hms.ads.lp;
import com.huawei.hms.ads.lu;
import com.huawei.openalliance.ad.utils.ba;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/SloganView.class */
public class SloganView extends RelativeLayout implements lp {
    private int B;
    private int C;
    private float D;
    private View F;
    private kh I;
    private int S;

    public SloganView(Context context, int i, int i2) {
        super(context);
        this.C = 0;
        this.S = 1;
        this.B = i;
        V(i2);
    }

    public SloganView(Context context, int i, int i2, int i3) {
        super(context);
        this.C = 0;
        this.S = 1;
        this.S = i;
        this.B = i2;
        V(i3);
    }

    private void Code(int i, int i2) {
        int i3;
        String str;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        float f = (i * 1.0f) / i2;
        float abs = Math.abs(this.D - f);
        ge.Code("SloganView", "ratio: %s diff: %s", Float.valueOf(f), Float.valueOf(abs));
        if (abs > 0.01f) {
            this.D = f;
            if (f > 0.9f) {
                i3 = this.C;
                if (i3 > 0) {
                    str = "pick wideSloganResId";
                    ge.Code("SloganView", str);
                    this.I.Code(i3, false);
                }
            }
            i3 = this.B;
            str = "pick defaultSloganResId";
            ge.Code("SloganView", str);
            this.I.Code(i3, false);
        }
    }

    private void V(int i) {
        this.I = new ju(getContext(), this);
    }

    public void Code() {
        if (this.F == null) {
            this.I.Code(this.B, true);
        }
        setVisibility(0);
    }

    @Override // com.huawei.hms.ads.lp
    public void Code(final int i) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.SloganView.1
            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                if (SloganView.this.F instanceof ImageView) {
                    imageView = (ImageView) SloganView.this.F;
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    SloganView.this.removeAllViews();
                    imageView = new ImageView(SloganView.this.getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    SloganView.this.F = imageView;
                    SloganView.this.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
                }
                imageView.setImageResource(i);
            }
        });
    }

    public void V() {
        setVisibility(8);
    }

    public int getOrientation() {
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ge.Code("SloganView", "onSizeChanged w: %d h: %d oldw: %d oldh: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        Code(i, i2);
    }

    public void setSloganShowListener(lu luVar) {
        this.I.Code(luVar);
    }

    public void setWideSloganResId(int i) {
        this.C = i;
    }
}
