package com.blued.community.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/ScalableImageView.class */
public class ScalableImageView extends AppCompatImageView {
    private static final float MIN_POINT_DISTINCT = 10.0f;
    public static final int REBOUND_ENLARGE_ANIMATOR_TIME = 500;
    private static final float REBOUND_ENLARGE_ROTATE = 8.0f;
    private static final String TAG = "ScalableImageView";
    private Matrix cacheMatrix;
    private boolean isCheckLeftRight;
    private boolean isCheckTopBottom;
    private boolean isOutReboundRotateRange;
    private boolean isRebound;
    private Context mContext;
    private float mDegree;
    private PointF mEnd;
    private float mPointDistinct;
    private PointF mStart;
    private Mode mode;
    private Matrix nowMatrix;
    private float rotate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/ScalableImageView$Mode.class */
    public enum Mode {
        NONE,
        DOWN,
        MOVE
    }

    public ScalableImageView(Context context) {
        this(context, null);
    }

    public ScalableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPointDistinct = 1.0f;
        this.rotate = 0.0f;
        this.mStart = new PointF();
        this.mEnd = new PointF();
        this.mContext = context;
        init();
    }

    private void calPoint(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    private float calRotation(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
    }

    private float calSpacing(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private void checkTranslateWithBorder() {
        RectF matrixRectf = getMatrixRectf();
        int width = getWidth();
        int height = getHeight();
        float f = (matrixRectf.top <= 0.0f || !this.isCheckTopBottom) ? 0.0f : -matrixRectf.top;
        float f2 = matrixRectf.bottom;
        float f3 = height;
        float f4 = f;
        if (f2 < f3) {
            f4 = f;
            if (this.isCheckTopBottom) {
                f4 = f3 - matrixRectf.bottom;
            }
        }
        float f5 = 0.0f;
        if (matrixRectf.left > 0.0f) {
            f5 = 0.0f;
            if (this.isCheckLeftRight) {
                f5 = -matrixRectf.left;
            }
        }
        float f6 = matrixRectf.right;
        float f7 = width;
        float f8 = f5;
        if (f6 < f7) {
            f8 = f5;
            if (this.isCheckLeftRight) {
                f8 = f7 - matrixRectf.right;
            }
        }
        this.nowMatrix.postTranslate(f8, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getMatrixRectf() {
        Matrix matrix = this.nowMatrix;
        RectF rectF = new RectF();
        if (getDrawable() != null) {
            rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    private void imageCenter() {
        this.nowMatrix.setRectToRect(new RectF(0.0f, 0.0f, getMatrixRectf().width(), getMatrixRectf().height()), new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight()), Matrix.ScaleToFit.CENTER);
    }

    private void init() {
        this.nowMatrix = new Matrix();
        this.cacheMatrix = new Matrix();
        this.mode = Mode.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTopBottomCenter() {
        return getMatrixRectf().width() / getMatrixRectf().height() > ((float) getMeasuredWidth()) / ((float) getMeasuredHeight());
    }

    private void reboundEnlarge(boolean z) {
        RectF matrixRectf = getMatrixRectf();
        int measuredWidth = (isTopBottomCenter() ? getMeasuredWidth() : getMeasuredHeight()) / 6;
        if (isTopBottomCenter()) {
            if (matrixRectf.width() <= getMeasuredWidth()) {
                if (!z) {
                    float f = matrixRectf.left;
                    float f2 = measuredWidth;
                    if (f < f2 && getMeasuredWidth() - matrixRectf.right <= f2) {
                        return;
                    }
                }
                this.isRebound = true;
                Log.v(TAG, "postScale: " + (getMeasuredWidth() / matrixRectf.width()));
                reboundEnlargeScaleAnimator(matrixRectf.width(), (float) getMeasuredWidth());
                Log.v(TAG, "postTranslate: " + (-getMatrixRectf().left));
                reboundEnlargeTranslateAnimator(0.0f, ((((float) getMeasuredWidth()) - matrixRectf.right) - matrixRectf.left) / 2.0f);
            }
        } else if (matrixRectf.height() <= getMeasuredHeight()) {
            if (!z) {
                float f3 = matrixRectf.top;
                float f4 = measuredWidth;
                if (f3 < f4 && getMeasuredHeight() - matrixRectf.bottom <= f4) {
                    return;
                }
            }
            this.isRebound = true;
            Log.v(TAG, "postScale: " + (getMeasuredHeight() / matrixRectf.height()));
            reboundEnlargeScaleAnimator(matrixRectf.height(), (float) getMeasuredHeight());
            Log.v(TAG, "postTranslate: " + (-getMatrixRectf().top));
            reboundEnlargeTranslateAnimator(0.0f, ((((float) getMeasuredHeight()) - matrixRectf.bottom) - matrixRectf.top) / 2.0f);
        }
    }

    private void reboundEnlargeScaleAnimator(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(500L).start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.ScalableImageView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!ScalableImageView.this.isRebound) {
                    valueAnimator.cancel();
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Log.i(ScalableImageView.TAG, "ScaleValues: " + floatValue);
                float width = floatValue / (ScalableImageView.this.isTopBottomCenter() ? ScalableImageView.this.getMatrixRectf().width() : ScalableImageView.this.getMatrixRectf().height());
                ScalableImageView.this.nowMatrix.postScale(width, width, ScalableImageView.this.getMeasuredWidth() / 2, ScalableImageView.this.getMeasuredHeight() / 2);
                ScalableImageView scalableImageView = ScalableImageView.this;
                scalableImageView.setImageMatrix(scalableImageView.nowMatrix);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.blued.community.view.ScalableImageView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ScalableImageView.this.cacheMatrix.set(ScalableImageView.this.nowMatrix);
                ScalableImageView.this.isRebound = false;
            }
        });
    }

    private void reboundEnlargeTranslateAnimator(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(500L).start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.ScalableImageView.3
            float beforeValues = 0.0f;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!ScalableImageView.this.isRebound) {
                    valueAnimator.cancel();
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Log.i(ScalableImageView.TAG, "TranslateValues: " + floatValue);
                float f3 = floatValue - this.beforeValues;
                if (ScalableImageView.this.isTopBottomCenter()) {
                    ScalableImageView.this.nowMatrix.postTranslate(f3, 0.0f);
                } else {
                    ScalableImageView.this.nowMatrix.postTranslate(0.0f, f3);
                }
                ScalableImageView scalableImageView = ScalableImageView.this;
                scalableImageView.setImageMatrix(scalableImageView.nowMatrix);
                this.beforeValues += f3;
            }
        });
    }

    private void scaleWithBorder(MotionEvent motionEvent) {
        float calSpacing = calSpacing(motionEvent);
        float f = calSpacing / this.mPointDistinct;
        Log.v(TAG, "move: " + calSpacing);
        if (calSpacing > 10.0f) {
            this.nowMatrix.postScale(f, f, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        }
        RectF matrixRectf = getMatrixRectf();
        if (isTopBottomCenter()) {
            if (f < 1.0f) {
                if (matrixRectf.width() < getMeasuredWidth()) {
                    this.nowMatrix.postTranslate(((getMeasuredWidth() - matrixRectf.right) - matrixRectf.left) / 2.0f, 0.0f);
                } else if (matrixRectf.left >= 0.0f && matrixRectf.right - getMeasuredWidth() > 0.0f) {
                    Log.v(TAG, "postTranslate: " + (-matrixRectf.left));
                    this.nowMatrix.postTranslate(-matrixRectf.left, 0.0f);
                } else if (matrixRectf.right - getMeasuredWidth() > 0.0f || matrixRectf.left >= 0.0f) {
                } else {
                    Log.v(TAG, "postTranslate: " + (getMeasuredWidth() - matrixRectf.right));
                    this.nowMatrix.postTranslate(((float) getMeasuredWidth()) - matrixRectf.right, 0.0f);
                }
            }
        } else if (f < 1.0f) {
            if (matrixRectf.height() < getMeasuredHeight()) {
                this.nowMatrix.postTranslate(0.0f, ((getMeasuredHeight() - matrixRectf.bottom) - matrixRectf.top) / 2.0f);
            } else if (matrixRectf.top >= 0.0f && matrixRectf.bottom - getMeasuredHeight() > 0.0f) {
                Log.v(TAG, "postTranslate: " + (-matrixRectf.top));
                this.nowMatrix.postTranslate(0.0f, -matrixRectf.top);
            } else if (matrixRectf.bottom - getMeasuredHeight() > 0.0f || matrixRectf.top >= 0.0f) {
            } else {
                Log.v(TAG, "postTranslate: " + (getMeasuredHeight() - matrixRectf.bottom));
                this.nowMatrix.postTranslate(0.0f, ((float) getMeasuredHeight()) - matrixRectf.bottom);
            }
        }
    }

    private void translateWithBorder() {
        RectF matrixRectf = getMatrixRectf();
        if (isTopBottomCenter()) {
            if (matrixRectf.top >= 0.0f) {
                this.nowMatrix.postTranslate(0.0f, -matrixRectf.top);
            } else if (matrixRectf.bottom - getMeasuredHeight() <= 0.0f) {
                this.nowMatrix.postTranslate(0.0f, getMeasuredHeight() - matrixRectf.bottom);
            }
        } else if (matrixRectf.left >= 0.0f) {
            this.nowMatrix.postTranslate(-matrixRectf.left, 0.0f);
        } else if (matrixRectf.right - getMeasuredWidth() <= 0.0f) {
            this.nowMatrix.postTranslate(getMeasuredWidth() - matrixRectf.right, 0.0f);
        }
    }

    private void translateWithCenter() {
        RectF matrixRectf = getMatrixRectf();
        if (isTopBottomCenter()) {
            if (matrixRectf.top > 0.0f || matrixRectf.bottom - getMeasuredHeight() < 0.0f) {
                this.nowMatrix.postTranslate(0.0f, ((getMeasuredHeight() - matrixRectf.bottom) - matrixRectf.top) / 2.0f);
            }
        } else if (matrixRectf.left > 0.0f || matrixRectf.right - getMeasuredWidth() < 0.0f) {
            this.nowMatrix.postTranslate(((getMeasuredWidth() - matrixRectf.right) - matrixRectf.left) / 2.0f, 0.0f);
        }
    }

    public Matrix getNowMatrix() {
        return this.nowMatrix;
    }

    public boolean isImageMax() {
        RectF matrixRectf = getMatrixRectf();
        return matrixRectf.width() > ((float) (getMeasuredWidth() * 2)) && matrixRectf.height() > ((float) (getMeasuredHeight() * 2));
    }

    public boolean isImageMix() {
        RectF matrixRectf = getMatrixRectf();
        return matrixRectf.width() <= ((float) getMeasuredWidth()) && matrixRectf.height() <= ((float) getMeasuredHeight());
    }

    public void loadImageFromLocal(IRequestHost iRequestHost, String str) {
        ImageLoader.d(iRequestHost, str).e().a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r0 != 6) goto L18;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.view.ScalableImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postRotate(float f) {
        this.nowMatrix.postRotate(f, getPivotX(), getPivotY());
        setImageMatrix(this.nowMatrix);
    }

    public void postScale(float f) {
        this.nowMatrix.postScale(f, f, getPivotX(), getPivotY());
        setImageMatrix(this.nowMatrix);
        reboundEnlarge(true);
    }

    public void resetImage() {
        this.nowMatrix.reset();
        this.cacheMatrix.reset();
        imageCenter();
        setImageMatrix(this.nowMatrix);
        invalidate();
    }

    public void setNowMatrix(Matrix matrix) {
        this.nowMatrix = matrix;
        this.cacheMatrix.set(matrix);
        setImageMatrix(matrix);
    }
}
