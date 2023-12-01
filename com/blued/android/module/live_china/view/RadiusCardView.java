package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import com.blued.android.module.live_china.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/RadiusCardView.class */
public class RadiusCardView extends MaterialCardView {

    /* renamed from: a  reason: collision with root package name */
    private float f15240a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f15241c;
    private float d;

    public RadiusCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    public RadiusCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setRadius(0.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadiusCardView);
        this.f15240a = obtainStyledAttributes.getDimension(R.styleable.RadiusCardView_rcv_topLeftRadiu, 0.0f);
        this.b = obtainStyledAttributes.getDimension(R.styleable.RadiusCardView_rcv_topRightRadiu, 0.0f);
        this.f15241c = obtainStyledAttributes.getDimension(R.styleable.RadiusCardView_rcv_bottomRightRadiu, 0.0f);
        this.d = obtainStyledAttributes.getDimension(R.styleable.RadiusCardView_rcv_bottomLeftRadiu, 0.0f);
        obtainStyledAttributes.recycle();
        setBackground(new ColorDrawable());
    }

    private RectF getRectF() {
        Rect rect = new Rect();
        getDrawingRect(rect);
        return new RectF(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        RectF rectF = getRectF();
        float f = this.f15240a;
        float f2 = this.b;
        float f3 = this.f15241c;
        float f4 = this.d;
        path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
        canvas.clipPath(path, Region.Op.INTERSECT);
        super.onDraw(canvas);
    }
}
