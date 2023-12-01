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
    private ClipZoomImageView f14700a;
    private ClipImageBorderView b;

    /* renamed from: c  reason: collision with root package name */
    private int f14701c;
    private int d;

    public ClipImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14701c = 20;
        this.d = 0;
        this.f14700a = new ClipZoomImageView(context);
        this.b = new ClipImageBorderView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.f14700a, layoutParams);
        addView(this.b, layoutParams);
        this.f14701c = (int) TypedValue.applyDimension(1, this.f14701c, getResources().getDisplayMetrics());
    }

    public Bitmap a() {
        return this.f14700a.a();
    }

    public void setHorizontalPadding(int i) {
        this.f14701c = i;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f14700a.setImageBitmap(BitmapUtils.a(bitmap));
    }

    public void setVerticalPadding(int i) {
        this.d = i;
        this.f14700a.setVerticalPadding(i);
        this.b.setVerticalPadding(i);
    }
}
