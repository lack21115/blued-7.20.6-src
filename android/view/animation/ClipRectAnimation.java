package android.view.animation;

import android.graphics.Rect;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/ClipRectAnimation.class */
public class ClipRectAnimation extends Animation {
    private Rect mFromRect = new Rect();
    private Rect mToRect = new Rect();

    public ClipRectAnimation(Rect rect, Rect rect2) {
        if (rect == null || rect2 == null) {
            throw new RuntimeException("Expected non-null animation clip rects");
        }
        this.mFromRect.set(rect);
        this.mToRect.set(rect2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        transformation.setClipRect(this.mFromRect.left + ((int) ((this.mToRect.left - this.mFromRect.left) * f)), this.mFromRect.top + ((int) ((this.mToRect.top - this.mFromRect.top) * f)), this.mFromRect.right + ((int) ((this.mToRect.right - this.mFromRect.right) * f)), this.mFromRect.bottom + ((int) ((this.mToRect.bottom - this.mFromRect.bottom) * f)));
    }

    @Override // android.view.animation.Animation
    public boolean willChangeTransformationMatrix() {
        return false;
    }
}
