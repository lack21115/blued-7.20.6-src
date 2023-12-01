package android.graphics.drawable.shapes;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RectF;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/shapes/RectShape.class */
public class RectShape extends Shape {
    private RectF mRect = new RectF();

    @Override // android.graphics.drawable.shapes.Shape
    /* renamed from: clone */
    public RectShape mo343clone() throws CloneNotSupportedException {
        RectShape rectShape = (RectShape) super.mo343clone();
        rectShape.mRect = new RectF(this.mRect);
        return rectShape;
    }

    @Override // android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawRect(this.mRect, paint);
    }

    @Override // android.graphics.drawable.shapes.Shape
    public void getOutline(Outline outline) {
        RectF rect = rect();
        outline.setRect((int) Math.ceil(rect.left), (int) Math.ceil(rect.top), (int) Math.floor(rect.right), (int) Math.floor(rect.bottom));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.shapes.Shape
    public void onResize(float f, float f2) {
        this.mRect.set(0.0f, 0.0f, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RectF rect() {
        return this.mRect;
    }
}
