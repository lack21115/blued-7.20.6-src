package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ChangeTransform.class */
public class ChangeTransform extends Transition {
    private static final String[] b = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* renamed from: c  reason: collision with root package name */
    private static final Property<PathAnimatorMatrix, float[]> f3427c = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") { // from class: androidx.transition.ChangeTransform.1
        @Override // android.util.Property
        public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.a(fArr);
        }
    };
    private static final Property<PathAnimatorMatrix, PointF> d = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") { // from class: androidx.transition.ChangeTransform.2
        @Override // android.util.Property
        public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            pathAnimatorMatrix.a(pointF);
        }
    };
    private static final boolean e;

    /* renamed from: a  reason: collision with root package name */
    boolean f3428a;
    private boolean f;
    private Matrix g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/ChangeTransform$GhostListener.class */
    public static class GhostListener extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private View f3431a;
        private GhostView b;

        GhostListener(View view, GhostView ghostView) {
            this.f3431a = view;
            this.b = ghostView;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            GhostViewUtils.a(this.f3431a);
            this.f3431a.setTag(R.id.transition_transform, null);
            this.f3431a.setTag(R.id.parent_matrix, null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            this.b.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            this.b.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/ChangeTransform$PathAnimatorMatrix.class */
    public static class PathAnimatorMatrix {

        /* renamed from: a  reason: collision with root package name */
        private final Matrix f3432a = new Matrix();
        private final View b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f3433c;
        private float d;
        private float e;

        PathAnimatorMatrix(View view, float[] fArr) {
            this.b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f3433c = fArr2;
            this.d = fArr2[2];
            this.e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f3433c;
            fArr[2] = this.d;
            fArr[5] = this.e;
            this.f3432a.setValues(fArr);
            ViewUtils.c(this.b, this.f3432a);
        }

        Matrix a() {
            return this.f3432a;
        }

        void a(PointF pointF) {
            this.d = pointF.x;
            this.e = pointF.y;
            b();
        }

        void a(float[] fArr) {
            System.arraycopy((Object) fArr, 0, (Object) this.f3433c, 0, fArr.length);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/ChangeTransform$Transforms.class */
    public static class Transforms {

        /* renamed from: a  reason: collision with root package name */
        final float f3434a;
        final float b;

        /* renamed from: c  reason: collision with root package name */
        final float f3435c;
        final float d;
        final float e;
        final float f;
        final float g;
        final float h;

        Transforms(View view) {
            this.f3434a = view.getTranslationX();
            this.b = view.getTranslationY();
            this.f3435c = ViewCompat.getTranslationZ(view);
            this.d = view.getScaleX();
            this.e = view.getScaleY();
            this.f = view.getRotationX();
            this.g = view.getRotationY();
            this.h = view.getRotation();
        }

        public boolean equals(Object obj) {
            if (obj instanceof Transforms) {
                Transforms transforms = (Transforms) obj;
                boolean z = false;
                if (transforms.f3434a == this.f3434a) {
                    z = false;
                    if (transforms.b == this.b) {
                        z = false;
                        if (transforms.f3435c == this.f3435c) {
                            z = false;
                            if (transforms.d == this.d) {
                                z = false;
                                if (transforms.e == this.e) {
                                    z = false;
                                    if (transforms.f == this.f) {
                                        z = false;
                                        if (transforms.g == this.g) {
                                            z = false;
                                            if (transforms.h == this.h) {
                                                z = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return z;
            }
            return false;
        }

        public int hashCode() {
            float f = this.f3434a;
            int i = 0;
            int floatToIntBits = f != 0.0f ? Float.floatToIntBits(f) : 0;
            float f2 = this.b;
            int floatToIntBits2 = f2 != 0.0f ? Float.floatToIntBits(f2) : 0;
            float f3 = this.f3435c;
            int floatToIntBits3 = f3 != 0.0f ? Float.floatToIntBits(f3) : 0;
            float f4 = this.d;
            int floatToIntBits4 = f4 != 0.0f ? Float.floatToIntBits(f4) : 0;
            float f5 = this.e;
            int floatToIntBits5 = f5 != 0.0f ? Float.floatToIntBits(f5) : 0;
            float f6 = this.f;
            int floatToIntBits6 = f6 != 0.0f ? Float.floatToIntBits(f6) : 0;
            float f7 = this.g;
            int floatToIntBits7 = f7 != 0.0f ? Float.floatToIntBits(f7) : 0;
            float f8 = this.h;
            if (f8 != 0.0f) {
                i = Float.floatToIntBits(f8);
            }
            return (((((((((((((floatToIntBits * 31) + floatToIntBits2) * 31) + floatToIntBits3) * 31) + floatToIntBits4) * 31) + floatToIntBits5) * 31) + floatToIntBits6) * 31) + floatToIntBits7) * 31) + i;
        }

        public void restore(View view) {
            ChangeTransform.a(view, this.f3434a, this.b, this.f3435c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    static {
        e = Build.VERSION.SDK_INT >= 21;
    }

    public ChangeTransform() {
        this.f3428a = true;
        this.f = true;
        this.g = new Matrix();
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3428a = true;
        this.f = true;
        this.g = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f3428a = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.f = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [float[], java.lang.Object[]] */
    private ObjectAnimator a(TransitionValues transitionValues, TransitionValues transitionValues2, final boolean z) {
        Matrix matrix = (Matrix) transitionValues.values.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) transitionValues2.values.get("android:changeTransform:matrix");
        Matrix matrix3 = matrix;
        if (matrix == null) {
            matrix3 = MatrixUtils.f3456a;
        }
        Matrix matrix4 = matrix2;
        if (matrix2 == null) {
            matrix4 = MatrixUtils.f3456a;
        }
        if (matrix3.equals(matrix4)) {
            return null;
        }
        final Transforms transforms = (Transforms) transitionValues2.values.get("android:changeTransform:transforms");
        final View view = transitionValues2.view;
        a(view);
        float[] fArr = new float[9];
        matrix3.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix4.getValues(fArr2);
        final PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, PropertyValuesHolder.ofObject(f3427c, new FloatArrayEvaluator(new float[9]), (Object[]) new float[]{fArr, fArr2}), PropertyValuesHolderUtils.a(d, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        final Matrix matrix5 = matrix4;
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeTransform.3
            private boolean g;
            private Matrix h = new Matrix();

            private void a(Matrix matrix6) {
                this.h.set(matrix6);
                view.setTag(R.id.transition_transform, this.h);
                transforms.restore(view);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.g = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.g) {
                    if (z && ChangeTransform.this.f3428a) {
                        a(matrix5);
                    } else {
                        view.setTag(R.id.transition_transform, null);
                        view.setTag(R.id.parent_matrix, null);
                    }
                }
                ViewUtils.c(view, null);
                transforms.restore(view);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                a(pathAnimatorMatrix.a());
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator) {
                ChangeTransform.a(view);
            }
        };
        ofPropertyValuesHolder.addListener(animatorListenerAdapter);
        AnimatorUtils.a(ofPropertyValuesHolder, animatorListenerAdapter);
        return ofPropertyValuesHolder;
    }

    static void a(View view) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    static void a(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        ViewCompat.setTranslationZ(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    private void a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Transition transition;
        View view = transitionValues2.view;
        Matrix matrix = new Matrix((Matrix) transitionValues2.values.get("android:changeTransform:parentMatrix"));
        ViewUtils.b(viewGroup, matrix);
        GhostView a2 = GhostViewUtils.a(view, viewGroup, matrix);
        if (a2 == null) {
            return;
        }
        a2.reserveEndViewTransition((ViewGroup) transitionValues.values.get("android:changeTransform:parent"), transitionValues.view);
        Transition transition2 = this;
        while (true) {
            transition = transition2;
            if (transition.mParent == null) {
                break;
            }
            transition2 = transition.mParent;
        }
        transition.addListener(new GhostListener(view, a2));
        if (e) {
            if (transitionValues.view != transitionValues2.view) {
                ViewUtils.a(transitionValues.view, 0.0f);
            }
            ViewUtils.a(view, 1.0f);
        }
    }

    private void a(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        transitionValues.values.put("android:changeTransform:parent", view.getParent());
        transitionValues.values.put("android:changeTransform:transforms", new Transforms(view));
        Matrix matrix = view.getMatrix();
        transitionValues.values.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.f) {
            Matrix matrix2 = new Matrix();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            ViewUtils.a(viewGroup, matrix2);
            matrix2.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            transitionValues.values.put("android:changeTransform:parentMatrix", matrix2);
            transitionValues.values.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
            transitionValues.values.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
        }
    }

    private void a(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix) transitionValues2.values.get("android:changeTransform:parentMatrix");
        transitionValues2.view.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.g;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) transitionValues.values.get("android:changeTransform:matrix");
        Matrix matrix4 = matrix3;
        if (matrix3 == null) {
            matrix4 = new Matrix();
            transitionValues.values.put("android:changeTransform:matrix", matrix4);
        }
        matrix4.postConcat((Matrix) transitionValues.values.get("android:changeTransform:parentMatrix"));
        matrix4.postConcat(matrix2);
    }

    private boolean a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        boolean z = false;
        if (isValidTarget(viewGroup) && isValidTarget(viewGroup2)) {
            TransitionValues matchedTransitionValues = getMatchedTransitionValues(viewGroup, true);
            if (matchedTransitionValues != null) {
                if (viewGroup2 == matchedTransitionValues.view) {
                    z = true;
                }
                z = false;
            }
        } else {
            if (viewGroup == viewGroup2) {
                z = true;
            }
            z = false;
        }
        return z;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues);
        if (e) {
            return;
        }
        ((ViewGroup) transitionValues.view.getParent()).startViewTransition(transitionValues.view);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.values.containsKey("android:changeTransform:parent") || !transitionValues2.values.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) transitionValues.values.get("android:changeTransform:parent");
        boolean z = this.f && !a(viewGroup2, (ViewGroup) transitionValues2.values.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) transitionValues.values.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            transitionValues.values.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) transitionValues.values.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            transitionValues.values.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            a(transitionValues, transitionValues2);
        }
        ObjectAnimator a2 = a(transitionValues, transitionValues2, z);
        if (z && a2 != null && this.f3428a) {
            a(viewGroup, transitionValues, transitionValues2);
            return a2;
        }
        if (!e) {
            viewGroup2.endViewTransition(transitionValues.view);
        }
        return a2;
    }

    public boolean getReparent() {
        return this.f;
    }

    public boolean getReparentWithOverlay() {
        return this.f3428a;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return b;
    }

    public void setReparent(boolean z) {
        this.f = z;
    }

    public void setReparentWithOverlay(boolean z) {
        this.f3428a = z;
    }
}
