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
    private static final String f35774a = PreviewMask.class.getSimpleName();
    private static final int b = Color.argb(0, 0, 0, 0);

    /* renamed from: c  reason: collision with root package name */
    private HeadBorderView f35775c;
    private int d;

    public PreviewMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HeadBorderView headBorderView = new HeadBorderView(context.getApplicationContext());
        this.f35775c = headBorderView;
        addView(headBorderView, layoutParams);
        this.d = b;
        setWillNotDraw(false);
    }

    public HeadBorderView a() {
        return this.f35775c;
    }

    public void b() {
        this.d = b;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setReflectColor(int i) {
        this.d = i;
        this.f35775c.b(i);
        invalidate();
    }
}
