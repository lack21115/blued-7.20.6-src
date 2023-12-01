package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/transition/TransitionUtils.class */
public class TransitionUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f3483a;
    private static final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f3484c;

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/TransitionUtils$MatrixEvaluator.class */
    static class MatrixEvaluator implements TypeEvaluator<Matrix> {

        /* renamed from: a  reason: collision with root package name */
        final float[] f3485a = new float[9];
        final float[] b = new float[9];

        /* renamed from: c  reason: collision with root package name */
        final Matrix f3486c = new Matrix();

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f3485a);
            matrix2.getValues(this.b);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 9) {
                    this.f3486c.setValues(this.b);
                    return this.f3486c;
                }
                float[] fArr = this.b;
                float f2 = fArr[i2];
                float[] fArr2 = this.f3485a;
                fArr[i2] = fArr2[i2] + ((f2 - fArr2[i2]) * f);
                i = i2 + 1;
            }
        }
    }

    static {
        f3483a = Build.VERSION.SDK_INT >= 19;
        b = Build.VERSION.SDK_INT >= 18;
        f3484c = Build.VERSION.SDK_INT >= 28;
    }

    private TransitionUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Animator a(Animator animator, Animator animator2) {
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(android.view.View r5, android.graphics.Matrix r6, android.graphics.RectF r7, android.view.ViewGroup r8) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionUtils.a(android.view.View, android.graphics.Matrix, android.graphics.RectF, android.view.ViewGroup):android.graphics.Bitmap");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        ViewUtils.a(view, matrix);
        ViewUtils.b(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap a2 = a(view, matrix, rectF, viewGroup);
        if (a2 != null) {
            imageView.setImageBitmap(a2);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }
}
