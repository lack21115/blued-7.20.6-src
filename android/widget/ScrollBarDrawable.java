package android.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: source-4181928-dex2jar.jar:android/widget/ScrollBarDrawable.class */
public class ScrollBarDrawable extends Drawable {
    private static final int[] STATE_ENABLED = {16842910};
    private boolean mAlwaysDrawHorizontalTrack;
    private boolean mAlwaysDrawVerticalTrack;
    private boolean mChanged;
    private int mExtent;
    private Drawable mHorizontalThumb;
    private Drawable mHorizontalTrack;
    private boolean mMutated;
    private int mOffset;
    private int mRange;
    private boolean mRangeChanged;
    private final Rect mTempBounds = new Rect();
    private boolean mVertical;
    private Drawable mVerticalThumb;
    private Drawable mVerticalTrack;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = this.mVertical;
        int i = this.mExtent;
        int i2 = this.mRange;
        boolean z2 = true;
        boolean z3 = true;
        if (i <= 0 || i2 <= i) {
            z2 = z ? this.mAlwaysDrawVerticalTrack : this.mAlwaysDrawHorizontalTrack;
            z3 = false;
        }
        Rect bounds = getBounds();
        if (canvas.quickReject(bounds.left, bounds.top, bounds.right, bounds.bottom, Canvas.EdgeType.AA)) {
            return;
        }
        if (z2) {
            drawTrack(canvas, bounds, z);
        }
        if (z3) {
            int height = z ? bounds.height() : bounds.width();
            int width = z ? bounds.width() : bounds.height();
            int round = Math.round((height * i) / i2);
            int round2 = Math.round(((height - round) * this.mOffset) / (i2 - i));
            int i3 = width * 2;
            int i4 = round;
            if (round < i3) {
                i4 = i3;
            }
            int i5 = round2;
            if (round2 + i4 > height) {
                i5 = height - i4;
            }
            drawThumb(canvas, bounds, i5, i4, z);
        }
    }

    protected void drawThumb(Canvas canvas, Rect rect, int i, int i2, boolean z) {
        Rect rect2 = this.mTempBounds;
        boolean z2 = this.mRangeChanged || this.mChanged;
        if (z2) {
            if (z) {
                rect2.set(rect.left, rect.top + i, rect.right, rect.top + i + i2);
            } else {
                rect2.set(rect.left + i, rect.top, rect.left + i + i2, rect.bottom);
            }
        }
        if (z) {
            if (this.mVerticalThumb != null) {
                Drawable drawable = this.mVerticalThumb;
                if (z2) {
                    drawable.setBounds(rect2);
                }
                drawable.draw(canvas);
            }
        } else if (this.mHorizontalThumb != null) {
            Drawable drawable2 = this.mHorizontalThumb;
            if (z2) {
                drawable2.setBounds(rect2);
            }
            drawable2.draw(canvas);
        }
    }

    protected void drawTrack(Canvas canvas, Rect rect, boolean z) {
        Drawable drawable = z ? this.mVerticalTrack : this.mHorizontalTrack;
        if (drawable != null) {
            if (this.mChanged) {
                drawable.setBounds(rect);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mVerticalThumb.getAlpha();
    }

    public boolean getAlwaysDrawHorizontalTrack() {
        return this.mAlwaysDrawHorizontalTrack;
    }

    public boolean getAlwaysDrawVerticalTrack() {
        return this.mAlwaysDrawVerticalTrack;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getSize(boolean z) {
        int i = 0;
        if (z) {
            if (this.mVerticalTrack != null) {
                i = this.mVerticalTrack.getIntrinsicWidth();
            } else if (this.mVerticalThumb != null) {
                return this.mVerticalThumb.getIntrinsicWidth();
            }
        } else if (this.mHorizontalTrack != null) {
            return this.mHorizontalTrack.getIntrinsicHeight();
        } else {
            if (this.mHorizontalThumb != null) {
                return this.mHorizontalThumb.getIntrinsicHeight();
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public ScrollBarDrawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            if (this.mVerticalTrack != null) {
                this.mVerticalTrack.mutate();
            }
            if (this.mVerticalThumb != null) {
                this.mVerticalThumb.mutate();
            }
            if (this.mHorizontalTrack != null) {
                this.mHorizontalTrack.mutate();
            }
            if (this.mHorizontalThumb != null) {
                this.mHorizontalThumb.mutate();
            }
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mChanged = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mVerticalTrack != null) {
            this.mVerticalTrack.setAlpha(i);
        }
        if (this.mVerticalThumb != null) {
            this.mVerticalThumb.setAlpha(i);
        }
        if (this.mHorizontalTrack != null) {
            this.mHorizontalTrack.setAlpha(i);
        }
        if (this.mHorizontalThumb != null) {
            this.mHorizontalThumb.setAlpha(i);
        }
    }

    public void setAlwaysDrawHorizontalTrack(boolean z) {
        this.mAlwaysDrawHorizontalTrack = z;
    }

    public void setAlwaysDrawVerticalTrack(boolean z) {
        this.mAlwaysDrawVerticalTrack = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mVerticalTrack != null) {
            this.mVerticalTrack.setColorFilter(colorFilter);
        }
        if (this.mVerticalThumb != null) {
            this.mVerticalThumb.setColorFilter(colorFilter);
        }
        if (this.mHorizontalTrack != null) {
            this.mHorizontalTrack.setColorFilter(colorFilter);
        }
        if (this.mHorizontalThumb != null) {
            this.mHorizontalThumb.setColorFilter(colorFilter);
        }
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        if (drawable != null) {
            if (this.mMutated) {
                drawable.mutate();
            }
            drawable.setState(STATE_ENABLED);
            this.mHorizontalThumb = drawable;
        }
    }

    public void setHorizontalTrackDrawable(Drawable drawable) {
        if (drawable != null) {
            if (this.mMutated) {
                drawable.mutate();
            }
            drawable.setState(STATE_ENABLED);
        }
        this.mHorizontalTrack = drawable;
    }

    public void setParameters(int i, int i2, int i3, boolean z) {
        if (this.mVertical != z) {
            this.mChanged = true;
        }
        if (this.mRange != i || this.mOffset != i2 || this.mExtent != i3) {
            this.mRangeChanged = true;
        }
        this.mRange = i;
        this.mOffset = i2;
        this.mExtent = i3;
        this.mVertical = z;
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        if (drawable != null) {
            if (this.mMutated) {
                drawable.mutate();
            }
            drawable.setState(STATE_ENABLED);
            this.mVerticalThumb = drawable;
        }
    }

    public void setVerticalTrackDrawable(Drawable drawable) {
        if (drawable != null) {
            if (this.mMutated) {
                drawable.mutate();
            }
            drawable.setState(STATE_ENABLED);
        }
        this.mVerticalTrack = drawable;
    }

    public String toString() {
        return "ScrollBarDrawable: range=" + this.mRange + " offset=" + this.mOffset + " extent=" + this.mExtent + (this.mVertical ? " V" : " H");
    }
}
