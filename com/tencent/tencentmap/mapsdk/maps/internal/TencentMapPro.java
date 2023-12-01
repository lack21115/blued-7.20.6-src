package com.tencent.tencentmap.mapsdk.maps.internal;

import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mapsdk.internal.f0;
import com.tencent.mapsdk.internal.h1;
import com.tencent.mapsdk.internal.kj;
import com.tencent.mapsdk.internal.rc;
import com.tencent.mapsdk.internal.u4;
import com.tencent.mapsdk.internal.x1;
import com.tencent.mapsdk.internal.yi;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/internal/TencentMapPro.class */
public final class TencentMapPro {
    private yi mVectorMapDelegate;
    private boolean mapDestroyed = false;
    private h1 mapManager;
    private f0 viewControl;

    public TencentMapPro(h1 h1Var, f0 f0Var) {
        this.mapManager = h1Var;
        this.viewControl = f0Var;
        this.mVectorMapDelegate = h1Var.l();
    }

    public IntersectionOverlay addIntersectionEnlargeOverlay(IntersectionOverlayOptions intersectionOverlayOptions) {
        yi yiVar;
        rc A;
        if (this.mapDestroyed || (yiVar = this.mVectorMapDelegate) == null || (A = yiVar.A()) == null) {
            return null;
        }
        return A.a(intersectionOverlayOptions);
    }

    public void addRouteNameSegments(List<MapRouteSectionWithName> list, List<LatLng> list2) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (MapRouteSectionWithName mapRouteSectionWithName : list) {
                if (mapRouteSectionWithName != null) {
                    MapRouteSection mapRouteSection = new MapRouteSection();
                    mapRouteSection.color = mapRouteSectionWithName.color;
                    mapRouteSection.endNum = mapRouteSectionWithName.endNum;
                    mapRouteSection.roadName = mapRouteSectionWithName.roadName;
                    mapRouteSection.startNum = mapRouteSectionWithName.startNum;
                    arrayList.add(mapRouteSection);
                }
            }
            addSegmentsWithRouteName(arrayList, list2);
        }
    }

    public void addSegmentsWithRouteName(List<MapRouteSection> list, List<LatLng> list2) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.a(list, list2);
    }

    public final void animateToNaviPosition(LatLng latLng, float f, float f2) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.a(latLng, f, f2, true);
    }

    public final void animateToNaviPosition(LatLng latLng, float f, float f2, float f3) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.animateToNaviPosition(latLng, f, f2, f3, true);
    }

    public final void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, boolean z) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.animateToNaviPosition(latLng, f, f2, f3, z);
    }

    public final void animateToNaviPosition2(LatLng latLng, float f, float f2, float f3, boolean z) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.animateToNaviPosition2(latLng, f, f2, f3, z);
    }

    public float calNaviLevel(LatLngBounds latLngBounds, float f, int i, boolean z) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return 0.0f;
        }
        return h1Var.calNaviLevel(latLngBounds, f, i, z);
    }

    public float calNaviLevel2(LatLng latLng, LatLng latLng2, float f, float f2, int i, boolean z) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return 0.0f;
        }
        return h1Var.calNaviLevel2(latLng, latLng2, f, f2, i, z);
    }

    public float calNaviLevel3(LatLng latLng, LatLng latLng2, float f, int i, int i2, int i3, int i4, boolean z) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return 0.0f;
        }
        return h1Var.calNaviLevel3(latLng, latLng2, f, i, i2, i3, i4, z);
    }

    public CameraPosition calculateZoomToSpanLevelAsync(List<IOverlay> list, List<LatLng> list2, int i, int i2, int i3, int i4, TencentMap.AsyncOperateCallback<CameraPosition> asyncOperateCallback) {
        if (this.mapDestroyed || this.mapManager == null) {
            if (asyncOperateCallback != null) {
                asyncOperateCallback.onOperateFinished(null);
                return null;
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (IOverlay iOverlay : list) {
                if (iOverlay instanceof u4) {
                    arrayList.add((u4) iOverlay);
                }
            }
        }
        return this.mapManager.calculateZoomToSpanLevelAsync(arrayList, list2, i, i2, i3, i4, asyncOperateCallback);
    }

    public void clearRouteNameSegments() {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.clearRouteNameSegments();
    }

    public boolean isNaviStateEnabled() {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return false;
        }
        return h1Var.b();
    }

    public final void moveToNavPosition(CameraUpdate cameraUpdate, LatLng latLng) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.moveCamera(cameraUpdate);
        if (latLng != null) {
            setNavCenter((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
        }
    }

    public void onDestroy() {
        this.mapDestroyed = true;
    }

    public void setNavCenter(int i, int i2) {
        f0 f0Var = this.viewControl;
        if (f0Var == null) {
            return;
        }
        x1 b = f0Var.b();
        if (b instanceof kj) {
            ((kj) b).getVectorMapDelegate().c(i, i2);
        }
    }

    public void setNaviFixingProportion(float f, float f2) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.setNaviFixingProportion(f, f2);
    }

    public void setNaviFixingProportion2D(float f, float f2) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.setNaviFixingProportion2D(f, f2);
    }

    public void setNaviStateEnabled(boolean z) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.a(z);
    }

    public void setOnCameraChangeListener(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        h1 h1Var;
        if (this.mapDestroyed || (h1Var = this.mapManager) == null) {
            return;
        }
        h1Var.a(onCameraChangeListener);
    }

    public void setOptionalResourcePath(String str) {
        yi yiVar;
        rc A;
        if (this.mapDestroyed || (yiVar = this.mVectorMapDelegate) == null || (A = yiVar.A()) == null) {
            return;
        }
        A.h(str);
    }
}
