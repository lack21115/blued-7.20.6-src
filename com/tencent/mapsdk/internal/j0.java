package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j0.class */
public interface j0 {
    float a(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3);

    int a(String str);

    int a(byte[] bArr, String str);

    List<Rect> a(List<String> list);

    void a(float f, float f2, boolean z);

    void a(Handler handler, Bitmap.Config config, int i);

    void a(d5 d5Var);

    void a(TencentMap.OnCameraChangeListener onCameraChangeListener);

    void a(TencentMap.OnDismissCallback onDismissCallback);

    void a(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener);

    void a(TencentMap.OnMapPoiClickListener onMapPoiClickListener);

    void a(Language language);

    void a(LatLng latLng, float f, float f2, boolean z);

    void a(LatLng latLng, LatLng latLng2, float f);

    void a(LatLngBounds latLngBounds, int i);

    void a(List<MapRouteSection> list, List<LatLng> list2);

    void a(boolean z);

    CustomLayer addCustomLayer(CustomLayerOptions customLayerOptions);

    void addOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback);

    void addTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener);

    TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions);

    int animateCamera(CameraUpdate cameraUpdate, long j, TencentMap.CancelableCallback cancelableCallback);

    void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, boolean z);

    void animateToNaviPosition2(LatLng latLng, float f, float f2, float f3, boolean z);

    void b(d5 d5Var);

    void b(boolean z);

    boolean b();

    IndoorBuilding c();

    void c(boolean z);

    float calNaviLevel(LatLngBounds latLngBounds, float f, int i, boolean z);

    float calNaviLevel2(LatLng latLng, LatLng latLng2, float f, float f2, int i, boolean z);

    float calNaviLevel3(LatLng latLng, LatLng latLng2, float f, int i, int i2, int i3, int i4, boolean z);

    CameraPosition calculateZoomToSpanLevel(List<u4> list, List<LatLng> list2, int i, int i2, int i3, int i4);

    CameraPosition calculateZoomToSpanLevelAsync(List<u4> list, List<LatLng> list2, int i, int i2, int i3, int i4, TencentMap.AsyncOperateCallback<CameraPosition> asyncOperateCallback);

    void clearRouteNameSegments();

    String e();

    void enableMultipleInfowindow(boolean z);

    String f();

    ArrayList<MapPoi> g();

    CameraPosition getCameraPosition();

    String getCityName(LatLng latLng);

    String getDebugError();

    int getIndoorFloorId();

    Language getLanguage();

    int getMapStyle();

    int getMapType();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    String getVersion();

    float getZoomToSpanLevel(LatLng latLng, LatLng latLng2);

    String[] h();

    boolean isHandDrawMapEnable();

    boolean isTrafficEnabled();

    void loadKMLFile(String str);

    int moveCamera(CameraUpdate cameraUpdate);

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onStart();

    void onStop();

    void removeOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback);

    void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener);

    void setCompassExtraPadding(int i);

    void setCompassExtraPadding(int i, int i2);

    void setForeignLanguage(Language language);

    void setHandDrawMapEnable(boolean z);

    void setIndoorEnabled(boolean z);

    void setIndoorFloor(int i);

    void setIndoorFloor(String str, String str2);

    void setMapStyle(int i);

    void setMapType(int i);

    void setMaxZoomLevel(int i);

    void setMinZoomLevel(int i);

    void setNaviFixingProportion(float f, float f2);

    void setNaviFixingProportion2D(float f, float f2);

    void setOnCameraChangeListener(TencentMap.OnCameraChangeListener onCameraChangeListener);

    void setOnCompassClickedListener(TencentMap.OnCompassClickedListener onCompassClickedListener);

    void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener);

    void setOnMapClickListener(TencentMap.OnMapClickListener onMapClickListener);

    void setOnMapLongClickListener(TencentMap.OnMapLongClickListener onMapLongClickListener);

    void setOnMarkerClickListener(TencentMap.OnMarkerClickListener onMarkerClickListener);

    void setOnScaleViewChangedListener(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener);

    void setOnTapMapViewInfoWindowHidden(boolean z);

    void setOnTrafficEventClickListener(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener);

    void setPoisEnabled(boolean z);

    void setTrafficEnabled(boolean z);

    void stopAnimation();
}
