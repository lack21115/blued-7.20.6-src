package com.tencent.tencentmap.mapsdk.maps.model;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel;
import com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator;
import com.tencent.tencentmap.mapsdk.maps.model.transform.Point;
import com.tencent.tencentmap.mapsdk.maps.model.transform.SphericalMercatorProjection;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/GeneralTranslateAnimator.class */
public class GeneralTranslateAnimator extends OverlayAnimator {
    private List<IAnimatorModel.IAnimatorEndListener> mAnimatorEndListeners;
    private final IAnimatorModel mAnimatorModel;
    private double[] mDistances;
    private SphericalMercatorProjection mEarthMercatorProjection;
    private LatLng[] mLatLngs;
    private RotateAnimationController mRotateAnimationController;
    private double mSumDistance;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/GeneralTranslateAnimator$Builder.class */
    public static class Builder {
        private final IAnimatorModel animatorModel;
        private final long duration;
        private final LatLng[] latLngs;
        private boolean rotateEnabled = false;
        private float initRotate = 0.0f;
        private ModelType modelType = ModelType.MARKER_OVERLAY;

        public Builder(IAnimatorModel iAnimatorModel, long j, LatLng[] latLngArr) {
            this.animatorModel = iAnimatorModel;
            this.duration = j;
            this.latLngs = latLngArr;
        }

        public GeneralTranslateAnimator build() {
            return new GeneralTranslateAnimator(this);
        }

        public Builder initRotate(float f) {
            this.initRotate = f;
            return this;
        }

        public Builder modelType(ModelType modelType) {
            this.modelType = modelType;
            return this;
        }

        public Builder rotateEnabled(boolean z) {
            this.rotateEnabled = z;
            return this;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/GeneralTranslateAnimator$ModelType.class */
    public enum ModelType {
        MARKER_OVERLAY,
        MODEL_OVERLAY
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/GeneralTranslateAnimator$a.class */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Point f25288a;
        public final /* synthetic */ Point b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f25289c;

        public a(Point point, Point point2, int i) {
            this.f25288a = point;
            this.b = point2;
            this.f25289c = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f25288a.equals(this.b)) {
                return;
            }
            double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
            double d = this.f25288a.x;
            double d2 = ((this.b.x - d) * parseDouble) / GeneralTranslateAnimator.this.mDistances[this.f25289c];
            double d3 = this.f25288a.y;
            double d4 = ((this.b.y - d3) * parseDouble) / GeneralTranslateAnimator.this.mDistances[this.f25289c];
            if (GeneralTranslateAnimator.this.mAnimatorModel == null) {
                return;
            }
            GeneralTranslateAnimator.this.mAnimatorModel.setPosition(GeneralTranslateAnimator.this.mEarthMercatorProjection.toLatLng(new Point(d + d2, d3 + d4)));
        }
    }

    public GeneralTranslateAnimator(Builder builder) {
        super(builder.animatorModel, builder.duration);
        int i;
        this.mAnimatorModel = builder.animatorModel;
        if (builder.latLngs == null || builder.latLngs.length <= 0 || builder.duration < 0) {
            return;
        }
        this.mLatLngs = builder.latLngs;
        this.mAnimatorEndListeners = new ArrayList();
        this.mEarthMercatorProjection = new SphericalMercatorProjection();
        ArrayList arrayList = new ArrayList();
        this.mDistances = new double[this.mLatLngs.length - 1];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            LatLng[] latLngArr = this.mLatLngs;
            if (i3 >= latLngArr.length - 1) {
                break;
            }
            double[] dArr = this.mDistances;
            SphericalMercatorProjection sphericalMercatorProjection = this.mEarthMercatorProjection;
            LatLng latLng = latLngArr[i3];
            int i4 = i3 + 1;
            dArr[i3] = sphericalMercatorProjection.distanceBetween(latLng, latLngArr[i4]);
            this.mSumDistance += this.mDistances[i3];
            i2 = i4;
        }
        for (i = 0; i < this.mLatLngs.length - 1; i++) {
            arrayList.add(createSegmentAnimator(i));
        }
        getAnimatorSet().playSequentially(arrayList);
        this.mRotateAnimationController = new RotateAnimationController(builder.animatorModel, builder.duration, builder.modelType, builder.rotateEnabled, builder.initRotate, this.mLatLngs, this.mDistances, this.mSumDistance, this.mEarthMercatorProjection);
    }

    public void addAnimatorEndListener(IAnimatorModel.IAnimatorEndListener iAnimatorEndListener) {
        List<IAnimatorModel.IAnimatorEndListener> list = this.mAnimatorEndListeners;
        if (list == null || list.contains(iAnimatorEndListener) || iAnimatorEndListener == null) {
            return;
        }
        this.mAnimatorEndListeners.add(iAnimatorEndListener);
        addAnimationListener();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator
    public void cancelAnimation() {
        super.cancelAnimation();
        if (this.mRotateAnimationController == null) {
            return;
        }
        synchronized (this) {
            this.mRotateAnimationController.cancelAnimation();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator
    public ValueAnimator createSegmentAnimator(int i) {
        Point point = this.mEarthMercatorProjection.toPoint(this.mLatLngs[i]);
        Point point2 = this.mEarthMercatorProjection.toPoint(this.mLatLngs[i + 1]);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) ((getDuration() * this.mDistances[i]) / this.mSumDistance));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setFloatValues((float) this.mDistances[i]);
        valueAnimator.addUpdateListener(new a(point, point2, i));
        return valueAnimator;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator
    public void endAnimation() {
        super.endAnimation();
        if (this.mRotateAnimationController == null) {
            return;
        }
        synchronized (this) {
            this.mRotateAnimationController.endAnimation();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator
    public void innerAnimationEnd() {
        List<IAnimatorModel.IAnimatorEndListener> list = this.mAnimatorEndListeners;
        if (list == null) {
            return;
        }
        for (IAnimatorModel.IAnimatorEndListener iAnimatorEndListener : list) {
            iAnimatorEndListener.onAnimatorEnd();
        }
    }

    public void removeAnimatorEndListener(IAnimatorModel.IAnimatorEndListener iAnimatorEndListener) {
        List<IAnimatorModel.IAnimatorEndListener> list = this.mAnimatorEndListeners;
        if (list == null) {
            return;
        }
        list.remove(iAnimatorEndListener);
        removeAnimationListener();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator
    public void startAnimation() {
        super.startAnimation();
        if (this.mRotateAnimationController == null) {
            return;
        }
        synchronized (this) {
            this.mRotateAnimationController.startAnimation();
        }
    }
}
