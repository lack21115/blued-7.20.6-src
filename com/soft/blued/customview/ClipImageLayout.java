package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.blued.android.module.common.utils.BitmapUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ClipImageLayout.class */
public class ClipImageLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private ClipZoomImageView f28390a;
    private ClipImageBorderView b;

    /* renamed from: c  reason: collision with root package name */
    private int f28391c;
    private int d;

    public ClipImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28391c = 20;
        this.d = 0;
        this.f28390a = new ClipZoomImageView(context);
        this.b = new ClipImageBorderView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.f28390a, layoutParams);
        addView(this.b, layoutParams);
        this.f28391c = (int) TypedValue.applyDimension(1, this.f28391c, getResources().getDisplayMetrics());
    }

    public Bitmap a() {
        return this.f28390a.a();
    }

    public void setHorizontalPadding(int i) {
        this.f28391c = i;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f28390a.setImageBitmap(BitmapUtils.a(bitmap));
    }

    public void setVerticalPadding(int i) {
        this.d = i;
        this.f28390a.setVerticalPadding(i);
        this.b.setVerticalPadding(i);
    }
}
