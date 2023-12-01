package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/PreviewMask.class */
public class PreviewMask extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22083a = PreviewMask.class.getSimpleName();
    private static final int b = Color.argb(0, 0, 0, 0);

    /* renamed from: c  reason: collision with root package name */
    private HeadBorderView f22084c;
    private int d;

    public PreviewMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HeadBorderView headBorderView = new HeadBorderView(context.getApplicationContext());
        this.f22084c = headBorderView;
        addView(headBorderView, layoutParams);
        this.d = b;
        setWillNotDraw(false);
    }

    public HeadBorderView a() {
        return this.f22084c;
    }

    public void b() {
        this.d = b;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setReflectColor(int i) {
        this.d = i;
        this.f22084c.b(i);
        invalidate();
    }
}
