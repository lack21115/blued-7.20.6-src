package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ReactiveGuide.class */
public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {

    /* renamed from: a  reason: collision with root package name */
    private int f2234a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f2235c;
    private boolean d;

    public ReactiveGuide(Context context) {
        super(context);
        this.f2234a = -1;
        this.b = false;
        this.f2235c = 0;
        this.d = true;
        super.setVisibility(8);
        a(null);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2234a = -1;
        this.b = false;
        this.f2235c = 0;
        this.d = true;
        super.setVisibility(8);
        a(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2234a = -1;
        this.b = false;
        this.f2235c = 0;
        this.d = true;
        super.setVisibility(8);
        a(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f2234a = -1;
        this.b = false;
        this.f2235c = 0;
        this.d = true;
        super.setVisibility(8);
        a(attributeSet);
    }

    private void a(int i, int i2, MotionLayout motionLayout, int i3) {
        ConstraintSet constraintSet = motionLayout.getConstraintSet(i3);
        constraintSet.setGuidelineEnd(i2, i);
        motionLayout.updateState(i3, constraintSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    break;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f2234a = obtainStyledAttributes.getResourceId(index, this.f2234a);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.b = obtainStyledAttributes.getBoolean(index, this.b);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.f2235c = obtainStyledAttributes.getResourceId(index, this.f2235c);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.d = obtainStyledAttributes.getBoolean(index, this.d);
                }
                i = i2 + 1;
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f2234a != -1) {
            ConstraintLayout.getSharedValues().addListener(this.f2234a, this);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f2235c;
    }

    public int getAttributeId() {
        return this.f2234a;
    }

    public boolean isAnimatingChange() {
        return this.b;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
    public void onNewValue(int i, int i2, int i3) {
        int[] constraintSetIds;
        setGuidelineBegin(i2);
        int id = getId();
        if (id <= 0 || !(getParent() instanceof MotionLayout)) {
            return;
        }
        MotionLayout motionLayout = (MotionLayout) getParent();
        int currentState = motionLayout.getCurrentState();
        int i4 = this.f2235c;
        if (i4 != 0) {
            currentState = i4;
        }
        if (this.b) {
            if (this.d) {
                for (int i5 : motionLayout.getConstraintSetIds()) {
                    if (i5 != currentState) {
                        a(i2, id, motionLayout, i5);
                    }
                }
            }
            ConstraintSet cloneConstraintSet = motionLayout.cloneConstraintSet(currentState);
            cloneConstraintSet.setGuidelineEnd(id, i2);
            motionLayout.updateStateAnimate(currentState, cloneConstraintSet, 1000);
        } else if (!this.d) {
            a(i2, id, motionLayout, currentState);
        } else {
            int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= constraintSetIds2.length) {
                    return;
                }
                a(i2, id, motionLayout, constraintSetIds2[i7]);
                i6 = i7 + 1;
            }
        }
    }

    public void setAnimateChange(boolean z) {
        this.b = z;
    }

    public void setApplyToConstraintSetId(int i) {
        this.f2235c = i;
    }

    public void setAttributeId(int i) {
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i2 = this.f2234a;
        if (i2 != -1) {
            sharedValues.removeListener(i2, this);
        }
        this.f2234a = i;
        if (i != -1) {
            sharedValues.addListener(i, this);
        }
    }

    public void setGuidelineBegin(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideBegin = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideEnd = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guidePercent = f;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }
}
