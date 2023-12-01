package com.google.android.material.transition;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.transition.TransitionUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/transition/MaterialContainerTransform.class */
public final class MaterialContainerTransform extends Transition {
    private static final float ELEVATION_NOT_SET = -1.0f;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private boolean appliedThemeValues;
    private int containerColor;
    private boolean drawDebugEnabled;
    private int drawingViewId;
    private boolean elevationShadowEnabled;
    private int endContainerColor;
    private float endElevation;
    private ShapeAppearanceModel endShapeAppearanceModel;
    private View endView;
    private int endViewId;
    private int fadeMode;
    private ProgressThresholds fadeProgressThresholds;
    private int fitMode;
    private boolean holdAtEndEnabled;
    private boolean pathMotionCustom;
    private ProgressThresholds scaleMaskProgressThresholds;
    private ProgressThresholds scaleProgressThresholds;
    private int scrimColor;
    private ProgressThresholds shapeMaskProgressThresholds;
    private int startContainerColor;
    private float startElevation;
    private ShapeAppearanceModel startShapeAppearanceModel;
    private View startView;
    private int startViewId;
    private int transitionDirection;
    private static final String TAG = MaterialContainerTransform.class.getSimpleName();
    private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final String[] TRANSITION_PROPS = {PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/transition/MaterialContainerTransform$FadeMode.class */
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/transition/MaterialContainerTransform$FitMode.class */
    public @interface FitMode {
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/transition/MaterialContainerTransform$ProgressThresholds.class */
    public static class ProgressThresholds {
        private final float end;
        private final float start;

        public ProgressThresholds(float f, float f2) {
            this.start = f;
            this.end = f2;
        }

        public float getEnd() {
            return this.end;
        }

        public float getStart() {
            return this.start;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/transition/MaterialContainerTransform$ProgressThresholdsGroup.class */
    public static class ProgressThresholdsGroup {
        private final ProgressThresholds fade;
        private final ProgressThresholds scale;
        private final ProgressThresholds scaleMask;
        private final ProgressThresholds shapeMask;

        private ProgressThresholdsGroup(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4) {
            this.fade = progressThresholds;
            this.scale = progressThresholds2;
            this.scaleMask = progressThresholds3;
            this.shapeMask = progressThresholds4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/transition/MaterialContainerTransform$TransitionDirection.class */
    public @interface TransitionDirection {
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/transition/MaterialContainerTransform$TransitionDrawable.class */
    static final class TransitionDrawable extends Drawable {
        private static final int COMPAT_SHADOW_COLOR = -7829368;
        private static final int SHADOW_COLOR = 754974720;
        private static final float SHADOW_DX_MULTIPLIER_ADJUSTMENT = 0.3f;
        private static final float SHADOW_DY_MULTIPLIER_ADJUSTMENT = 1.5f;
        private final MaterialShapeDrawable compatShadowDrawable;
        private final Paint containerPaint;
        private float currentElevation;
        private float currentElevationDy;
        private final RectF currentEndBounds;
        private final RectF currentEndBoundsMasked;
        private RectF currentMaskBounds;
        private final RectF currentStartBounds;
        private final RectF currentStartBoundsMasked;
        private final Paint debugPaint;
        private final Path debugPath;
        private final float displayHeight;
        private final float displayWidth;
        private final boolean drawDebugEnabled;
        private final boolean elevationShadowEnabled;
        private final RectF endBounds;
        private final Paint endContainerPaint;
        private final float endElevation;
        private final ShapeAppearanceModel endShapeAppearanceModel;
        private final View endView;
        private final boolean entering;
        private final FadeModeEvaluator fadeModeEvaluator;
        private FadeModeResult fadeModeResult;
        private final FitModeEvaluator fitModeEvaluator;
        private FitModeResult fitModeResult;
        private final MaskEvaluator maskEvaluator;
        private final float motionPathLength;
        private final PathMeasure motionPathMeasure;
        private final float[] motionPathPosition;
        private float progress;
        private final ProgressThresholdsGroup progressThresholds;
        private final Paint scrimPaint;
        private final Paint shadowPaint;
        private final RectF startBounds;
        private final Paint startContainerPaint;
        private final float startElevation;
        private final ShapeAppearanceModel startShapeAppearanceModel;
        private final View startView;

        private TransitionDrawable(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f2, int i, int i2, int i3, int i4, boolean z, boolean z2, FadeModeEvaluator fadeModeEvaluator, FitModeEvaluator fitModeEvaluator, ProgressThresholdsGroup progressThresholdsGroup, boolean z3) {
            this.containerPaint = new Paint();
            this.startContainerPaint = new Paint();
            this.endContainerPaint = new Paint();
            this.shadowPaint = new Paint();
            this.scrimPaint = new Paint();
            this.maskEvaluator = new MaskEvaluator();
            this.motionPathPosition = new float[2];
            this.compatShadowDrawable = new MaterialShapeDrawable();
            this.debugPaint = new Paint();
            this.debugPath = new Path();
            this.startView = view;
            this.startBounds = rectF;
            this.startShapeAppearanceModel = shapeAppearanceModel;
            this.startElevation = f;
            this.endView = view2;
            this.endBounds = rectF2;
            this.endShapeAppearanceModel = shapeAppearanceModel2;
            this.endElevation = f2;
            this.entering = z;
            this.elevationShadowEnabled = z2;
            this.fadeModeEvaluator = fadeModeEvaluator;
            this.fitModeEvaluator = fitModeEvaluator;
            this.progressThresholds = progressThresholdsGroup;
            this.drawDebugEnabled = z3;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.displayWidth = displayMetrics.widthPixels;
            this.displayHeight = displayMetrics.heightPixels;
            this.containerPaint.setColor(i);
            this.startContainerPaint.setColor(i2);
            this.endContainerPaint.setColor(i3);
            this.compatShadowDrawable.setFillColor(ColorStateList.valueOf(0));
            this.compatShadowDrawable.setShadowCompatibilityMode(2);
            this.compatShadowDrawable.setShadowBitmapDrawingEnable(false);
            this.compatShadowDrawable.setShadowColor(-7829368);
            this.currentStartBounds = new RectF(rectF);
            this.currentStartBoundsMasked = new RectF(this.currentStartBounds);
            this.currentEndBounds = new RectF(this.currentStartBounds);
            this.currentEndBoundsMasked = new RectF(this.currentEndBounds);
            PointF motionPathPoint = getMotionPathPoint(rectF);
            PointF motionPathPoint2 = getMotionPathPoint(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(motionPathPoint.x, motionPathPoint.y, motionPathPoint2.x, motionPathPoint2.y), false);
            this.motionPathMeasure = pathMeasure;
            this.motionPathLength = pathMeasure.getLength();
            this.motionPathPosition[0] = rectF.centerX();
            this.motionPathPosition[1] = rectF.top;
            this.scrimPaint.setStyle(Paint.Style.FILL);
            this.scrimPaint.setShader(TransitionUtils.createColorShader(i4));
            this.debugPaint.setStyle(Paint.Style.STROKE);
            this.debugPaint.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }

        private static float calculateElevationDxMultiplier(RectF rectF, float f) {
            return ((rectF.centerX() / (f / 2.0f)) - 1.0f) * 0.3f;
        }

        private static float calculateElevationDyMultiplier(RectF rectF, float f) {
            return (rectF.centerY() / f) * SHADOW_DY_MULTIPLIER_ADJUSTMENT;
        }

        private void drawDebugCumulativePath(Canvas canvas, RectF rectF, Path path, int i) {
            PointF motionPathPoint = getMotionPathPoint(rectF);
            if (this.progress == 0.0f) {
                path.reset();
                path.moveTo(motionPathPoint.x, motionPathPoint.y);
                return;
            }
            path.lineTo(motionPathPoint.x, motionPathPoint.y);
            this.debugPaint.setColor(i);
            canvas.drawPath(path, this.debugPaint);
        }

        private void drawDebugRect(Canvas canvas, RectF rectF, int i) {
            this.debugPaint.setColor(i);
            canvas.drawRect(rectF, this.debugPaint);
        }

        private void drawElevationShadow(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.maskEvaluator.getPath(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                drawElevationShadowWithPaintShadowLayer(canvas);
            } else {
                drawElevationShadowWithMaterialShapeDrawable(canvas);
            }
            canvas.restore();
        }

        private void drawElevationShadowWithMaterialShapeDrawable(Canvas canvas) {
            this.compatShadowDrawable.setBounds((int) this.currentMaskBounds.left, (int) this.currentMaskBounds.top, (int) this.currentMaskBounds.right, (int) this.currentMaskBounds.bottom);
            this.compatShadowDrawable.setElevation(this.currentElevation);
            this.compatShadowDrawable.setShadowVerticalOffset((int) this.currentElevationDy);
            this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.getCurrentShapeAppearanceModel());
            this.compatShadowDrawable.draw(canvas);
        }

        private void drawElevationShadowWithPaintShadowLayer(Canvas canvas) {
            ShapeAppearanceModel currentShapeAppearanceModel = this.maskEvaluator.getCurrentShapeAppearanceModel();
            if (!currentShapeAppearanceModel.isRoundRect(this.currentMaskBounds)) {
                canvas.drawPath(this.maskEvaluator.getPath(), this.shadowPaint);
                return;
            }
            float cornerSize = currentShapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.currentMaskBounds);
            canvas.drawRoundRect(this.currentMaskBounds, cornerSize, cornerSize, this.shadowPaint);
        }

        private void drawEndView(Canvas canvas) {
            maybeDrawContainerColor(canvas, this.endContainerPaint);
            TransitionUtils.transform(canvas, getBounds(), this.currentEndBounds.left, this.currentEndBounds.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new TransitionUtils.CanvasOperation() { // from class: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.2
                @Override // com.google.android.material.transition.TransitionUtils.CanvasOperation
                public void run(Canvas canvas2) {
                    TransitionDrawable.this.endView.draw(canvas2);
                }
            });
        }

        private void drawStartView(Canvas canvas) {
            maybeDrawContainerColor(canvas, this.startContainerPaint);
            TransitionUtils.transform(canvas, getBounds(), this.currentStartBounds.left, this.currentStartBounds.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new TransitionUtils.CanvasOperation() { // from class: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.1
                @Override // com.google.android.material.transition.TransitionUtils.CanvasOperation
                public void run(Canvas canvas2) {
                    TransitionDrawable.this.startView.draw(canvas2);
                }
            });
        }

        private static PointF getMotionPathPoint(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        private void maybeDrawContainerColor(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProgress(float f) {
            if (this.progress != f) {
                updateProgress(f);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0066, code lost:
            if (r10 < 0.0f) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void updateProgress(float r10) {
            /*
                Method dump skipped, instructions count: 829
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.updateProgress(float):void");
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.scrimPaint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.scrimPaint);
            }
            int save = this.drawDebugEnabled ? canvas.save() : -1;
            if (this.elevationShadowEnabled && this.currentElevation > 0.0f) {
                drawElevationShadow(canvas);
            }
            this.maskEvaluator.clip(canvas);
            maybeDrawContainerColor(canvas, this.containerPaint);
            if (this.fadeModeResult.endOnTop) {
                drawStartView(canvas);
                drawEndView(canvas);
            } else {
                drawEndView(canvas);
                drawStartView(canvas);
            }
            if (this.drawDebugEnabled) {
                canvas.restoreToCount(save);
                drawDebugCumulativePath(canvas, this.currentStartBounds, this.debugPath, Color.MAGENTA);
                drawDebugRect(canvas, this.currentStartBoundsMasked, -256);
                drawDebugRect(canvas, this.currentStartBounds, Color.GREEN);
                drawDebugRect(canvas, this.currentEndBoundsMasked, Color.CYAN);
                drawDebugRect(canvas, this.currentEndBounds, Color.BLUE);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    public MaterialContainerTransform() {
        boolean z = false;
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        this.elevationShadowEnabled = Build.VERSION.SDK_INT >= 28 ? true : z;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
    }

    public MaterialContainerTransform(Context context, boolean z) {
        boolean z2 = false;
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        this.elevationShadowEnabled = Build.VERSION.SDK_INT >= 28 ? true : z2;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
        maybeApplyThemeValues(context, z);
        this.appliedThemeValues = true;
    }

    private ProgressThresholdsGroup buildThresholdsGroup(boolean z) {
        PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof ArcMotion) || (pathMotion instanceof MaterialArcMotion)) ? getThresholdsOrDefault(z, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC) : getThresholdsOrDefault(z, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }

    private static RectF calculateDrawableBounds(View view, View view2, float f, float f2) {
        if (view2 != null) {
            RectF locationOnScreen = TransitionUtils.getLocationOnScreen(view2);
            locationOnScreen.offset(f, f2);
            return locationOnScreen;
        }
        return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
    }

    private static ShapeAppearanceModel captureShapeAppearance(View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel) {
        return TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(view, shapeAppearanceModel), rectF);
    }

    private static void captureValues(TransitionValues transitionValues, View view, int i, ShapeAppearanceModel shapeAppearanceModel) {
        if (i != -1) {
            transitionValues.view = TransitionUtils.findDescendantOrAncestorById(transitionValues.view, i);
        } else if (view != null) {
            transitionValues.view = view;
        } else if (transitionValues.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof View) {
            View view2 = (View) transitionValues.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
            transitionValues.view.setTag(com.google.android.material.R.id.mtrl_motion_snapshot_view, null);
            transitionValues.view = view2;
        }
        View view3 = transitionValues.view;
        if (!ViewCompat.isLaidOut(view3) && view3.getWidth() == 0 && view3.getHeight() == 0) {
            return;
        }
        RectF relativeBounds = view3.getParent() == null ? TransitionUtils.getRelativeBounds(view3) : TransitionUtils.getLocationOnScreen(view3);
        transitionValues.values.put(PROP_BOUNDS, relativeBounds);
        transitionValues.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(view3, relativeBounds, shapeAppearanceModel));
    }

    private static float getElevationOrDefault(float f, View view) {
        return f != -1.0f ? f : ViewCompat.getElevation(view);
    }

    private static ShapeAppearanceModel getShapeAppearance(View view, ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        if (view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel) {
            return (ShapeAppearanceModel) view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
        }
        Context context = view.getContext();
        int transitionShapeAppearanceResId = getTransitionShapeAppearanceResId(context);
        return transitionShapeAppearanceResId != -1 ? ShapeAppearanceModel.builder(context, transitionShapeAppearanceResId, 0).build() : view instanceof Shapeable ? ((Shapeable) view).getShapeAppearanceModel() : ShapeAppearanceModel.builder().build();
    }

    private ProgressThresholdsGroup getThresholdsOrDefault(boolean z, ProgressThresholdsGroup progressThresholdsGroup, ProgressThresholdsGroup progressThresholdsGroup2) {
        if (!z) {
            progressThresholdsGroup = progressThresholdsGroup2;
        }
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.defaultIfNull(this.fadeProgressThresholds, progressThresholdsGroup.fade), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleProgressThresholds, progressThresholdsGroup.scale), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, progressThresholdsGroup.scaleMask), (ProgressThresholds) TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, progressThresholdsGroup.shapeMask));
    }

    private static int getTransitionShapeAppearanceResId(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean isEntering(RectF rectF, RectF rectF2) {
        int i = this.transitionDirection;
        boolean z = false;
        if (i == 0) {
            if (TransitionUtils.calculateArea(rectF2) > TransitionUtils.calculateArea(rectF)) {
                z = true;
            }
            return z;
        } else if (i != 1) {
            if (i == 2) {
                return false;
            }
            throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
        } else {
            return true;
        }
    }

    private void maybeApplyThemeValues(Context context, boolean z) {
        TransitionUtils.maybeApplyThemeInterpolator(this, context, com.google.android.material.R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        TransitionUtils.maybeApplyThemeDuration(this, context, z ? com.google.android.material.R.attr.motionDurationLong1 : com.google.android.material.R.attr.motionDurationMedium2);
        if (this.pathMotionCustom) {
            return;
        }
        TransitionUtils.maybeApplyThemePath(this, context, com.google.android.material.R.attr.motionPath);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View findAncestorById;
        View view;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        RectF rectF = (RectF) transitionValues.values.get(PROP_BOUNDS);
        ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues.values.get(PROP_SHAPE_APPEARANCE);
        if (rectF == null || shapeAppearanceModel == null) {
            Log.w(TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
            return null;
        }
        RectF rectF2 = (RectF) transitionValues2.values.get(PROP_BOUNDS);
        ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues2.values.get(PROP_SHAPE_APPEARANCE);
        if (rectF2 == null || shapeAppearanceModel2 == null) {
            Log.w(TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
            return null;
        }
        final View view2 = transitionValues.view;
        final View view3 = transitionValues2.view;
        View view4 = view3.getParent() != null ? view3 : view2;
        if (this.drawingViewId == view4.getId()) {
            findAncestorById = (View) view4.getParent();
            view = view4;
        } else {
            findAncestorById = TransitionUtils.findAncestorById(view4, this.drawingViewId);
            view = null;
        }
        RectF locationOnScreen = TransitionUtils.getLocationOnScreen(findAncestorById);
        float f = -locationOnScreen.left;
        float f2 = -locationOnScreen.top;
        RectF calculateDrawableBounds = calculateDrawableBounds(findAncestorById, view, f, f2);
        rectF.offset(f, f2);
        rectF2.offset(f, f2);
        boolean isEntering = isEntering(rectF, rectF2);
        if (!this.appliedThemeValues) {
            maybeApplyThemeValues(view4.getContext(), isEntering);
        }
        final TransitionDrawable transitionDrawable = new TransitionDrawable(getPathMotion(), view2, rectF, shapeAppearanceModel, getElevationOrDefault(this.startElevation, view2), view3, rectF2, shapeAppearanceModel2, getElevationOrDefault(this.endElevation, view3), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, isEntering, this.elevationShadowEnabled, FadeModeEvaluators.get(this.fadeMode, isEntering), FitModeEvaluators.get(this.fitMode, isEntering, rectF, rectF2), buildThresholdsGroup(isEntering), this.drawDebugEnabled);
        transitionDrawable.setBounds(Math.round(calculateDrawableBounds.left), Math.round(calculateDrawableBounds.top), Math.round(calculateDrawableBounds.right), Math.round(calculateDrawableBounds.bottom));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.MaterialContainerTransform.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                transitionDrawable.setProgress(valueAnimator.getAnimatedFraction());
            }
        });
        final View view5 = findAncestorById;
        addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.MaterialContainerTransform.2
            @Override // com.google.android.material.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                MaterialContainerTransform.this.removeListener(this);
                if (MaterialContainerTransform.this.holdAtEndEnabled) {
                    return;
                }
                view2.setAlpha(1.0f);
                view3.setAlpha(1.0f);
                ViewUtils.getOverlay(view5).remove(transitionDrawable);
            }

            @Override // com.google.android.material.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                ViewUtils.getOverlay(view5).add(transitionDrawable);
                view2.setAlpha(0.0f);
                view3.setAlpha(0.0f);
            }
        });
        return ofFloat;
    }

    public int getContainerColor() {
        return this.containerColor;
    }

    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    public View getEndView() {
        return this.endView;
    }

    public int getEndViewId() {
        return this.endViewId;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    public ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    public ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    public int getScrimColor() {
        return this.scrimColor;
    }

    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    public View getStartView() {
        return this.startView;
    }

    public int getStartViewId() {
        return this.startViewId;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setAllContainerColors(int i) {
        this.containerColor = i;
        this.startContainerColor = i;
        this.endContainerColor = i;
    }

    public void setContainerColor(int i) {
        this.containerColor = i;
    }

    public void setDrawDebugEnabled(boolean z) {
        this.drawDebugEnabled = z;
    }

    public void setDrawingViewId(int i) {
        this.drawingViewId = i;
    }

    public void setElevationShadowEnabled(boolean z) {
        this.elevationShadowEnabled = z;
    }

    public void setEndContainerColor(int i) {
        this.endContainerColor = i;
    }

    public void setEndElevation(float f) {
        this.endElevation = f;
    }

    public void setEndShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.endShapeAppearanceModel = shapeAppearanceModel;
    }

    public void setEndView(View view) {
        this.endView = view;
    }

    public void setEndViewId(int i) {
        this.endViewId = i;
    }

    public void setFadeMode(int i) {
        this.fadeMode = i;
    }

    public void setFadeProgressThresholds(ProgressThresholds progressThresholds) {
        this.fadeProgressThresholds = progressThresholds;
    }

    public void setFitMode(int i) {
        this.fitMode = i;
    }

    public void setHoldAtEndEnabled(boolean z) {
        this.holdAtEndEnabled = z;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.pathMotionCustom = true;
    }

    public void setScaleMaskProgressThresholds(ProgressThresholds progressThresholds) {
        this.scaleMaskProgressThresholds = progressThresholds;
    }

    public void setScaleProgressThresholds(ProgressThresholds progressThresholds) {
        this.scaleProgressThresholds = progressThresholds;
    }

    public void setScrimColor(int i) {
        this.scrimColor = i;
    }

    public void setShapeMaskProgressThresholds(ProgressThresholds progressThresholds) {
        this.shapeMaskProgressThresholds = progressThresholds;
    }

    public void setStartContainerColor(int i) {
        this.startContainerColor = i;
    }

    public void setStartElevation(float f) {
        this.startElevation = f;
    }

    public void setStartShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.startShapeAppearanceModel = shapeAppearanceModel;
    }

    public void setStartView(View view) {
        this.startView = view;
    }

    public void setStartViewId(int i) {
        this.startViewId = i;
    }

    public void setTransitionDirection(int i) {
        this.transitionDirection = i;
    }
}
