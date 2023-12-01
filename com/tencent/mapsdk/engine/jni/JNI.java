package com.tencent.mapsdk.engine.jni;

import android.graphics.Rect;
import com.tencent.map.lib.JNIInterface;
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
import com.tencent.mapsdk.internal.be;
import com.tencent.mapsdk.internal.ee;
import com.tencent.mapsdk.internal.ge;
import com.tencent.mapsdk.internal.he;
import com.tencent.mapsdk.internal.le;
import com.tencent.mapsdk.internal.ma;
import com.tencent.mapsdk.internal.me;
import com.tencent.mapsdk.internal.na;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.oe;
import com.tencent.mapsdk.internal.pe;
import com.tencent.mapsdk.internal.qe;
import com.tencent.mapsdk.internal.t1;
import com.tencent.mapsdk.internal.w;
import com.tencent.mapsdk.shell.events.EngineWriteDataModel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/engine/jni/JNI.class */
public class JNI {
    private JNICallback mCallback;
    private JNIInterface mJNIInterface;

    public static void nativeEndProfile() {
        synchronized (JNI.class) {
            try {
                JNIInterface.nativeEndProfile();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void nativeStartProfile() {
        synchronized (JNI.class) {
            try {
                JNIInterface.nativeStartProfile();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int addLineText(long j, GeoPoint[] geoPointArr, PolylineOptions.Text text) {
        return this.mJNIInterface.addLineText(j, geoPointArr, text);
    }

    public boolean checkMapLoadFinishedTask(long j, int i) {
        return this.mJNIInterface.checkMapLoadFinishedTask(j, i);
    }

    public void destory() {
        this.mCallback.destory();
        this.mCallback = null;
        this.mJNIInterface = null;
    }

    public VectorHeatAggregationUnit getAggregationUnit(long j, long j2, LatLng latLng) {
        return this.mJNIInterface.nativeGetAggregationUnit(j, j2, latLng);
    }

    public int getIndoorOutlineZoom(long j, String str) {
        return this.mJNIInterface.getIndoorOutlineZoom(j, str);
    }

    public String getMapEngineRenderStatus(long j) {
        return this.mJNIInterface.getMapEngineRenderStatus(j);
    }

    public void initCallback(be beVar, w wVar, he heVar, ge geVar, pe peVar, le leVar, oe oeVar, t1 t1Var, qe qeVar, ne neVar, ee eeVar) {
        JNICallback jNICallback = new JNICallback(beVar, wVar, heVar, geVar, peVar, leVar, oeVar, t1Var, qeVar, neVar, eeVar);
        this.mCallback = jNICallback;
        this.mJNIInterface = new JNIInterface(jNICallback);
    }

    public long nativeAddAggregatioinOverlay(long j, AggregationOverlayInfo aggregationOverlayInfo) {
        return this.mJNIInterface.nativeAddAggregationOverlay(j, aggregationOverlayInfo);
    }

    public long nativeAddArcLineOverlay(long j, ArcLineOverlayInfo arcLineOverlayInfo) {
        return this.mJNIInterface.nativeAddArcLineOverlay(j, arcLineOverlayInfo);
    }

    public int nativeAddCircle(long j, CircleInfo circleInfo) {
        return this.mJNIInterface.nativeAddCircle(j, circleInfo);
    }

    public long nativeAddGLModel(long j, GLModelInfo gLModelInfo) {
        return this.mJNIInterface.nativeAddGLModel(j, gLModelInfo);
    }

    public long nativeAddGroundOverlay(long j, GroundOverlayInfo groundOverlayInfo) {
        return this.mJNIInterface.nativeAddGroundOverlay(j, groundOverlayInfo);
    }

    public long nativeAddHeatmapOverlay(long j, HeatmapInfo heatmapInfo) {
        return this.mJNIInterface.nativeAddHeatmapOverlay(j, heatmapInfo);
    }

    public long nativeAddIntersectionOverlay(long j, IntersectionOverlayInfo intersectionOverlayInfo) {
        return this.mJNIInterface.nativeAddIntersectionOverlay(j, intersectionOverlayInfo);
    }

    public int nativeAddMarker(long j, String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, int i2) {
        return this.mJNIInterface.nativeAddMarker(j, str, d, d2, f, f2, f3, f4, f5, f6, z, z2, z3, z4, z5, i, i2);
    }

    public long nativeAddMarker2(long j, MarkerInfo markerInfo) {
        return this.mJNIInterface.nativeAddMarker2(j, markerInfo);
    }

    public int nativeAddMaskLayer(long j, MaskLayer maskLayer) {
        return this.mJNIInterface.nativeAddMaskLayer(j, maskLayer);
    }

    public int nativeAddPolygon(long j, PolygonInfo polygonInfo) {
        return this.mJNIInterface.nativeAddPolygon(j, polygonInfo);
    }

    public void nativeAddRouteNameSegments(long j, byte[][] bArr, int i, GeoPoint[] geoPointArr, int i2) {
        this.mJNIInterface.nativeAddRouteNameSegments(j, bArr, i, geoPointArr, i2);
    }

    public long nativeAddScatterOverlay(long j, ScatterPlotInfo scatterPlotInfo) {
        return this.mJNIInterface.nativeAddScatterPlotOverlay(j, scatterPlotInfo);
    }

    public int nativeAddTileOverlay(long j, TileOverlayCallback tileOverlayCallback, boolean z) {
        return this.mJNIInterface.nativeAddTileOverlay(j, tileOverlayCallback, z);
    }

    public long nativeAddTrailOverlay(long j, TrailOverlayInfo trailOverlayInfo) {
        return this.mJNIInterface.nativeAddTrailOverlay(j, trailOverlayInfo);
    }

    public void nativeBringElementAbove(long j, int i, int i2) {
        this.mJNIInterface.nativeBringElementAbove(j, i, i2);
    }

    public void nativeBringElementBelow(long j, int i, int i2) {
        this.mJNIInterface.nativeBringElementBelow(j, i, i2);
    }

    public void nativeCheckTrafficBlockCache(long j, int i, int i2, int i3, int i4, int i5) {
        this.mJNIInterface.nativeCheckTrafficBlockCache(j, i, i2, i3, i4, i5);
    }

    public void nativeCheckTrafficBlockCacheForReplay(long j, int i, int i2, int i3, int i4, int i5) {
        this.mJNIInterface.nativeCheckTrafficBlockCacheForReplay(j, i, i2, i3, i4, i5);
    }

    public int nativeClearCache(long j) {
        return this.mJNIInterface.nativeClearCache(j);
    }

    public void nativeClearDownloadURLCache(long j) {
        this.mJNIInterface.nativeClearDownloadURLCache(j);
    }

    public void nativeClearRouteNameSegments(long j) {
        this.mJNIInterface.nativeClearRouteNameSegments(j);
    }

    public AnnocationTextResult nativeCreateAnnotationTextBitmap(long j, AnnocationText annocationText) {
        return this.mJNIInterface.nativeCreateAnnotationText(j, annocationText);
    }

    public int nativeCreateOrUpdateLine(long j, int i, int[] iArr, int[] iArr2, GeoPoint[] geoPointArr, String str, float f, int i2, boolean z, boolean z2, boolean z3, boolean z4, float f2, boolean z5, int[] iArr3, int[] iArr4, float f3, int[] iArr5, float f4, int i3, boolean z6) {
        na.a(ma.f, "create or update line = " + i + " p:" + geoPointArr.length + " w:" + f + " v:" + z6 + " a:" + f4 + " bw:" + f3);
        return this.mJNIInterface.nativeCreateOrUpdateLine(j, i, iArr, iArr2, geoPointArr, str, f, i2, z, z2, z3, z4, (int) f2, z5, iArr3, iArr4, f3, iArr5, f4, i3, z6);
    }

    public void nativeDeleteCircle(long j, int i) {
        this.mJNIInterface.nativeDeleteCircle(j, i);
    }

    public void nativeDeleteIcons(long j, int[] iArr, int i) {
        this.mJNIInterface.nativeDeleteIcons(j, iArr, i);
    }

    public void nativeDeleteLine(long j, long j2, boolean z) {
        this.mJNIInterface.nativeDeleteLine(j, j2, z);
    }

    public void nativeDeletePolygon(long j, int i, int i2) {
        this.mJNIInterface.nativeDeletePolygon(j, i, i2);
    }

    public void nativeDestroyEngine(long j) {
        this.mJNIInterface.nativeDestroyEngine(j);
    }

    public boolean nativeDrawFrame(long j) {
        return this.mJNIInterface.nativeDrawFrame(j);
    }

    public void nativeEnableBaseMap(long j, boolean z) {
        this.mJNIInterface.nativeEnableBaseMap(j, z);
    }

    public void nativeEnableBuilding(long j, boolean z) {
        this.mJNIInterface.nativeEnableBuilding(j, z);
    }

    public void nativeEnablePOI(long j, boolean z) {
        this.mJNIInterface.nativeEnablePOI(j, z);
    }

    public int[] nativeFetchLackedTrafficBlocks(long j) {
        return this.mJNIInterface.nativeFetchLackedTrafficBlocks(j);
    }

    public void nativeFromScreenLocation(long j, byte[] bArr, float f, float f2, double[] dArr) {
        this.mJNIInterface.nativeFromScreenLocation(j, bArr, f, f2, dArr);
    }

    public float[] nativeGLProjectMatrix() {
        return this.mJNIInterface.nativeGLProjectMatrix();
    }

    public double[] nativeGLViewMatrix() {
        return this.mJNIInterface.nativeGLViewMatrix();
    }

    public float nativeGLViewScaleRatio() {
        return this.mJNIInterface.nativeGLViewScaleRatio();
    }

    public int[] nativeGLViewport() {
        return this.mJNIInterface.nativeGLViewport();
    }

    public boolean nativeGenerateTextures(long j) {
        return this.mJNIInterface.nativeGenerateTextures(j);
    }

    public String nativeGetActiveIndoorBuildingGUID(long j) {
        return this.mJNIInterface.nativeGetActiveIndoorBuildingGUID(j);
    }

    public boolean nativeGetAndResetDirty(long j) {
        return this.mJNIInterface.nativeGetAndResetDirty(j);
    }

    public String nativeGetBlockRouteInfo(long j, int i, int i2) {
        return this.mJNIInterface.nativeGetBlockRouteInfo(j, i, i2);
    }

    public void nativeGetCenterMapPoint(long j, GeoPoint geoPoint) {
        this.mJNIInterface.nativeGetCenterMapPoint(j, geoPoint);
    }

    public byte[] nativeGetCityName(long j, GeoPoint geoPoint) {
        return this.mJNIInterface.nativeGetCityName(j, geoPoint);
    }

    public String nativeGetCurIndoorName(long j, GeoPoint geoPoint) {
        return this.mJNIInterface.nativeGetCurIndoorName(j, geoPoint);
    }

    public String nativeGetDataEngineVersion(long j) {
        return this.mJNIInterface.nativeGetDataEngineVersion(j);
    }

    public int nativeGetEngineId(long j) {
        return this.mJNIInterface.nativeGetEngineId(j);
    }

    public String nativeGetEngineLogInfo(long j) {
        return this.mJNIInterface.nativeGetEngineLogInfo(j);
    }

    public int nativeGetGLModelSkeletonAnimationCount(long j, long j2) {
        return this.mJNIInterface.nativeGetGLModelSkeletonAnimationCount(j, j2);
    }

    public float[] nativeGetGLModelSkeletonAnimationDuration(long j, long j2) {
        return this.mJNIInterface.nativeGetGLModelSkeletonAnimationDuration(j, j2);
    }

    public String[] nativeGetGLModelSkeletonAnimationName(long j, long j2) {
        return this.mJNIInterface.nativeGetGLModelSkeletonAnimationName(j, j2);
    }

    public Rect nativeGetIndoorBound(long j) {
        return this.mJNIInterface.nativeGetIndoorBound(j);
    }

    public int nativeGetIndoorCurrentFloorId(long j) {
        return this.mJNIInterface.nativeGetIndoorCurrentFloorId(j);
    }

    public String[] nativeGetIndoorFloorNames(long j) {
        return this.mJNIInterface.nativeGetIndoorFloorNames(j);
    }

    public int nativeGetLanguage(long j) {
        return this.mJNIInterface.nativeGetLanguage(j);
    }

    public String nativeGetMapEngineVersion(long j) {
        return this.mJNIInterface.nativeGetDataEngineVersion(j);
    }

    public int nativeGetMapStyle(long j) {
        return this.mJNIInterface.nativeGetMapStyle(j);
    }

    public ArrayList nativeGetPoisInScreen(long j) {
        return this.mJNIInterface.nativeGetPoisInScreen(j);
    }

    public float nativeGetRotate(long j) {
        return this.mJNIInterface.nativeGetRotate(j);
    }

    public double nativeGetScale(long j) {
        return this.mJNIInterface.nativeGetScale(j);
    }

    public int nativeGetScaleLevel(long j) {
        return this.mJNIInterface.nativeGetScaleLevel(j);
    }

    public float nativeGetSkew(long j) {
        return this.mJNIInterface.nativeGetSkew(j);
    }

    public double nativeGetTargetScale(long j, Rect rect, Rect rect2) {
        return this.mJNIInterface.nativeGetTargetScale(j, rect, rect2);
    }

    public boolean nativeGetTrafficCityInfo(long j, String str, CityTrafficInfo cityTrafficInfo) {
        return this.mJNIInterface.nativeGetTrafficCityInfo(j, str, cityTrafficInfo);
    }

    public boolean nativeHasStreetRoad(long j, String str) {
        return this.mJNIInterface.nativeHasStreetRoad(j, str);
    }

    public void nativeHideCompass(long j) {
        this.mJNIInterface.nativeHideCompass(j);
    }

    public void nativeHideIcons(long j, int[] iArr, int i) {
        this.mJNIInterface.nativeHideIcons(j, iArr, i);
    }

    public void nativeHideStreetRoad(long j) {
        this.mJNIInterface.nativeHideStreetRoad(j);
    }

    public void nativeHideTraffic(long j) {
        this.mJNIInterface.nativeHideTraffic(j);
    }

    public void nativeIndoorBuildingEnabled(long j, boolean z) {
        this.mJNIInterface.nativeIndoorBuildingEnabled(j, z);
    }

    public long nativeInitEngine(String str, String str2, String str3, float f, int i, float f2, int[] iArr, boolean z, int i2) {
        return this.mJNIInterface.nativeInitEngine(str, str2, str3, f, i, f2, iArr, z, i2);
    }

    public int nativeIsCityHasTraffic(long j, String str) {
        return this.mJNIInterface.nativeIsCityHasTraffic(j, str);
    }

    @Deprecated
    public boolean nativeIsMapDrawFinished(long j) {
        return this.mJNIInterface.nativeIsMapDrawFinished(j);
    }

    public boolean nativeIsTileOverlayEnabled(long j) {
        return this.mJNIInterface.nativeIsTileOverlayEnabled(j);
    }

    public void nativeLineClearPoint(long j, long j2, GeoPoint geoPoint, int i) {
        this.mJNIInterface.nativeLineClearPoint(j, j2, geoPoint, i);
    }

    public void nativeLineInsertPoint(long j, long j2, GeoPoint geoPoint, int i) {
        this.mJNIInterface.nativeLineInsertPoint(j, j2, geoPoint, i);
    }

    public void nativeLoadBlockRouteCityList(long j, int[] iArr, int[] iArr2, int i) {
        this.mJNIInterface.nativeLoadBlockRouteCityList(j, iArr, iArr2, i);
    }

    public void nativeLockEngine(long j) {
        this.mJNIInterface.nativeLockEngine(j);
    }

    public void nativeMapLoadKMLFile(long j, String str) {
        this.mJNIInterface.nativeMapLoadKMLFile(j, str);
    }

    public void nativeMapSetSatelliteServerFullUrl(long j, String str) {
        this.mJNIInterface.nativeMapSetSatelliteServerFullUrl(j, str);
    }

    public float nativeMapSightGetOnScreenHeight(long j) {
        return this.mJNIInterface.nativeMapSightGetOnScreenHeight(j);
    }

    public void nativeMoveBy(long j, float f, float f2, boolean z) {
        this.mJNIInterface.nativeMoveBy(j, f, f2, z);
    }

    public boolean nativeNeedDispaly(long j) {
        return this.mJNIInterface.nativeNeedDispaly(j);
    }

    public boolean nativeNeedRedraw(long j) {
        return this.mJNIInterface.nativeNeedRedraw(j);
    }

    public byte[] nativeOnTap(long j, float f, float f2) {
        return this.mJNIInterface.nativeOnTap(j, f, f2);
    }

    public boolean nativeOnTapLine(long j, float f, float f2) {
        return this.mJNIInterface.nativeOnTapLine(j, f, f2);
    }

    public int nativeQueryCityCodeList(long j, Rect rect, int i, int[] iArr, int i2) {
        return this.mJNIInterface.nativeQueryCityCodeList(j, rect, i, iArr, i2);
    }

    public int nativeRefreshTrafficData(long j, byte[] bArr, int i, boolean z, boolean z2) {
        return this.mJNIInterface.nativeRefreshTrafficData(j, bArr, i, z, z2);
    }

    public void nativeReloadTileOverlay(long j, int i) {
        this.mJNIInterface.nativeReloadTileOverlay(j, i);
    }

    public void nativeRemoveEngineOverlay(long j) {
        this.mJNIInterface.nativeRemoveEngineOverlay(j);
    }

    public void nativeRemoveGLVisualizationOverlay(long j, long j2) {
        this.mJNIInterface.nativeRemoveGLVisualizationOverlay(j, j2);
    }

    public void nativeRemoveMaskLayer(long j, int i) {
        this.mJNIInterface.nativeRemoveMaskLayer(j, i);
    }

    public void nativeRemovePolygon(long j, int i, int i2) {
        this.mJNIInterface.nativeDeletePolygon(j, i, i2);
    }

    public void nativeRemoveTileOverlay(long j, int i) {
        this.mJNIInterface.nativeRemoveTileOverlay(j, i);
    }

    public void nativeResetEnginePath(long j, String str, String str2, String str3) {
        this.mJNIInterface.nativeResetEnginePath(j, str, str2, str3);
    }

    public void nativeResetIndoorCellInfo(long j) {
        this.mJNIInterface.nativeResetIndoorCellInfo(j);
    }

    public void nativeSetBlockRouteVisible(long j, boolean z) {
        this.mJNIInterface.nativeSetBlockRouteVisible(j, z);
    }

    public void nativeSetBuilding3DEffect(long j, boolean z) {
        this.mJNIInterface.nativeSetBuilding3DEffect(j, z);
    }

    public void nativeSetBuildingBlackList(long j, LatLngBounds[] latLngBoundsArr) {
        this.mJNIInterface.nativeSetBuildingBlackList(j, latLngBoundsArr);
    }

    public void nativeSetBuildingToSpecificFloor(long j, String str, String str2) {
        this.mJNIInterface.nativeSetBuildingToSpecificFloor(j, str, str2);
    }

    public void nativeSetCallback(long j) {
        this.mJNIInterface.nativeSetCallback(j);
    }

    public void nativeSetCenter(long j, GeoPoint geoPoint, boolean z) {
        this.mJNIInterface.nativeSetCenter(j, geoPoint, z);
    }

    public void nativeSetCenterMapPointAndScaleLevel(long j, GeoPoint geoPoint, int i, boolean z) {
        this.mJNIInterface.nativeSetCenterMapPointAndScaleLevel(j, geoPoint, i, z);
    }

    public void nativeSetCompassImage(long j, String str) {
        this.mJNIInterface.nativeSetCompassImage(j, str);
    }

    public void nativeSetCompassPosition(long j, int i, int i2) {
        this.mJNIInterface.nativeSetCompassPosition(j, i, i2);
    }

    public void nativeSetCompassVisible(long j, boolean z) {
        this.mJNIInterface.nativeSetCompassVisible(j, z);
    }

    public void nativeSetDrawCap(long j, long j2, boolean z) {
        this.mJNIInterface.nativeSetDrawCap(j, j2, z);
    }

    public void nativeSetFlagOfZoomToSpanForLocation(long j, float f, float f2, float f3, float f4) {
        this.mJNIInterface.nativeSetFlagOfZoomToSpanForLocation(j, f, f2, f3, f4);
    }

    public void nativeSetIconsHidden(long j, int[] iArr, int i, boolean z) {
        this.mJNIInterface.nativeSetIconsHidden(j, iArr, i, z);
    }

    public void nativeSetIndoorActiveScreenArea(long j, float f, float f2, float f3, float f4) {
        this.mJNIInterface.nativeSetIndoorActiveScreenArea(j, f, f2, f3, f4);
    }

    public void nativeSetIndoorBuildingPickEnabled(long j, boolean z) {
        this.mJNIInterface.nativeSetIndoorBuildingPickEnabled(j, z);
    }

    public void nativeSetIndoorBuildingStyle(long j, int i) {
        na.a(ma.f, "nativeSetIndoorBuildingStyle:" + i);
        this.mJNIInterface.nativeSetIndoorBuildingStyle(j, i);
    }

    public void nativeSetIndoorCellInfo(long j, List<IndoorCellInfo> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (IndoorCellInfo indoorCellInfo : list) {
                if (indoorCellInfo != null && indoorCellInfo.getStyle() != null) {
                    arrayList.add(indoorCellInfo);
                }
            }
            this.mJNIInterface.nativeSetIndoorCellInfo(j, (IndoorCellInfo[]) arrayList.toArray(new IndoorCellInfo[0]));
        }
    }

    public void nativeSetIndoorConfigType(long j, int i) {
        this.mJNIInterface.nativeSetIndoorConfigType(j, i);
    }

    public void nativeSetIndoorFloor(long j, int i) {
        this.mJNIInterface.nativeSetIndoorFloor(j, i);
    }

    public void nativeSetIndoorMaskColor(long j, int i) {
        this.mJNIInterface.nativeSetIndoorMaskColor(j, i);
    }

    public void nativeSetLanguage(long j, int i) {
        this.mJNIInterface.nativeSetLanguage(j, i);
    }

    public void nativeSetLineArrowSpacing(long j, int i, float f) {
        this.mJNIInterface.nativeSetLineArrowSpacing(j, i, f);
    }

    public void nativeSetLineDirectionArrowTextureName(long j, long j2, String str) {
        this.mJNIInterface.nativeSetLineDirectionArrowTextureName(j, j2, str);
    }

    public void nativeSetLineDrawArrow(long j, long j2, boolean z) {
        this.mJNIInterface.nativeSetLineDrawArrow(j, j2, z);
    }

    public void nativeSetLineFootPrintSpacing(long j, int i, float f) {
        this.mJNIInterface.nativeSetLineFootPrintSpacing(j, i, f);
    }

    public void nativeSetLineSelected(long j, long j2, boolean z) {
        this.mJNIInterface.nativeSetLineSelected(j, j2, z);
    }

    public void nativeSetLocationCircleColor(long j, int i) {
        this.mJNIInterface.nativeSetLocationCircleColor(j, i);
    }

    public void nativeSetLocationCircleHidden(long j, boolean z) {
        this.mJNIInterface.nativeSetLocationCircleHidden(j, z);
    }

    public void nativeSetLocationCompassGroupImages(long j, String str, String str2, String str3, String str4, String str5) {
        this.mJNIInterface.nativeSetLocationCompassGroupImages(j, str, str2, str3, str4, str5);
    }

    public void nativeSetLocationCompassMarkerHidden(long j, boolean z) {
        this.mJNIInterface.nativeSetLocationCompassMarkerHidden(j, z);
    }

    public void nativeSetLocationCompassMarkerImage(long j, String str) {
        this.mJNIInterface.nativeSetLocationCompassMarkerImage(j, str);
    }

    public void nativeSetLocationFollow(long j, boolean z, boolean z2, boolean z3, boolean z4) {
        this.mJNIInterface.nativeSetLocationFollow(j, z, z2, z3, z4);
    }

    public void nativeSetLocationHeading(long j, float f) {
        this.mJNIInterface.nativeSetLocationHeading(j, f);
    }

    public void nativeSetLocationInfo(long j, double d, double d2, float f, float f2, boolean z) {
        this.mJNIInterface.nativeSetLocationInfo(j, d, d2, f, f2, z);
    }

    public void nativeSetLocationMarkerHidden(long j, boolean z) {
        this.mJNIInterface.nativeSetLocationMarkerHidden(j, z);
    }

    public int nativeSetLocationMarkerImage(long j, String str, float f, float f2) {
        return this.mJNIInterface.nativeSetLocationMarkerImage(j, str, f, f2);
    }

    public void nativeSetLocationRedLineHidden(long j, boolean z) {
        this.mJNIInterface.nativeSetLocationRedLineHidden(j, z);
    }

    public void nativeSetLocationRedLineInfo(long j, float f, int i, LatLng latLng) {
        this.mJNIInterface.nativeSetLocationRedLineInfo(j, f, i, latLng);
    }

    public void nativeSetMapFontSize(long j, int i) {
        this.mJNIInterface.nativeSetMapFontSize(j, i);
    }

    public void nativeSetMapParam(long j, byte[] bArr) {
        this.mJNIInterface.nativeSetMapParam(j, bArr);
    }

    public void nativeSetMapStyle(long j, int i, boolean z) {
        this.mJNIInterface.nativeSetMapStyle(j, i, z);
    }

    public void nativeSetMarkerMainSubRelation(long j, int i, int i2) {
        this.mJNIInterface.nativeSetMarkerMainSubRelation(j, i, i2);
    }

    public void nativeSetMarkerScaleLevelRange(long j, int i, int i2, int i3) {
        this.mJNIInterface.nativeSetMarkerScaleLevelRange(j, i, i2, i3);
    }

    public void nativeSetMaxScaleLevel(long j, int i) {
        this.mJNIInterface.nativeSetMaxScaleLevel(j, i);
    }

    public void nativeSetMinScaleLevel(long j, int i) {
        this.mJNIInterface.nativeSetMinScaleLevel(j, i);
    }

    public void nativeSetNeedDisplay(long j, boolean z) {
        this.mJNIInterface.nativeSetNeedDisplay(j, z);
    }

    public void nativeSetPolygonHidden(long j, int i, int i2, boolean z) {
        nativeSetIconsHidden(j, new int[]{i, i2}, 2, z);
    }

    public void nativeSetPriority(long j, int i, float f) {
        this.mJNIInterface.nativeSetPriority(j, i, f);
    }

    public void nativeSetRotate(long j, float f, boolean z) {
        this.mJNIInterface.nativeSetRotate(j, f, z);
    }

    public void nativeSetSatelliteEnabled(long j, boolean z) {
        this.mJNIInterface.nativeSetSatelliteEnabled(j, z);
    }

    public void nativeSetScale(long j, double d, boolean z) {
        this.mJNIInterface.nativeSetScale(j, d, z);
    }

    public void nativeSetScaleLevel(long j, int i, boolean z) {
        this.mJNIInterface.nativeSetScaleLevel(j, i, z);
    }

    public void nativeSetScreenCenterOffset(long j, float f, float f2, boolean z) {
        this.mJNIInterface.nativeSetScreenCenterOffset(j, f, f2, z);
    }

    public void nativeSetServerHost(long j, String str) {
        this.mJNIInterface.nativeSetServerHost(j, str);
    }

    public void nativeSetShowIndoorBuildingWhiteList(long j, String[] strArr) {
        this.mJNIInterface.nativeSetShowIndoorBuildingWhiteList(j, strArr);
    }

    public void nativeSetSkew(long j, float f, boolean z) {
        this.mJNIInterface.nativeSetSkew(j, f, z);
    }

    public void nativeSetTileOverlayDataLevelRange(long j, int i, int i2, int i3) {
        this.mJNIInterface.nativeSetTileOverlayDataLevelRange(j, i, i2, i3);
    }

    public void nativeSetTileOverlayEnabled(long j, boolean z) {
        this.mJNIInterface.nativeSetTileOverlayEnabled(j, z);
    }

    public void nativeSetTileOverlayPriority(long j, int i, int i2) {
        this.mJNIInterface.nativeSetTileOverlayPriority(j, i, i2);
    }

    public void nativeSetTrafficColor(long j, int i, int i2, int i3, int i4) {
        this.mJNIInterface.nativeSetTrafficColor(j, i, i2, i3, i4);
    }

    public void nativeSetTurnArrow(long j, long j2, List<GeoPoint> list, int i, int i2) {
        if (list != null) {
            this.mJNIInterface.nativeSetTurnArrow(j, j2, (GeoPoint[]) list.toArray(new GeoPoint[0]), i, i2);
        }
    }

    public void nativeSetTurnArrowStyle(long j, long j2, int i, int i2) {
        this.mJNIInterface.nativeSetTurnArrowStyle(j, j2, i, i2);
    }

    public void nativeSetViewport(long j, int i, int i2, int i3, int i4) {
        this.mJNIInterface.nativeSetViewport(j, i, i2, i3, i4);
    }

    public void nativeShowStreetRoad(long j) {
        this.mJNIInterface.nativeShowStreetRoad(j);
    }

    public void nativeShowTraffic(long j) {
        this.mJNIInterface.nativeShowTraffic(j);
    }

    public void nativeStartGLModelSkeletonAnimation(long j, long j2, int i, float f, boolean z) {
        this.mJNIInterface.nativeStartGLModelSkeletonAnimation(j, j2, i, f, z);
    }

    public void nativeStopGLModelSkeletonAnimation(long j, long j2) {
        this.mJNIInterface.nativeStopGLModelSkeletonAnimation(j, j2);
    }

    public void nativeSwitchEngineForeGround(long j, boolean z) {
        this.mJNIInterface.nativeSwitchEngineForeGround(j, z);
    }

    public void nativeToScreenLocation(long j, byte[] bArr, double d, double d2, float[] fArr) {
        this.mJNIInterface.nativeToScreenLocation(j, bArr, d, d2, fArr);
    }

    public void nativeUnlockEngine(long j) {
        this.mJNIInterface.nativeUnlockEngine(j);
    }

    public void nativeUpdateAggregatioinOverlay(long j, long j2, AggregationOverlayInfo aggregationOverlayInfo) {
        this.mJNIInterface.nativeUpdateAggregationOverlay(j, j2, aggregationOverlayInfo);
    }

    public void nativeUpdateArcLineOverlay(long j, long j2, ArcLineOverlayInfo arcLineOverlayInfo) {
        this.mJNIInterface.nativeUpdateArcLineOverlay(j, j2, arcLineOverlayInfo);
    }

    public void nativeUpdateCircle(long j, int i, CircleInfo circleInfo) {
        this.mJNIInterface.nativeUpdateCircle(j, i, circleInfo);
    }

    public void nativeUpdateFrame(long j, double d) {
        this.mJNIInterface.nativeUpdateFrame(j, d);
    }

    public void nativeUpdateGLModel(long j, long j2, GLModelInfo gLModelInfo) {
        this.mJNIInterface.nativeUpdateGLModel(j, j2, gLModelInfo);
    }

    public void nativeUpdateGroundOverlay(long j, long j2, GroundOverlayInfo groundOverlayInfo) {
        this.mJNIInterface.nativeUpdateGroundOverlay(j, j2, groundOverlayInfo);
    }

    public void nativeUpdateHeatmapOverlay(long j, long j2, HeatmapInfo heatmapInfo) {
        this.mJNIInterface.nativeUpdateHeatmapOverlay(j, j2, heatmapInfo);
    }

    public void nativeUpdateIntersectionOverlay(long j, IntersectionOverlayInfo intersectionOverlayInfo) {
        this.mJNIInterface.nativeUpdateIntersectionOverlay(j, intersectionOverlayInfo);
    }

    public void nativeUpdateMapResource(long j, String str) {
        this.mJNIInterface.nativeUpdateMapResource(j, str);
    }

    public void nativeUpdateMarker(long j, MarkerInfo markerInfo) {
        this.mJNIInterface.nativeUpdateMarker(j, markerInfo);
    }

    public void nativeUpdateMarkerInfo(long j, int i, String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i2, int i3) {
        this.mJNIInterface.nativeUpdateMarkerInfo(j, i, str, d, d2, f, f2, f3, f4, f5, f6, z, z2, z3, z4, z5, i2, i3);
    }

    public void nativeUpdateMaskLayer(long j, int i, int i2) {
        this.mJNIInterface.nativeUpdateMaskLayer(j, i, i2);
    }

    public void nativeUpdatePolygon(long j, int i, int i2, PolygonInfo polygonInfo) {
        this.mJNIInterface.nativeUpdatePolygon(j, i, i2, polygonInfo);
    }

    public void nativeUpdateScatterPlotOverlay(long j, long j2, ScatterPlotInfo scatterPlotInfo) {
        this.mJNIInterface.nativeUpdateScatterPlotOverlay(j, j2, scatterPlotInfo);
    }

    public void nativeUpdateTrailOverlay(long j, long j2, TrailOverlayInfo trailOverlayInfo) {
        this.mJNIInterface.nativeUpdateTrailOverlay(j, j2, trailOverlayInfo);
    }

    public EngineWriteDataModel nativeWriteMapDataBlock(long j, String str, byte[] bArr) {
        return this.mJNIInterface.nativeWriteMapDataBlock(j, str, bArr);
    }

    public void nativeZoomIn(long j, float f, float f2) {
        this.mJNIInterface.nativeZoomIn(j, f, f2);
    }

    public void nativeZoomOut(long j) {
        this.mJNIInterface.nativeZoomOut(j);
    }

    public void nativeZoomToSpan(long j, Rect rect, Rect rect2, boolean z) {
        this.mJNIInterface.nativeZoomToSpan(j, rect, rect2, z);
    }

    public void nativeZoomToSpanForNavigation(long j, GeoPoint geoPoint, int i, int i2, boolean z) {
        this.mJNIInterface.nativeZoomToSpanForNavigation(j, geoPoint, i, i2, z);
    }

    public void registerCallback(long j) {
        nativeSetCallback(j);
    }

    public void removeLineText(long j, int i) {
        this.mJNIInterface.removeLineText(j, i);
    }

    public void scheduleClickOnNextRender(long j, float f, float f2) {
        this.mJNIInterface.nativeScheduleClickOnNextRender(j, f, f2);
    }

    public void setLineTextStyle(long j, int i, PolylineOptions.Text text) {
        this.mJNIInterface.setLineTextStyle(j, i, text);
    }

    public void setMapCallbackGetGLContext(me meVar) {
        JNICallback jNICallback = this.mCallback;
        if (jNICallback != null) {
            jNICallback.setMapCallbackGetGLContext(meVar);
        }
    }

    public void setRestrictBounds(long j, double[] dArr, double[] dArr2, int i) {
        this.mJNIInterface.setRestrictBounds(j, dArr, dArr2, i);
    }

    public void setTrafficStyle(long j, TrafficStyle trafficStyle) {
        this.mJNIInterface.nativeSetTrafficStyle(j, trafficStyle);
    }
}
