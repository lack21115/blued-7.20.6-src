package com.tencent.mapsdk.vector;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.internal.qa;
import com.tencent.mapsdk.internal.ra;
import com.tencent.mapsdk.internal.rc;
import com.tencent.mapsdk.internal.x1;
import com.tencent.mapsdk.internal.yi;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/vector/VectorMapDelegateProxy.class */
public class VectorMapDelegateProxy implements MapDelegate<rc, VectorMap, x1> {
    private yi mMapDelegate;

    public VectorMapDelegateProxy(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        this.mMapDelegate = new yi(context, tencentMapOptions, viewGroup);
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    public VectorMap createMap(rc rcVar) {
        return this.mMapDelegate.a((yi) rcVar);
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    public x1 createMapView(rc rcVar, ViewGroup viewGroup) {
        return this.mMapDelegate.createMapView((yi) rcVar, viewGroup);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public TencentMap getMap() {
        return this.mMapDelegate.getMap();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mapsdk.core.MapDelegate
    public rc getMapContext() {
        return this.mMapDelegate.getMapContext();
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    public x1 getMapRenderView() {
        return this.mMapDelegate.getMapRenderView();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean isOpaque() {
        return this.mMapDelegate.isOpaque();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean isTouchable() {
        return this.mMapDelegate.isTouchable();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onCreated() {
        ra.h(qa.z);
        this.mMapDelegate.onCreated();
        ra.i(qa.z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onDestroy() {
        ra.h(qa.F);
        this.mMapDelegate.onDestroy();
        ra.i(qa.F);
        ra.i(qa.W);
        ra.e();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onPause() {
        ra.h(qa.C);
        this.mMapDelegate.onPause();
        ra.i(qa.C);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onRestart() {
        ra.h(qa.D);
        this.mMapDelegate.onRestart();
        ra.i(qa.D);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onResume() {
        ra.h(qa.B);
        this.mMapDelegate.onResume();
        ra.i(qa.B);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        ra.h(qa.H);
        this.mMapDelegate.onSizeChanged(i, i2, i3, i4);
        ra.i(qa.H);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onStart() {
        ra.h(qa.A);
        this.mMapDelegate.onStart();
        ra.i(qa.A);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onStop() {
        ra.h(qa.E);
        this.mMapDelegate.onStop();
        ra.i(qa.E);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onSurfaceChanged(Object obj, int i, int i2) {
        ra.h(qa.I);
        ra.b(qa.I, "width", Integer.valueOf(i));
        ra.b(qa.I, "height", Integer.valueOf(i2));
        this.mMapDelegate.onSurfaceChanged(obj, i, i2);
        ra.i(qa.I);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mMapDelegate.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onUpdateOptions(TencentMapOptions tencentMapOptions) {
        ra.h(qa.G);
        this.mMapDelegate.onUpdateOptions(tencentMapOptions);
        ra.i(qa.G);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void setOnTop(boolean z) {
        this.mMapDelegate.setOnTop(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void setOpaque(boolean z) {
        this.mMapDelegate.setOpaque(z);
    }
}
