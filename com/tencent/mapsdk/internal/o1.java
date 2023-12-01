package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapFontSize;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/o1.class */
public abstract class o1 implements w1, TencentMap {
    @Override // com.tencent.mapsdk.internal.w1
    public void a() {
        ra.h(qa.P);
        j();
        ra.i(qa.P);
    }

    public void a(int i) {
        ra.b(qa.W, "setIndoorConfigType", Integer.valueOf(i));
    }

    @Override // com.tencent.mapsdk.internal.w1
    public void a(Bundle bundle) {
        ra.h(qa.M);
        b(bundle);
        ra.i(qa.M);
    }

    public abstract void a(boolean z);

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Arc addArc(ArcOptions arcOptions) {
        ra.b(qa.W, "addArc", (Object) (arcOptions != null ? arcOptions.toString() : ""));
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Circle addCircle(CircleOptions circleOptions) {
        ra.b(qa.W, "addCircle", (Object) (circleOptions != null ? circleOptions.toString() : ""));
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public CustomLayer addCustomLayer(CustomLayerOptions customLayerOptions) {
        ra.b(qa.W, "addCustomLayer", (Object) ra.a(getMapContext().getContext(), customLayerOptions != null ? customLayerOptions.getLayerId() : ""));
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Marker addMarker(MarkerOptions markerOptions) {
        ra.b(qa.W, "addMarker", (Object) (markerOptions != null ? markerOptions.toString() : ""));
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void addOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        ra.b(qa.W, "addOnMapLoadedCallback", Boolean.valueOf(onMapLoadedCallback != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Polygon addPolygon(PolygonOptions polygonOptions) {
        ra.b(qa.W, "addPolygon", (Object) (polygonOptions != null ? polygonOptions.toString() : ""));
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Polyline addPolyline(PolylineOptions polylineOptions) {
        ra.b(qa.W, "addPolyline", (Object) (polylineOptions != null ? polylineOptions.toString() : ""));
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void addTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        ra.b(qa.W, "addTencentMapGestureListener", Boolean.valueOf(tencentMapGestureListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        ra.b(qa.W, "addTileOverlay", (Object) (tileOverlayOptions != null ? tileOverlayOptions.toString() : ""));
        return null;
    }

    @Override // com.tencent.mapsdk.internal.w1
    public void b() {
        ra.h(qa.S);
        h();
        ra.i(qa.S);
    }

    public void b(Bundle bundle) {
    }

    @Override // com.tencent.mapsdk.internal.w1
    public void c() {
        ra.h(qa.Q);
        i();
        ra.i(qa.Q);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clear() {
        ra.b(qa.W, "clear", Integer.valueOf(ra.i(qa.W, "clear")));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clearAllOverlays() {
        ra.b(qa.W, "clearAllOverlays", Integer.valueOf(ra.i(qa.W, "clearAllOverlays")));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clearCache() {
        ra.b(qa.W, "clearCache", Integer.valueOf(ra.i(qa.W, "clearCache")));
    }

    @Override // com.tencent.mapsdk.internal.w1
    public void d() {
        ra.h(qa.N);
        l();
        ra.i(qa.N);
    }

    @Override // com.tencent.mapsdk.internal.w1
    public void e() {
        ra.h(qa.O);
        k();
        ra.i(qa.O);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void enableAutoMaxSkew(boolean z) {
        ra.b(qa.W, "enableAutoMaxSkew", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void enableMultipleInfowindow(boolean z) {
        ra.b(qa.W, "enableMultipleInfowindow", Boolean.valueOf(z));
    }

    @Override // com.tencent.mapsdk.internal.w1
    public void f() {
        ra.h(qa.R);
        m();
        ra.i(qa.R);
    }

    public abstract boolean g();

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public <T extends TencentMapComponent.Component> T getMapComponent(Class<T> cls) {
        return (T) getMapContext().getMapComponent(cls);
    }

    public void h() {
    }

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public abstract void l();

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void loadKMLFile(String str) {
        ra.b(qa.W, "loadKMLFile", (Object) str);
    }

    public abstract void m();

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void removeOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        ra.b(qa.W, "removeOnMapLoadedCallback", Boolean.valueOf(onMapLoadedCallback != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        ra.b(qa.W, "removeTencentMapGestureListener", Boolean.valueOf(tencentMapGestureListener != null));
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void resetIndoorCellInfo() {
        ra.b(qa.W, "resetIndoorParkSpaceColors", (Object) "");
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBlockRouteEnabled(boolean z) {
        ra.b(qa.W, "setBlockRouteEnabled", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuilding3dEffectEnable(boolean z) {
        ra.b(qa.W, "setBuilding3dEffectEnable", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuildingBlackList(List<LatLngBounds> list) {
        ra.b(qa.W, "setBuildingBlackList", (Object) (list != null ? list.toString() : ""));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuildingEnable(boolean z) {
        ra.b(qa.W, "setBuildingEnable", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCameraCenterProportion(float f, float f2) {
        ra.b(qa.W, "setCameraCenterProportion", (Object) (f + "#" + f2));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCameraCenterProportion(float f, float f2, boolean z) {
        ra.b(qa.W, "setCameraCenterProportion", (Object) (f + "#" + f2 + "#" + z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCustomRender(CustomRender customRender) {
        ra.b(qa.W, "setCustomRender", customRender);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setDrawPillarWith2DStyle(boolean z) {
        ra.b(qa.W, "setDrawPillarWith2DStyle", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setForeignLanguage(Language language) {
        ra.b(qa.W, "setForeignLanguage", language);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setHandDrawMapEnable(boolean z) {
        ra.b(qa.W, "setHandDrawMapEnable", Boolean.valueOf(z));
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorCellInfo(List<IndoorCellInfo> list) {
        ra.b(qa.W, "setIndoorParkSpaceColors", (Object) (list != null ? list.toString() : ""));
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorEnabled(boolean z) {
        ra.b(qa.W, "setIndoorEnabled", Boolean.valueOf(z));
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorFloor(int i) {
        ra.b(qa.W, "setIndoorFloor", Integer.valueOf(i));
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorFloor(String str, String str2) {
        ra.b(qa.W, "setIndoorFloor", (Object) (str + "#" + str2));
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorMaskColor(int i) {
        ra.b(qa.W, "setIndoorMaskColor", Integer.valueOf(i));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        ra.b(qa.W, "setInfoWindowAdapter", Boolean.valueOf(infoWindowAdapter != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setLocationCompassHidden(boolean z) {
        ra.b(qa.W, "setLocationCompassEnabled", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setLocationNavigationGravityLineHidden(boolean z) {
        ra.b(qa.W, "setLocationNavigationGravityLineEnabled", Boolean.valueOf(z));
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setLocationSource(LocationSource locationSource) {
        if (locationSource != null) {
            ra.b(qa.W, "setLocationSource", (Object) locationSource.getClass().getSimpleName());
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapCenterAndScale(float f, float f2, float f3) {
        ra.b(qa.W, "setMapCenterAndScale", (Object) (f + "#" + f2 + "#" + f3));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapFontSize(MapFontSize mapFontSize) {
        ra.b(qa.W, "setMapFontSize", mapFontSize);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapFrameRate(float f) {
        ra.b(qa.W, "setMapFrameRate", Float.valueOf(f));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapStyle(int i) {
        ra.b(qa.W, "setMapStyle", Integer.valueOf(i));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapType(int i) {
        ra.b(qa.W, "setMapType", Integer.valueOf(i));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMaxZoomLevel(int i) {
        ra.b(qa.W, "setMaxZoomLevel", Integer.valueOf(i));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMinZoomLevel(int i) {
        ra.b(qa.W, "setMinZoomLevel", Integer.valueOf(i));
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationClickListener(TencentMap.OnMyLocationClickListener onMyLocationClickListener) {
        ra.b(qa.W, "setMyLocationClickListener", Boolean.valueOf(onMyLocationClickListener != null));
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationEnabled(boolean z) {
        ra.b(qa.W, "setMyLocationEnabled", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        ra.b(qa.W, "setMyLocationStyle", (Object) (myLocationStyle != null ? myLocationStyle.toString() : ""));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnCameraChangeListener(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        ra.b(qa.W, "setOnCameraChangeListener", Boolean.valueOf(onCameraChangeListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnCompassClickedListener(TencentMap.OnCompassClickedListener onCompassClickedListener) {
        ra.b(qa.W, "setOnCompassClickedListener", Boolean.valueOf(onCompassClickedListener != null));
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        ra.b(qa.W, "setOnIndoorStateChangeListener", Boolean.valueOf(onIndoorStateChangeListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        ra.b(qa.W, "OnInfoWindowClickListener", Boolean.valueOf(onInfoWindowClickListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapClickListener(TencentMap.OnMapClickListener onMapClickListener) {
        ra.b(qa.W, "setOnMapClickListener", Boolean.valueOf(onMapClickListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        addOnMapLoadedCallback(onMapLoadedCallback);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapLongClickListener(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        ra.b(qa.W, "setOnMapLongClickListener", Boolean.valueOf(onMapLongClickListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        ra.b(qa.W, "setOnMapPoiClickListener", Boolean.valueOf(onMapPoiClickListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMarkerClickListener(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        ra.b(qa.W, "setOnMarkerClickListener", Boolean.valueOf(onMarkerClickListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMarkerDragListener(TencentMap.OnMarkerDragListener onMarkerDragListener) {
        ra.b(qa.W, "OnMarkerDragListener", Boolean.valueOf(onMarkerDragListener != null));
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        ra.b(qa.W, "setOnMyLocationChangeListener", Boolean.valueOf(onMyLocationChangeListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnPolygonClickListener(TencentMap.OnPolygonClickListener onPolygonClickListener) {
        ra.b(qa.W, "setOnPolygonClickListener", Boolean.valueOf(onPolygonClickListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnPolylineClickListener(TencentMap.OnPolylineClickListener onPolylineClickListener) {
        ra.b(qa.W, "setOnPolylineClickListener", Boolean.valueOf(onPolylineClickListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnScaleViewChangedListener(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener) {
        ra.b(qa.W, "setOnScaleViewChangedListener", Boolean.valueOf(onScaleViewChangedListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnTapMapViewInfoWindowHidden(boolean z) {
        ra.b(qa.W, "setOnTapMapViewInfoWindowHidden", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnTrafficEventClickListener(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener) {
        ra.b(qa.W, "setOnTrafficEventClickListener", Boolean.valueOf(onTrafficEventClickListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnVectorOverlayClickListener(TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        ra.b(qa.W, "setOnVectorOverlayClickListener", Boolean.valueOf(onVectorOverlayClickListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOverSeaEnable(boolean z) {
        ra.b(qa.W, "enableOverSea", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOverSeaTileProvider(OverSeaTileProvider overSeaTileProvider) {
        ra.b(qa.W, "setOverSeaTileProvider", overSeaTileProvider);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPadding(int i, int i2, int i3, int i4) {
        ra.b(qa.W, "setPadding", (Object) (i + "#" + i2 + "#" + i3 + "#" + i4));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPadding(int i, int i2, int i3, int i4, boolean z) {
        ra.b(qa.W, "setPadding", (Object) (i + "#" + i2 + "#" + i3 + "#" + i4 + "#" + z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPointToCenter(int i, int i2) {
        ra.b(qa.W, "setPointToCenter", (Object) (i + "#" + i2));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPoisEnabled(boolean z) {
        ra.b(qa.W, "setPoisEnabled", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setRestrictBounds(LatLngBounds latLngBounds, RestrictBoundsFitMode restrictBoundsFitMode) {
        String str;
        if (latLngBounds == null) {
            str = "null restrictBounds";
        } else {
            str = latLngBounds.toString() + "#" + restrictBoundsFitMode;
        }
        ra.b(qa.W, "setRestrictBounds", (Object) str);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setSatelliteEnabled(boolean z) {
        ra.b(qa.W, "setSatelliteEnabled", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        ra.b(qa.W, "setTencentMapGestureListener", Boolean.valueOf(tencentMapGestureListener != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setTrafficEnabled(boolean z) {
        ra.b(qa.W, "setTrafficEnabled", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void showBuilding(boolean z) {
        ra.b(qa.W, "showBuilding", Boolean.valueOf(z));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback) {
        ra.b(qa.W, "snapshot", Boolean.valueOf(snapshotReadyCallback != null));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config) {
        StringBuilder sb = new StringBuilder();
        sb.append(snapshotReadyCallback != null);
        sb.append("#");
        sb.append(config);
        ra.b(qa.W, "snapshot", (Object) sb.toString());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(snapshotReadyCallback != null);
        sb.append("#");
        sb.append(config);
        sb.append("#");
        sb.append(i);
        ra.b(qa.W, "snapshot", (Object) sb.toString());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void stopAnimation() {
        ra.b(qa.W, "stopAnimation", Integer.valueOf(ra.i(qa.W, "stopAnimation")));
    }
}
