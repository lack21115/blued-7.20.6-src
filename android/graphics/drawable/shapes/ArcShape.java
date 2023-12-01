package android.graphics.drawable.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/shapes/ArcShape.class */
public class ArcShape extends RectShape {
    private float mStart;
    private float mSweep;

    public ArcShape(float f, float f2) {
        this.mStart = f;
        this.mSweep = f2;
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawArc(rect(), this.mStart, this.mSweep, true, paint);
    }
}
