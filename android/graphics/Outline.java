package android.graphics;

import android.graphics.Path;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Outline.class */
public final class Outline {
    public float mAlpha;
    public Path mPath;
    public float mRadius;
    public Rect mRect;

    public Outline() {
    }

    public Outline(Outline outline) {
        set(outline);
    }

    public boolean canClip() {
        return (isEmpty() || this.mRect == null) ? false : true;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public boolean isEmpty() {
        return this.mRect == null && this.mPath == null;
    }

    public void offset(int i, int i2) {
        if (this.mRect != null) {
            this.mRect.offset(i, i2);
        } else if (this.mPath != null) {
            this.mPath.offset(i, i2);
        }
    }

    public void set(Outline outline) {
        if (outline.mPath != null) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            this.mPath.set(outline.mPath);
            this.mRect = null;
        }
        if (outline.mRect != null) {
            if (this.mRect == null) {
                this.mRect = new Rect();
            }
            this.mRect.set(outline.mRect);
        }
        this.mRadius = outline.mRadius;
        this.mAlpha = outline.mAlpha;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public void setConvexPath(Path path) {
        if (path.isEmpty()) {
            setEmpty();
        } else if (!path.isConvex()) {
            throw new IllegalArgumentException("path must be convex");
        } else {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            this.mPath.set(path);
            this.mRect = null;
            this.mRadius = -1.0f;
        }
    }

    public void setEmpty() {
        this.mPath = null;
        this.mRect = null;
        this.mRadius = 0.0f;
    }

    public void setOval(int i, int i2, int i3, int i4) {
        if (i >= i3 || i2 >= i4) {
            setEmpty();
        } else if (i4 - i2 == i3 - i) {
            setRoundRect(i, i2, i3, i4, (i4 - i2) / 2.0f);
        } else {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            this.mPath.reset();
            this.mPath.addOval(i, i2, i3, i4, Path.Direction.CW);
            this.mRect = null;
        }
    }

    public void setOval(Rect rect) {
        setOval(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setRect(int i, int i2, int i3, int i4) {
        setRoundRect(i, i2, i3, i4, 0.0f);
    }

    public void setRect(Rect rect) {
        setRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setRoundRect(int i, int i2, int i3, int i4, float f) {
        if (i >= i3 || i2 >= i4) {
            setEmpty();
            return;
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
        this.mRect.set(i, i2, i3, i4);
        this.mRadius = f;
        this.mPath = null;
    }

    public void setRoundRect(Rect rect, float f) {
        setRoundRect(rect.left, rect.top, rect.right, rect.bottom, f);
    }
}
