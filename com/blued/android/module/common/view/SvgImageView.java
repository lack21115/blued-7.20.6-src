package com.blued.android.module.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.common.R;
import com.blued.android.module.common.svg_android.SVGParser;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/SvgImageView.class */
public class SvgImageView extends BaseImageView {
    private int b;

    public SvgImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public SvgImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    public static Bitmap a(Context context, int i, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(View.MEASURED_STATE_MASK);
        if (i3 > 0) {
            canvas.drawPicture(SVGParser.a(context.getResources().openRawResource(i3), i, i2).a());
            return createBitmap;
        }
        canvas.drawRect(new RectF(0.0f, 0.0f, i, i2), paint);
        return createBitmap;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomShapeImageView);
        this.b = obtainStyledAttributes.getResourceId(R.styleable.CustomShapeImageView_svg_raw_resource, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // com.blued.android.module.common.view.BaseImageView
    public Bitmap getBitmap() {
        return a(this.a, getWidth(), getHeight(), this.b);
    }
}
