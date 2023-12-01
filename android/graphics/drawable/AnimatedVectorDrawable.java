package android.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/AnimatedVectorDrawable.class */
public class AnimatedVectorDrawable extends Drawable implements Animatable {
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = AnimatedVectorDrawable.class.getSimpleName();
    private static final String TARGET = "target";
    private AnimatedVectorDrawableState mAnimatedVectorState;
    private final Drawable.Callback mCallback;
    private boolean mMutated;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/AnimatedVectorDrawable$AnimatedVectorDrawableState.class */
    public static class AnimatedVectorDrawableState extends Drawable.ConstantState {
        ArrayList<Animator> mAnimators;
        int mChangingConfigurations;
        ArrayMap<Animator, String> mTargetNameMap;
        VectorDrawable mVectorDrawable;

        public AnimatedVectorDrawableState(AnimatedVectorDrawableState animatedVectorDrawableState, Drawable.Callback callback, Resources resources) {
            if (animatedVectorDrawableState == null) {
                this.mVectorDrawable = new VectorDrawable();
                return;
            }
            this.mChangingConfigurations = animatedVectorDrawableState.mChangingConfigurations;
            if (animatedVectorDrawableState.mVectorDrawable != null) {
                Drawable.ConstantState constantState = animatedVectorDrawableState.mVectorDrawable.getConstantState();
                if (resources != null) {
                    this.mVectorDrawable = (VectorDrawable) constantState.newDrawable(resources);
                } else {
                    this.mVectorDrawable = (VectorDrawable) constantState.newDrawable();
                }
                this.mVectorDrawable = (VectorDrawable) this.mVectorDrawable.mutate();
                this.mVectorDrawable.setCallback(callback);
                this.mVectorDrawable.setLayoutDirection(animatedVectorDrawableState.mVectorDrawable.getLayoutDirection());
                this.mVectorDrawable.setBounds(animatedVectorDrawableState.mVectorDrawable.getBounds());
                this.mVectorDrawable.setAllowCaching(false);
            }
            if (animatedVectorDrawableState.mAnimators == null) {
                return;
            }
            int size = animatedVectorDrawableState.mAnimators.size();
            this.mAnimators = new ArrayList<>(size);
            this.mTargetNameMap = new ArrayMap<>(size);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                Animator animator = animatedVectorDrawableState.mAnimators.get(i2);
                Animator mo53clone = animator.mo53clone();
                String str = animatedVectorDrawableState.mTargetNameMap.get(animator);
                mo53clone.setTarget(this.mVectorDrawable.getTargetByName(str));
                this.mAnimators.add(mo53clone);
                this.mTargetNameMap.put(mo53clone, str);
                i = i2 + 1;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return (this.mVectorDrawable != null && this.mVectorDrawable.canApplyTheme()) || super.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimatedVectorDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new AnimatedVectorDrawable(this, resources);
        }
    }

    public AnimatedVectorDrawable() {
        this(null, null);
    }

    private AnimatedVectorDrawable(AnimatedVectorDrawableState animatedVectorDrawableState, Resources resources) {
        this.mCallback = new Drawable.Callback() { // from class: android.graphics.drawable.AnimatedVectorDrawable.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawable.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                AnimatedVectorDrawable.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawable.this.unscheduleSelf(runnable);
            }
        };
        this.mAnimatedVectorState = new AnimatedVectorDrawableState(animatedVectorDrawableState, this.mCallback, resources);
    }

    private boolean isStarted() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (arrayList.get(i2).isStarted()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private void setupAnimatorsForTarget(String str, Animator animator) {
        animator.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(str));
        if (this.mAnimatedVectorState.mAnimators == null) {
            this.mAnimatedVectorState.mAnimators = new ArrayList<>();
            this.mAnimatedVectorState.mTargetNameMap = new ArrayMap<>();
        }
        this.mAnimatedVectorState.mAnimators.add(animator);
        this.mAnimatedVectorState.mTargetNameMap.put(animator, str);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        VectorDrawable vectorDrawable = this.mAnimatedVectorState.mVectorDrawable;
        if (vectorDrawable == null || !vectorDrawable.canApplyTheme()) {
            return;
        }
        vectorDrawable.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return (this.mAnimatedVectorState != null && this.mAnimatedVectorState.canApplyTheme()) || super.canApplyTheme();
    }

    public boolean canReverse() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return true;
            }
            if (!arrayList.get(i2).canReverse()) {
                return false;
            }
            i = i2 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearMutated() {
        super.clearMutated();
        this.mAnimatedVectorState.mVectorDrawable.clearMutated();
        this.mMutated = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mAnimatedVectorState.mVectorDrawable.draw(canvas);
        if (isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        this.mAnimatedVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mAnimatedVectorState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.mAnimatedVectorState.mVectorDrawable.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        float f = 1.0f;
        while (true) {
            float f2 = f;
            if (eventType == 1) {
                return;
            }
            float f3 = f2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (ANIMATED_VECTOR.equals(name)) {
                    TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedVectorDrawable);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawable vectorDrawable = (VectorDrawable) resources.getDrawable(resourceId, theme).mutate();
                        vectorDrawable.setAllowCaching(false);
                        vectorDrawable.setCallback(this.mCallback);
                        f2 = vectorDrawable.getPixelSize();
                        if (this.mAnimatedVectorState.mVectorDrawable != null) {
                            this.mAnimatedVectorState.mVectorDrawable.setCallback(null);
                        }
                        this.mAnimatedVectorState.mVectorDrawable = vectorDrawable;
                    }
                    obtainAttributes.recycle();
                    f3 = f2;
                } else {
                    f3 = f2;
                    if ("target".equals(name)) {
                        TypedArray obtainAttributes2 = obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedVectorDrawableTarget);
                        String string = obtainAttributes2.getString(0);
                        int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                        if (resourceId2 != 0) {
                            setupAnimatorsForTarget(string, AnimatorInflater.loadAnimator(resources, theme, resourceId2, f2));
                        }
                        obtainAttributes2.recycle();
                        f3 = f2;
                    }
                }
            }
            eventType = xmlPullParser.next();
            f = f3;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (arrayList.get(i2).isRunning()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mAnimatedVectorState = new AnimatedVectorDrawableState(this.mAnimatedVectorState, this.mCallback, null);
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return this.mAnimatedVectorState.mVectorDrawable.setState(iArr);
    }

    public void reverse() {
        if (!canReverse()) {
            Log.w(LOGTAG, "AnimatedVectorDrawable can't reverse()");
            return;
        }
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            arrayList.get(i2).reverse();
            i = i2 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.mAnimatedVectorState.mVectorDrawable.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.mAnimatedVectorState.mVectorDrawable.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setLayoutDirection(int i) {
        this.mAnimatedVectorState.mVectorDrawable.setLayoutDirection(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.mAnimatedVectorState.mVectorDrawable.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(mode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.mAnimatedVectorState.mVectorDrawable.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isStarted()) {
            return;
        }
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                invalidateSelf();
                return;
            } else {
                arrayList.get(i2).start();
                i = i2 + 1;
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            arrayList.get(i2).end();
            i = i2 + 1;
        }
    }
}
