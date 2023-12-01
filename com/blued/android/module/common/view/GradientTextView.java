package com.blued.android.module.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/GradientTextView.class */
public class GradientTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f10990a;
    private TextPaint b;

    /* renamed from: c  reason: collision with root package name */
    private int f10991c;
    private int d;
    private float e;
    private float f;
    private int g;
    private float h;
    private GradientDrawable.Orientation i;

    public GradientTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = GradientDrawable.Orientation.LEFT_RIGHT;
        a(context, attributeSet, 0);
    }

    public GradientTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = GradientDrawable.Orientation.LEFT_RIGHT;
        a(context, attributeSet, i);
    }

    private void a() {
        LinearGradient linearGradient;
        getMeasuredHeight();
        getMeasuredWidth();
        if (this.i == GradientDrawable.Orientation.TOP_BOTTOM) {
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), new int[]{this.f10991c, this.d}, (float[]) null, Shader.TileMode.REPEAT);
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.f10991c, this.d}, (float[]) null, Shader.TileMode.CLAMP);
        }
        this.f10990a.setShader(linearGradient);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WordArtText);
        this.f10991c = obtainStyledAttributes.getColor(R.styleable.WordArtText_startColor, 0);
        this.d = obtainStyledAttributes.getColor(R.styleable.WordArtText_endColor, 0);
        this.g = obtainStyledAttributes.getColor(R.styleable.WordArtText_strokeColor, 0);
        this.e = obtainStyledAttributes.getFloat(R.styleable.WordArtText_radioHeight, 1.0f);
        this.f = obtainStyledAttributes.getFloat(R.styleable.WordArtText_radioWith, 0.0f);
        this.h = obtainStyledAttributes.getDimension(R.styleable.WordArtText_strokeWidth, 1.0f);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        if (this.b == null) {
            this.b = new TextPaint();
        }
        this.b.setTextSize(this.f10990a.getTextSize());
        this.b.setTypeface(this.f10990a.getTypeface());
        this.b.setFlags(this.f10990a.getFlags());
        this.b.setAlpha(this.f10990a.getAlpha());
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(this.g);
        this.b.setStrokeWidth(this.h);
    }

    public void a(int i, int i2) {
        this.f10991c = i;
        this.d = i2;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect = new Rect();
        this.f10990a = getPaint();
        String charSequence = getText().toString();
        this.f10990a.getTextBounds(charSequence, 0, charSequence.length(), rect);
        int i = (rect.bottom / 2) + (rect.top / 2);
        if (this.f10991c != 0 && this.d != 0) {
            a();
            canvas.drawText(charSequence, (getMeasuredWidth() / 2) - (rect.width() / 2), (getMeasuredHeight() / 2) - i, this.f10990a);
        }
        if (this.g != 0) {
            b();
            canvas.drawText(charSequence, (getMeasuredWidth() / 2) - (rect.width() / 2), (getMeasuredHeight() / 2) - i, this.b);
        }
    }
}
