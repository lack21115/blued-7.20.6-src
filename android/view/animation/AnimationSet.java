package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/AnimationSet.class */
public class AnimationSet extends Animation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private ArrayList<Animation> mAnimations;
    private boolean mDirty;
    private int mFlags;
    private boolean mHasAlpha;
    private long mLastEnd;
    private long[] mStoredOffsets;
    private Transformation mTempTransformation;

    public AnimationSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlags = 0;
        this.mAnimations = new ArrayList<>();
        this.mTempTransformation = new Transformation();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AnimationSet);
        setFlag(16, obtainStyledAttributes.getBoolean(1, true));
        init();
        if (context.getApplicationInfo().targetSdkVersion >= 14) {
            if (obtainStyledAttributes.hasValue(0)) {
                this.mFlags |= 32;
            }
            if (obtainStyledAttributes.hasValue(2)) {
                this.mFlags |= 2;
            }
            if (obtainStyledAttributes.hasValue(3)) {
                this.mFlags |= 1;
            }
            if (obtainStyledAttributes.hasValue(5)) {
                this.mFlags |= 4;
            }
            if (obtainStyledAttributes.hasValue(4)) {
                this.mFlags |= 8;
            }
        }
        obtainStyledAttributes.recycle();
    }

    public AnimationSet(boolean z) {
        this.mFlags = 0;
        this.mAnimations = new ArrayList<>();
        this.mTempTransformation = new Transformation();
        setFlag(16, z);
        init();
    }

    private void init() {
        this.mStartTime = 0L;
    }

    private void setFlag(int i, boolean z) {
        if (z) {
            this.mFlags |= i;
        } else {
            this.mFlags &= i ^ (-1);
        }
    }

    public void addAnimation(Animation animation) {
        this.mAnimations.add(animation);
        if (((this.mFlags & 64) == 0) && animation.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        boolean z = false;
        if ((this.mFlags & 128) == 0) {
            z = true;
        }
        if (z && animation.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) == 32) {
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else if (this.mAnimations.size() == 1) {
            this.mDuration = animation.getStartOffset() + animation.getDuration();
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else {
            this.mLastEnd = Math.max(this.mLastEnd, animation.getStartOffset() + animation.getDuration());
            this.mDuration = this.mLastEnd - this.mStartOffset;
        }
        this.mDirty = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.Animation
    /* renamed from: clone */
    public AnimationSet mo1105clone() throws CloneNotSupportedException {
        AnimationSet animationSet = (AnimationSet) super.mo1105clone();
        animationSet.mTempTransformation = new Transformation();
        animationSet.mAnimations = new ArrayList<>();
        int size = this.mAnimations.size();
        ArrayList<Animation> arrayList = this.mAnimations;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return animationSet;
            }
            animationSet.mAnimations.add(arrayList.get(i2).mo1105clone());
            i = i2 + 1;
        }
    }

    @Override // android.view.animation.Animation
    public long computeDurationHint() {
        long j = 0;
        int size = this.mAnimations.size();
        ArrayList<Animation> arrayList = this.mAnimations;
        int i = size - 1;
        while (i >= 0) {
            long computeDurationHint = arrayList.get(i).computeDurationHint();
            long j2 = j;
            if (computeDurationHint > j) {
                j2 = computeDurationHint;
            }
            i--;
            j = j2;
        }
        return j;
    }

    public List<Animation> getAnimations() {
        return this.mAnimations;
    }

    @Override // android.view.animation.Animation
    public long getDuration() {
        long j;
        ArrayList<Animation> arrayList = this.mAnimations;
        int size = arrayList.size();
        long j2 = 0;
        if (!((this.mFlags & 32) == 32)) {
            int i = 0;
            while (true) {
                int i2 = i;
                j = j2;
                if (i2 >= size) {
                    break;
                }
                j2 = Math.max(j2, arrayList.get(i2).getDuration());
                i = i2 + 1;
            }
        } else {
            j = this.mDuration;
        }
        return j;
    }

    @Override // android.view.animation.Animation
    public long getStartTime() {
        long j = Long.MAX_VALUE;
        int size = this.mAnimations.size();
        ArrayList<Animation> arrayList = this.mAnimations;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return j;
            }
            j = Math.min(j, arrayList.get(i2).getStartTime());
            i = i2 + 1;
        }
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        int size = this.mAnimations.size();
        ArrayList<Animation> arrayList = this.mAnimations;
        Transformation transformation2 = this.mTempTransformation;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        transformation.clear();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            Animation animation = arrayList.get(size);
            transformation2.clear();
            z = animation.getTransformation(j, transformation2, getScaleFactor()) || z;
            transformation.compose(transformation2);
            z2 = z2 || animation.hasStarted();
            z3 = animation.hasEnded() && z3;
        }
        if (z2 && !this.mStarted) {
            if (this.mListener != null) {
                this.mListener.onAnimationStart(this);
            }
            this.mStarted = true;
        }
        if (z3 != this.mEnded) {
            if (this.mListener != null) {
                this.mListener.onAnimationEnd(this);
            }
            this.mEnded = z3;
        }
        return z;
    }

    @Override // android.view.animation.Animation
    public boolean hasAlpha() {
        if (this.mDirty) {
            this.mHasAlpha = false;
            this.mDirty = false;
            int size = this.mAnimations.size();
            ArrayList<Animation> arrayList = this.mAnimations;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                } else if (arrayList.get(i2).hasAlpha()) {
                    this.mHasAlpha = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
        }
        return this.mHasAlpha;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b0, code lost:
        if (r0.length != r0) goto L55;
     */
    @Override // android.view.animation.Animation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initialize(int r7, int r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.animation.AnimationSet.initialize(int, int, int, int):void");
    }

    @Override // android.view.animation.Animation
    public void initializeInvalidateRegion(int i, int i2, int i3, int i4) {
        RectF rectF = this.mPreviousRegion;
        rectF.set(i, i2, i3, i4);
        rectF.inset(-1.0f, -1.0f);
        if (!this.mFillBefore) {
            return;
        }
        int size = this.mAnimations.size();
        ArrayList<Animation> arrayList = this.mAnimations;
        Transformation transformation = this.mTempTransformation;
        Transformation transformation2 = this.mPreviousTransformation;
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            Animation animation = arrayList.get(size);
            if (!animation.isFillEnabled() || animation.getFillBefore() || animation.getStartOffset() == 0) {
                transformation.clear();
                Interpolator interpolator = animation.mInterpolator;
                animation.applyTransformation(interpolator != null ? interpolator.getInterpolation(0.0f) : 0.0f, transformation);
                transformation2.compose(transformation);
            }
        }
    }

    @Override // android.view.animation.Animation
    public void reset() {
        super.reset();
        restoreChildrenStartOffset();
    }

    void restoreChildrenStartOffset() {
        long[] jArr = this.mStoredOffsets;
        if (jArr == null) {
            return;
        }
        ArrayList<Animation> arrayList = this.mAnimations;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            arrayList.get(i2).setStartOffset(jArr[i2]);
            i = i2 + 1;
        }
    }

    @Override // android.view.animation.Animation
    public void restrictDuration(long j) {
        super.restrictDuration(j);
        ArrayList<Animation> arrayList = this.mAnimations;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            arrayList.get(i2).restrictDuration(j);
            i = i2 + 1;
        }
    }

    @Override // android.view.animation.Animation
    public void scaleCurrentDuration(float f) {
        ArrayList<Animation> arrayList = this.mAnimations;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            arrayList.get(i2).scaleCurrentDuration(f);
            i = i2 + 1;
        }
    }

    @Override // android.view.animation.Animation
    public void setDuration(long j) {
        this.mFlags |= 32;
        super.setDuration(j);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    @Override // android.view.animation.Animation
    public void setFillAfter(boolean z) {
        this.mFlags |= 1;
        super.setFillAfter(z);
    }

    @Override // android.view.animation.Animation
    public void setFillBefore(boolean z) {
        this.mFlags |= 2;
        super.setFillBefore(z);
    }

    @Override // android.view.animation.Animation
    public void setRepeatMode(int i) {
        this.mFlags |= 4;
        super.setRepeatMode(i);
    }

    @Override // android.view.animation.Animation
    public void setStartOffset(long j) {
        this.mFlags |= 8;
        super.setStartOffset(j);
    }

    @Override // android.view.animation.Animation
    public void setStartTime(long j) {
        super.setStartTime(j);
        int size = this.mAnimations.size();
        ArrayList<Animation> arrayList = this.mAnimations;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            arrayList.get(i2).setStartTime(j);
            i = i2 + 1;
        }
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    @Override // android.view.animation.Animation
    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }
}
