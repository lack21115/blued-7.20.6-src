package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/utils/widget/MotionTelltales.class */
public class MotionTelltales extends MockView {
    MotionLayout b;

    /* renamed from: c  reason: collision with root package name */
    float[] f2246c;
    Matrix d;
    int e;
    int f;
    float g;
    private Paint h;

    public MotionTelltales(Context context) {
        super(context);
        this.h = new Paint();
        this.f2246c = new float[2];
        this.d = new Matrix();
        this.e = 0;
        this.f = Color.MAGENTA;
        this.g = 0.25f;
        a(context, null);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new Paint();
        this.f2246c = new float[2];
        this.d = new Matrix();
        this.e = 0;
        this.f = Color.MAGENTA;
        this.g = 0.25f;
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new Paint();
        this.f2246c = new float[2];
        this.d = new Matrix();
        this.e = 0;
        this.f = Color.MAGENTA;
        this.g = 0.25f;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    break;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.f = obtainStyledAttributes.getColor(index, this.f);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.e = obtainStyledAttributes.getInt(index, this.e);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.g = obtainStyledAttributes.getFloat(index, this.g);
                }
                i = i2 + 1;
            }
            obtainStyledAttributes.recycle();
        }
        this.h.setColor(this.f);
        this.h.setStrokeWidth(5.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.d);
        if (this.b == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.b = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                return;
            }
            float f = fArr[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < 5) {
                    float f2 = fArr[i4];
                    this.b.getViewVelocity(this, f2, f, this.f2246c, this.e);
                    this.d.mapVectors(this.f2246c);
                    float f3 = width * f2;
                    float f4 = height * f;
                    float[] fArr2 = this.f2246c;
                    float f5 = fArr2[0];
                    float f6 = this.g;
                    float f7 = fArr2[1];
                    this.d.mapVectors(fArr2);
                    canvas.drawLine(f3, f4, f3 - (f5 * f6), f4 - (f7 * f6), this.h);
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f2236a = charSequence.toString();
        requestLayout();
    }
}
