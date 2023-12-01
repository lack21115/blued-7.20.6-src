package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import com.android.internal.R;
import java.util.Random;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/GridLayoutAnimationController.class */
public class GridLayoutAnimationController extends LayoutAnimationController {
    public static final int DIRECTION_BOTTOM_TO_TOP = 2;
    public static final int DIRECTION_HORIZONTAL_MASK = 1;
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int DIRECTION_TOP_TO_BOTTOM = 0;
    public static final int DIRECTION_VERTICAL_MASK = 2;
    public static final int PRIORITY_COLUMN = 1;
    public static final int PRIORITY_NONE = 0;
    public static final int PRIORITY_ROW = 2;
    private float mColumnDelay;
    private int mDirection;
    private int mDirectionPriority;
    private float mRowDelay;

    /* loaded from: source-4181928-dex2jar.jar:android/view/animation/GridLayoutAnimationController$AnimationParameters.class */
    public static class AnimationParameters extends LayoutAnimationController.AnimationParameters {
        public int column;
        public int columnsCount;
        public int row;
        public int rowsCount;
    }

    public GridLayoutAnimationController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayoutAnimation);
        this.mColumnDelay = Animation.Description.parseValue(obtainStyledAttributes.peekValue(0)).value;
        this.mRowDelay = Animation.Description.parseValue(obtainStyledAttributes.peekValue(1)).value;
        this.mDirection = obtainStyledAttributes.getInt(2, 0);
        this.mDirectionPriority = obtainStyledAttributes.getInt(3, 0);
        obtainStyledAttributes.recycle();
    }

    public GridLayoutAnimationController(Animation animation) {
        this(animation, 0.5f, 0.5f);
    }

    public GridLayoutAnimationController(Animation animation, float f, float f2) {
        super(animation);
        this.mColumnDelay = f;
        this.mRowDelay = f2;
    }

    private int getTransformedColumnIndex(AnimationParameters animationParameters) {
        int nextFloat;
        switch (getOrder()) {
            case 1:
                nextFloat = (animationParameters.columnsCount - 1) - animationParameters.column;
                break;
            case 2:
                if (this.mRandomizer == null) {
                    this.mRandomizer = new Random();
                }
                nextFloat = (int) (animationParameters.columnsCount * this.mRandomizer.nextFloat());
                break;
            default:
                nextFloat = animationParameters.column;
                break;
        }
        int i = nextFloat;
        if ((this.mDirection & 1) == 1) {
            i = (animationParameters.columnsCount - 1) - nextFloat;
        }
        return i;
    }

    private int getTransformedRowIndex(AnimationParameters animationParameters) {
        int nextFloat;
        switch (getOrder()) {
            case 1:
                nextFloat = (animationParameters.rowsCount - 1) - animationParameters.row;
                break;
            case 2:
                if (this.mRandomizer == null) {
                    this.mRandomizer = new Random();
                }
                nextFloat = (int) (animationParameters.rowsCount * this.mRandomizer.nextFloat());
                break;
            default:
                nextFloat = animationParameters.row;
                break;
        }
        int i = nextFloat;
        if ((this.mDirection & 2) == 2) {
            i = (animationParameters.rowsCount - 1) - nextFloat;
        }
        return i;
    }

    public float getColumnDelay() {
        return this.mColumnDelay;
    }

    @Override // android.view.animation.LayoutAnimationController
    protected long getDelayForView(View view) {
        long j;
        float f;
        AnimationParameters animationParameters = (AnimationParameters) view.getLayoutParams().layoutAnimationParameters;
        if (animationParameters == null) {
            return 0L;
        }
        int transformedColumnIndex = getTransformedColumnIndex(animationParameters);
        int transformedRowIndex = getTransformedRowIndex(animationParameters);
        int i = animationParameters.rowsCount;
        int i2 = animationParameters.columnsCount;
        long duration = this.mAnimation.getDuration();
        float f2 = this.mColumnDelay * ((float) duration);
        float f3 = this.mRowDelay * ((float) duration);
        if (this.mInterpolator == null) {
            this.mInterpolator = new LinearInterpolator();
        }
        switch (this.mDirectionPriority) {
            case 1:
                j = (transformedRowIndex * f3) + (transformedColumnIndex * i * f3);
                f = (i * f3) + (i2 * i * f3);
                break;
            case 2:
                j = (transformedColumnIndex * f2) + (transformedRowIndex * i2 * f2);
                f = (i2 * f2) + (i * i2 * f2);
                break;
            default:
                j = (transformedColumnIndex * f2) + (transformedRowIndex * f3);
                f = (i2 * f2) + (i * f3);
                break;
        }
        return this.mInterpolator.getInterpolation(((float) j) / f) * f;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public int getDirectionPriority() {
        return this.mDirectionPriority;
    }

    public float getRowDelay() {
        return this.mRowDelay;
    }

    public void setColumnDelay(float f) {
        this.mColumnDelay = f;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    public void setDirectionPriority(int i) {
        this.mDirectionPriority = i;
    }

    public void setRowDelay(float f) {
        this.mRowDelay = f;
    }

    @Override // android.view.animation.LayoutAnimationController
    public boolean willOverlap() {
        return this.mColumnDelay < 1.0f || this.mRowDelay < 1.0f;
    }
}
