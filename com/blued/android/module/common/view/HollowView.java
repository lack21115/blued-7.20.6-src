package com.blued.android.module.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.R;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/HollowView.class */
public final class HollowView extends View {
    private final int a;
    private final int b;
    private Paint c;
    private float d;
    private float e;
    private int f;
    private ArrayList<Integer> g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HollowView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HollowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HollowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.b = 1;
        this.g = new ArrayList<>();
        a(context, attributeSet, i);
    }

    private final void a() {
        Paint paint = new Paint();
        this.c = paint;
        if (paint != null) {
            paint.setXfermode(null);
        }
        Paint paint2 = this.c;
        if (paint2 != null) {
            paint2.setTextSize(DensityUtils.a(getContext(), 12.0f));
        }
        Paint paint3 = this.c;
        if (paint3 != null) {
            paint3.setAntiAlias(true);
        }
        Paint paint4 = this.c;
        if (paint4 == null) {
            return;
        }
        paint4.setStyle(Paint.Style.FILL);
    }

    private final void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HollowView);
        Intrinsics.c(obtainStyledAttributes, "context.obtainStyledAttr…, R.styleable.HollowView)");
        if (obtainStyledAttributes.hasValue(R.styleable.HollowView_gradient_start_color)) {
            this.g.add(Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.HollowView_gradient_start_color, 0)));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.HollowView_gradient_center_color)) {
            this.g.add(Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.HollowView_gradient_center_color, 0)));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.HollowView_gradient_end_color)) {
            this.g.add(Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.HollowView_gradient_end_color, 0)));
        }
        this.d = obtainStyledAttributes.getDimension(R.styleable.HollowView_stroke_width, 0.0f);
        this.e = obtainStyledAttributes.getDimension(R.styleable.HollowView_corner_radius, 0.0f);
        this.f = obtainStyledAttributes.getInt(R.styleable.HollowView_gradient_orientation, this.a);
        obtainStyledAttributes.recycle();
        if (this.g.size() <= 0) {
            this.g.get(-1);
        }
        if (this.g.size() < 2) {
            ArrayList<Integer> arrayList = this.g;
            arrayList.add(arrayList.get(0));
        }
        a();
    }

    private final void a(Canvas canvas) {
        Paint paint = this.c;
        if (paint == null) {
            return;
        }
        paint.setShader(getGradient());
        paint.setColor(-1);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth() * 1.0f, getHeight() * 1.0f);
        if (canvas != null) {
            float f = this.e;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
        if (canvas == null) {
            return;
        }
        canvas.save();
    }

    private final void b(Canvas canvas) {
        Paint paint = this.c;
        if (paint == null) {
            return;
        }
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        float f = this.d;
        RectF rectF = new RectF(f, f, (getWidth() * 1.0f) - this.d, (getHeight() * 1.0f) - this.d);
        if (canvas != null) {
            float f2 = this.e;
            canvas.drawRoundRect(rectF, f2, f2, paint);
        }
        paint.setXfermode(null);
    }

    private final LinearGradient getGradient() {
        return this.f == this.b ? new LinearGradient(0.0f, 0.0f, 0.0f, getHeight() * 1.0f, CollectionsKt.b((Collection<Integer>) this.g), (float[]) null, Shader.TileMode.CLAMP) : new LinearGradient(0.0f, 0.0f, getWidth() * 1.0f, 0.0f, CollectionsKt.b((Collection<Integer>) this.g), (float[]) null, Shader.TileMode.CLAMP);
    }

    public final ArrayList<Integer> getMGradientColor() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Integer valueOf = canvas == null ? null : Integer.valueOf(canvas.saveLayer(0.0f, 0.0f, getWidth() * 1.0f, getHeight() * 1.0f, this.c));
        a(canvas);
        b(canvas);
        if (valueOf != null) {
            canvas.restoreToCount(valueOf.intValue());
        }
    }

    public final void setMGradientColor(ArrayList<Integer> value) {
        Intrinsics.e(value, "value");
        this.g = value;
        if (value.size() <= 0) {
            this.g.get(-1);
        }
        if (this.g.size() < 2) {
            ArrayList<Integer> arrayList = this.g;
            arrayList.add(arrayList.get(0));
        }
        invalidate();
    }
}
