package android.graphics.drawable.shapes;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/shapes/Shape.class */
public abstract class Shape implements Cloneable {
    private float mHeight;
    private float mWidth;

    @Override // 
    /* renamed from: clone */
    public Shape mo343clone() throws CloneNotSupportedException {
        return (Shape) super.clone();
    }

    public abstract void draw(Canvas canvas, Paint paint);

    public final float getHeight() {
        return this.mHeight;
    }

    public void getOutline(Outline outline) {
    }

    public final float getWidth() {
        return this.mWidth;
    }

    public boolean hasAlpha() {
        return true;
    }

    protected void onResize(float f, float f2) {
    }

    public final void resize(float f, float f2) {
        float f3 = f;
        if (f < 0.0f) {
            f3 = 0.0f;
        }
        float f4 = f2;
        if (f2 < 0.0f) {
            f4 = 0.0f;
        }
        if (this.mWidth == f3 && this.mHeight == f4) {
            return;
        }
        this.mWidth = f3;
        this.mHeight = f4;
        onResize(f3, f4);
    }
}
