package android.graphics.drawable.shapes;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/shapes/RoundRectShape.class */
public class RoundRectShape extends RectShape {
    private float[] mInnerRadii;
    private RectF mInnerRect;
    private RectF mInset;
    private float[] mOuterRadii;
    private Path mPath;

    public RoundRectShape(float[] fArr, RectF rectF, float[] fArr2) {
        if (fArr != null && fArr.length < 8) {
            throw new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
        }
        if (fArr2 != null && fArr2.length < 8) {
            throw new ArrayIndexOutOfBoundsException("inner radii must have >= 8 values");
        }
        this.mOuterRadii = fArr;
        this.mInset = rectF;
        this.mInnerRadii = fArr2;
        if (rectF != null) {
            this.mInnerRect = new RectF();
        }
        this.mPath = new Path();
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    /* renamed from: clone */
    public RoundRectShape mo343clone() throws CloneNotSupportedException {
        RoundRectShape roundRectShape = (RoundRectShape) super.mo343clone();
        roundRectShape.mOuterRadii = this.mOuterRadii != null ? (float[]) this.mOuterRadii.clone() : null;
        roundRectShape.mInnerRadii = this.mInnerRadii != null ? (float[]) this.mInnerRadii.clone() : null;
        roundRectShape.mInset = new RectF(this.mInset);
        roundRectShape.mInnerRect = new RectF(this.mInnerRect);
        roundRectShape.mPath = new Path(this.mPath);
        return roundRectShape;
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawPath(this.mPath, paint);
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void getOutline(Outline outline) {
        if (this.mInnerRect != null) {
            return;
        }
        float f = 0.0f;
        if (this.mOuterRadii != null) {
            float f2 = this.mOuterRadii[0];
            int i = 1;
            while (true) {
                int i2 = i;
                f = f2;
                if (i2 >= 8) {
                    break;
                } else if (this.mOuterRadii[i2] != f2) {
                    outline.setConvexPath(this.mPath);
                    return;
                } else {
                    i = i2 + 1;
                }
            }
        }
        RectF rect = rect();
        outline.setRoundRect((int) Math.ceil(rect.left), (int) Math.ceil(rect.top), (int) Math.floor(rect.right), (int) Math.floor(rect.bottom), f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void onResize(float f, float f2) {
        super.onResize(f, f2);
        RectF rect = rect();
        this.mPath.reset();
        if (this.mOuterRadii != null) {
            this.mPath.addRoundRect(rect, this.mOuterRadii, Path.Direction.CW);
        } else {
            this.mPath.addRect(rect, Path.Direction.CW);
        }
        if (this.mInnerRect != null) {
            this.mInnerRect.set(rect.left + this.mInset.left, rect.top + this.mInset.top, rect.right - this.mInset.right, rect.bottom - this.mInset.bottom);
            if (this.mInnerRect.width() >= f || this.mInnerRect.height() >= f2) {
                return;
            }
            if (this.mInnerRadii != null) {
                this.mPath.addRoundRect(this.mInnerRect, this.mInnerRadii, Path.Direction.CCW);
            } else {
                this.mPath.addRect(this.mInnerRect, Path.Direction.CCW);
            }
        }
    }
}
