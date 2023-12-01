package com.tencent.tencentmap.mapsdk.maps.model;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.tencentmap.mapsdk.maps.model.GeneralTranslateAnimator;
import com.tencent.tencentmap.mapsdk.maps.model.transform.Point;
import com.tencent.tencentmap.mapsdk.maps.model.transform.SphericalMercatorProjection;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/RotateAnimationController.class */
public class RotateAnimationController {
    private IAnimatorModel mAnimatorModel;
    private double[] mDistances;
    private long mDuration;
    private SphericalMercatorProjection mEarthMercatorProjection;
    private d mIValueAnimatorStrategy;
    private final float mInitRotate;
    private LatLng[] mLatLngs;
    private GeneralTranslateAnimator.ModelType mModelType;
    private AnimatorSet mRotateAnimatorSet;
    private final boolean mRotateEnabled;
    private double mSumDistance;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/RotateAnimationController$a.class */
    public class a implements d {
        public a() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.RotateAnimationController.d
        public ValueAnimator a(float f, float f2) {
            return RotateAnimationController.this.mModelType.ordinal() != 1 ? ValueAnimator.ofFloat(f, f2) : ValueAnimator.ofFloat(f * (-1.0f), f2 * (-1.0f));
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.RotateAnimationController.d
        public double[] a() {
            int i = c.f38983a[RotateAnimationController.this.mModelType.ordinal()];
            return new double[]{0.0d, 1.0d};
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/RotateAnimationController$b.class */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
            if (RotateAnimationController.this.mAnimatorModel == null) {
                return;
            }
            RotateAnimationController.this.mAnimatorModel.setRotation((float) parseDouble);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/RotateAnimationController$c.class */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38983a;

        static {
            GeneralTranslateAnimator.ModelType.values();
            int[] iArr = new int[2];
            f38983a = iArr;
            try {
                GeneralTranslateAnimator.ModelType modelType = GeneralTranslateAnimator.ModelType.MODEL_OVERLAY;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/RotateAnimationController$d.class */
    public interface d {
        ValueAnimator a(float f, float f2);

        double[] a();
    }

    public RotateAnimationController(IAnimatorModel iAnimatorModel, long j, GeneralTranslateAnimator.ModelType modelType, boolean z, float f, LatLng[] latLngArr, double[] dArr, double d2, SphericalMercatorProjection sphericalMercatorProjection) {
        this.mRotateEnabled = z;
        this.mInitRotate = f;
        if (z) {
            this.mAnimatorModel = iAnimatorModel;
            this.mDuration = j;
            this.mModelType = modelType;
            this.mRotateAnimatorSet = new AnimatorSet();
            this.mLatLngs = latLngArr;
            this.mDistances = dArr;
            this.mSumDistance = d2;
            this.mEarthMercatorProjection = sphericalMercatorProjection;
            initValueAnimatorStrategy();
            initRotateAnimation();
        }
    }

    private double calculateAngle(double d2, double d3, double d4, double d5) {
        double sqrt = ((d2 * d4) + (d3 * d5)) / (Math.sqrt((d2 * d2) + (d3 * d3)) * Math.sqrt((d4 * d4) + (d5 * d5)));
        if (Double.isNaN(sqrt)) {
            return 0.0d;
        }
        double d6 = sqrt;
        if (sqrt < -1.0d) {
            d6 = -1.0d;
        }
        double d7 = d6;
        if (d6 > 1.0d) {
            d7 = 1.0d;
        }
        double acos = (Math.acos(d7) * 180.0d) / 3.141592653589793d;
        double d8 = acos;
        if ((d2 * d5) - (d3 * d4) > 0.0d) {
            d8 = -acos;
        }
        return (float) d8;
    }

    private long calculateDelay(int i, int i2) {
        double d2 = 0.0d;
        while (i < i2) {
            d2 += this.mDistances[i];
            i++;
        }
        return (long) ((this.mDuration * d2) / this.mSumDistance);
    }

    private ValueAnimator createRotateAnimator(float f, float f2, long j, long j2) {
        d dVar = this.mIValueAnimatorStrategy;
        float f3 = this.mInitRotate;
        ValueAnimator a2 = dVar.a(f + f3, f2 + f3);
        a2.setDuration(j);
        a2.setStartDelay(j2);
        a2.setInterpolator(new LinearInterpolator());
        a2.addUpdateListener(new b());
        return a2;
    }

    private void initRotateAnimation() {
        long abs;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        float f = 0.0f;
        long j = 0;
        while (true) {
            LatLng[] latLngArr = this.mLatLngs;
            if (i2 >= latLngArr.length) {
                this.mRotateAnimatorSet.playSequentially(arrayList);
                return;
            }
            if (!latLngArr[i3].equals(latLngArr[i2])) {
                Point point = this.mEarthMercatorProjection.toPoint(this.mLatLngs[i]);
                Point point2 = this.mEarthMercatorProjection.toPoint(this.mLatLngs[i3]);
                Point point3 = this.mEarthMercatorProjection.toPoint(this.mLatLngs[i2]);
                double d2 = point2.x;
                double d3 = point.x;
                double d4 = point.y;
                double d5 = point2.y;
                float calculateAngle = (float) calculateAngle(d2 - d3, d4 - d5, point3.x - d2, d5 - point3.y);
                if (arrayList.size() == 0) {
                    IAnimatorModel iAnimatorModel = this.mAnimatorModel;
                    if (iAnimatorModel == null) {
                        return;
                    }
                    f = iAnimatorModel.getRotation();
                    double[] a2 = this.mIValueAnimatorStrategy.a();
                    calculateAngle = ((float) calculateAngle(a2[0], a2[1], point3.x - point2.x, point2.y - point3.y)) - f;
                    abs = 0;
                } else {
                    abs = (long) ((this.mDuration * (((Math.abs(calculateAngle) * 3.141592653589793d) * 6.0d) / 180.0d)) / this.mSumDistance);
                    j = calculateDelay(i, i3) - (abs / 2);
                }
                float f2 = f + calculateAngle;
                arrayList.add(createRotateAnimator(f, f2, abs, j));
                int i4 = i3;
                f = f2;
                i3 = i2;
                i = i4;
            }
            i2++;
        }
    }

    private void initValueAnimatorStrategy() {
        this.mIValueAnimatorStrategy = new a();
    }

    public void cancelAnimation() {
        if (this.mRotateEnabled) {
            this.mRotateAnimatorSet.cancel();
        }
    }

    public void endAnimation() {
        if (this.mRotateEnabled) {
            this.mRotateAnimatorSet.end();
        }
    }

    public void startAnimation() {
        if (this.mRotateEnabled && !this.mRotateAnimatorSet.isRunning()) {
            this.mRotateAnimatorSet.start();
        }
    }
}
