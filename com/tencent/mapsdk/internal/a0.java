package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a0.class */
public class a0 {
    public static final int d = 0;

    /* renamed from: a  reason: collision with root package name */
    private j0 f23590a;
    private TencentMap.SnapshotReadyCallback b = null;

    /* renamed from: c  reason: collision with root package name */
    private Handler f23591c = new a(Looper.getMainLooper());

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a0$a.class */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.what != 0) {
                return;
            }
            if (a0.this.b != null) {
                a0.this.b.onSnapshotReady((Bitmap) message.obj);
            }
            a0.this.b = null;
        }
    }

    public a0(j0 j0Var) {
        this.f23590a = null;
        this.f23590a = j0Var;
    }

    private void a(Handler handler, Bitmap.Config config, int i) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.a(handler, config, i);
    }

    public final float a(LatLng latLng, LatLng latLng2) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return -1.0f;
        }
        return j0Var.getZoomToSpanLevel(latLng, latLng2);
    }

    public final int a(CameraUpdate cameraUpdate) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return Integer.MIN_VALUE;
        }
        return j0Var.moveCamera(cameraUpdate);
    }

    public final int a(CameraUpdate cameraUpdate, long j, TencentMap.CancelableCallback cancelableCallback) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return Integer.MIN_VALUE;
        }
        return j0Var.animateCamera(cameraUpdate, j, cancelableCallback);
    }

    public int a(String str) {
        if (this.f23590a == null || f7.b(str)) {
            return -1;
        }
        return this.f23590a.a(str);
    }

    public CameraPosition a(List<u4> list, List<LatLng> list2, int i, int i2, int i3, int i4) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return null;
        }
        return j0Var.calculateZoomToSpanLevel(list, list2, i, i2, i3, i4);
    }

    public CustomLayer a(CustomLayerOptions customLayerOptions) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return null;
        }
        return j0Var.addCustomLayer(customLayerOptions);
    }

    public TileOverlay a(TileOverlayOptions tileOverlayOptions) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return null;
        }
        return j0Var.addTileOverlay(tileOverlayOptions);
    }

    public final String a(LatLng latLng) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return null;
        }
        return j0Var.getCityName(latLng);
    }

    public void a() {
        if (this.f23590a != null) {
            this.f23590a = null;
        }
    }

    public void a(float f, float f2, boolean z) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.a(f, f2, z);
    }

    public void a(int i) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setCompassExtraPadding(i);
    }

    public void a(int i, int i2) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setCompassExtraPadding(i, i2);
    }

    public final void a(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setOnCameraChangeListener(onCameraChangeListener);
    }

    public final void a(TencentMap.OnCompassClickedListener onCompassClickedListener) {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            j0Var.setOnCompassClickedListener(onCompassClickedListener);
        }
    }

    public final void a(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.a(onIndoorStateChangeListener);
    }

    public final void a(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setOnInfoWindowClickListener(onInfoWindowClickListener);
    }

    public final void a(TencentMap.OnMapClickListener onMapClickListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setOnMapClickListener(onMapClickListener);
    }

    public void a(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            j0Var.addOnMapLoadedCallback(onMapLoadedCallback);
        }
    }

    public final void a(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setOnMapLongClickListener(onMapLongClickListener);
    }

    public final void a(TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.a(onMapPoiClickListener);
    }

    public final void a(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setOnMarkerClickListener(onMarkerClickListener);
    }

    public final void a(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setOnScaleViewChangedListener(onScaleViewChangedListener);
    }

    public void a(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setOnTrafficEventClickListener(onTrafficEventClickListener);
    }

    public void a(TencentMap.SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config, int i) {
        if (this.f23590a == null || snapshotReadyCallback == null) {
            return;
        }
        this.b = snapshotReadyCallback;
        a(this.f23591c, config, i);
    }

    public void a(Language language) {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            j0Var.setForeignLanguage(language);
        }
    }

    public final void a(LatLng latLng, LatLng latLng2, float f) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.a(latLng, latLng2, f);
    }

    public void a(LatLngBounds latLngBounds, int i) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.a(latLngBounds, i);
    }

    public final void a(TencentMapGestureListener tencentMapGestureListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.addTencentMapGestureListener(tencentMapGestureListener);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f23590a.setIndoorFloor(str, str2);
    }

    public void a(boolean z) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.enableMultipleInfowindow(z);
    }

    public CameraPosition b() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return null;
        }
        return j0Var.getCameraPosition();
    }

    @Deprecated
    public String b(LatLng latLng) {
        IndoorBuilding c2;
        j0 j0Var = this.f23590a;
        if (j0Var == null || (c2 = j0Var.c()) == null) {
            return null;
        }
        if (c2.getBuildingLatLng() != null && latLng != null) {
            latLng.latitude = c2.getBuildingLatLng().latitude;
            latLng.longitude = c2.getBuildingLatLng().longitude;
        }
        return c2.getBuildingName();
    }

    public void b(int i) {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            j0Var.setIndoorFloor(i);
        }
    }

    public void b(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            j0Var.removeOnMapLoadedCallback(onMapLoadedCallback);
        }
    }

    public void b(Language language) {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            j0Var.a(language);
        }
    }

    public final void b(TencentMapGestureListener tencentMapGestureListener) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.removeTencentMapGestureListener(tencentMapGestureListener);
    }

    public final void b(String str) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.loadKMLFile(str);
    }

    public void b(boolean z) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setHandDrawMapEnable(z);
    }

    public String c() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return null;
        }
        return j0Var.getDebugError();
    }

    public final void c(int i) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setMapStyle(i);
    }

    public void c(boolean z) {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            j0Var.setIndoorEnabled(z);
        }
    }

    public int d() {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            return j0Var.getIndoorFloorId();
        }
        return -1;
    }

    public final void d(int i) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setMapType(i);
    }

    public final void d(boolean z) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.c(z);
    }

    public final void e(int i) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setMaxZoomLevel(i);
    }

    public void e(boolean z) {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            j0Var.a(z);
        }
    }

    public String[] e() {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            return j0Var.h();
        }
        return null;
    }

    public Language f() {
        j0 j0Var = this.f23590a;
        return j0Var != null ? j0Var.getLanguage() : Language.zh;
    }

    public final void f(int i) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setMinZoomLevel(i);
    }

    public void f(boolean z) {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            j0Var.setOnTapMapViewInfoWindowHidden(z);
        }
    }

    public final int g() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return -1;
        }
        return j0Var.getMapStyle();
    }

    public void g(boolean z) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setPoisEnabled(z);
    }

    public final int h() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return 1000;
        }
        return j0Var.getMapType();
    }

    public final void h(boolean z) {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.setTrafficEnabled(z);
    }

    public final float i() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return -1.0f;
        }
        return j0Var.getMaxZoomLevel();
    }

    public final float j() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return -1.0f;
        }
        return j0Var.getMinZoomLevel();
    }

    public String k() {
        j0 j0Var = this.f23590a;
        return j0Var == null ? "" : j0Var.getVersion();
    }

    public boolean l() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return false;
        }
        return j0Var.isHandDrawMapEnable();
    }

    public boolean m() {
        j0 j0Var = this.f23590a;
        if (j0Var != null) {
            return j0Var.b();
        }
        return false;
    }

    public final boolean n() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return false;
        }
        return j0Var.isTrafficEnabled();
    }

    public void o() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.onDestroy();
    }

    public void p() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.onPause();
    }

    public void q() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.onRestart();
    }

    public void r() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.onResume();
    }

    public void s() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.onStart();
    }

    public void t() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.onStop();
    }

    public final void u() {
        j0 j0Var = this.f23590a;
        if (j0Var == null) {
            return;
        }
        j0Var.stopAnimation();
    }
}
