package android.view.animation;

import android.graphics.Matrix;
import android.graphics.Rect;
import java.io.PrintWriter;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/Transformation.class */
public class Transformation {
    public static final int TYPE_ALPHA = 1;
    public static final int TYPE_BOTH = 3;
    public static final int TYPE_IDENTITY = 0;
    public static final int TYPE_MATRIX = 2;
    protected float mAlpha;
    private Rect mClipRect = new Rect();
    private boolean mHasClipRect;
    protected Matrix mMatrix;
    protected int mTransformationType;

    public Transformation() {
        clear();
    }

    public void clear() {
        if (this.mMatrix == null) {
            this.mMatrix = new Matrix();
        } else {
            this.mMatrix.reset();
        }
        this.mClipRect.setEmpty();
        this.mHasClipRect = false;
        this.mAlpha = 1.0f;
        this.mTransformationType = 3;
    }

    public void compose(Transformation transformation) {
        this.mAlpha *= transformation.getAlpha();
        this.mMatrix.preConcat(transformation.getMatrix());
        if (transformation.mHasClipRect) {
            setClipRect(transformation.getClipRect());
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public Rect getClipRect() {
        return this.mClipRect;
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public int getTransformationType() {
        return this.mTransformationType;
    }

    public boolean hasClipRect() {
        return this.mHasClipRect;
    }

    public void postCompose(Transformation transformation) {
        this.mAlpha *= transformation.getAlpha();
        this.mMatrix.postConcat(transformation.getMatrix());
        if (transformation.mHasClipRect) {
            setClipRect(transformation.getClipRect());
        }
    }

    public void printShortString(PrintWriter printWriter) {
        printWriter.print("{alpha=");
        printWriter.print(this.mAlpha);
        printWriter.print(" matrix=");
        this.mMatrix.printShortString(printWriter);
        printWriter.print('}');
    }

    public void set(Transformation transformation) {
        this.mAlpha = transformation.getAlpha();
        this.mMatrix.set(transformation.getMatrix());
        if (transformation.mHasClipRect) {
            setClipRect(transformation.getClipRect());
        } else {
            this.mHasClipRect = false;
            this.mClipRect.setEmpty();
        }
        this.mTransformationType = transformation.getTransformationType();
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public void setClipRect(int i, int i2, int i3, int i4) {
        this.mClipRect.set(i, i2, i3, i4);
        this.mHasClipRect = true;
    }

    public void setClipRect(Rect rect) {
        setClipRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setTransformationType(int i) {
        this.mTransformationType = i;
    }

    public String toShortString() {
        StringBuilder sb = new StringBuilder(64);
        toShortString(sb);
        return sb.toString();
    }

    public void toShortString(StringBuilder sb) {
        sb.append("{alpha=");
        sb.append(this.mAlpha);
        sb.append(" matrix=");
        this.mMatrix.toShortString(sb);
        sb.append('}');
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Transformation");
        toShortString(sb);
        return sb.toString();
    }
}
