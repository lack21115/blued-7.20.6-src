package android.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* loaded from: source-9557208-dex2jar.jar:android/transition/TransitionUtils.class */
public class TransitionUtils {
    private static int MAX_IMAGE_SIZE = 1048576;

    /* loaded from: source-9557208-dex2jar.jar:android/transition/TransitionUtils$MatrixEvaluator.class */
    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        float[] mTempStartValues = new float[9];
        float[] mTempEndValues = new float[9];
        Matrix mTempMatrix = new Matrix();

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.mTempStartValues);
            matrix2.getValues(this.mTempEndValues);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 9) {
                    this.mTempMatrix.setValues(this.mTempEndValues);
                    return this.mTempMatrix;
                }
                this.mTempEndValues[i2] = this.mTempStartValues[i2] + (f * (this.mTempEndValues[i2] - this.mTempStartValues[i2]));
                i = i2 + 1;
            }
        }
    }

    public static View copyViewImage(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        view.transformMatrixToGlobal(matrix);
        viewGroup.transformMatrixToLocal(matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap createViewBitmap = createViewBitmap(view, matrix, rectF);
        if (createViewBitmap != null) {
            imageView.setImageBitmap(createViewBitmap);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    public static Bitmap createDrawableBitmap(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        float min = Math.min(1.0f, MAX_IMAGE_SIZE / (intrinsicWidth * intrinsicHeight));
        if ((drawable instanceof BitmapDrawable) && min == 1.0f) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int i = (int) (intrinsicWidth * min);
        int i2 = (int) (intrinsicHeight * min);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect bounds = drawable.getBounds();
        int i3 = bounds.left;
        int i4 = bounds.top;
        int i5 = bounds.right;
        int i6 = bounds.bottom;
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(canvas);
        drawable.setBounds(i3, i4, i5, i6);
        return createBitmap;
    }

    public static Bitmap createViewBitmap(View view, Matrix matrix, RectF rectF) {
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Bitmap bitmap = null;
        if (round > 0) {
            bitmap = null;
            if (round2 > 0) {
                float min = Math.min(1.0f, MAX_IMAGE_SIZE / (round * round2));
                matrix.postTranslate(-rectF.left, -rectF.top);
                matrix.postScale(min, min);
                bitmap = Bitmap.createBitmap((int) (round * min), (int) (round2 * min), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Animator mergeAnimators(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }

    public static Transition mergeTransitions(Transition... transitionArr) {
        TransitionSet transitionSet;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        while (i3 < transitionArr.length) {
            int i4 = i;
            if (transitionArr[i3] != null) {
                i4 = i + 1;
                i2 = i3;
            }
            i3++;
            i = i4;
        }
        if (i != 0) {
            if (i != 1) {
                TransitionSet transitionSet2 = new TransitionSet();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    transitionSet = transitionSet2;
                    if (i6 >= transitionArr.length) {
                        break;
                    }
                    if (transitionArr[i6] != null) {
                        transitionSet2.addTransition(transitionArr[i6]);
                    }
                    i5 = i6 + 1;
                }
            } else {
                return transitionArr[i2];
            }
        } else {
            transitionSet = null;
        }
        return transitionSet;
    }
}
