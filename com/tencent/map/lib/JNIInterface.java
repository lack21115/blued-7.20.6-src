package com.tencent.map.lib;

import android.graphics.Rect;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AggregationOverlayInfo;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.ArcLineOverlayInfo;
import com.tencent.map.lib.models.CircleInfo;
import com.tencent.map.lib.models.CityTrafficInfo;
import com.tencent.map.lib.models.GLModelInfo;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.map.lib.models.HeatmapInfo;
import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.map.lib.models.IntersectionOverlayInfo;
import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.lib.models.ScatterPlotInfo;
import com.tencent.map.lib.models.TrailOverlayInfo;
import com.tencent.mapsdk.shell.events.EngineWriteDataModel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/JNIInterface.class */
public class JNIInterface implements JNIInterfaceCallback {
    private JNIInterfaceCallback mCallback;

    public JNIInterface(JNIInterfaceCallback jNIInterfaceCallback) {
        this.mCallback = jNIInterfaceCallback;
    }

    public static native synchronized void nativeEndProfile();

    public static native synchronized void nativeStartProfile();

    public native int addLineText(long j, GeoPoint[] geoPointArr, PolylineOptions.Text text);

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public Object callback(int i, int i2, String str, byte[] bArr, Object obj) {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            return jNIInterfaceCallback.callback(i, i2, str, bArr, obj);
        }
        return null;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public int callbackGetGLContext() {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            return jNIInterfaceCallback.callbackGetGLContext();
        }
        return 0;
    }

    public native boolean checkMapLoadFinishedTask(long j, int i);

    public native int getIndoorOutlineZoom(long j, String str);

    public native String getMapEngineRenderStatus(long j);

    public native long nativeAddAggregationOverlay(long j, AggregationOverlayInfo aggregationOverlayInfo);

    public native long nativeAddArcLineOverlay(long j, ArcLineOverlayInfo arcLineOverlayInfo);

    public native int nativeAddCircle(long j, CircleInfo circleInfo);

    public native long nativeAddGLModel(long j, GLModelInfo gLModelInfo);

    public native long nativeAddGroundOverlay(long j, GroundOverlayInfo groundOverlayInfo);

    public native long nativeAddHeatmapOverlay(long j, HeatmapInfo heatmapInfo);

    public native long nativeAddIntersectionOverlay(long j, IntersectionOverlayInfo intersectionOverlayInfo);

    public native int nativeAddMarker(long j, String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, int i2);

    public native long nativeAddMarker2(long j, MarkerInfo markerInfo);

    public native int nativeAddMaskLayer(long j, MaskLayer maskLayer);

    public native int nativeAddPolygon(long j, PolygonInfo polygonInfo);

    public native void nativeAddRouteNameSegments(long j, byte[][] bArr, int i, GeoPoint[] geoPointArr, int i2);

    public native long nativeAddScatterPlotOverlay(long j, ScatterPlotInfo scatterPlotInfo);

    public native int nativeAddTileOverlay(long j, TileOverlayCallback tileOverlayCallback, boolean z);

    public native long nativeAddTrailOverlay(long j, TrailOverlayInfo trailOverlayInfo);

    public native void nativeBringElementAbove(long j, int i, int i2);

    public native void nativeBringElementBelow(long j, int i, int i2);

    public native void nativeCheckTrafficBlockCache(long j, int i, int i2, int i3, int i4, int i5);

    public native void nativeCheckTrafficBlockCacheForReplay(long j, int i, int i2, int i3, int i4, int i5);

    public native int nativeClearCache(long j);

    public native void nativeClearDownloadURLCache(long j);

    public native void nativeClearRouteNameSegments(long j);

    public native AnnocationTextResult nativeCreateAnnotationText(long j, AnnocationText annocationText);

    public native int nativeCreateOrUpdateLine(long j, int i, int[] iArr, int[] iArr2, GeoPoint[] geoPointArr, String str, float f, int i2, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int[] iArr3, int[] iArr4, float f2, int[] iArr5, float f3, int i4, boolean z6);

    public native void nativeDeleteCircle(long j, int i);

    public native void nativeDeleteIcons(long j, int[] iArr, int i);

    public native void nativeDeleteLine(long j, long j2, boolean z);

    public native void nativeDeletePolygon(long j, int i, int i2);

    public native void nativeDestroyEngine(long j);

    public native boolean nativeDrawFrame(long j);

    public native void nativeEnableBaseMap(long j, boolean z);

    public native void nativeEnableBuilding(long j, boolean z);

    public native void nativeEnablePOI(long j, boolean z);

    public native int[] nativeFetchLackedTrafficBlocks(long j);

    public native void nativeFromScreenLocation(long j, byte[] bArr, float f, float f2, double[] dArr);

    public native float[] nativeGLProjectMatrix();

    public native double[] nativeGLViewMatrix();

    public native float nativeGLViewScaleRatio();

    public native int[] nativeGLViewport();

    public native boolean nativeGenerateTextures(long j);

    public native String nativeGetActiveIndoorBuildingGUID(long j);

    public native VectorHeatAggregationUnit nativeGetAggregationUnit(long j, long j2, LatLng latLng);

    public native boolean nativeGetAndResetDirty(long j);

    public native String nativeGetBlockRouteInfo(long j, int i, int i2);

    public native void nativeGetCenterMapPoint(long j, GeoPoint geoPoint);

    public native byte[] nativeGetCityName(long j, GeoPoint geoPoint);

    public native String nativeGetCurIndoorName(long j, GeoPoint geoPoint);

    public native String nativeGetDataEngineVersion(long j);

    public native int nativeGetEngineId(long j);

    public native String nativeGetEngineLogInfo(long j);

    public native int nativeGetGLModelSkeletonAnimationCount(long j, long j2);

    public native float[] nativeGetGLModelSkeletonAnimationDuration(long j, long j2);

    public native String[] nativeGetGLModelSkeletonAnimationName(long j, long j2);

    public native Rect nativeGetIndoorBound(long j);

    public native int nativeGetIndoorCurrentFloorId(long j);

    public native String[] nativeGetIndoorFloorNames(long j);

    public native int nativeGetLanguage(long j);

    public native String nativeGetMapEngineVersion(long j);

    public native int nativeGetMapStyle(long j);

    public native ArrayList nativeGetPoisInScreen(long j);

    public native float nativeGetRotate(long j);

    public native double nativeGetScale(long j);

    public native int nativeGetScaleLevel(long j);

    public native float nativeGetSkew(long j);

    public native double nativeGetTargetScale(long j, Rect rect, Rect rect2);

    public native boolean nativeGetTrafficCityInfo(long j, String str, CityTrafficInfo cityTrafficInfo);

    public native boolean nativeHasStreetRoad(long j, String str);

    public native void nativeHideCompass(long j);

    public native void nativeHideIcons(long j, int[] iArr, int i);

    public native void nativeHideStreetRoad(long j);

    public native void nativeHideTraffic(long j);

    public native void nativeIndoorBuildingEnabled(long j, boolean z);

    public native long nativeInitEngine(String str, String str2, String str3, float f, int i, float f2, int[] iArr, boolean z, int i2);

    public native int nativeIsCityHasTraffic(long j, String str);

    @Deprecated
    public native boolean nativeIsMapDrawFinished(long j);

    public native boolean nativeIsTileOverlayEnabled(long j);

    public native void nativeLineClearPoint(long j, long j2, GeoPoint geoPoint, int i);

    public native void nativeLineInsertPoint(long j, long j2, GeoPoint geoPoint, int i);

    public native void nativeLoadBlockRouteCityList(long j, int[] iArr, int[] iArr2, int i);

    public native void nativeLockEngine(long j);

    public native void nativeMapLoadKMLFile(long j, String str);

    public native void nativeMapSetSatelliteServerFullUrl(long j, String str);

    public native float nativeMapSightGetOnScreenHeight(long j);

    public native void nativeMoveBy(long j, float f, float f2, boolean z);

    public native boolean nativeNeedDispaly(long j);

    public native boolean nativeNeedRedraw(long j);

    public native byte[] nativeOnTap(long j, float f, float f2);

    public native boolean nativeOnTapLine(long j, float f, float f2);

    public native int nativeQueryCityCodeList(long j, Rect rect, int i, int[] iArr, int i2);

    public native int nativeRefreshTrafficData(long j, byte[] bArr, int i, boolean z, boolean z2);

    public native void nativeReloadTileOverlay(long j, int i);

    public native void nativeRemoveEngineOverlay(long j);

    public native void nativeRemoveGLVisualizationOverlay(long j, long j2);

    public native void nativeRemoveMaskLayer(long j, int i);

    public native void nativeRemoveTileOverlay(long j, int i);

    public native void nativeResetEnginePath(long j, String str, String str2, String str3);

    public native void nativeResetIndoorCellInfo(long j);

    public native void nativeScheduleClickOnNextRender(long j, float f, float f2);

    public native void nativeSetBlockRouteVisible(long j, boolean z);

    public native void nativeSetBuilding3DEffect(long j, boolean z);

    public native void nativeSetBuildingBlackList(long j, LatLngBounds[] latLngBoundsArr);

    public native void nativeSetBuildingToSpecificFloor(long j, String str, String str2);

    public native void nativeSetCallback(long j);

    public native void nativeSetCenter(long j, GeoPoint geoPoint, boolean z);

    public native void nativeSetCenterMapPointAndScaleLevel(long j, GeoPoint geoPoint, int i, boolean z);

    public native void nativeSetCompassImage(long j, String str);

    public native void nativeSetCompassPosition(long j, int i, int i2);

    public native void nativeSetCompassVisible(long j, boolean z);

    public native void nativeSetDrawCap(long j, long j2, boolean z);

    public native void nativeSetFlagOfZoomToSpanForLocation(long j, float f, float f2, float f3, float f4);

    public native void nativeSetIconsHidden(long j, int[] iArr, int i, boolean z);

    public native void nativeSetIndoorActiveScreenArea(long j, float f, float f2, float f3, float f4);

    public native void nativeSetIndoorBuildingPickEnabled(long j, boolean z);

    public native void nativeSetIndoorBuildingStyle(long j, int i);

    public native void nativeSetIndoorCellInfo(long j, IndoorCellInfo[] indoorCellInfoArr);

    public native void nativeSetIndoorConfigType(long j, int i);

    public native void nativeSetIndoorFloor(long j, int i);

    public native void nativeSetIndoorMaskColor(long j, int i);

    public native void nativeSetLanguage(long j, int i);

    public native void nativeSetLineArrowSpacing(long j, int i, float f);

    public native void nativeSetLineDirectionArrowTextureName(long j, long j2, String str);

    public native void nativeSetLineDrawArrow(long j, long j2, boolean z);

    public native void nativeSetLineFootPrintSpacing(long j, int i, float f);

    public native void nativeSetLineSelected(long j, long j2, boolean z);

    public native void nativeSetLocationCircleColor(long j, int i);

    public native void nativeSetLocationCircleHidden(long j, boolean z);

    public native void nativeSetLocationCompassGroupImages(long j, String str, String str2, String str3, String str4, String str5);

    public native void nativeSetLocationCompassMarkerHidden(long j, boolean z);

    public native void nativeSetLocationCompassMarkerImage(long j, String str);

    public native void nativeSetLocationFollow(long j, boolean z, boolean z2, boolean z3, boolean z4);

    public native void nativeSetLocationHeading(long j, float f);

    public native void nativeSetLocationInfo(long j, double d, double d2, float f, float f2, boolean z);

    public native void nativeSetLocationMarkerHidden(long j, boolean z);

    public native int nativeSetLocationMarkerImage(long j, String str, float f, float f2);

    public native void nativeSetLocationRedLineHidden(long j, boolean z);

    public native void nativeSetLocationRedLineInfo(long j, float f, int i, LatLng latLng);

    public native void nativeSetMapFontSize(long j, int i);

    public native void nativeSetMapParam(long j, byte[] bArr);

    public native void nativeSetMapStyle(long j, int i, boolean z);

    public native void nativeSetMarkerMainSubRelation(long j, int i, int i2);

    public native void nativeSetMarkerScaleLevelRange(long j, int i, int i2, int i3);

    public native void nativeSetMarsXLogLevel(int i, boolean z, boolean z2);

    public native void nativeSetMaxScaleLevel(long j, int i);

    public native void nativeSetMinScaleLevel(long j, int i);

    public native void nativeSetNeedDisplay(long j, boolean z);

    public native void nativeSetPriority(long j, int i, float f);

    public native void nativeSetRotate(long j, float f, boolean z);

    public native void nativeSetSatelliteEnabled(long j, boolean z);

    public native void nativeSetScale(long j, double d, boolean z);

    public native void nativeSetScaleLevel(long j, int i, boolean z);

    public native void nativeSetScreenCenterOffset(long j, float f, float f2, boolean z);

    public native void nativeSetServerHost(long j, String str);

    public native void nativeSetShowIndoorBuildingWhiteList(long j, String[] strArr);

    public native void nativeSetSkew(long j, float f, boolean z);

    public native void nativeSetTileOverlayDataLevelRange(long j, int i, int i2, int i3);

    public native void nativeSetTileOverlayEnabled(long j, boolean z);

    public native void nativeSetTileOverlayPriority(long j, int i, int i2);

    public native void nativeSetTrafficColor(long j, int i, int i2, int i3, int i4);

    public native void nativeSetTrafficStyle(long j, TrafficStyle trafficStyle);

    public native void nativeSetTurnArrow(long j, long j2, GeoPoint[] geoPointArr, int i, int i2);

    public native void nativeSetTurnArrowStyle(long j, long j2, int i, int i2);

    public native void nativeSetViewport(long j, int i, int i2, int i3, int i4);

    public native void nativeShowStreetRoad(long j);

    public native void nativeShowTraffic(long j);

    public native void nativeStartGLModelSkeletonAnimation(long j, long j2, int i, float f, boolean z);

    public native void nativeStopGLModelSkeletonAnimation(long j, long j2);

    public native void nativeSwitchEngineForeGround(long j, boolean z);

    public native void nativeToScreenLocation(long j, byte[] bArr, double d, double d2, float[] fArr);

    public native void nativeUnlockEngine(long j);

    public native void nativeUpdateAggregationOverlay(long j, long j2, AggregationOverlayInfo aggregationOverlayInfo);

    public native void nativeUpdateArcLineOverlay(long j, long j2, ArcLineOverlayInfo arcLineOverlayInfo);

    public native void nativeUpdateCircle(long j, int i, CircleInfo circleInfo);

    public native void nativeUpdateFrame(long j, double d);

    public native void nativeUpdateGLModel(long j, long j2, GLModelInfo gLModelInfo);

    public native void nativeUpdateGroundOverlay(long j, long j2, GroundOverlayInfo groundOverlayInfo);

    public native void nativeUpdateHeatmapOverlay(long j, long j2, HeatmapInfo heatmapInfo);

    public native void nativeUpdateIntersectionOverlay(long j, IntersectionOverlayInfo intersectionOverlayInfo);

    public native void nativeUpdateMapResource(long j, String str);

    public native void nativeUpdateMarker(long j, MarkerInfo markerInfo);

    public native void nativeUpdateMarkerInfo(long j, int i, String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i2, int i3);

    public native void nativeUpdateMaskLayer(long j, int i, int i2);

    public native void nativeUpdatePolygon(long j, int i, int i2, PolygonInfo polygonInfo);

    public native void nativeUpdateScatterPlotOverlay(long j, long j2, ScatterPlotInfo scatterPlotInfo);

    public native void nativeUpdateTrailOverlay(long j, long j2, TrailOverlayInfo trailOverlayInfo);

    public native EngineWriteDataModel nativeWriteMapDataBlock(long j, String str, byte[] bArr);

    public native void nativeZoomIn(long j, float f, float f2);

    public native void nativeZoomOut(long j);

    public native void nativeZoomToSpan(long j, Rect rect, Rect rect2, boolean z);

    public native void nativeZoomToSpanForNavigation(long j, GeoPoint geoPoint, int i, int i2, boolean z);

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public boolean onJniCallbackRenderMapFrame(int i) {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            return jNIInterfaceCallback.onJniCallbackRenderMapFrame(i);
        }
        return false;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapCameraChangeStopped() {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            jNIInterfaceCallback.onMapCameraChangeStopped();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapCameraChanged() {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            jNIInterfaceCallback.onMapCameraChanged();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapLoaded() {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            jNIInterfaceCallback.onMapLoaded();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onVisualLayerClickResult(float f, float f2, long j, String str, String str2) {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            jNIInterfaceCallback.onVisualLayerClickResult(f, f2, j, str, str2);
        }
    }

    public native void removeLineText(long j, int i);

    public native void setLineTextStyle(long j, int i, PolylineOptions.Text text);

    public native void setRestrictBounds(long j, double[] dArr, double[] dArr2, int i);
}
