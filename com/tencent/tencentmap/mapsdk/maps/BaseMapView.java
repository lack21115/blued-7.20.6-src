package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MapKernel;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/BaseMapView.class */
public abstract class BaseMapView extends FrameLayout {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/BaseMapView$MapViewProxy.class */
    public interface MapViewProxy {
        TencentMap getMap();

        boolean isOpaque();

        boolean isTouchable();

        void onCreated();

        void onDestroy();

        void onPause();

        void onRestart();

        void onResume();

        void onSizeChanged(int i, int i2, int i3, int i4);

        void onStart();

        void onStop();

        void onSurfaceChanged(Object obj, int i, int i2);

        boolean onTouchEvent(MotionEvent motionEvent);

        void onUpdateOptions(TencentMapOptions tencentMapOptions);

        void setOnTop(boolean z);

        void setOpaque(boolean z);
    }

    public BaseMapView(Context context) {
        super(context);
    }

    public BaseMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public abstract TencentMap getMap();

    public abstract TencentMap getMap(TencentMapOptions tencentMapOptions);

    public TencentMapOptions.IMapKernel getMapKernel() {
        return MapKernel.Vector;
    }

    public MapViewType getViewType() {
        return MapViewType.SurfaceView;
    }

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onRestart();

    public abstract void onResume();

    public abstract void onStart();

    public abstract void onStop();
}
