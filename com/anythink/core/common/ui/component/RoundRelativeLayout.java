package com.anythink.core.common.ui.component;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.anythink.core.common.k.u;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/ui/component/RoundRelativeLayout.class */
public class RoundRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    int f6931a;

    public RoundRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6931a = dip2px(context, 4.0f);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        this(context);
    }

    private void a(Context context) {
        this.f6931a = dip2px(context, 4.0f);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.draw(canvas);
        u.a(canvas, getWidth(), getHeight(), this.f6931a);
        canvas.restoreToCount(saveLayer);
    }
}
