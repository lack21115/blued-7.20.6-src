package android.animation;

import android.graphics.Rect;

/* loaded from: source-9557208-dex2jar.jar:android/animation/RectEvaluator.class */
public class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = rect.left + ((int) ((rect2.left - rect.left) * f));
        int i2 = rect.top + ((int) ((rect2.top - rect.top) * f));
        int i3 = rect.right + ((int) ((rect2.right - rect.right) * f));
        int i4 = rect.bottom + ((int) ((rect2.bottom - rect.bottom) * f));
        if (this.mRect == null) {
            return new Rect(i, i2, i3, i4);
        }
        this.mRect.set(i, i2, i3, i4);
        return this.mRect;
    }
}
